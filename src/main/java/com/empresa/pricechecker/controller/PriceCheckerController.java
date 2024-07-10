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

    // Injeção de dependência do serviço de verificação de preços
    public PriceCheckerController(PriceCheckerService priceCheckerService) {
        this.priceCheckerService = priceCheckerService;
    }

    // Endpoint para verificar os preços
    
    @GetMapping("/check-prices")
    public String checkPrices(@RequestParam String product) {
        logger.info("Iniciando busca de preços para o produto: " + product);
        String result = priceCheckerService.fetchPrices(product);
        logger.info("Busca de preços concluída.");
        return result;
    } 
}
