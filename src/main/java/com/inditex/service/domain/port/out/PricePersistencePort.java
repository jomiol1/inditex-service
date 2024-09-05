package com.inditex.service.domain.port.out;

import java.util.Date;

import com.inditex.service.domain.model.Price;

public interface PricePersistencePort {
	
	Price findPriceBetweenDates(Date searchDate, int productId, int brandId);

}
