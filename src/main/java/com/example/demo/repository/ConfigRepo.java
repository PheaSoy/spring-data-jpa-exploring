package com.example.demo.repository;

import com.example.demo.domain.Config;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.repository.CrudRepository;

public interface ConfigRepo extends CrudRepository<Config, Integer> {

  List<Config> findAll();

  default Map<String, String> systemConfigs() {
    return this.findAll().stream().collect(Collectors.toMap(Config::getKey, Config::getValue));
  }
}
