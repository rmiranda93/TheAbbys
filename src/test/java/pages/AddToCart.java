package pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCart extends BaseClass {

    By AddBP1 = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");

    By AddLight = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");

    By AddShirt = By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");

    By cart = By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]");

    By checkOut = By.xpath("//button[@id='checkout']");

    By checkInfo = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]");
    public AddToCart(WebDriver driver) {
        super(driver);
    }

    public String CheckInfo(){return getText(explicitWait(checkInfo));}

    public void AddToCart() {
        DefinirEspera(3000);;
        click(explicitWait(AddBP1));
        DefinirEspera(3000);
        click(explicitWait(AddLight));
        DefinirEspera(3000);
        click(explicitWait(AddShirt));
        DefinirEspera(3000);
       }

    public void checkcart(){
        click(explicitWait(cart));
        DefinirEspera(3000);
        click(explicitWait(checkOut));
        DefinirEspera(3000);
    }


}
