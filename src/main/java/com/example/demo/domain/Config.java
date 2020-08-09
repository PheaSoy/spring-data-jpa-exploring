package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "configs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Config {

  @Id
  int id;
  String key;
  String value;

}
