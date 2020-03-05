package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "book")
@Data
public class Book {

    @Id
    @GeneratedValue
    private int id;
    private String author;
    private LocalDate createdAt;
    private double price;
    private String snb;


}
