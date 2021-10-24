package Pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends BasePage{
	@FindBy(xpath="//a[@class='pure-menu-link squared scope']//span[@class='icon']")
	private WebElement searchButton;

	@FindBy(xpath="//*[@id='search_term']")
	private WebElement searchField;

    public void clickSearchButton(){
        searchButton.click();
    }

    public void executeSearch(String keyWord){
        searchField.sendKeys(keyWord);
        searchField.sendKeys(Keys.ENTER);
    }


}
