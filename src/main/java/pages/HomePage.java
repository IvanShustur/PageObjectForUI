package pages;


import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@NoArgsConstructor
public class HomePage extends BasePage{


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class = 'highcharts-a11y-proxy-button highcharts-no-tooltip']")
    private WebElement chartContextMenuButton;

    @FindBy(xpath = "//*[@class = 'highcharts-contextmenu']//*[contains(text(),'Download CSV')]")
    private WebElement downloadCSVButton;


    
   //@FindBy (xpath = "//*[@class='highcharts-markers highcharts-series-2 highcharts-area-series highcharts-color-2 highcharts-tracker']/*")
    @FindBy (xpath = "//*[@aria-label='Highsoft employees, series 3 of 7 with 14 data points. Y axis, Employees.']/*")
    public List<WebElement> listOfEmployee;

    @FindBy (xpath = "//*[contains(text(), 'View in full screen')]")
    public WebElement viewInFullScreenButton;

    @FindBy (xpath = "//*[@class='highcharts-a11y-proxy-button'][@aria-label='Show Google search for highcharts']")
    private WebElement disableGoogleGraphButton;

    @FindBy (xpath = "//*[@class='highcharts-a11y-proxy-button'][@aria-label='Show Revenue']")
    private WebElement disableRevenueGraphButton;

    @FindBy (xpath ="//*[@style='color: rgb(51, 51, 51); font-size: 12px; fill: rgb(51, 51, 51);']")
    public WebElement tooltip;


    public void clickOnChartContextMenuButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(chartContextMenuButton));
        chartContextMenuButton.click();
    }

    public void clickOnDownloadCSVButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(downloadCSVButton));
        downloadCSVButton.click();
    }

    public void disableGoogleGraph(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(disableGoogleGraphButton));
        disableGoogleGraphButton.click();
    }

    public void disableRevenueGraph(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(disableRevenueGraphButton));
        disableRevenueGraphButton.click();
    }

    public void openInFullScreen(){
      viewInFullScreenButton.click();
    }
}
