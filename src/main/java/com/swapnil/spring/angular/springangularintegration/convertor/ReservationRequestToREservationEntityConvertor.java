package com.swapnil.spring.angular.springangularintegration.convertor;

import org.springframework.core.convert.converter.Converter;

import com.swapnil.spring.angular.springangularintegration.bo.Response.ReservationRequest;
import com.swapnil.spring.angular.springangularintegration.bo.Response.ReservationResponse;
import com.swapnil.spring.angular.springangularintegration.entity.ReservationEntity;

public class ReservationRequestToREservationEntityConvertor implements Converter<ReservationRequest,ReservationEntity>
{
	@Override
	public ReservationEntity convert(ReservationRequest source) {
		ReservationEntity reservationEntity=new ReservationEntity();
		reservationEntity.setCheckin(source.getCheckin());
		reservationEntity.setCheckout(source.getCheckout());
		if(source.getId()!=null) {
			reservationEntity.setId(source.getId());
		}
		return reservationEntity;
	}
}

