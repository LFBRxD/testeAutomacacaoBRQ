package com.brq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductSelectedInfoPage {
	@FindBy(how = How.XPATH, xpath = "*//h1[@itemprop='name']")
	WebElement productTitle;
	@FindBy(how = How.XPATH, xpath = "*//p[@id='product_reference']/span[@class='editable']")
	WebElement Model;
	@FindBy(how = How.XPATH, xpath = "*//p[@id='product_condition']/span[@class='editable']")
	WebElement Condition;
	@FindBy(how = How.XPATH, xpath = "*//p[@id='quantity_wanted_p']/input[@id='quantity_wanted']")
	WebElement txtQuantity;
	@FindBy(how = How.XPATH, xpath = "*//p[@id='add_to_cart']/button[@type='submit']")
	WebElement btnAddToCart;
	@FindBy(how = How.XPATH, xpath = "*//div[@id='layer_cart']")
	private WebElement layerAddToCart;

	WebDriver driver;

	public ProductSelectedInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	public ProductSelectedInfoPage() {
	}

	public WebElement getProductTitle() {
		return productTitle;
	}

	public WebElement getModel() {
		return Model;
	}

	public WebElement getCondition() {
		return Condition;
	}

	public WebElement getTxtQuantity() {
		return txtQuantity;
	}

	public WebElement getBtnAddToCart() {
		return btnAddToCart;
	}

	public void setProductTitle(WebElement productTitle) {
		this.productTitle = productTitle;
	}

	public void setModel(WebElement model) {
		Model = model;
	}

	public void setCondition(WebElement condition) {
		Condition = condition;
	}

	public void setTxtQuantity(int value) {
		getTxtQuantity().clear();
		getTxtQuantity().sendKeys(Integer.toString(value));
	}

	public void clickBtnAddToCart() {
		getBtnAddToCart().click();
	}

	public WebElement getLayerSuccessToCart() {
		return layerAddToCart;
	}

	public void setLayerAddToCart(WebElement layerAddToCart) {
		this.layerAddToCart = layerAddToCart;

	}

}
