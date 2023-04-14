package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoadTimeCalculator {

    static int limitTime = 60*1000;
    public static int calculateTime(WebElement element, int initialTime) throws InterruptedException {

        Boolean isPresent = (element.isDisplayed());

        if (isPresent) {

            return initialTime;
        }else{
            Thread.sleep(1);
            initialTime = initialTime + 1;
           if(initialTime>=limitTime){
               System.out.println("Maximum limit of 1 minute reached");
               return initialTime;
           }
            calculateTime(element, initialTime);
        }

        return initialTime;

    }

    public static long clculateTime_1(WebElement element, WebDriverWait wait){

        long startTime = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOf(element));
        long endTime = System.currentTimeMillis();
        return  (endTime - startTime);




    }
}
