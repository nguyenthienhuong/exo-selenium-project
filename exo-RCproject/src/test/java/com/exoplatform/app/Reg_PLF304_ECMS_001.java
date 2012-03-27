package com.exoplatform.app;

import com.thoughtworks.selenium.SeleneseTestCase;

public class Reg_PLF304_ECMS_001 extends SeleneseTestCase {
	
	public void setUp() throws Exception {
		setUp("http://localhost:8080/portal/default/", "*chrome");
	}
	public void testReg_PLF304_ECMS_001() throws Exception {
		selenium.open("/portal/intranet/");
		selenium.click("link=Login as John");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Sites Explorer");
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@name='address']", "/acme/documents");
		selenium.keyDown("//input[@name='address']", "\\13");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("xpath=(//a[contains(text(),'New Content')])[2]")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("xpath=(//a[contains(text(),'New Content')])[2]");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("//div[@id='UISelectDocumentForm']")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("//div[@id='UISelectDocumentForm']/div/div[2]/div[11]/div/div/div/div");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("css=#name")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.type("css=#name", "jsfile");
		System.out.println("-- Click Save");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("link=Save")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("link=Save");
		System.out.println("-- Click Publications");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("//a[contains(text(),'Publications')]")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("//a[contains(text(),'Publications')]");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("xpath=(//img[@alt='Enrol'])[2]")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("xpath=(//img[@alt='Enrol'])[2]");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("xpath=(//span[contains(text(),'Manage Publication' )])")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		// State and base mode
		verifyTrue(selenium.isElementPresent("//a[contains(text(),'Obsolete')]"));
		selenium.click("css=div.UIAction > a.ActionButton.LightBlueStyle");
		selenium.click("link=Close");
		selenium.click("//a[contains(text(),'Logout')]");
		selenium.waitForPageToLoad("30000");
	}
}