import com.opencsv.exceptions.CsvException;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tools.CSVReaderFromFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class UITests extends BaseTest {

    @DisplayName("Downloading csv File")
    @Test
    public void openHomePage() throws InterruptedException {
        getPopupPage().clickOnUseNecessaryCookiesOnlyButton();
        getHomePage().clickOnChartContextMenuButton();
        getHomePage().clickOnDownloadCSVButton();

    }


    @DisplayName("Verify data from tooltips and CSV file")
    @Test
    public void verifyTextFromTooltip() throws InterruptedException, IOException, CsvException{
        getPopupPage().clickOnUseNecessaryCookiesOnlyButton();
        getHomePage().disableGoogleGraph();
        getHomePage().disableRevenueGraph();
        Actions actions = new Actions(driver);
        List<String> textFromTooltip = new ArrayList<>();

        for (WebElement element : getHomePage().listOfEmployee) {
            actions.moveToElement(element).perform();
            textFromTooltip.add(getHomePage().tooltip.getText());
        }
        List<String[]> textFromCSVFile = CSVReaderFromFile
                .parseCSVFile(new File("src/main/resources/expectingTestDataForTests.csv"));

        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 2; i < textFromTooltip.size(); i++) {
            String receivedResult = textFromTooltip.get(i).replace(",", "")
                    .replace(" ", "")
                    .replace("employees", "")
                    .toLowerCase(Locale.ROOT);
            String expectedResult = Arrays.toString(textFromCSVFile.get(i)).
                    replace(",", "")
                    .replace(" ", "")
                    .replace("[", "")
                    .replace("]", "")
                    .toLowerCase(Locale.ROOT);
            softAssertions.assertThat(receivedResult).as("Received text is not match the expected from the CSV file").isEqualTo(expectedResult);
        }
        softAssertions.assertAll();
    }

    @DisplayName("Verify data from tooltips and CSV file with String Join")
    @Test
    public void verifyTextFromTooltipUsingStringJoin() throws InterruptedException, IOException, CsvException {
        getPopupPage().clickOnUseNecessaryCookiesOnlyButton();
        getHomePage().disableGoogleGraph();
        getHomePage().disableRevenueGraph();
        Actions actions = new Actions(driver);
        List<String> textFromTooltip = new ArrayList<>();
        for (WebElement element : getHomePage().listOfEmployee) {
           actions.moveToElement(element).perform();
            textFromTooltip.add(getHomePage().tooltip.getText());
        }
        List<String[]> textFromCSVFile = CSVReaderFromFile
                .parseCSVFile(new File("src/main/resources/expectingTestDataForTests.csv"));

        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 2; i < textFromTooltip.size(); i++) {
            String receivedResult = textFromTooltip.get(i)
                    .replace(",", "")
                    .replace(" ", "")
                    .replace("employees", "")
                    .toLowerCase(Locale.ROOT);
            String expectedResult = String.join("",textFromCSVFile.get(i))
                    .replace(",", "")
                    .replace(" ", "")
                    .toLowerCase(Locale.ROOT);

            softAssertions.assertThat(receivedResult).as("Received text is not match the expected from the CSV file").isEqualTo(expectedResult);

        }
        softAssertions.assertAll();

    }
}
