package com.cucumber.junit.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class StepDefinitions {
    private static final String HIGHCHARTS_URL = "https://www.highcharts.com/demo/combo-timeline/";
    WebDriver driver;

    @Given("User open home page")
    public void userOpensHomePage() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HIGHCHARTS_URL);
    }
}
