package com.ahabilet.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "seats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seat extends BaseEntity {

    private int number;

    @Column(name = "is_reserved")
    private boolean isReserved;

    @ManyToOne
    private Booking booking;

    @OneToOne
    private Passsenger passsenger;

    @OneToOne
    private RegisteredPassenger registeredPassenger;

    @ManyToOne
    private Event event;
}
