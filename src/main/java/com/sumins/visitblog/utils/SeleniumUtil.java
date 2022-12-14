package com.sumins.visitblog.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

@Component
public class SeleniumUtil {

    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
    public static final String WEB_DRIVER_PATH = "chromedriver.exe"; // 드라이버 경로

    public void visitBlog() throws InterruptedException {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();

        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        //창안띄우고 실행
        options.addArguments("headless");
        //
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://m.blog.naver.com/hera1720");
        Thread.sleep(2654);
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[2]/div/div[2]/ul/li[2]/div[2]/div[2]/div[1]/a")).sendKeys("\n");
        Thread.sleep(36153);
        driver.navigate().back();
        Thread.sleep(5252);
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[2]/div/div[2]/ul/li[2]/div[1]/div[2]/div[1]/a")).sendKeys("\n");
        Thread.sleep(22543);
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[2]/div/div[2]/ul/li[4]/div[1]/div[2]/div[1]/a")).sendKeys("\n");
        Thread.sleep(34123);
        driver.navigate().back();
        Thread.sleep(10321);
        driver.navigate().refresh();
        Thread.sleep(5532);
        driver.navigate().refresh();
        Thread.sleep(4378);


        // 브라우저 닫기
        driver.close();
        driver.quit();
    }
}
