package com.brq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignInPage {
	@FindBy(how = How.ID, id = "SubmitCreate")
	private WebElement btnCreateAcc;

	@FindBy(how = How.ID, id = "SubmitLogin")
	private WebElement btnSignin;

	private WebDriver driver;

	@FindBy(how = How.ID, id = "email")
	private WebElement txtLogEmail;

	@FindBy(how = How.ID, id = "passwd")
	private WebElement txtLogPass;

	@FindBy(how = How.ID, id = "email_create")
	private WebElement txtRegEmail;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBtnCreateAcc() {
		return btnCreateAcc;
	}

	public WebElement getBtnSignin() {
		return btnSignin;
	}

	public WebElement getTxtLogEmail() {
		return txtLogEmail;
	}

	public WebElement getTxtLogPass() {
		return txtLogPass;
	}

	public WebElement getTxtRegEmail() {
		return txtRegEmail;
	}

	public void clickBtnCreateAcc() {
		getBtnCreateAcc().click();
	}

	public void clickBtnSignin() {
		getBtnSignin().click();
	}

	public void setTxtLogEmail(String txtLogEmail) {
		getTxtRegEmail().sendKeys(txtLogEmail);
	}

	public void setTxtLogPass(String txtLogPass) {
		getTxtLogPass().sendKeys(txtLogPass);
	}

	public void setTxtRegEmail(String txtRegEmail) {
		getTxtRegEmail().sendKeys(txtRegEmail);
	}

}
