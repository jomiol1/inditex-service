package com.inditex.service.domain.model.port.in;

import java.util.Date;

import com.inditex.service.domain.model.Price;

public interface PriceServicesPort {
	Price findPriceBetweenDates(Date dateSearch, int productId, int brandId);
}
