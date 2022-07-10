package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.*;
import pages.OrderPage;
import pages.SmartBearLoginPage;
import pages.ViewAllOrdersPage;
import utils.DateHandler;
import utils.Driver;
import utils.Waiter;

import java.util.NoSuchElementException;

public class SmartBearSteps {

    WebDriver driver;
    SmartBearLoginPage smartBearLoginPage;
    ViewAllOrdersPage viewAllOrdersPage;
    OrderPage orderPage;

    @Before
    public void setUp(){
        driver = Driver.getDriver();
        smartBearLoginPage = new SmartBearLoginPage();
        viewAllOrdersPage = new ViewAllOrdersPage();
        orderPage = new OrderPage();
    }


    @When("user enters username as {string}")
    public void userEntersUsernameAs(String userName) {
        smartBearLoginPage.userNameInputBox.sendKeys(userName);
    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String password) {
        smartBearLoginPage.passwordInputBox.sendKeys(password);
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        smartBearLoginPage.loginButton.click();
    }

    @Then("user should see {string} Message")
    public void userShouldSeeMessage(String text) {
        Assert.assertTrue(smartBearLoginPage.errorMessage.isDisplayed());
        Assert.assertEquals(text, smartBearLoginPage.errorMessage.getText());
    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String URL) {
        Assert.assertEquals(URL,driver.getCurrentUrl());
    }

    @And("validate below menu items are displayed")
    public void validateBelowMenuItemsAreDisplayed(DataTable dataTable) {
        for (int i = 0; i < dataTable.asList().size(); i++) {
            Assert.assertEquals(dataTable.asList().get(i), viewAllOrdersPage.menuList.get(i).getText());
        }
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String text) {
        switch (text){
            case "Check All":
                viewAllOrdersPage.checkAllButton.click();
                break;
            case "Uncheck All":
                viewAllOrdersPage.uncheckAllButton.click();
                break;
            case "Process":
                orderPage.processButton.click();
                Waiter.pause(6);
                break;
            case "Delete Selected":
                viewAllOrdersPage.deleteSelectedButton.click();
                break;
            default:
                throw new NotFoundException("The text is not defined properly in the feature file!!!");
        }
    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        for (WebElement e : viewAllOrdersPage.checkBoxes) {
            Assert.assertTrue(e.isSelected());
        }
    }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        for (WebElement e : viewAllOrdersPage.checkBoxes) {
            Assert.assertFalse(e.isSelected());
        }
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String text) {
        viewAllOrdersPage.clickOnMenuItem(text);
    }

    @And("user selects {string} as product")
    public void userSelectsAsProduct(String text) {
        orderPage.clickOnProductDropDownItem(text);
    }

    @And("user enters {string} as quantity")
    public void userEntersAsQuantity(String num) {
        orderPage.quantityInoutBox.sendKeys(num);
    }

    @And("user enters all address information")
    public void userEntersAllAddressInformation(DataTable dataTable) {

            orderPage.customerNameInputBox.sendKeys(dataTable.asList().get(0));
            orderPage.streetInoutBox.sendKeys(dataTable.asList().get(1));
            orderPage.cityInoutBox.sendKeys(dataTable.asList().get(2));
            orderPage.stateInoutBox.sendKeys(dataTable.asList().get(3));
            orderPage.zipInoutBox.sendKeys(dataTable.asList().get(4));
    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation(DataTable dataTable) {
        orderPage.clickOnCardType(dataTable.asList().get(0));
        orderPage.cardNumberInputBox.sendKeys(dataTable.asList().get(1));
        orderPage.cardExpireInoutBox.sendKeys(dataTable.asList().get(2));
    }

    @Then("user should see their order displayed in the {string} table")
    public void userShouldSeeTheirOrderDisplayedInTheTable(String text) {
        Assert.assertTrue(viewAllOrdersPage.ordersTableRows.size() > 9);

    }

    @And("validate all information entered displayed correct with the order")
    public void validateAllInformationEnteredDisplayedCorrectWithTheOrder(DataTable dataTable) {
        Waiter.pause(3);
        for (int i = 0; i < dataTable.asList().size(); i++) {
            if (i == 4){
                Assert.assertEquals(viewAllOrdersPage.enteredOrderDisplayed.get(i).getText(), DateHandler.getCurrentDate());

            }
            else Assert.assertEquals(dataTable.asList().get(i), viewAllOrdersPage.enteredOrderDisplayed.get(i).getText());
        }
    }

    @Then("validate all orders are deleted from the {string}")
    public void validateAllOrdersAreDeletedFromThe(String text) {
           Assert.assertFalse(viewAllOrdersPage.ordersTableRows.size() > 1);

    }

    @And("validate user sees {string} Message")
    public void validateUserSeesMessage(String text) {
        Assert.assertTrue(viewAllOrdersPage.emptyOrderListMessage.isDisplayed());
        Assert.assertEquals(text, viewAllOrdersPage.emptyOrderListMessage.getText());
    }
}
