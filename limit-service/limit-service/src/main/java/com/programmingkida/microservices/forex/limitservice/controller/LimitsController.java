package com.programmingkida.microservices.forex.limitservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmingkida.microservices.forex.limitservice.controller.bean.Limits;

@RestController
public class LimitsController {

	@GetMapping("limits")

	public Limits retriveLimits() {
		return new Limits(1, 1000);
	}
}
