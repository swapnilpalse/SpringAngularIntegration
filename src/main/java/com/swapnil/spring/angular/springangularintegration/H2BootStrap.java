package com.swapnil.spring.angular.springangularintegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.swapnil.spring.angular.springangularintegration.entity.RoomEntity;
import com.swapnil.spring.angular.springangularintegration.repositories.RoomRepository;

@Component
public class H2BootStrap implements CommandLineRunner {

	@Autowired
	RoomRepository roomRepository;
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("BootStrapping Data: ");
		roomRepository.save(new RoomEntity(405,"200"));
		roomRepository.save(new RoomEntity(406,"220"));
		roomRepository.save(new RoomEntity(407,"210"));
		roomRepository.save(new RoomEntity(408,"220"));
		roomRepository.save(new RoomEntity(409,"250"));
		roomRepository.save(new RoomEntity(410,"300"));
		roomRepository.save(new RoomEntity(411,"210"));
		roomRepository.save(new RoomEntity(412,"320"));
		roomRepository.save(new RoomEntity(413,"200"));
		Iterable<RoomEntity> itr=roomRepository.findAll();
		for(RoomEntity roomEntity:itr) {
			System.out.println(roomEntity.getRoomNumber());
		}
	}

}
