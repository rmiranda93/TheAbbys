package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import Utils.BaseClass;


public class login extends BaseClass {

    public login(WebDriver driver) { super(driver); }

    By userName = By.id("user-name");
    By password = By.name("password");
    By BtnIngresar = By.xpath("//input[@id='login-button']");

    By Products = By.xpath("//span[contains(text(),'Products')]");

    //Funcion
    public void login(String user, String pass){
        DefinirEspera(3000);
        click(explicitWait(userName));
        addText(userName,user);
        DefinirEspera(3000);
        click(explicitWait(password));
        addText(password,pass);
        DefinirEspera(3000);
        if(isEnabled(BtnIngresar)){
            click(explicitWait(BtnIngresar));
        }
        DefinirEspera(3000);
    }

    public String TituloProducts(){
        return getText(explicitWait(Products));
    }


}
