package test;

import Utils.DataDriven;
import Utils.PropDriven;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.nio.file.Paths;
import java.util.ArrayList;

public class test2 {

    private WebDriver driver;
    private login loginSD;
    private ClaveIncorrecta claveincorrecta;
    private payCheckOut payCheckout;
    private LogOut logout;
    private AddToCart cart;
    private RemoveFromCart removecart;
    private FilterPriceLTH FilterLTH;
    private productDetail prodDetails;
    private ArrayList<String> datosCP;
    private String urlSite;
    private String path;
    private String browser;
    private String propertyDriver;


    @BeforeTest
    public void Starting(){
        path = Paths.get(System.getProperty("user.dir"),PropDriven.getProperty("rutaDriver")).toString();
        browser = PropDriven.getProperty("browser");
        propertyDriver = PropDriven.getProperty("propertyDriver");
        loginSD = new login(driver);
        loginSD.conexionBrowser(browser,path,propertyDriver);
        loginSD = new login(loginSD.getDriver());
        claveincorrecta = new ClaveIncorrecta(loginSD.getDriver());
        payCheckout = new payCheckOut(loginSD.getDriver());
        logout = new LogOut(loginSD.getDriver());
        cart = new AddToCart(loginSD.getDriver());
        removecart = new RemoveFromCart(loginSD.getDriver());
        prodDetails = new productDetail(loginSD.getDriver());
        datosCP = new ArrayList<>();
        FilterLTH = new FilterPriceLTH(loginSD.getDriver());
    }


    @BeforeMethod
    public void preparacion(){
        urlSite = PropDriven.getProperty("url");
        loginSD.RunSite(urlSite);
        loginSD.maxBrowser();
    }

    @Test
    public void logOut(){
        datosCP = DataDriven.getData("CP05_LOGOUT");
        loginSD.login(datosCP.get(1),datosCP.get(2));
        logout.DefinirEspera(3000);
        logout.logOut();
        Assert.assertEquals(logout.logOutVerif(), datosCP.get(3));
    }

    @Test
    public void removeFromCart(){
        datosCP = DataDriven.getData("CP06_REMOVEFROMCART");
        loginSD.login(datosCP.get(1),datosCP.get(2));
        cart.AddToCart();
        removecart.DefinirEspera(3000);
        removecart.remFromCart();
        Assert.assertEquals(removecart.yourCartVerif(),datosCP.get(3));
    }

    @Test
    public void FilterLTH(){
        datosCP = DataDriven.getData("CP07_FILTERLTH");
        loginSD.login(datosCP.get(1),datosCP.get(2));
        FilterLTH.changeFilterLTH();
    }

    @Test
    public void prodDetails(){
        datosCP = DataDriven.getData("CP08_PRODUCTDETAIL");
        loginSD.login(datosCP.get(1),datosCP.get(2));
        prodDetails.productdetails();
        Assert.assertEquals(prodDetails.TituloProducts(), datosCP.get(3));
    }
}
