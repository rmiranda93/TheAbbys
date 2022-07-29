package pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RemoveFromCart extends BaseClass {

    By removeBP1 = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    By removeLight = By.xpath("//button[@id='remove-sauce-labs-bike-light']");
    By removeShirt = By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']");

    By cart = By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]");

    By yourcart = By.xpath("//span[contains(text(),'Your Cart')]");


    public RemoveFromCart(WebDriver driver) {
        super(driver);
    }

    public void remFromCart() {
        DefinirEspera(3000);
        click(explicitWait(removeBP1));
        DefinirEspera(3000);
        click(explicitWait(removeLight));
        DefinirEspera(3000);
        click(explicitWait(removeShirt));
        DefinirEspera(3000);
        click(explicitWait(cart));
        DefinirEspera(3000);
    }

    public String yourCartVerif(){return getText(explicitWait(yourcart));}

}
