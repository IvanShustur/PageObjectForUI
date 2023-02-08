package pages;

import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@NoArgsConstructor
public class PopupPage extends BasePage {
    public PopupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy( xpath = "//*[@id = 'CybotCookiebotDialogBodyButtonDecline']")
    public WebElement useNecessaryCookiesOnlyButton;

    public void clickOnUseNecessaryCookiesOnlyButton() throws InterruptedException {
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(useNecessaryCookiesOnlyButton));
        useNecessaryCookiesOnlyButton.click();
    }
}
