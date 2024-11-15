package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KitapYurduPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Basarili_Kullanici_Girisi {

// 1- "KitapYurdu" web sitesine git.
// 2- Çerezleri kabul et.
// 3- "Giriş Yap" butonuna tıkla.
// 4- Kullanıcı giriş yap ekranını görüntüle. E-posta ve şifre alanlarına geçerli bilgiler gir, giriş yap.
// 5- Giriş sonrası "Merhaba Mesut Karadağ" yazısının görüntülendiğini kontrol et.



    @Test
    @Description("Basarili kullanici girisi kontrol edilecek")
    @Severity(SeverityLevel.CRITICAL)
    public void test01() {

        KitapYurduPage kitapYurduPage= new KitapYurduPage();

        Allure.step(" KitapYurdu web sitesine git.");
        Driver.getDriver().get(ConfigReader.getProperty("kitapyurduUrl"));

        Allure.step("Cerezleri kabul et.");
        kitapYurduPage.cerezler.click();

        Allure.step("Giris Yap butonuna tikla.");
        kitapYurduPage.girisYapButton.click();

        Allure.step(" Kullanıcı giris yap ekranini görüntüle. E-posta ve sifre alanlarina geçerli bilgiler gir, giris yap.");
        kitapYurduPage.email.sendKeys("mesutkaradag56@gmail.com");

        kitapYurduPage.sifre.sendKeys("mesut123789MESUT.");

        kitapYurduPage.hesapGiris.click();

        kitapYurduPage.hesabimKontrol.isDisplayed();

        Allure.step("Giriş sonrasi kullanici adi 'Mesut Karadağ' yazisinin görüntülendiğini kontrol et.");
        Assert.assertTrue( kitapYurduPage.hesabimKontrol.isDisplayed(),"'Mesut Karadağ' yazisi görünmedi. Giris başarisiz olmuş olabilir.");

        Allure.step("Driver kapatildi");
        Driver.closeDriver();
    }
}
