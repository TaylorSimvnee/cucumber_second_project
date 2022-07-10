package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class ViewAllOrdersPage {

    public ViewAllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#ctl00_menu a")
    public List<WebElement> menuList;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAllButton;

    @FindBy(css = "input[id^= 'ctl00_MainContent_orderGrid_ct']")
    public List<WebElement> checkBoxes;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAllButton;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement deleteSelectedButton;

    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement emptyOrderListMessage;

    @FindBy(css = "#ctl00_MainContent_orderGrid tr")
    public List<WebElement> ordersTableRows;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]/td")
    public List<WebElement> enteredOrderDisplayed;




    public void clickOnMenuItem(String text){
        for (WebElement e : menuList) {
            if (e.getText().equals(text)){
                e.click();
            }
        }
    }
}
