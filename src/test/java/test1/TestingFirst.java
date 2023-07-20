package test1;

import pages.HomePages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;
import org.openqa.selenium.Keys;

import java.util.List;

public class TestingFirst {

    WebDriver driver;
    HomePages homePages = new HomePages();
    @BeforeMethod
    public void setUp() throws InterruptedException {
       driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));
        Thread.sleep(2000);
        WebElement cokies = driver.findElement(homePages.cookies);
        cokies.click();
    }
    @Test
    public void HomePage() throws InterruptedException {

        WebElement endeckePlusLogoButton = driver.findElement(homePages.EndeckePlusLogoButton);
        endeckePlusLogoButton.click();
        String currentUrlZalandoPlus = driver.getCurrentUrl();
        String expectedUrlZalandoPlus = "https://www.zalando.de/zalandoplus/";
        Assert.assertEquals(currentUrlZalandoPlus, expectedUrlZalandoPlus);

    }

    @Test
    public void HomeBekleidungHemden() throws InterruptedException {
        WebElement unternehmenButton = driver.findElement(homePages.HomeBekleidungButton);
        Actions action = new Actions(driver);
        action.moveToElement(unternehmenButton).build().perform();
        Thread.sleep(2000);
        driver.findElement(homePages.homeHemdenUnderBekleidung).click();


        //JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("arguments[0].click();", junior);


    }
}
