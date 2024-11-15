package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KitapYurduPage;
import utilities.ConfigReader;
import utilities.Driver;
import java.time.Duration;

public class Sepetten_Urun_Silme {

// 1- "KitapYurdu" web sitesine git.
// 2- Çerezleri kabul et.
// 3- Arama kutusuna "Yüzüklerin Efendisi" yaz ve arama yap.
// 4- Arama sonucları sayfasında bulunan kitaba tıkla
// 5- Sepete ekle butonuna tıkla
// 6- Sepetim butonuna tıkla ve ardından "Sepete Git" seçeneğine tıkla.
// 7- Açılan sayfada "Sepetim" yazısının ekrana geldiğini doğrula.
// 8- Kitap adını kontrol ederek ürünün sepete eklendiğini doğrula.
// 9- Sil butonuna tıkla
// 10- Açılan ekranda işlemi onayla
// 11- "Sepetinizde urun bulunmamaktadır" yazısının ekrana geldiğini doğrula.

    @Test
    @Description("Sepetten ürün silme kontrol edilecek")
    @Severity(SeverityLevel.CRITICAL)
    public void test01() {



        KitapYurduPage kitapyurdupage= new KitapYurduPage();

        Allure.step("KitapYurdu web sitesine git.");
        Driver.getDriver().get(ConfigReader.getProperty("kitapyurduUrl"));

        Allure.step("Cerezleri kabul et");
        kitapyurdupage.cerezler.click();

        Allure.step("Arama kutusuna 'Yüzüklerin Efendisi' yaz ve arama yap");
        kitapyurdupage.aramaKutusu.sendKeys("Yüzüklerin Efendisi" + Keys.ENTER);

        Allure.step("Arama sonuclari sayfasinda bulunan kitaba tikla");
        kitapyurdupage.arananKitap.click();

        Allure.step("Sepete ekle butonuna tikla");
        kitapyurdupage.sepeteEkle.click();

        Allure.step("Sepetim butonuna tikla ve ardından 'Sepete Git' seceneğine tıkla.");
        kitapyurdupage.sepetMenu.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(kitapyurdupage.sepeteGit));

        kitapyurdupage.sepeteGit.click();

        Allure.step("Acilan sayfada 'Sepetim' yazisinin ekrana geldigini dogrula.");
        Assert.assertTrue( kitapyurdupage.sepetteyim.isDisplayed(),"'Sepetim' yazisi görünmedi. Sepete Giris basarisiz olmus olabilir.");

        Allure.step("Kitap adini kontrol ederek ürünün sepete eklendiğini dogrula.");
        Assert.assertTrue( kitapyurdupage.urunAd.isDisplayed()," Kitap adi görünmedi. Sepete urun eklenmemis olabilir.");

        Allure.step("Sil butonuna tikla");
        kitapyurdupage.urunSil.click();

        Allure.step("Acilan ekranda islemi onayla");
        kitapyurdupage.silOnay.click();

        Allure.step("Acılan ekranda 'Sepetinizde urun bulunmamaktadir' yazisinin ekrana geldigini dogrula.");
        Assert.assertTrue( kitapyurdupage.sepetteyim.isDisplayed(),"'Sepetinizde urun bulunmamaktadir yazisi görünmedi.");

        Allure.step("Driver kapatildi");
        Driver.closeDriver();
    }
}