package com.github.m4nko.currencyconversionservice.proxy;

import com.github.m4nko.currencyconversionservice.entity.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange", url = "localhost:8000") // Use the name of the microservice u want to use
@FeignClient(name="currency-exchange") // Removing the url lets load balance happen
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
