package utils;

import io.cucumber.core.options.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.PageInitializer;

import java.io.File;
import java.util.List;
import java.util.Set;

public class CommonMethods extends PageInitializer {

    public static void sendText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public static void clickRadioOrCheckbox(List<WebElement> listElement, String value){
        String actualValue ;

        for (WebElement el:listElement){
            actualValue=el.getAttribute("value").trim();

            if (el.isEnabled()&&actualValue.equals(value)){
                el.click();
                break;
            }
        }
    }

    public static void selectDropdown(WebElement element, String textToSelect){
        try{
            Select select=new Select(element);

            List<WebElement> options=select.getOptions();

            for (WebElement el:options) {
                if (el.getText().equals(textToSelect)){
                    select.selectByVisibleText(textToSelect);
                    break;
                }
            }
        }catch (UnexpectedTagNameException e){
            e.printStackTrace();
        }
    }


    public static void selectDropdown(WebElement element, int index){
        try{
            Select select=new Select(element);

            int size=select.getOptions().size();

            if(size>index){
                select.selectByIndex(index);
            }
        }catch (UnexpectedTagNameException e){
            e.printStackTrace();
        }
    }


    public static void acceptAlert(){
        try{
            Alert alert=driver.switchTo().alert();
            alert.accept();
        }catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }


    public static void dismissAlert(){
        try{
            Alert alert=driver.switchTo().alert();
            alert.dismiss();
        }catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }


    public static String getAlertText(){
        String alertText=null;
        try{
            Alert alert=driver.switchTo().alert();
            alertText=alert.getText();
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
        return alertText;
    }


    public static void sendAlertText(String text){
        try{
            Alert alert=driver.switchTo().alert();
            alert.sendKeys(text);
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    public static void switchToFrame(String nameOrId){
        try{
            driver.switchTo().frame(nameOrId);
        }catch (NoSuchFrameException e){
            e.printStackTrace();
        }
    }

    public static void switchToFrame(int index){
        try{
            driver.switchTo().frame(index);
        }catch (NoSuchFrameException e){
            e.printStackTrace();
        }
    }

    public static void switchToFrame(WebElement element){
        try{
            driver.switchTo().frame(element);
        }catch (NoSuchFrameException e){
            e.printStackTrace();
        }
    }


    public static void switchToChildWindow(){
        String mainWindow=driver.getWindowHandle();
        Set<String> windows=driver.getWindowHandles();

        for (String window:windows) {
            if (!window.equals(mainWindow)){
                driver.switchTo().window(window);
            }

        }
    }


    public static WebDriverWait getWaitObject(){
        WebDriverWait wait =new WebDriverWait(driver,30);
        return wait;
    }

    public static WebElement waitForClickability(WebElement element){
        return  getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
    }


    public static WebElement waitForVisibility(WebElement element){
        return  getWaitObject().until(ExpectedConditions.visibilityOf(element));
    }

    public static void click(WebElement  element){
        waitForClickability(element);
        element.click();
    }


    public static void wait(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static JavascriptExecutor getJSObject(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return js;
    }

    public static void jsClick(WebElement element){
        getJSObject().executeScript("arguments[0].click",element);
    }

    public static void scrollToElement(WebElement element){
        getJSObject().executeScript("arguments[0].scrollIntoView(true)",element);
    }

    public static void scrollDown(int pixel){
        getJSObject().executeScript("window.scrollBy(0,"+pixel+")");
    }

    public static void scrollUp(int pixel){
        getJSObject().executeScript("window.scrollBy(0,-"+pixel+")");
    }


    public static void selectCalendarDate(List<WebElement>elements,String text){
        for (WebElement day:elements) {

            if(day.isEnabled()){
                if (day.getText().equals(text)){
                    day.click();
                    break;
                }
            }
        }
    }





}
