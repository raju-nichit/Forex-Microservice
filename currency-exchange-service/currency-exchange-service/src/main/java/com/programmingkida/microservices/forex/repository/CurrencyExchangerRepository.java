package com.programmingkida.microservices.forex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programmingkida.microservices.forex.bean.CurrencyExchange;

public interface CurrencyExchangerRepository extends JpaRepository<CurrencyExchange, Long> {

	public CurrencyExchange findByFromAndTo(String from, String to);
}
