package com.swapnil.spring.angular.springangularintegration.repositories;

import org.springframework.data.repository.CrudRepository;

import com.swapnil.spring.angular.springangularintegration.entity.ReservationEntity;

public interface ReservationRepository extends CrudRepository<ReservationEntity	, Long>
{

}
