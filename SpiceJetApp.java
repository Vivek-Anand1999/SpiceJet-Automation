package com.vivek;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//! for choosing country
public class SpiceJetPractise {
    public static void ChoosingCountry(WebDriver driver) {
        driver.findElement(By.id("autosuggest")).click();
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }
    }

    // ! choosing the ChoosingTheRadioButtonForTrip
    public static void ChoosingTheRadioButtonForTrip(WebDriver driver) {
        // driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        // ? To know the return date is enabled or disabled
        // System.out.println(driver.findElement(By.id("view_fulldate_id_2")).isEnabled());
        // Assert.assertTrue(driver.findElement(By.id("view_fulldate_id_2")).isEnabled());
        // ? sometime enable or disable will not work on that time examine carefully
        // html
        // System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
            System.out.println("Enabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    // !for choosing departure and Arrival
    public static void ChooseDepartureCityAndArrivalCity(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.cssSelector("a[value='BLR']")).click();
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
    }

    // ! for date
    public static void chooseDate(WebDriver driver) {
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
        // ! work on this--
    }

    // ! for passenger
    public static void choosePassengers(WebDriver driver) {
        driver.findElement(By.id("divpaxinfo")).click();
        int passenger = 1;
        while (passenger < 5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            passenger++;
        }
        // System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        driver.findElement(By.id("btnclosepaxoption")).click();
    }

    // !for currency
    public static void chooseStaticCurrency(WebDriver driver) {
        System.out.println(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).getText());
        WebElement staticDropDownOptions = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select option = new Select(staticDropDownOptions);
        option.selectByIndex(2);
        System.out.println(option.getFirstSelectedOption().getText());
    }

    // !for checkbox
    public static void chooseCheckBox(WebDriver driver) {
        Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        // System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        // System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
    }

    // !for searchBox
    public static void ClickOnSearch(WebDriver driver) {
        driver.findElement(By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights']")).click();
        System.out.println(
                driver.findElement(By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights']")).isEnabled());
    }

    // !for close website
    public static void closeWebsite(WebDriver driver) {
        driver.close();
    }

    public static void main(String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/home/vivek/Downloads/chromedriver-linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // ! calling from function---
        // ChoosingTheRadioButtonForTrip(driver);
        // ChoosingCountry(driver);
        ChooseDepartureCityAndArrivalCity(driver);
        // chooseCheckBox(driver);
        // choosePassengers(driver);
        // chooseStaticCurrency(driver);
        // ClickOnSearch(driver);
        chooseDate(driver);
        Thread.sleep(5000);
        closeWebsite(driver);
    }
}
