package com.brq.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderPage {
	@FindBy(how = How.ID, id = "summary_products_quantity")
	WebElement qtyItensOnCart;
	@FindBy(how = How.XPATH, xpath = "*//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement procedeCheckout;

	@FindBy(how = How.XPATH, xpath = "*//tbody/tr")
	List<WebElement> qtyRows;

	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		this.driver = driver;
		//this.qtyRows = 
	}

	public int qtyItensTypeOnCart() {
		return qtyRows.size();
		
	}

	public int qtyItensOnCart() {
		String qty = getQtyItensOnCart().getText().substring(0, 2);
		return Integer.parseInt(qty.trim());
	}

	public void clearCart() throws InterruptedException {
		List<WebElement> qty = driver.findElements(By.xpath("*//tbody/tr/td[7]"));
		for (WebElement button : qty) {
			Thread.sleep(250);
			button.click();
		}
	}

	public boolean findProductOnCart(String element) {
		for (WebElement button : qtyRows) {
			if (button.findElement(By.linkText(element)).getText().toLowerCase().contains(element.toLowerCase()))
				return true;
		}
		return false;
	}

	private WebElement getQtyItensOnCart() {
		return qtyItensOnCart;
	}

	public void clickProcedeCheckout() {
		procedeCheckout.click();
	}
}
