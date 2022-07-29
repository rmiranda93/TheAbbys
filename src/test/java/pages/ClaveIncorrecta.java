package pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClaveIncorrecta extends BaseClass {

    public ClaveIncorrecta(WebDriver driver) {
        super(driver);
    }

    By tituloErr = By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]");

    public String TituloError(){
        return getText(explicitWait(tituloErr));
    }

}
