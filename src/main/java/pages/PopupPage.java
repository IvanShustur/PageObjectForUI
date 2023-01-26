package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopupPage extends BasePage {
    public PopupPage(WebDriver driver) {
        super(driver);
    }
    @FindBy( xpath = "//*[@id = 'CybotCookiebotDialogBodyButtonDecline']")

    private WebElement useNecessaryCookiesOnlyButton;
    public void clickOnUseNecessaryCookiesOnlyButton() throws InterruptedException {
        Thread.sleep(900);
        useNecessaryCookiesOnlyButton.click();
    }

}
