package com.swapnil.spring.angular.springangularintegration.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Reservation")
public class ReservationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkin;
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkout;
	@ManyToOne
	private RoomEntity roomEntity;


	public ReservationEntity() {
		super();
	}

	public ReservationEntity(@NotNull LocalDate checkin, @NotNull LocalDate checkout,RoomEntity roomEntity){
		super();
		this.checkin = checkin;
		this.checkout = checkout;
		this.roomEntity=roomEntity;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}

	public RoomEntity getRoomEntity() {
		return roomEntity;
	}
	
	public void setRoomEntity(RoomEntity roomEntity) {
		this.roomEntity = roomEntity;
	}

	@Override
	public String toString() {
		return "ReservationEntity [Id=" + Id + ", checkin=" + checkin + ", checkout=" + checkout + ", roomEntity="
				+ roomEntity + "]";
	}
	
	
}
