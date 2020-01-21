package com.brq.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	private WebDriver driver;

	@FindBy(how = How.ID, id = "submitAccount")
	private WebElement btnRegister;
	@FindBy(how = How.XPATH, xpath = "*//div/div/label[@class='top']")
	private List<WebElement> rdbTitle;
	@FindBy(how = How.XPATH, xpath = "uniform-newsletter")
	private WebElement chkNewsLetter;
	@FindBy(how = How.ID, id = "uniform-optin")
	private WebElement chkOffer;
	@FindBy(how = How.ID, id = "id_country")
	private WebElement cmbCountry;
	@FindBy(how = How.ID, id = "days")
	private WebElement cmbDay;
	@FindBy(how = How.ID, id = "months")
	private WebElement cmbMonth;
	@FindBy(how = How.ID, id = "id_state")
	private WebElement cmbState;
	@FindBy(how = How.ID, id = "years")
	private WebElement cmdYear;
	@FindBy(how = How.ID, id = "address1")
	private WebElement txtAddress;
	@FindBy(how = How.ID, id = "address2")
	private WebElement txtAddress_2;
	@FindBy(how = How.ID, id = "alias")
	private WebElement txtAliasAddress;
	@FindBy(how = How.ID, id = "city")
	private WebElement txtCity;
	@FindBy(how = How.ID, id = "company")
	private WebElement txtCompany;
	@FindBy(how = How.ID, id = "email")
	private WebElement txtEmail;
	@FindBy(how = How.ID, id = "other")
	private WebElement txtExtraInform;
	@FindBy(how = How.ID, id = "customer_firstname")
	private WebElement txtFirstName;
	@FindBy(how = How.ID, id = "firstname")
	private WebElement txtFirstName_2;
	@FindBy(how = How.ID, id = "customer_lastname")
	private WebElement txtLastName;
	@FindBy(how = How.ID, id = "lastname")
	private WebElement txtLastName_2;
	@FindBy(how = How.ID, id = "phone_mobile")
	private WebElement txtMobPhone;
	@FindBy(how = How.ID, id = "phone")
	private WebElement txtHomePhone;
	@FindBy(how = How.ID, id = "passwd")
	private WebElement txtPass;
	@FindBy(how = How.ID, id = "postcode")
	private WebElement txtZipCode;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBtnRegister() {
		return btnRegister;
	}

	public WebElement getChkNewsLetter() {
		return chkNewsLetter;
	}

	public WebElement getChkOffer() {
		return chkOffer;
	}

	public WebElement getCmbCountry() {
		return cmbCountry;
	}

	public WebElement getCmbDay() {
		return cmbDay;
	}

	public WebElement getCmbMonth() {
		return cmbMonth;
	}

	public WebElement getCmbState() {
		return cmbState;
	}

	public WebElement getCmdYear() {
		return cmdYear;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtAddress_2() {
		return txtAddress_2;
	}

	public WebElement getTxtAliasAddress() {
		return txtAliasAddress;
	}

	public WebElement getTxtCity() {
		return txtCity;
	}

	public WebElement getTxtCompany() {
		return txtCompany;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtExtraInform() {
		return txtExtraInform;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtFirstName_2() {
		return txtFirstName_2;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtLastName_2() {
		return txtLastName_2;
	}

	public WebElement getTxtMobPhone() {
		return txtMobPhone;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getTxtZipCode() {
		return txtZipCode;
	}

	public void setBtnRegister(WebElement btnRegister) {
		this.btnRegister = btnRegister;
	}

	public void setChkNewsLetter(WebElement chkNewsLetter) {
		this.chkNewsLetter = chkNewsLetter;
	}

	public void setChkOffer(WebElement chkOffer) {
		this.chkOffer = chkOffer;
	}

	public void setCmbCountry(WebElement cmbCountry) {
		this.cmbCountry = cmbCountry;
	}

	public void setCmbDay(WebElement cmbDay) {
		this.cmbDay = cmbDay;
	}

	public void setCmbMonth(WebElement cmbMonth) {
		this.cmbMonth = cmbMonth;
	}

	public void setCmbState(WebElement cmbState) {
		this.cmbState = cmbState;
	}

	public void setCmdYear(WebElement cmdYear) {
		this.cmdYear = cmdYear;
	}

	public void setTxtAddress(String address) {
		getTxtAddress().sendKeys(address);
	}

	public void setTxtAddress_2(WebElement txtAddress_2) {
		this.txtAddress_2 = txtAddress_2;
	}

	public void setTxtAliasAddress(String txtAliasAddress) {
		getTxtAliasAddress().clear();
		getTxtAliasAddress().sendKeys(txtAliasAddress);
	}

	public void setTxtCity(String txtCity) {
		getTxtCity().clear();
		getTxtCity().sendKeys(txtCity);
	}

	public void setTxtCompany(String txtCompany) {
		getTxtCompany().clear();
		getTxtCompany().sendKeys(txtCompany);
	}

	public void setTxtEmail(String email) {
		getTxtEmail().clear();
		getTxtEmail().sendKeys(email);
	}

	public void setTxtExtraInform(String txtExtraInform) {
		getTxtExtraInform().clear();
		getTxtExtraInform().sendKeys(txtExtraInform);
	}

	public void setTxtFirstName(String fName) {
		getTxtFirstName().clear();
		getTxtFirstName().sendKeys(fName);
	}

	public void setTxtFirstName_2(String sndName) {
		getTxtFirstName_2().clear();
		getTxtFirstName_2().sendKeys(sndName);
	}

	public void setTxtLastName(String lName) {
		getTxtLastName().clear();
		getTxtLastName().sendKeys(lName);
	}

	public void setTxtLastName_2(String sndLastName) {
		getTxtAddress_2().clear();
		getTxtAddress_2().sendKeys(sndLastName);
	}

	public void setTxtMobPhone(int phone) {
		getTxtMobPhone().clear();
		getTxtMobPhone().sendKeys(Integer.toString(phone));
	}

	public void setTxtPass(String pwd) {
		getTxtPass().clear();
		getTxtPass().sendKeys(pwd);
	}

	public void setTxtZipCode(int zipCode) {
		getTxtZipCode().clear();
		getTxtZipCode().sendKeys(Integer.toString(zipCode));
	}

	public void setTxtZipCode(String zipCode) {
		getTxtZipCode().clear();
		getTxtZipCode().sendKeys(zipCode);
	}

	public WebElement getTxtHomePhone() {
		return txtHomePhone;
	}

	public void setTxtHomePhone(WebElement txtHomePhone) {
		this.txtHomePhone = txtHomePhone;
	}

	public List<WebElement> getRdbTitle() {
		return rdbTitle;
	}

	public void setRdbTitle(List<WebElement> rdbTitle) {
		this.rdbTitle = rdbTitle;
	}

	public void fillFormWithData(String gender, String fName, String lName, String email, String pwd, String sndName,
			String sndLastName, String address, String city, String state, int zipCode, int phone) {
		if (gender.equalsIgnoreCase("Male")) {
			getRdbTitle().get(0).click();
		} else {
			getRdbTitle().get(1).click();
		}
		setTxtFirstName(fName);
		setTxtLastName(lName);
		setTxtEmail(email);
		setTxtPass(pwd);
		setTxtFirstName_2(sndName);
		setTxtLastName_2(sndLastName);
		setTxtAddress(address);
		setTxtCity(city);
		Select stateSel = new Select(getCmbState());
		for (WebElement webElement : stateSel.getOptions()) {
			if (webElement.getText().equalsIgnoreCase(state))
				webElement.click();
		}
		setTxtZipCode(zipCode);
		setTxtMobPhone(phone);
	}
	
	public void fillFormWithData(String gender, String fName, String lName, String email, String pwd, String sndName,
			String sndLastName, String address, String city, String state, String zipCode, int phone) {
		if (gender.equalsIgnoreCase("Male")) {
			getRdbTitle().get(0).click();
		} else {
			getRdbTitle().get(1).click();
		}
		setTxtFirstName(fName);
		setTxtLastName(lName);
		setTxtEmail(email);
		setTxtPass(pwd);
		setTxtFirstName_2(sndName);
		setTxtLastName_2(sndLastName);
		setTxtAddress(address);
		setTxtCity(city);
		Select stateSel = new Select(getCmbState());
		for (WebElement webElement : stateSel.getOptions()) {
			if (webElement.getText().equalsIgnoreCase(state))
				webElement.click();
		}
		setTxtZipCode(zipCode);
		setTxtMobPhone(phone);
	}

	public void clickBtnRegister() {
		getBtnRegister().click();
	}
}
