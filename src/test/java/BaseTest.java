
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

@NoArgsConstructor
@AllArgsConstructor
public class BaseTest {


    public WebDriver driver;
    public static final String HIGHCHARTS_URL= "https://www.highcharts.com/demo/combo-timeline/";


    @Before
    public void testSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @After
    public void tearDown() {
        driver.close();
    }

}
