import com.opencsv.exceptions.CsvException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.CSVReaderFromFile;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;



public class UITests extends BaseTest {

    @DisplayName("Downloading csv File")
    @Test
    public void openHomePage() throws InterruptedException {
        getPopupPage().clickOnUseNecessaryCookiesOnlyButton();
        getHomePage().clickOnChartContextMenuButton();
        getHomePage().clickOnDownloadCSVButton();

    }


    @DisplayName("Parsing csv File")
    @Test
    public void parsingCSV() throws IOException, CsvException {
        List<String []> dataFromCSVFile= CSVReaderFromFile.parseCSVFile(new File(filePath));
    }

    @DisplayName("Using class Action")
    @Test
    public void verifyStephane() throws InterruptedException {
        getPopupPage().clickOnUseNecessaryCookiesOnlyButton();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[span = 'Area charts']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[span = 'Area charts']"))).
                perform();
        Thread.sleep(5000);
    }

    @DisplayName("Using Offset")
    @Test
    public void verifyStephaneWithAction() throws InterruptedException {
        getPopupPage().clickOnUseNecessaryCookiesOnlyButton();
        Thread.sleep(2000);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) By.xpath("//*[@class='highcharts-markers highcharts-series-2 highcharts-area-series highcharts-color-2 highcharts-tracker']/*")));
        for (WebElement element: getHomePage().listOfEmployee){
            element.click();
        }


        Thread.sleep(5000);
    }

    @DisplayName("Using JS executor")
    @Test
    public void verifyStephaneWithJS() throws InterruptedException {
        getPopupPage().clickOnUseNecessaryCookiesOnlyButton();
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'highcharts-a11y-proxy-button highcharts-no-tooltip']")));


        Thread.sleep(5000);
    }


}
