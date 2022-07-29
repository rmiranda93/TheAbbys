package pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterPriceLTH extends BaseClass {

    By wrapper = By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[2]/div[2]/span[1]/select[1]");
    By lowToHigh = By.xpath("//option[contains(text(),'Price (low to high)')]");
    By VerifPrice = By.xpath("div.page_wrapper div.inventory_container div.inventory_list div.inventory_item:nth-child(1) div.inventory_item_description div.inventory_item_label a:nth-child(1) > div.inventory_item_name");

    public FilterPriceLTH(WebDriver driver) {
        super(driver);
    }

    public void changeFilterLTH(){
        DefinirEspera(2000);
        click(explicitWait(wrapper));
        DefinirEspera(2000);
        click(explicitWait(lowToHigh));
    }

    public String VerifLP(){return getText(explicitWait(VerifPrice));}
}
