package com.empresa.pricechecker.controller;

import com.empresa.pricechecker.service.PriceCheckerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class PriceCheckerController {

    private static final Logger logger = LoggerFactory.getLogger(PriceCheckerController.class);
    private final PriceCheckerService priceCheckerService;

    public PriceCheckerController(PriceCheckerService priceCheckerService) {
        this.priceCheckerService = priceCheckerService;
    }

    @GetMapping("/check-prices")
    public String checkPrices(@RequestParam String product) {
        logger.info("Iniciando busca de preços para o produto: " + product);
        String result = priceCheckerService.getPrices(product);
        logger.info("Busca de preços concluída.");
        return result;
    } 
}

