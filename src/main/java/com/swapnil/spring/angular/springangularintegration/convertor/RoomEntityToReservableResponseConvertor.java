package com.swapnil.spring.angular.springangularintegration.convertor;

import org.springframework.core.convert.converter.Converter;

import com.swapnil.spring.angular.springangularintegration.bo.Response.Links;
import com.swapnil.spring.angular.springangularintegration.bo.Response.ReservableResponse;
import com.swapnil.spring.angular.springangularintegration.bo.Response.Self;
import com.swapnil.spring.angular.springangularintegration.entity.RoomEntity;
import com.swapnil.spring.angular.springangularintegration.rest.ResourceConstants;

public class RoomEntityToReservableResponseConvertor implements Converter<RoomEntity, ReservableResponse>{

	@Override
	public ReservableResponse convert(RoomEntity source) {
		ReservableResponse rr=new ReservableResponse();
		rr.setRoomNumber(source.getRoomNumber());
		rr.setPrice(Integer.valueOf(source.getPrice()));
		Links links=new Links();
		Self self=new Self();
		self.setRef(ResourceConstants.ROOM_RESERVATION_V1+"/"+source.getId());
		links.setSelf(self);
		rr.setLinks(links);
		rr.setId(source.getId());
		return rr;
	}

}
