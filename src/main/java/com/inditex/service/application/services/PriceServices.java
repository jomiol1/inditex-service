package com.inditex.service.application.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.inditex.service.domain.model.Price;
import com.inditex.service.domain.port.in.PriceServicesPort;
import com.inditex.service.domain.port.out.PricePersistencePort;

@Service
public class PriceServices implements PriceServicesPort {

	private PricePersistencePort pricePersistence;
	
	public PriceServices(PricePersistencePort pricePersistence){
		this.pricePersistence=pricePersistence;
	}

	@Override
	public Price findPriceBetweenDates(Date dateSearch, int productId, int brandId) {
		return pricePersistence.findPriceBetweenDates(dateSearch, productId, brandId);
	}
	
}
