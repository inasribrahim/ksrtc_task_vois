package com.vois.ksrtc.screen;


import com.vois.ksrtc.driver.DriverManager;
import com.vois.ksrtc.waits.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.util.List;


public class BaseScreen {

    Actions actions;
    WaitUtils waitUtils = new WaitUtils();

    JavascriptExecutor executor;
    protected String constructXpath(String xpath , String replacingStr){
        return String.format(xpath,replacingStr);
    }
    protected WebElement getWebElement(By by){
      return waitUtils.waitUntilElementUntilIsVisible(by);
    }

    public List<WebElement> getElements(By selector) {
        waitUtils.waitUntilElementUntilIsVisible(selector);
        return DriverManager.getWebDriver().findElements(selector);
    }
    public void scrollToElement(By selector) {
        WebElement element = getWebElement(selector);
        actions = new Actions(DriverManager.getWebDriver());
        ((JavascriptExecutor) DriverManager.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public boolean elementIsExisted(By by) {
        return DriverManager.getWebDriver().findElements(by).size() != 0;
    }

    public String getElementText(By by){
        return waitUtils.waitUntilElementIsPresence(by).getText();
    }

    public void clickOnElementUsingJS   (WebElement link){
        executor = (JavascriptExecutor) DriverManager.getWebDriver();
        executor.executeScript("arguments[0].click();", link);
    }
}
