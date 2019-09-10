package Helpers;
import Common.Constants;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

import Pages.BasePage;

public class CommonHelper extends BasePage {

    public void appOut(){
        driver.quit();
    }

    public void appBefore(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
