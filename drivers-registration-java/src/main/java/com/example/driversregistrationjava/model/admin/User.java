package com.example.driversregistrationjava.model.admin;

import com.example.driversregistrationjava.model.admin.status.TypeAccess;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name; //имя

    @Column(name = "user_last_name")
    private String lastName; //фамилия

    @Enumerated(EnumType.STRING)
    private TypeAccess typeAccess; //тип доступа
}
