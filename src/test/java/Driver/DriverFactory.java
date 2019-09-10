package Driver;
import Common.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    static WebDriver driver = null;
    static WebDriver getDriver() {
        String driverName = System.getProperty("driver");
        if ("edge".equals(driverName)) {
            System.setProperty("webdriver.edge.driver", "Drivers/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Constants.BASE_URL);
        return driver;
    }
}
