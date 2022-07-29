package pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOut extends BaseClass {

    By sidemenu = By.xpath("//button[@id='react-burger-menu-btn']");

    By btnlogOut = By.xpath("//a[@id='logout_sidebar_link']");

    By logOutVerif = By.xpath("//h4[contains(text(),'Accepted usernames are:')]");

    public LogOut(WebDriver driver) {
        super(driver);
    }

    public void logOut(){
        click(explicitWait(sidemenu));
        DefinirEspera(3000);
        click(explicitWait(btnlogOut));
        }

    public String logOutVerif(){return getText(explicitWait(logOutVerif));}
}
