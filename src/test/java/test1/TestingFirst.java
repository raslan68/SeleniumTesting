package test1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePages;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TestingFirst {

    WebDriver driver;
    HomePages homePages = new HomePages();
    @BeforeMethod
    public void setUp() throws InterruptedException {
       driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));
        Thread.sleep(3000);
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

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(homePages.btnHomeUnderBekleidungHemdenGrosse).click();
        driver.findElement(homePages.ddHomeUnderBekleidungHemdenGrosse42).click();
        driver.findElement(homePages.btnHomeUnderBekleidungHemdenGrosse).click();

        Thread.sleep(3000);

        driver.findElement(homePages.btnHomeUnderBekleidungHemdenPreis).click();
        driver.findElement(homePages.txtHomeUnderBekleidungHemdenPreisAb).sendKeys(Keys.CONTROL + "a");
        driver.findElement(homePages.txtHomeUnderBekleidungHemdenPreisAb).sendKeys(Keys.DELETE);
        driver.findElement(homePages.txtHomeUnderBekleidungHemdenPreisAb).sendKeys("20");
        driver.findElement(homePages.txtHomeUnderBekleidungHemdenPreisBis).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        driver.findElement(homePages.txtHomeUnderBekleidungHemdenPreisBis).sendKeys("70");

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        driver.findElement(homePages.btnHomeUnderBekleidungHemdenPreis).click();

    }
}
