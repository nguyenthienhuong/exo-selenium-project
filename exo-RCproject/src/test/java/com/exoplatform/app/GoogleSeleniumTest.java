package com.exoplatform.app;

import com.thoughtworks.selenium.HttpCommandProcessor;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.DefaultSelenium;

public class GoogleSeleniumTest {
    static Selenium browser;

    public static void main(String[] arguments) {
        HttpCommandProcessor cmdProcessor =
                new HttpCommandProcessor("localhost", 4444, "*chrome", "http://www.google.com");
        browser = new DefaultSelenium(cmdProcessor);
        browser.start();
        browser.open("/");

        boolean result;
        try {
            result = searchTest();
        } catch(Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            browser.stop();
        }

        System.out.println("Test " + (result? "passed." : "failed."));
        if (!result) {
            System.exit(1);
        }
    }

    private static boolean searchTest() {
        browser.type("q", "qa automation");
        browser.mouseDown("btnG");
        browser.mouseUp("btnG");
        browser.waitForCondition("selenium.browserbot.getCurrentWindow().document.getElementById('body') === null", "30000");

        // sleep so that you get time to see the effect of above steps
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            //
        }
        return browser.isTextPresent("About * results");
    }
}