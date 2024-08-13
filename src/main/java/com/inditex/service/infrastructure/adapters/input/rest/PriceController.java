package com.inditex.service.infrastructure.adapters.input.rest;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.service.domain.model.Price;
import com.inditex.service.domain.model.port.in.PriceServicesPort;


@RestController
@RequestMapping("api/inditex")
public class PriceController {
	
	private final PriceServicesPort priceServices;
	
	public PriceController(PriceServicesPort priceServices){
		this.priceServices = priceServices;
	}
	
	@GetMapping(value = "/findPriceBetweenDates/{dateSearch}/{productId}/{brandId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Price> findPriceBetweenDates(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateSearch, @PathVariable int productId, @PathVariable int brandId){
		
		return new ResponseEntity<>(priceServices.findPriceBetweenDates(dateSearch, productId, brandId), HttpStatus.OK);
		
	}
}
