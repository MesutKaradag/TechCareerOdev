package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KitapYurduPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Hesap_Bilgileri_Güncelle {

// 1- "KitapYurdu" web sitesine git.
// 2- Cerezleri kabul et.
// 3- "Giriş Yap" butonuna tıkla.
// 4- Kullanıcı giriş yap ekranını görüntüle. E-posta ve şifre alanlarına geçerli bilgiler gir, giriş yap.
// 5- Giriş sonrası "Merhaba Mesut Karadağ" yazısının görüntülendiğini kontrol et.
// 6- "Merhaba Mesut Karadağ" yazısının üstüne git, kullanıcı profil menüsü seçeneklerini görüntüle.
// 7- "Hesabım" seçeneğine tıkla.
// 8- Hesap bilgilerini güncellemek için "Hesap Bilgilerim" seçeneğine tıkla.
// 9- Takma ad, doğum tarihi (ay, gün, yıl) alanlarına yeni bilgiler gir.
// 10- "Kaydet" butonuna tıkla.
// 11- "Hesabınız başarılı bir şekilde güncellendi." yazısının görüntülendiğini kontrol et.

    @Test
    @Description("Hesap bilgileri güncelleme kontrol edilecek")
    @Severity(SeverityLevel.NORMAL)
    public void test01() {

        KitapYurduPage kitapYurduPage= new KitapYurduPage();

        Allure.step("KitapYurdu web sitesine git.");
        Driver.getDriver().get(ConfigReader.getProperty("kitapyurduUrl"));

        Actions actions = new Actions(Driver.getDriver());

        Allure.step("Cerezleri kabul et.");
        kitapYurduPage.cerezler.click();

        Allure.step("Giris Yap butonuna tikla.");
        kitapYurduPage.girisYapButton.click();

        Allure.step(" Kullanıcı giris yap ekranini görüntüle. E-posta ve sifre alanlarina geçerli bilgiler gir, giris yap.");
        kitapYurduPage.email.sendKeys("mesutkaradag56@gmail.com");

        kitapYurduPage.sifre.sendKeys("mesut123789MESUT.");

        kitapYurduPage.hesapGiris.click();

        Allure.step("Giriş sonrasi kullanici adi 'Mesut Karadağ' yazisinin görüntülendiğini kontrol et.");
        Assert.assertTrue( kitapYurduPage.hesabimKontrol.isDisplayed(),"'Mesut Karadağ' yazısı görünmedi. Giriş başarısız olmuş olabilir.");

        Allure.step(" Merhaba Mesut Karadağ yazısının üstüne git, kullanıcı profil menüsü seçeneklerini görüntüle.");
        actions.moveToElement(kitapYurduPage.menu).perform();

        Allure.step("Hesabım seçeneğine tıkla.");
        kitapYurduPage.hesabim.click();

        Allure.step("Hesap bilgilerini güncellemek için Hesap Bilgilerim seçeneğine tıkla.");
        kitapYurduPage.hesapBilgileri.click();

        Allure.step("Takma ad, doğum tarihi (ay, gün, yil) alanlarina yeni bilgiler gir.");
        kitapYurduPage.nickName.sendKeys("AlKitapAl12Kurduu198");

        Select selectDay = new Select(kitapYurduPage.gun);
        Select selectMonth = new Select(kitapYurduPage.ay);
        Select selectYear = new Select(kitapYurduPage.yil);

        selectDay.selectByValue("19");

        selectMonth.selectByVisibleText("Ocak");

        selectYear.selectByValue("2001");

        Allure.step("Kaydet butonuna tikla.");
        kitapYurduPage.kaydet.click();

        Allure.step("Hesabiniz basarili bir sekilde güncellendi.' yazisinin görüntülendiğini kontrol et.");
        Assert.assertTrue( kitapYurduPage.kayitBasarili.isDisplayed(),"'Hesabiniz basarili bir sekilde güncellendi.' yazisi görünmedi. Bilgi güncelleme basarisiz olmus olabilir");

        Allure.step("Driver kapatildi");
        Driver.closeDriver();
    }
}
