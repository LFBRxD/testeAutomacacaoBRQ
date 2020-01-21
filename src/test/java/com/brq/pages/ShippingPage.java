package com.brq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShippingPage {
	@FindBy(how = How.XPATH, xpath = "*//button[@type='submit']/span/i")
	private WebElement btnProcede;
	@FindBy(how = How.ID, id = "cgv")
	private WebElement chkAgree;

	private WebDriver driver;

	public ShippingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBtnProcede() {
		return btnProcede;
	}

	public void clickBtnProcede() throws InterruptedException {
		Thread.sleep(100);
		getBtnProcede().click();
	}

	public void checkTheAgree() throws InterruptedException {
		Thread.sleep(100);
		getChkAgree().click();
	}

	public WebElement getChkAgree() {
		return chkAgree;
	}
}
