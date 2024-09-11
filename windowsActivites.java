package com.vivek;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WindowsActivities {
    public static void main(String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/home/vivek/Downloads/chromedriver-linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        // driver.get("https://rahulshettyacademy.com/locatorspractice/");// it will
        // wait until the compents of that page
        // is fully loaded.
        // driver.navigate().to("https://www.youtube.com/");// this way will not wait
        // for the comepents to be fully loaded
        // it just load the website
        // driver.navigate().back();// go back to rahulshetty link

        // !---------------static dropDown---------------------

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropDown = new Select(staticDropDown);
        dropDown.selectByIndex(2);
        System.out.println(dropDown.getFirstSelectedOption().getText());
        dropDown.selectByVisibleText("INR");
        System.out.println(dropDown.getFirstSelectedOption().getText());
        dropDown.selectByValue("INR");
        System.out.println(dropDown.getFirstSelectedOption().getText());

        Thread.sleep(5000);
        driver.close();

        // ! ---------Dynamic Dropdown -----------
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        int numberOfAdults = 1;
        while (numberOfAdults < 5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            numberOfAdults++;
        }
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("btnclosepaxoption")).click();
        // !-------Multiple Selection List Box------
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        // Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        // driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']"))
                .click();
        // !AutoSuggestion box ----------------
        driver.findElement(By.id("autosuggest")).click();
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement option : options) {
            option.getText();
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }
        // ! check box-----
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        // ! getting all checkbox info--
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
    }
}
