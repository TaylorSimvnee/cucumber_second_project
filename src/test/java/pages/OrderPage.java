package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class OrderPage {

    public OrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct>option")
    public List<WebElement> productDropDown;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityInoutBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerNameInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetInoutBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityInoutBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateInoutBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipInoutBox;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList input")
    public List<WebElement> cardTypeRadioButtons;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList label")
    public List<WebElement> cardTypeRadioLabels;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumberInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement cardExpireInoutBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;




    public void clickOnProductDropDownItem(String text){
        for (WebElement e : productDropDown) {
            if (e.getText().equals(text)){
                e.click();
            }
        }
    }


    public void clickOnCardType(String text){
        for (int i = 0; i < 3; i++) {
            if (cardTypeRadioLabels.get(i).getText().equals(text)){
                cardTypeRadioButtons.get(i).click();
            }
        }
    }
}
