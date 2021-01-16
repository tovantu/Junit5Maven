package Drivers;

import UiHelper.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static ThreadLocal<DriverManager> driverManager = ThreadLocal.withInitial(()-> null);

    public WebDriver driver ;


    public DriverManager(){
        String browser = ReadProperties.getInstance("TestSetting").getProperty("browser");
        if(browser.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\java\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
    }

    public static DriverManager createInstance(){
        if (driverManager.get() != null) return driverManager.get();
        driverManager.set(new DriverManager());
        return driverManager.get();
    }

    public static WebDriver getDriver(){
        return createInstance().driver;
    }


    public static void resetDriver(){
        getDriver().quit();
        driverManager.set(null);
    }
}
