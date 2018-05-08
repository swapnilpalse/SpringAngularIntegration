package com.swapnil.spring.angular.springangularintegration.rest;


import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swapnil.spring.angular.springangularintegration.bo.Response.ReservableResponse;
import com.swapnil.spring.angular.springangularintegration.bo.Response.ReservationRequest;
import com.swapnil.spring.angular.springangularintegration.bo.Response.ReservationResponse;
import com.swapnil.spring.angular.springangularintegration.convertor.RoomEntityToReservableResponseConvertor;
import com.swapnil.spring.angular.springangularintegration.entity.ReservationEntity;
import com.swapnil.spring.angular.springangularintegration.entity.RoomEntity;
import com.swapnil.spring.angular.springangularintegration.repositories.PagebleRoomRepository;
import com.swapnil.spring.angular.springangularintegration.repositories.ReservationRepository;
import com.swapnil.spring.angular.springangularintegration.repositories.RoomRepository;
@RestController
@RequestMapping("/room/reservation/v1")
@CrossOrigin
public class ReservationResoure {
	@Autowired
	PagebleRoomRepository pagebleRoomRepository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	ConversionService conversionService;
    @RequestMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<ReservableResponse> getAvailableRooms(
            @RequestParam(name = "checkin")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkin,
            @RequestParam(name = "checkout")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate checkout, Pageable pageable) {
    		Page<RoomEntity> roomEntityList=pagebleRoomRepository.findAll(pageable);
        	return roomEntityList.map(s->new RoomEntityToReservableResponseConvertor().convert(s)); 
    }
    @RequestMapping(path="",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservationResponse> createReservation(
    		@RequestBody ReservationRequest reservationRequest){
    	ReservationEntity reservationEntity=conversionService.convert(reservationRequest, ReservationEntity.class);
    	reservationRepository.save(reservationEntity);
    	RoomEntity roomEntity=roomRepository.findById(reservationRequest.getRoomId()).get();
    	roomEntity.addReservationEntity(reservationEntity);
    	roomRepository.save(roomEntity);
    	reservationEntity.setRoomEntity(roomEntity);
    	ReservationResponse reservationResponse=conversionService.convert(reservationEntity, ReservationResponse.class);
    	return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);
    }
    
    @RequestMapping(path="",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ReservableResponse> updateReservation(
    		@RequestBody ReservationRequest reservationRequest){
    	return new ResponseEntity<>(new ReservableResponse(), HttpStatus.OK);
    }
    @RequestMapping(path="/{reservationId}",method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReservation(
    		@PathVariable long reservationId){
    	return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
    @RequestMapping(path="/{roomId}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RoomEntity> getRoomById(@PathVariable Long roomId){
    	Optional<RoomEntity> roomEntity=roomRepository.findById(roomId);
    	return new ResponseEntity<RoomEntity>(roomEntity.get(),HttpStatus.OK);
    }
}
