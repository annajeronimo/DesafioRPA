package com.empresa.pricechecker.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCheckerService {

    public String getPrices(String product) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.mercadolivre.com.br");
        WebElement searchBox = driver.findElement(By.name("as_word"));
        searchBox.sendKeys(product);
        searchBox.submit();

        // Espere a página carregar e busque os preços
        List<WebElement> prices = driver.findElements(By.className("price-tag-fraction"));
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Math.min(prices.size(), 3); i++) {
            result.append(prices.get(i).getText()).append("\n");
        }

        driver.quit();
        return result.toString();
    }
}
