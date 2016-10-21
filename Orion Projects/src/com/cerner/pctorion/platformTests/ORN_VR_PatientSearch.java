package com.cerner.pctorion.platformTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.cerner.pctorion.platform.LandingPage;
import com.cerner.pctorion.utilities.Settings;


public class ORN_VR_PatientSearch extends Settings {

	
	@Test
	public void orn_vr_patientsearch() throws InterruptedException{
		
		String patientFullname = "DODDS, BRAIN";
		String homeNo="Home: (888) 663-1919";
		String mobileNo="Mobile: --";
		String ssn="SSN: XXX-XX-7777";
		String pcp="PCP: Dickey,Doug";
		String agd="60 years M DOB: 05/25/1956"; //age, gender, dob

		LandingPage lp = new LandingPage(driver);
		lp.initialLoginButton()
		.enterUsernamePassword("jw027642", "asdf")
		.clickMPlusLoginButton()
		.enterPatientsearchString(patientFullname).verifyPatientDetails(patientFullname, homeNo,mobileNo,pcp, ssn, agd)
		.selectPatient();	

	}

}



