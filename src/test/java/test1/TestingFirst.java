package test1;

import Pages.HomePages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
        driver.get("https://www.usu.com/de-de/");
        Thread.sleep(2000);
        WebElement cokies = driver.findElement(homePages.cookies);
        cokies.click();
    }
    @Test
    public void HomePage() throws InterruptedException {

        String ActualURL = driver.getCurrentUrl();
        System.out.println("URL: " + ActualURL);
        String expectedURL = "https://www.usu.com/de-de/";
        Assert.assertEquals(ActualURL, expectedURL);

    }

    @Test
    public void Unternehmen() throws InterruptedException {
        WebElement unternehmenButton = driver.findElement(homePages.UnternehmenButton);
        Actions action = new Actions(driver);
        action.moveToElement(unternehmenButton).build().perform();
        Thread.sleep(2000);
        WebElement karrier = driver.findElement(homePages.Karrier);
        action.moveToElement(karrier).build().perform();
        driver.findElement(By.xpath("//*[@id=\"→karriere\"]/li[1]/a[1]")).click();
        WebElement jobfinden = driver.findElement(homePages.JobFinden);
        jobfinden.sendKeys("Softwareentwickler", Keys.ENTER);
        Thread.sleep(2000);
        WebElement junior =driver.findElement(homePages.junior);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", junior);

        String actual = driver.findElement(By.xpath("(//*[text()='Junior Softwareentwickler / Consultant - Enterprise Portal Anwendungen (w/d/m)'])[2]")).getText();
        String expected = "Junior Softwareentwickler / Consultant - Enterprise Portal Anwendungen (w/d/m)";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void HomeLoginButton() throws InterruptedException {

        driver.findElement(By.xpath("//nav[@class='top__extra-nav']//a[6]")).click();
        driver.navigate().to("https://services.usu.com/simplesaml/module.php/core/loginuserpass.php?AuthState=_32c4b08ed36e24697374eb31ab1da92b4c4df7e9bd%3Ahttps%3A%2F%2Fservices.usu.com%2Fsimplesaml%2Fsaml2%2Fidp%2FSSOService.php%3Fspentityid%3Dhttps%253A%252F%252Fservices.usu.com%252Fsimplesaml%252Fmodule.php%252Fsaml%252Fsp%252Fmetadata.php%252Ftypo3-sp%26RelayState%3Dhttps%253A%252F%252Fservices.usu.com%252Fknowledgehub%252Fen%252F%253Flogintype%253Dlogin%26cookieTime%3D1686819758");
        WebElement register = driver.findElement(By.xpath("//div[@class='login-options']/a[2]"));
        register.click();
    }
    @Test
    public void Register() throws InterruptedException {
        driver.get("https://services.usu.com/simplesaml/module.php/aspera/requestlogin.php?AuthState=_e17f1706e9180df24a9d0ab036055132ef3e5b9ba9:https://services.usu.com/simplesaml/saml2/idp/SSOService.php?spentityid=https%3A%2F%2Fservices.usu.com%2Fsimplesaml%2Fmodule.php%2Fsaml%2Fsp%2Fmetadata.php%2Ftypo3-sp&RelayState=https%3A%2F%2Fservices.usu.com%2Fknowledgehub%2Fen%2F%3Flogintype%3Dlogin&cookieTime=1686923853");
        Thread.sleep(1000);
        WebElement firstname = driver.findElement(By.xpath("//*[@id=\"firstname-8fa8fa78-8015-496a-a831-6b19228ec753\"]"));
        firstname.sendKeys("Alex");
        driver.findElement(By.xpath("//input[@id='lastname-8fa8fa78-8015-496a-a831-6b19228ec753']")).sendKeys("Adler");
        driver.findElement(By.xpath("//input[@id='company-8fa8fa78-8015-496a-a831-6b19228ec753']")).sendKeys("ABC GmbH");
        driver.findElement(By.xpath("//input[@id='email-8fa8fa78-8015-496a-a831-6b19228ec753']")).sendKeys("alex@abc.de");
        driver.findElement(By.xpath("//input[@id='jobtitle-8fa8fa78-8015-496a-a831-6b19228ec753']")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@id='one_knowledge_customer_key-8fa8fa78-8015-496a-a831-6b19228ec753']")).sendKeys("Nein");
        driver.findElement(By.xpath("//select[@id='aspera_country-8fa8fa78-8015-496a-a831-6b19228ec753']")).click();
        driver.findElement(By.xpath("//option[@value='Germany']")).isSelected();
        WebElement country = driver.findElement(By.xpath("//select[@id='aspera_country-8fa8fa78-8015-496a-a831-6b19228ec753']"));

        Select select = new Select(country);
        //select.selectByVisibleText("Finland");
        //country.sendKeys(Keys.ENTER);
        System.out.println("Countries Size is " + select.getOptions().size());
        List<WebElement> options = select.getOptions();

        for (WebElement state : options){
            if (state.getText().equals("Germany")) {
                state.click();
                break;
            }
        }
        driver.findElement(By.xpath("//input[@id='one_knowledge_solution_area0-8fa8fa78-8015-496a-a831-6b19228ec753']")).click();
        driver.findElement(By.xpath("//input[@id='one_knowledge_solution_area4-8fa8fa78-8015-496a-a831-6b19228ec753']")).click();
        driver.findElement(By.xpath("//input[@id='one_knowledge_solution_area2-8fa8fa78-8015-496a-a831-6b19228ec753']")).click();
        driver.findElement(By.xpath("//textarea[@id='message-8fa8fa78-8015-496a-a831-6b19228ec753']")).sendKeys("Softwaretest Automation");
        driver.findElement(By.xpath("//input[@value='Absenden']")).submit();

        WebElement datenschutz =driver.findElement(By.xpath("//p[contains(text(),'Ich habe die')]"));
        String subdatenschutz = datenschutz.getText().substring(0,200);
        Assert.assertEquals(subdatenschutz, "Ich habe die Datenschutzerklärung zur Kenntnis genommen. " +
                                "Die Verarbeitung meiner personenbezogenen Daten erfolgt aufgrund des oben referenzierten Vertrages und beruht damit auf Art. 6 I lit. b DS-GVO.");


        Thread.sleep(2000);
        String actual = driver.findElement(By.xpath("//*[text()='Vielen Dank für Ihre Registrierung.']")).getText();
        Assert.assertEquals(actual, "Vielen Dank für Ihre Registrierung.");
    }

    @Test
    public void AssetManagement() throws InterruptedException {

        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement link = driver.findElement(By.xpath("//a[@href='/de-de/loesungen/usu-software-asset-management/'][normalize-space()='Mehr erfahren']"));
        jse.executeScript("arguments[0].click();", link);
        Thread.sleep(1000);
        WebElement video = driver.findElement(By.xpath("//span[@class='player__poster']//img"));
        jse.executeScript("arguments[0].click();", video);

    }
}
