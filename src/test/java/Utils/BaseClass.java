package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {

    //Atributos
    protected WebDriver driver;

    protected WebDriverWait wait;

    //Metodos
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    //Constructor

    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }

    //FUNCIONES

    //Buscar un elemento web
    public WebElement FindWE(By locator){return this.driver.findElement(locator); }

    //Arrancar Browser
    public void RunSite(String url) {
        this.driver.get(url);
    }

    // espera explicita
    public WebElement explicitWait(By locator){
        wait = new WebDriverWait(this.driver,120);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //espera implicita

    public void DefinirEspera(int miliSegundos){
        try{
            Thread.sleep(miliSegundos);
        }catch (Exception e){
            System.out.println("Espera implicita fallida");
            e.getStackTrace();
        }
    }
    //Click
    public void click(By locator){
        this.driver.findElement(locator).click();
    }
    public void click(WebElement elementoWeb){elementoWeb.click();}

    //obtener texto
    //public String getText(By locator){this.driver.findElement(locator).getText();}
    public String getText(WebElement locator){
        return locator.getText();
    }

    //Agregar texto
    public void addText(By locator, String texto){
        this.driver.findElement(locator).sendKeys(texto);
    }
    public void addText(WebElement elementoWeb, String texto){
        elementoWeb.sendKeys(texto);
    }

    //Maximizar el browser
    public void maxBrowser() {this.driver.manage().window().maximize();}

    //Cerrar Browser
    public void closeBrowser() {this.driver.close();}

    //Conexion Browser

    public WebDriver conexionBrowser(String browser, String ruta, String propertyDriver){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty(propertyDriver,ruta);
            this.driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty(propertyDriver,ruta);
            this.driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("IExplorer")){
            System.setProperty(propertyDriver,ruta);
            this.driver = new InternetExplorerDriver();
        }
        return this.driver;
    }

    //Verificar si se despliega un elemento web
    public boolean isDeployed(By locator){
        try{
            return this.driver.findElement(locator).isDisplayed();
        }catch (Exception e){
            System.out.println("No se encontro el elemento : "+locator);
            return false;
        }
    }

    public boolean isEnabled(By locator){
        try{
            return this.driver.findElement(locator).isEnabled();
        }catch (NoSuchElementException e){
            System.out.println("No se encontro el elemento : "+locator);
            return false;
        }
    }
}
