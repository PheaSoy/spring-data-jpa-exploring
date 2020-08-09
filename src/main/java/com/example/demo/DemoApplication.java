package com.example.demo;

import com.example.demo.domain.Book;
import com.example.demo.domain.Config;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.ConfigRepo;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(BookRepository bookRepository, ConfigRepo configRepo) {

    return args -> {
      bookRepository.saveAll(Arrays.asList(
          new Book(1, "Cloud-Native Java", 1.0),
          new Book(2, "Enterprise Kubernetes", 1000.0),
          new Book(2, "Clean Architecture", 100),
          new Book(2, "Java in Action", 50)
      ));
      configs(configRepo);

      log.info("Save completed");
    };
  }

  public void configs(ConfigRepo configRepo) {
    configRepo.save(new Config(1, "server.port", "8080"));
    configRepo.save(new Config(2, "connection.timeout", "30000"));
    log.info("Save configs completed");
    configRepo.findAll().forEach(System.out::println);
    // Getting from map
    Map<String, String> configs = configRepo.systemConfigs();
    System.out.println("connection.timeout:" + configs.get("connection.timeout"));
  }

}

