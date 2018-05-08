package com.swapnil.spring.angular.springangularintegration.convertor;

import org.springframework.core.convert.converter.Converter;

import com.swapnil.spring.angular.springangularintegration.bo.Response.ReservationResponse;
import com.swapnil.spring.angular.springangularintegration.entity.ReservationEntity;

public class ReservationEntityReservationResponse implements Converter<ReservationEntity, ReservationResponse>{

	@Override
	public ReservationResponse convert(ReservationEntity source) {
		ReservationResponse rr=new ReservationResponse();
		rr.setCheckin(source.getCheckin());
		rr.setCheckout(source.getCheckout());
		if (null != source.getRoomEntity())
            rr.setId(source.getRoomEntity().getId());
		return rr;
	}

}
