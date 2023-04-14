package POM;

import Util.LoadTimeCalculator;
import org.example.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    @FindBy(xpath = "//input[@id='search']")
    private WebElement searchBox;


    @FindBy(xpath = "//button[@id='search-icon-legacy']//yt-icon")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='container']//yt-image//img")
    private List<WebElement> contents;
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }


    public void enterSearchText(String keyWord) {
//
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        wait.until(ExpectedConditions.visibilityOf(searchButton));

        searchBox.sendKeys(keyWord);


    }

    public void clickSearchButton() {


        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
        long time = (LoadTimeCalculator.clculateTime_1(contents.get(0), wait)) / 1000;
        //long time = (LoadTimeCalculator.calculateTime(element, 0)) / 1000;
        Base.loadTimeDetails.put("Search result load time", time + "seconds ");


    }
}
