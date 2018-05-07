package com.swapnil.spring.angular.springangularintegration.bo.Response;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservationRequest {
	private Long id;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkin;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkout;
	private Long roomId;

	public ReservationRequest(LocalDate checkin, LocalDate checkout, Long roomId) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
		this.roomId = roomId;
	}

	public ReservationRequest() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
}
