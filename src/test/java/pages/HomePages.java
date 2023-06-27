package pages;

import org.openqa.selenium.By;

public class HomePages {

     public By  cookies = By.xpath("//*[contains(text(),'Alle akzeptieren')]");
     public By UnternehmenButton = By.xpath("//a[normalize-space()='Unternehmen']");
     public By Karrier = By.xpath("//*[@id=\"→unternehmen\"]/li[6]");
     public By JobFinden = By.xpath("//*[@id=\"edit-text--8\"]");
     public By junior= By.xpath("//span[contains(text(),'Junior Softwareentwickler / Consultant - Enterprise')]");
}
