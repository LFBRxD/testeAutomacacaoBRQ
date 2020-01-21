package com.brq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddressPage {
	@FindBy(how = How.XPATH, xpath = "*//button[@type='submit']/span/i")
	private WebElement btnProcede;

	private WebDriver driver;

	public AddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBtnProcede() {
		return btnProcede;
	}

	public void clickBtnProcede() throws InterruptedException {
		Thread.sleep(100);
		getBtnProcede().click();
	}
}
