package com.programmingkida.microservices.forex.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.programmingkida.microservices.forex.bean.CurrencyExchange;
import com.programmingkida.microservices.forex.repository.CurrencyExchangerRepository;

@RestController
public class CurrencyExchangeController {
	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangerRepository currencyExchangerRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		CurrencyExchange currencyExchange = currencyExchangerRepository.findByFromAndTo(from, to);

		if (currencyExchange == null) {
			throw new RuntimeException("Unable to find data for from " + from + " to " + to);
		}

//		CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(82));
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));

		return currencyExchange;
	}
}
