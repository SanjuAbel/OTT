package Testcases;

import POM.HomePage;
import POM.ResultPage;
import org.example.Base;

public class Test extends Base {



    @org.testng.annotations.Test(priority = 0)
    public void searchAnElement(){

        HomePage hp = new HomePage(driver);

        hp.enterSearchText("java");
        hp.clickSearchButton();



    }

    @org.testng.annotations.Test(priority = 1)
    public void SelectContent() throws InterruptedException {

        ResultPage rp = new ResultPage(driver);

        rp.selectContent(2);

    }
}
