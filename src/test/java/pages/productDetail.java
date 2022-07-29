package pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class productDetail extends BaseClass {

    public productDetail(WebDriver driver) {
        super(driver);
    }

    By BPDetail = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/div[1]");
    By JacketDetail = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/a[1]/div[1]");
    By btnBacktoProducts = By.xpath("//button[@id='back-to-products']");

    By Products = By.xpath("//span[contains(text(),'Products')]");


    public void productdetails(){
        DefinirEspera(3000);
        click(explicitWait(BPDetail));
        DefinirEspera(3000);
        click(btnBacktoProducts);
        DefinirEspera(3000);
        click(explicitWait(JacketDetail));
        DefinirEspera(3000);
        click(btnBacktoProducts);
    }

    public String TituloProducts(){
        return getText(explicitWait(Products));
    }

}
