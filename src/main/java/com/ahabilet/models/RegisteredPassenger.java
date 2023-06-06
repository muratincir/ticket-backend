package com.ahabilet.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "registered_passengers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredPassenger extends BaseEntity {

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne
    private Gender gender;

    @ManyToOne
    private User user;
}
