package com.cucumber.junit.steps;

import com.opencsv.exceptions.CsvException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.PopupPage;
import tools.CSVReaderFromFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



public class StepDefinitions {
    private static final String HIGHCHARTS_URL = "https://www.highcharts.com/demo/combo-timeline/";
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public PopupPage getPopupPage() {
        return new PopupPage(getDriver());
    }

    List<String> textFromTooltip;
    List<String[]> textFromCSVFile;

    @Before
    public void testSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HIGHCHARTS_URL);
    }
    @After
    public void tearDown() {
        driver.close();
    }



    @Given("User do some preparations for the test")
    public void disableUnnecessaryFunctions() throws InterruptedException {
        Thread.sleep(1000);
        getPopupPage().useNecessaryCookiesOnlyButton.click();
        getHomePage().disableGoogleGraph();
        getHomePage().disableRevenueGraph();
    }

    @When("User write all information from tooltips")
    public List<String> writeTextFromToolTip() {
        Actions actions = new Actions(driver);
          textFromTooltip = new ArrayList<>();
        for (WebElement element : getHomePage().listOfEmployee) {
            actions.moveToElement(element).perform();
            textFromTooltip.add(getHomePage().tooltip.getText());
            }
        return textFromTooltip;
    }

    @Then("User read expected data from the file")
    public List<String[]> userReadExpectedDataFromTheFile() throws IOException, CsvException {
        textFromCSVFile = CSVReaderFromFile
                .parseCSVFile(new File("src/main/resources/expectingTestDataForTests.csv"));
        return textFromCSVFile;
    }

    @Then("User verify text from Tooltips with text from CSV file")
    public void userVerifyTextFromTooltipsWithTextFromCSVFile() {
        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 2; i < textFromTooltip.size(); i++) {
            String receivedResult = textFromTooltip.get(i).replace(",", "")
                    .replace(" ", "")
                    .replace("employees", "")
                    .toLowerCase(Locale.ROOT);
            String expectedResult = String.join("",textFromCSVFile.get(i))
                    .replace(",", "")
                    .replace(" ", "")
                    .toLowerCase(Locale.ROOT);
            softAssertions.assertThat(receivedResult).isEqualTo(expectedResult);

        }
        softAssertions.assertAll();

    }

    @Then("User download CSV file from chart context menu")
    public void userDownloadCSVFileFromChartContextMenu() {
        getHomePage().clickOnChartContextMenuButton();
        getHomePage().clickOnDownloadCSVButton();
    }

}
