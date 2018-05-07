package com.swapnil.spring.angular.springangularintegration.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Reservation")
public class ReservationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@NotNull
	private LocalDate checkin;
	@NotNull
	private LocalDate checkout;

	public ReservationEntity() {
		super();
	}

	public ReservationEntity(@NotNull LocalDate checkin, @NotNull LocalDate checkout) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
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

}
