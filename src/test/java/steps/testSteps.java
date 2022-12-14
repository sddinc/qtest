package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.testPage;
import testbase.BaseClass;

public class testSteps {
    BaseClass bs= new BaseClass();
    testPage tPage = new testPage();
    @Given("I add four random items to my cart")
    public void i_add_four_random_items_to_my_cart() {
        bs.Setup();
        tPage.clickOnRandomItemInList();
    }
    @When("I view my cart")
    public void i_view_my_cart() {

    }
    @Then("I find total four items listed in my cart")
    public void i_find_total_four_items_listed_in_my_cart() {

    }
    @When("I search for lowest price item")
    public void i_search_for_lowest_price_item() {

    }
    @When("I am able to remove the lowest price item from my cart")
    public void i_am_able_to_remove_the_lowest_price_item_from_my_cart() {

    }
    @Then("I am able to verify three items in my cart")
    public void i_am_able_to_verify_three_items_in_my_cart() {

    }
}
