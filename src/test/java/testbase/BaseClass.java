package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public  static WebDriver Setup(){
        //String projectPath=  System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver","/Users/sdinc00/IdeaProjects/qtest/src/test/resources/Drivers/chromedriver");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://cms.demo.katalon.com/");

        return driver;
    }

    public static void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }
}
