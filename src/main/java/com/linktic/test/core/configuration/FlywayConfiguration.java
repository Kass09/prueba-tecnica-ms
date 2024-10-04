package com.linktic.test.core.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({DataSourceProperties.class, FlywayProperties.class})
public class FlywayConfiguration {

  @Bean(initMethod = "migrate")
  public Flyway flyway(FlywayProperties flywayProperties,
      DataSourceProperties dataSourceProperties) {
    return Flyway.configure()
        .dataSource(
            flywayProperties.getUrl(), dataSourceProperties.getUsername(),
            dataSourceProperties.getPassword())
        .schemas(flywayProperties.getSchemas().toArray(new String[0]))
        .baselineOnMigrate(flywayProperties.isBaselineOnMigrate())
        .locations(flywayProperties.getLocations().toArray(String[]::new))
        .load();
  }
}