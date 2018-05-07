package com.swapnil.spring.angular.springangularintegration.repositories;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.swapnil.spring.angular.springangularintegration.entity.RoomEntity;

public interface RoomRepository extends CrudRepository<RoomEntity,Long> {
	//public RoomEntity findById(Long id);
}
