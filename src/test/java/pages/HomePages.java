package pages;

import org.openqa.selenium.By;

public class HomePages {

     public By  cookies = By.xpath("//button[@id='uc-btn-accept-banner']");
     public By EndeckePlusLogoButton = By.xpath("//span[normalize-space()='Entdecke']");
     public By HomeHerrenButton = By.xpath("//span[@class='KxHAYs _2kjxJ6 dgII7d EvwuKo']");
     public By HomeBekleidungButton = By.xpath("//span[contains(text(),'Bekleidung')]");
     public By homeHemdenUnderBekleidung = By.xpath("//span[normalize-space()='Hemden']");
     public By btnHomeUnderBekleidungHemdenGrosse = By.xpath("//button[@aria-label='Filtere nach Größe']");
     public By ddHomeUnderBekleidungHemdenGrosse42 = By.xpath("//span[normalize-space()='42']");
     public By btnHomeUnderBekleidungHemdenGrosseSpeichern = By.xpath("//span[normalize-space()='Speichern']");

     public By btnHomeUnderBekleidungHemdenPreis = By.xpath("//button[@aria-label='Filtere nach Preis']");
     public By txtHomeUnderBekleidungHemdenPreisAb = By.xpath("//input[@id='collection-view-desktop-filter-prices-minimum']");
     public By txtHomeUnderBekleidungHemdenPreisBis = By.xpath("//input[@id='collection-view-desktop-filter-prices-maximum']");
     public By btnTxtHerrenHomeInspirierendeStorysAdidas = By.xpath("//li[1]//article[1]//a[1]//div[1]//figure[1]//div[1]//div[1]//img[1]");

}
