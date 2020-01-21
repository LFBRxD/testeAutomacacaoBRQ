package com.brq.tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.brq.pages.AddressPage;
import com.brq.pages.HomePage;
import com.brq.pages.OrderConfirmPage;
import com.brq.pages.OrderPage;
import com.brq.pages.PaymentPage;
import com.brq.pages.ProductSelectedInfoPage;
import com.brq.pages.RegisterPage;
import com.brq.pages.ShippingPage;
import com.brq.pages.SignInPage;

import net.bytebuddy.utility.RandomString;

public class Desafio {

	private static WebDriver driver;
	private static WebDriverWait waiter;
	private final String BASE_URL = "http://www.automationpractice.com";
	private final String CHECKOUT_URL = BASE_URL + "/index.php?controller=order";

	@BeforeClass
	public static void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "target/chromedriver.exe");
		driver = new ChromeDriver();
		waiter = new WebDriverWait(driver, 15);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void realizarUmaCompraComSucesso() throws Exception {
		// 1. Acessar o site: www.automationpractice.com.
		driver.get(BASE_URL);

		// 2. Escolha um produto qualquer na loja
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.getBlouseItem().click();

		waiter.until(ExpectedConditions.urlContains("controller=product"));
		ProductSelectedInfoPage detailsProductPage = PageFactory.initElements(driver, ProductSelectedInfoPage.class);
		waiter.until(ExpectedConditions.elementToBeClickable(detailsProductPage.getTxtQuantity()));
		detailsProductPage.setTxtQuantity(1);

		// 3. Adicione o produto escolhido ao carrinho.
		detailsProductPage.clickBtnAddToCart();
		waiter.until(ExpectedConditions.elementToBeClickable(detailsProductPage.getLayerSuccessToCart()));
		Assert.assertTrue(detailsProductPage.getLayerSuccessToCart().isDisplayed());

		// 4. Prossiga para o checkout.
		driver.get(CHECKOUT_URL);
		Thread.sleep(1000);
		OrderPage orderPage = PageFactory.initElements(driver, OrderPage.class);
		String currentUrl = driver.getCurrentUrl();

		// 5. Valide se o produto foi corretamente adicionado ao carrinho e prossiga
		// caso esteja tudo certo.
		Assert.assertEquals(1, orderPage.qtyItensOnCart());
		Assert.assertEquals(1, orderPage.qtyItensTypeOnCart());
		Assert.assertTrue(orderPage.findProductOnCart("Blouse"));
		orderPage.clickProcedeCheckout();

		// 6. Realize o cadastro do cliente preenchendo todos os campos obrigatórios dos
		// formulários.
		waiter.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
		SignInPage signinPage = PageFactory.initElements(driver, SignInPage.class);
		RandomString rndstr = new RandomString(12);
		String email = "jwick" + rndstr.nextString() + "@test.com";

		signinPage.setTxtRegEmail(email);
		currentUrl = driver.getCurrentUrl();
		signinPage.clickBtnCreateAcc();

		waiter.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
		RegisterPage regPage = PageFactory.initElements(driver, RegisterPage.class);
		regPage.fillFormWithData("Male", "John", "Wick", email, "qawsedrf1@3$", "John", "Wick", "Washington Street",
				"Manhathan", "New York", "00000", 86563144);
		currentUrl = driver.getCurrentUrl();
		regPage.clickBtnRegister();

		// 7. Valide se o endereço está correto e prossiga.
//		waiter.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
		AddressPage adPage = PageFactory.initElements(driver, AddressPage.class);
		currentUrl = driver.getCurrentUrl();
		adPage.clickBtnProcede();

		// 8. Aceite os termos de serviço e prossiga.
		waiter.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
		currentUrl = driver.getCurrentUrl();
		ShippingPage shipPage = PageFactory.initElements(driver, ShippingPage.class);
		shipPage.checkTheAgree();
		shipPage.clickBtnProcede();

		// 9. Valide o valor total da compra.
		waiter.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
		PaymentPage payPage = PageFactory.initElements(driver, PaymentPage.class);
		currentUrl = driver.getCurrentUrl();
		Assert.assertEquals("$29.00", payPage.getTotalValue().trim());

		// 10. Selecione um método de pagamento e prossiga.
		payPage.payWithCreditCard();
		waiter.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));

		// 11. Confirme a compra e valide se foi finalizada com sucesso.
		OrderConfirmPage orderConfirmPage = PageFactory.initElements(driver, OrderConfirmPage.class);
		orderConfirmPage.clickBtnProcede();
		
		WebElement completeElement = driver.findElement(By.xpath("*//div[@class='box']/p/strong[@class='dark']"));
		Assert.assertNotNull(completeElement);
		Assert.assertEquals("Your order on My Store is complete.", completeElement.getText().trim());
	}

}
