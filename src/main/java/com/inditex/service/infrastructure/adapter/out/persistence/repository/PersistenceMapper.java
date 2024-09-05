package com.inditex.service.infrastructure.adapter.out.persistence.repository;

import com.inditex.service.domain.model.Price;
import com.inditex.service.infrastructure.adapter.out.persistence.entity.PriceEntity;

public class PersistenceMapper {
	
    public static Price toDomainModel(PriceEntity priceEntity) {
    	return Price.builder().id(priceEntity.getId()).brand(priceEntity.getBrand().getName())
    			.startDate(priceEntity.getStartDate()).endDate(priceEntity.getEndDate())
    			.product(priceEntity.getProduct().getName()).priority(priceEntity.getPriority())
    			.price(priceEntity.getPrice()).currency(priceEntity.getCurrency()).build();
    }

}
