
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.PopupPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

@NoArgsConstructor
@AllArgsConstructor
public class BaseTest {

    public WebDriver driver;
    public static final String HIGHCHARTS_URL = "https://www.highcharts.com/demo/combo-timeline/";
    public static final String filePath = "src/main/resources/expectingTestDataForTests.csv";


    @BeforeEach
    public void testSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HIGHCHARTS_URL);
    }


    @AfterEach
    public void tearDown() {
         driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }
    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public PopupPage getPopupPage() {
        return new PopupPage(getDriver());
    }
}
