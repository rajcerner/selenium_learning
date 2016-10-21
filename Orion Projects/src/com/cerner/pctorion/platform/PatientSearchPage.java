package com.cerner.pctorion.platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.cerner.pctorion.utilities.Page;

public class PatientSearchPage  extends Page{  


	public PatientSearchPage(WebDriver driver) {
		super(driver);
	}

	static SoftAssert saObj = new SoftAssert();

	@FindBy(id="ion-patient-search-text-box")
	WebElement patSrcTxtBx;

	@FindBy(xpath=".//*[@id='ion-patient-search-form']/fieldset/button")
	WebElement xBtn;

	@FindBy(xpath=".//*[@data-patient-id='1660009']/a/div[2]/h5/strong")
	WebElement fullNameLbl;

	@FindBy(xpath=".//*[@data-patient-id='1660009']/a/div[2]/h6[1]")
	WebElement agdLbl;

	@FindBy(xpath=".//*[@data-patient-id='1660009']/a/div[2]/h6[2]")
	WebElement ssnLbl;

	@FindBy(xpath=".//*[@data-patient-id='1660009']/a/div[2]/div[1]/h6")
	WebElement pcpLbl;

	@FindBy(xpath=".//*[@data-patient-id='1660009']/a/div[1]/div[1]/h6/small")
	WebElement mbNoLbl;

	@FindBy(xpath=".//*[@data-patient-id='1660009']/a/div[1]/div[1]/h6/small")
	WebElement hmNoLbl;


	public PatientSearchPage enterPatientsearchString(String patientsearchstring) throws InterruptedException {
		patSrcTxtBx.sendKeys(patientsearchstring);
		return this;
	}

	public void clearTestArea() {
		patSrcTxtBx.clear();
	}	

	public void clickXButton() {
		xBtn.click();

	}

	public void selectPatient() {

		Actions actions = new Actions(driver);
		actions.moveToElement(fullNameLbl).click(fullNameLbl).build().perform();

	}

	public PatientSearchPage verifyPatientDetails(String patientFullname, String homeNo, String mobileNo, String pcp, String ssn, String agd)
	{
		saObj.assertEquals("patientFullname", fullNameLbl.getText());
		saObj.assertEquals("homeNo",hmNoLbl.getText() );
		saObj.assertEquals("mobileNo",mbNoLbl.getText() );
		saObj.assertEquals("pcp",pcpLbl.getText() );
		saObj.assertEquals("ssn",ssnLbl.getText() );
		saObj.assertEquals("agd",agdLbl.getText() );

		return this;

	}

}