package com.qait.acs.tests;

import static com.qait.automation.utils.YamlReader.getYamlValue;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.automation.TestSessionInitiator;

public class BaseTest {
	protected TestSessionInitiator test;
	
	@BeforeClass
	public void Start_Test_Session() {
		test = new TestSessionInitiator(this.getClass().getSimpleName());
	    test.launchApplication(getYamlValue("baseUrl"));
	}

	@Test
	public void Step1_isLoginPageOpen() throws InterruptedException {
		assertTrue(test.loginPage.isLoginPanelVisible());
	}

	@Test(dependsOnMethods = "Step1_isLoginPageOpen")
	public void Step2_verifyThatTimeSheetIsOpen() throws InterruptedException {
		test.loginPage.login();
		assertTrue(test.timeSheetPage.isUserImageDisplayed());
	}

	@Test(dependsOnMethods="Step2_verifyThatTimeSheetIsOpen")
	public void Step3_verifyFirstName() {
		test.timeSheetPage.clickOnUserImage();
		String expectedName = getYamlValue("expected_username");
		String actualName = test.timeSheetPage.getFirstName();
	    assertTrue(expectedName.contains(actualName));
	}
	
	@AfterClass
	public void close_Test_Session() throws IOException {
		test.closeBrowserSession();
	}

}
