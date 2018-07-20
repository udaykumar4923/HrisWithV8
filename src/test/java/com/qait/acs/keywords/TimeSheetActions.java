package com.qait.acs.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

public class TimeSheetActions extends GetPage {
	public TimeSheetActions(WebDriver driver) {
		super(driver,"timeSheetPage");
	}
	
	
	public boolean isUserImageDisplayed() {
		boolean flag = false;
		wait.waitForPageToLoad();
		if(isElementDisplayed("img_user_image"))
			flag = true;
		return flag;
	}
	
	public void clickOnUserImage() {
		element("img_user_image").click();
		element("link_open_profile_link").click();
	}
	
	public String getFirstName() {
		String firstname = "";
		firstname = element("txt_first_name").getAttribute("value");
		return firstname;
	}
}
