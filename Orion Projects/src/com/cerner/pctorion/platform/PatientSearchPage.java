package com.cerner.pctorion.platform;

import java.text.DateFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.cerner.pctorion.utilities.Page;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class PatientSearchPage  extends Page{  


	public PatientSearchPage(WebDriver driver) {
		super(driver);
	}

	//static SoftAssert saObj = new SoftAssert();

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

	@FindBy(xpath=".//*[@data-patient-id='1660009']/a/div[1]/div[2]/h6/small")
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

	public PatientSearchPage verifyPatientDetails(String patientFullname, String homeNo, String mobileNo, String pcp, 
			String ssn, String agd, ExtentTest test,DateFormat formatter, String projectFolderPath)
	{
		try{
			System.out.println("patientFullname "+patientFullname);
			System.out.println("visible "+fullNameLbl.getText());
			
			//patientfullname
			if(fullNameLbl.getText()!="" && fullNameLbl.getText().equals(patientFullname) && fullNameLbl.getText() !=null ){
				
				passTestCase( test, fullNameLbl.getText(), formatter, projectFolderPath);
			}else{
				
				failTestCase( test, fullNameLbl.getText(), formatter, projectFolderPath);
			}
			
			//home number
			if(hmNoLbl.getText()!="" && hmNoLbl.getText().equals(homeNo) && hmNoLbl.getText() !=null  ){
				passTestCase( test, hmNoLbl.getText(), formatter, projectFolderPath);
			}else{
				
				failTestCase( test, hmNoLbl.getText(), formatter, projectFolderPath);
			}
			
			//mobileNo
			if(mbNoLbl.getText()!="" && mbNoLbl.getText().equals(mobileNo) && mbNoLbl.getText() !=null  ){
				passTestCase( test, mbNoLbl.getText(), formatter, projectFolderPath);
			}else{
				
				failTestCase( test, mbNoLbl.getText(), formatter, projectFolderPath);
			}
			
			//pcp
			if(pcpLbl.getText()!="" && pcpLbl.getText().equals(pcp)  && pcpLbl.getText() !=null ){
				passTestCase( test, pcpLbl.getText(), formatter, projectFolderPath);
			}else{
				
				failTestCase( test, pcpLbl.getText(), formatter, projectFolderPath);
			}
			
			
			//ssn
			if(ssnLbl.getText()!="" && ssnLbl.getText().equals(ssn) && ssnLbl.getText() !=null  ){
				passTestCase( test, ssnLbl.getText(), formatter, projectFolderPath);
			}else{
				
				failTestCase( test, ssnLbl.getText(), formatter, projectFolderPath);
			}
			
			//agd
			if(agdLbl.getText()!="" && agdLbl.getText().equals(agd)  && agdLbl.getText() !=null ){
				passTestCase( test, agdLbl.getText(), formatter, projectFolderPath);
			}else{
				
				failTestCase( test, agdLbl.getText(), formatter, projectFolderPath);
			}
		}
		catch(Exception e){
			test.log(LogStatus.ERROR, e.getMessage());

		}
		return this;
	}
}