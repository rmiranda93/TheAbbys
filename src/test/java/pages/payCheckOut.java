package pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class payCheckOut extends BaseClass {

    public payCheckOut(WebDriver driver) {
        super(driver);
    }

    //Funciones
    By firstName = By.xpath("//input[@id='first-name']");
    By Lastname = By.xpath("//input[@id='last-name']");
    By Zip = By.xpath("//input[@id='postal-code']");
    By btnContinue = By.xpath("//input[@id='continue']");
    By btnFinish = By.xpath("//button[@id='finish']");
    By CheckCompl = By.xpath("//span[contains(text(),'Checkout: Complete!')]");
    By Order = By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]");

    public String CheckCompleted(){return getText(explicitWait(CheckCompl));}

    public String Order(){return getText(explicitWait(Order));}

    public void PayCheckOut(String name, String lastname, String zip) {
        click(explicitWait(firstName));
        addText(firstName, name);
        DefinirEspera(3000);
        click(explicitWait(Lastname));
        addText(Lastname, lastname);
        DefinirEspera(3000);
        click(explicitWait(Zip));
        addText(Zip, zip);
        DefinirEspera(3000);
        if (isEnabled(btnContinue)) {
            click(explicitWait(btnContinue));
        }
        DefinirEspera(3000);
        if (isEnabled(btnFinish)) {
            click(explicitWait(btnFinish));
        }
    }
}
