package com.inditex.service.infrastructure.adapters.input.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.inditex.service.domain.model.Price;
import com.inditex.service.domain.model.exception.PriceNotFound;
import com.inditex.service.domain.model.port.in.PriceServicesPort;

@WebMvcTest(PriceController.class)
public class PriceControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

    @MockBean
    private PriceServicesPort priceServices;
    
    @Test
    void testFindPriceBetweenDatesOK() throws Exception {

    	Price price = Price.builder().id(1).brand("zara").currency("EUR").endDate(new Date())
    			.price("20").priority(1).product("test").startDate(new Date()).build();
        when(priceServices.findPriceBetweenDates(any(),anyInt(),anyInt())).thenReturn(price);

        mockMvc.perform(get("/api/inditex/findPriceBetweenDates/2020-06-15-16.00.00/35455/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.brand").value("zara"))
                .andExpect(jsonPath("$.currency").value("EUR"))
                .andExpect(jsonPath("$.price").value("20"))
                .andExpect(jsonPath("$.priority").value(1))
                .andExpect(jsonPath("$.product").value("test"));
    }
    
    @Test
    void testFindPriceBetweenDatesNotFound() throws Exception {

        when(priceServices.findPriceBetweenDates(any(),anyInt(),anyInt())).thenThrow(new PriceNotFound());

        mockMvc.perform(get("/api/inditex/findPriceBetweenDates/2020-06-15-16.00.00/35455/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}
