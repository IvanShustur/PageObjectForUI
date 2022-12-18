import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class UITests extends BaseTest {

    @Test
    public void openHomePage() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HIGHCHARTS_URL);
    }
}
