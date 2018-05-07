package com.swapnil.spring.angular.springangularintegration.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.swapnil.spring.angular.springangularintegration.entity.RoomEntity;

public interface PagebleRoomRepository extends PagingAndSortingRepository<RoomEntity, Long>{
Page<RoomEntity> findById(Long id,Pageable page);
}
