package com.vivek;

import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webInvoking {
    
    public static String breakingPassword(String temporaryPassword) {
        // System.out.println(temporaryPassword);
        int beginIndex = temporaryPassword.indexOf("'");
        int lastIndex = temporaryPassword.lastIndexOf("'");
        String userNameOfPage = temporaryPassword.substring(beginIndex + 1, lastIndex);
        String password = temporaryPassword.substring(beginIndex + 1, lastIndex);
        // System.out.println(temporaryPassword.substring(beginIndex + 1, lastIndex));
        return password;
    }

    public static String getPassword(WebDriver driver) {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Samir");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("samwichviky@234.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9966321456");
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        String grabbingThePassword = driver.findElement(By.className("infoMsg")).getText();
        String[] passwordArray = grabbingThePassword.split("'");
        String password = passwordArray[1];
        return password;

    }

    public static void main(String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/home/vivek/Downloads/chromedriver-linux64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("vivek");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(1000);

        /*
         * driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Samir"
         * );
         * driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(
         * "samwichviky@234.com");
         * // driver.findElement(By.xpath("//input[@placeholder='Phone
         * // Number']")).sendKeys("99633145");
         * driver.findElement(By.xpath("//form/input[3]")).sendKeys("9966321456");
         * driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
         * driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
         */
        /*
         * System.out.println(driver.findElement(By.className("infoMsg")).getText());
         * String temporaryPassword =
         * driver.findElement(By.className("infoMsg")).getText();
         * String mainPassword = breakingPassword(temporaryPassword);
         * System.out.println(mainPassword);
         */
        String password = getPassword(driver);
        driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("inputUsername")).sendKeys("vivek");
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.className("submit")).click();
        Thread.sleep(1000);

        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

        driver.findElement(By.className("logout-btn")).click();

        driver.close();
    }
}
