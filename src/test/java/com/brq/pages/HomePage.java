package com.brq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	@FindBy(how = How.LINK_TEXT, linkText = "Blouse")
	private WebElement blouseItem;

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBlouseItem() {
		return blouseItem;
	}

	public void setBlouseItem(WebElement blouseItem) {
		this.blouseItem = blouseItem;
	}

}
