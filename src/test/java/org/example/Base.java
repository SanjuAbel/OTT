package org.example;

import com.google.gson.JsonObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.network.Network;
import org.openqa.selenium.devtools.v108.network.model.ConnectionType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Base {


    public static WebDriver driver;

    public static HashMap<String,String> loadTimeDetails = new HashMap<>();


    @BeforeSuite
    public void beforeSuite(){

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        String url = "https://www.youtube.com/";
        System.out.println("test starting");
        WebDriverManager manager = WebDriverManager.chromedriver();
        manager.setup();


       driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        long startTime = System.currentTimeMillis();
        driver.navigate().to(url);
        long endTime = System.currentTimeMillis();
        long loadTime = (endTime - startTime) / 1000;

        loadTimeDetails.put("Page load time",loadTime+"Seconds");



    }


    @AfterSuite
    public void afterSuite(){

        System.out.println("Test ending, The loading time details are:-");
        System.out.println(loadTimeDetails);
        driver.quit();



    }
}
