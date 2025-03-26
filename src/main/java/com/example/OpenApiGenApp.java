
package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.SpringDocUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;

@SpringBootApplication(scanBasePackages = "com.recarga")
public class OpenApiGenApp {
  public static void main(String[] args) throws Exception {
    SpringDocUtils.getConfig().removeRequestWrapperToIgnore();

    ApplicationContext ctx = SpringApplication.run(OpenApiGenApp.class, args);
    OpenAPI openAPI = ctx.getBean(OpenAPI.class);

    String json = new ObjectMapper().writeValueAsString(openAPI);
    Path out = Path.of("/tmp/manual_openapi_" + Instant.now().toEpochMilli() + ".json");
    Files.writeString(out, json);
    System.out.println("✅ Manual OpenAPI generated at: " + out);
  }
}
