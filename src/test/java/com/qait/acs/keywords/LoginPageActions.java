package com.qait.acs.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

public class LoginPageActions extends GetPage{
	
	public LoginPageActions(WebDriver driver) {
		super(driver,"loginPage");
	}
	
	
	public boolean isLoginPanelVisible() {
//		wait.waitForPageToLoad();
//		isElementDisplayed("link_login_panel_link");
		boolean flag = false;
		wait.waitForPageToLoad();
		if(isElementDisplayed("link_login_panel_link"));
			flag = true;
		return flag;
	}
	
	
	public void login() throws InterruptedException {
		element("link_login_panel_link").click();
		isElementDisplayed("txt_user_name_entry");
		element("txt_user_name_entry").sendKeys("ayushtrivedi");
		isElementDisplayed("txt_user_passwd_entry");
		element("txt_user_passwd_entry").sendKeys("Ayush@321#");
		isElementDisplayed("btn_submit");
		element("btn_submit").click();
	}
}
