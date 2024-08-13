package com.inditex.service.infrastructure.adapter.out.persistence.repository;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.inditex.service.domain.model.Price;
import com.inditex.service.domain.model.exception.PriceNotFound;
import com.inditex.service.domain.model.port.out.PricePersistencePort;
import com.inditex.service.infrastructure.adapter.out.persistence.entity.PriceEntity;

@Service
public class PricePersistenceAdapter implements PricePersistencePort {

	private PriceRepository priceRepository;
	
	public PricePersistenceAdapter(PriceRepository priceRepository){
		this.priceRepository = priceRepository;
	}
	
	@Override
	public Price findPriceBetweenDates(Date searchDate, int productId, int brandId) {
		
		PriceEntity priceEntity =  priceRepository.findPriceBetweenDates(searchDate, productId, brandId)
				.orElseThrow(PriceNotFound::new);
		
		return priceEntity.toDomainModel();
	}

}
