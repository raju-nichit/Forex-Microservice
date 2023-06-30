package com.programmingkida.microservices.forex.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmingkida.microservices.forex.limitservice.bean.Limits;
import com.programmingkida.microservices.forex.limitservice.configuration.Configuration;

@RestController
public class LimitsController {

	@Autowired
	private Configuration configuration;

	@GetMapping(path = "/limits")
	public Limits retriveLimits() {

//		return new Limits(1, 1000);
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
	}
}
