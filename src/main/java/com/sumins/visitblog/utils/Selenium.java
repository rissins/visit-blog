package com.sumins.visitblog.utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium {

    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
    public static final String WEB_DRIVER_PATH = "chromedriver.exe"; // 드라이버 경로

    public void visitBlog() {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();

        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        //창안띄우고 실행
        options.addArguments("headless");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://m.blog.naver.com/hera1720");

        // 브라우저 닫기
        driver.close();
        driver.quit();
    }
}
