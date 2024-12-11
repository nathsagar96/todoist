package com.codesmith.stride;

import org.springframework.boot.SpringApplication;

public class TestApplication {

  public static void main(String[] args) {
    SpringApplication.from(Application::main)
        .with(TestContainersConfiguration.class)
        .run(args);
  }
}
