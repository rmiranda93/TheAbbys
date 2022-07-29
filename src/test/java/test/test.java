package test;
import Utils.DataDriven;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import Utils.PropDriven;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;


public class test {

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
    public void LOGIN(){
        datosCP = DataDriven.getData("CP01_LOGIN");
        loginSD.DefinirEspera(3000);
        loginSD.login(datosCP.get(1),datosCP.get(2));
        Assert.assertEquals(loginSD.TituloProducts(), datosCP.get(3));

    }

    @Test
    public void LOGINFALLIDO(){
        datosCP = DataDriven.getData("CP02_LOGINFALLIDO");
        loginSD.DefinirEspera(3000);
        loginSD.login(datosCP.get(1),datosCP.get(2));
        Assert.assertEquals(claveincorrecta.TituloError(), datosCP.get(4));
    }

    @Test
    public void addCart(){
        datosCP = DataDriven.getData("CP03_ADDCART");
        cart.DefinirEspera(3000);
        loginSD.login(datosCP.get(1),datosCP.get(2));
        cart.AddToCart();
        cart.checkcart();
        Assert.assertEquals(cart.CheckInfo(), datosCP.get(5));
    }

    @Test
    public void payCheckOut(){
        datosCP = DataDriven.getData("CP04_PAYCHECKOUT");
        loginSD.login(datosCP.get(1),datosCP.get(2));
        cart.AddToCart();
        cart.checkcart();
        payCheckout.PayCheckOut(datosCP.get(6),datosCP.get(7),datosCP.get(8));
        Assert.assertEquals(payCheckout.CheckCompleted(), datosCP.get(9));
        Assert.assertEquals(payCheckout.Order(), datosCP.get(10));

    }


}
