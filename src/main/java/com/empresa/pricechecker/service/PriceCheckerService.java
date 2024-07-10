package com.empresa.pricechecker.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class PriceCheckerService {

    private WebDriver driver;

    public PriceCheckerService() {
        // Configuração do ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\ProjetoRPA\\chromedriver-win32\\chromedriver.exe");
        
        // Configurações adicionais para o Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        // Inicialização do WebDriver
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public String fetchPrices(String product) {
        StringBuilder result = new StringBuilder();

        // Busca no Mercado Livre
        fetchPricesFromMercadoLivre(product, result);

        // Busca nas Casas Bahia
        fetchPricesFromCasasBahia(product, result);

        // Fechar o driver ao finalizar
        driver.quit();
        return result.toString();
    }

    private void fetchPricesFromMercadoLivre(String product, StringBuilder result) {
        driver.get("https://www.mercadolivre.com.br");
        
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='as_word']"));
        searchBox.sendKeys(product);
        searchBox.submit();

        List<WebElement> prices = driver.findElements(By.className("price-tag"));
        result.append("Preços no Mercado Livre para ").append(product).append(":\n");
        for (WebElement price : prices) {
            result.append(price.getText()).append("\n");
        }
        result.append("\n");
    }

    private void fetchPricesFromCasasBahia(String product, StringBuilder result) {
        driver.get("https://www.casasbahia.com.br");

        WebDriverWait wait = new WebDriverWait(driver, 20); // Espera
        
        // Verificar se há iframes e alternar para eles, se necessário
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        if (!iframes.isEmpty()) {
            driver.switchTo().frame(iframes.get(0));
        }

        // Esperar até que o elemento esteja presente e visível
        wait.until(ExpectedConditions.and(
            ExpectedConditions.presenceOfElementLocated(By.id("input-search")),
            ExpectedConditions.visibilityOfElementLocated(By.id("input-search"))
        ));

        WebElement searchBox = driver.findElement(By.id("input-search"));
        searchBox.sendKeys(product);
        searchBox.submit();

        // Voltar ao contexto principal caso tenha mudado para um iframe
        driver.switchTo().defaultContent();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("price")));
        List<WebElement> prices = driver.findElements(By.className("price"));
        result.append("Preços na Casas Bahia para ").append(product).append(":\n");
        for (WebElement price : prices) {
            result.append(price.getText()).append("\n");
        }
        result.append("\n");
    }
}

