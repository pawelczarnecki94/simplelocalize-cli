package io.simplelocalize.cli.configuration;

import lombok.Data;

import java.util.Set;

@Data
public class Configuration {

  private String searchDir;
  private String clientId;
  private String clientSecret;
  private String projectToken;
  private String projectType;
  private Set<String> ignoredKeys = Set.of();

}
