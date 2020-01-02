package com.wipro.ta.steps;

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NetshoesHomePageSteps extends AbstractSteps {

    @Value("${home.url}")
    private String NETSHOES_HOMEPAGE_URL;

    protected Logger LOG = Logger.getLogger(this.getClass());

    @Autowired
    protected WebDriverProvider webDriverProvider;

    @Given("the customer access the NetShoes home page")
    public void givenCustomerAccessHomePage() {
        LOG.info("Navigating user to page: " + NETSHOES_HOMEPAGE_URL);
        webDriverProvider.get().get(NETSHOES_HOMEPAGE_URL);
    }

    @Then("I should see the search bar")
    public void thenProductListIsDisplayed() {
        WebElement contentDiv = webDriverProvider.get().findElement(By.id("search-input"));
        Assert.assertTrue("The search bar was expected to be displayed, but it was not."
                , contentDiv.isDisplayed());
    }
}