package POM;

import Util.LoadTimeCalculator;
import org.example.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ResultPage {

    @FindBy(xpath = "//div[@id='container']//yt-image//img")
    private List<WebElement> contents;


    @FindBy(xpath = "//div[@id='container']//button//div[contains(@class,'ytp-button ytp-settings-button')]")
    private WebElement settingsButton;

    @FindBy(css = ".html5-video-player")
    private WebElement videoPlayer;


    WebDriver driver;
    private WebDriverWait wait;

    public ResultPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }


    public void selectContent(int count) throws InterruptedException {


        WebElement element = contents.get(1);





        element.click();
        long time = (LoadTimeCalculator.clculateTime_1(videoPlayer, wait)) / 1000;
        //time = (LoadTimeCalculator.calculateTime(videoPlayer, 0)) / 1000;
        Base.loadTimeDetails.put("video element loading time", time + "seconds ");

    }
}
