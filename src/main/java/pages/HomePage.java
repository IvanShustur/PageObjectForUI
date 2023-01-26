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


    
    @FindBy (xpath = "//*[@class='highcharts-markers highcharts-series-2 highcharts-area-series highcharts-color-2 highcharts-tracker']/*")
    public List<WebElement> listOfEmployee;

    @FindBy (xpath = "//*[@class='highcharts-label highcharts-tooltip highcharts-color-2']")
    private WebElement stephane;

    @FindBy (xpath = "//*[@class='highcharts-halo highcharts-color-2']")
    private WebElement pickStephane;

    @FindBy (xpath = "//*[@class='btn btn-primary mr-1 btn-small horisontal-menu-item text-uppercase']")
    private WebElement buttonToTry;


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



    public String getTextFromTooltip() {
        return stephane.getText();
    }

}
