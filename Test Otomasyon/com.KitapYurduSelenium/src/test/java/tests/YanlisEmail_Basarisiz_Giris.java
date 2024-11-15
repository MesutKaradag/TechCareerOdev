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

public class YanlisEmail_Basarisiz_Giris {

// 1- "KitapYurdu" web sitesine git.
// 2-  Çerezleri kabul et.
// 3- "Giriş Yap" butonuna tıkla.
// 4- Kullanıcı giriş yap ekranını görüntüle.
// 5- Geçersiz Email ve geçerli sifre bilgileri ile giris yap.
// 6- Hata mesajı "E-Posta Adresi ya da şifreniz yanlış." yazısının görüntülendiğini kontrol et.

    @Test
    @Description("Yanlis Email ile basarisiz giris kontrol edilecek")
    @Severity(SeverityLevel.NORMAL)
    public void test01() {

        KitapYurduPage kitapYurduPage= new KitapYurduPage();

        Allure.step(" KitapYurdu web sitesine git.");
        Driver.getDriver().get(ConfigReader.getProperty("kitapyurduUrl"));

        Allure.step("Cerezleri kabul et.");
        kitapYurduPage.cerezler.click();

        Allure.step("Giris Yap butonuna tikla.");
        kitapYurduPage.girisYapButton.click();

        Allure.step(" Geçersiz Email ve geçerli sifre bilgileri ile giris yap.");
        kitapYurduPage.email.sendKeys("mesutkaradag@gmail.com");

        kitapYurduPage.sifre.sendKeys("mesut123789MESUT.");

        kitapYurduPage.hesapGiris.click();

        Allure.step("Hata mesajı 'E-Posta Adresi ya da şifreniz yanlis.' yazisinin görüntülendiğini kontrol et.");
        Assert.assertTrue(kitapYurduPage.hataliGirisMesaji.isDisplayed(), " Hata mesaji goruntulenemedi");

        Allure.step("Driver kapatildi");
        Driver.closeDriver();
    }
}
