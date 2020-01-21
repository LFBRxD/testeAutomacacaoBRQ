package com.brq.tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.brq.pages.HomePage;
import com.brq.pages.OrderPage;
import com.brq.pages.ProductSelectedInfoPage;
import com.brq.pages.SignInPage;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Single;

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
		signinPage.setTxtRegEmail("teste_brq@email.com");
		signinPage.clickBtnCreateAcc();
		
		
		Thread.sleep(2000);
		
		
	}

}
