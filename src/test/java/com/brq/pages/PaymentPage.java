package com.brq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentPage {
	@FindBy(how = How.ID, id = "total_price")
	private WebElement lblTotal;
	@FindBy(how = How.XPATH, xpath = "*//div/p/a[@class='bankwire']")
	private WebElement btnPaymenCard;
	@FindBy(how = How.XPATH, xpath = "*//div/p/a[@class='cheque']")
	private WebElement btnPaymentCheq;

	private WebDriver driver;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBtnProcede() {
		return lblTotal;
	}

	public String getTotalValue() {
		return getBtnProcede().getText();
	}

	public WebElement getBtnPaymentCheq() {
		return btnPaymentCheq;
	}

	public WebElement getBtnPaymenCard() {
		return btnPaymenCard;
	}
	
	public void payWithCreditCard() {
		getBtnPaymenCard().click();
	}
}
