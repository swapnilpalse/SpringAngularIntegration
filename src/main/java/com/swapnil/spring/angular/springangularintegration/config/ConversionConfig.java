package com.swapnil.spring.angular.springangularintegration.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.swapnil.spring.angular.springangularintegration.bo.Response.ReservationRequest;
import com.swapnil.spring.angular.springangularintegration.convertor.ReservationEntityReservationResponse;
import com.swapnil.spring.angular.springangularintegration.convertor.ReservationRequestToREservationEntityConvertor;
import com.swapnil.spring.angular.springangularintegration.convertor.RoomEntityToReservableResponseConvertor;

@Configuration
public class ConversionConfig {
private Set<Converter> getConverters(){
	Set<Converter> converters=new HashSet<Converter>();
	converters.add(new RoomEntityToReservableResponseConvertor());
	converters.add(new ReservationRequestToREservationEntityConvertor());
	converters.add(new ReservationEntityReservationResponse());
	
	return converters;
}
@Bean
public ConversionService conversionService()
{
	ConversionServiceFactoryBean bean=new ConversionServiceFactoryBean();
	bean.setConverters(getConverters());
	bean.afterPropertiesSet();
	return bean.getObject();
}
}
