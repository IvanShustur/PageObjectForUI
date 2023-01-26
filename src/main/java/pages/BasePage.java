package pages;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


@NoArgsConstructor
public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
