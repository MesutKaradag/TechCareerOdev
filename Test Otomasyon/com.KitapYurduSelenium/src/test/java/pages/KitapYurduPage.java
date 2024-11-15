package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KitapYurduPage {

    public KitapYurduPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

   @FindBy(xpath = "//span[@title='Giriş Yap']")
    public WebElement giris;

    @FindBy(xpath = "//div[@id=\"cookiescript_accept\"]")
    public WebElement cerezler;

    @FindBy(xpath = "//a[contains(text(),'Giriş Yap')]")
    public WebElement girisYapButton;

    @FindBy(xpath = "//input[@id='login-email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='login-password']")
    public WebElement sifre;

   @FindBy(xpath = "//button[@role='button']")
    public WebElement hesapGiris;

   @FindBy(xpath = "//b[contains(text(),'Mesut Karadağ')]")
    public WebElement hesabimKontrol;

   @FindBy(xpath = "//input[@id='search-input']")
    public WebElement aramaKutusu;

   @FindBy(xpath = "//span[contains(text(),'Yüzük Kardeşliği Yüzüklerin Efendisi 1')]")
    public WebElement arananKitap;

   @FindBy(xpath = "//p[@class='product-name flex-grow-1']")
    public WebElement urunAd;

   @FindBy(xpath = "//span[normalize-space()='Sepete Ekle']")
   public WebElement sepeteEkle;

   @FindBy(xpath = "//h4[@class='common-sprite']")
    public WebElement sepetMenu;

   @FindBy(xpath = "//a[@id='js-cart']")
    public WebElement sepeteGit;

   @FindBy(xpath = "//span[@class='fs-4 text-gray-800']")
    public WebElement sepetteyim;

   @FindBy(xpath = "//div[@class='ky-error']")
    public WebElement hataliGirisMesaji;

   @FindBy(xpath = "//i[@class='cart-sprite cart-icon-trash']")
    public WebElement urunSil;

   @FindBy(xpath = "//button[@class='btn fs-18 bg-gray-200 lh-sm text-gray-900 mb-10px p-15px']")
   public WebElement silOnay;

   @FindBy(xpath = "//span[contains(text(),'Sepetinizde ürün bulunmamaktadır.')]")
    public WebElement silKontrol;

   @FindBy(xpath = "//div[@class='menu top login']//a[@class='common-sprite']")
    public WebElement menu;

   @FindBy(xpath = "//a[contains(text(),'Hesabım')]")
    public WebElement hesabim;

   @FindBy(xpath = "//span[normalize-space()='Hesap Bilgilerim']")
    public WebElement hesapBilgileri;

   @FindBy(xpath = "//input[@name='nickname']")
    public WebElement nickName;


   @FindBy(xpath = "//select[@name='day']")
    public WebElement gun;

   @FindBy(xpath = "//select[@name='month']")
    public WebElement ay;

   @FindBy(xpath = "//select[@name='year']")
    public WebElement yil;

    @FindBy(xpath = "//input[@id='button']")
    public WebElement kaydet;

     @FindBy(xpath = "//div[@class='alert dismissable success']")
    public WebElement kayitBasarili;


}
