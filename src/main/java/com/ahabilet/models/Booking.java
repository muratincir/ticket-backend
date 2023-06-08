package com.ahabilet.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking extends BaseEntity {

    @Column(name = "ticket_count")
    private int ticketCount;

    @Column(name = "is_cancelled")
    private boolean isCancelled;

    private String pnr;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;
}
