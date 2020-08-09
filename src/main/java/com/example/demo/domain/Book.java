package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private double price;

}
