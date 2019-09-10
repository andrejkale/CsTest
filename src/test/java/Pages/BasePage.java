package Pages;
import Driver.MyDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected static WebDriver driver = MyDriver.getMyDriver();
    public BasePage() {
        PageFactory.initElements(driver, this);
    }
    WebDriverWait webElement = new WebDriverWait(driver, 10);
}
