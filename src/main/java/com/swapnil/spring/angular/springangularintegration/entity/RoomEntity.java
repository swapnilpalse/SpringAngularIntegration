package com.swapnil.spring.angular.springangularintegration.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Room")
public class RoomEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	private Integer roomNumber;
	@NotNull
	private String price;
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private List<ReservationEntity> reservationEntities;
	public RoomEntity() {
		super();
	}
	public List<ReservationEntity> getReservationEntity() {
		return reservationEntities;
	}
	public void setReservationEntity(List<ReservationEntity> reservationEntity) {
		this.reservationEntities = reservationEntity;
	}
	public Long getId() {
		return id;
	}
	public RoomEntity(@NotNull Integer roomNumber, @NotNull String price) {
		super();
		this.roomNumber = roomNumber;
		this.price = price;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void addReservationEntity(ReservationEntity rr) {
		if(reservationEntities==null) {
			reservationEntities=new ArrayList<>();			
		}
		reservationEntities.add(rr);
	}

}
