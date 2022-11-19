package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.BaseClass;

import javax.swing.*;
import java.util.List;
import java.util.Random;

public class testPage extends BaseClass {

    //@FindBy(xpath="//a[text()='Add to cart']")
    @FindBy(css="div a h2")
    private WebElement exampleList;

    @FindBy(xpath="//span[@class=\"onsale\"]")

    private List<WebElement> saleList;

    @FindBy(css="div a img")
    private WebElement imageProduct;

    public void clickOnRandomItemInList(){

        /*
        Actions action = new Actions(driver);
        action.moveToElement(imageProduct).build().perform();
        action.click();

        Random rnd = new Random();
        int i = rnd.nextInt(exampleList.size());

        exampleList.get(i).click();
*/
        saleList.get(2).click();


    }



}
