package io.simplelocalize.cli.configuration;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ConfigurationLoaderTest {

  private ConfigurationLoader loader = new ConfigurationLoader();

  @Test
  public void shouldLoadConfiguration() throws Exception {
    //given
    ClassLoader classLoader = getClass().getClassLoader();
    String pathToConfig = classLoader.getResource("simplelocalize.yml").toURI().toString().replace("file:", "");

    //when
    Configuration configuration = loader.load(pathToConfig);

    //then
    Assertions.assertThat(configuration).isNotNull();
    Assertions.assertThat(configuration.getClientId()).isEqualTo("123456");
    Assertions.assertThat(configuration.getClientSecret()).isEqualTo("7890");
    Assertions.assertThat(configuration.getProjectToken()).isEqualTo("abc");
    Assertions.assertThat(configuration.getProjectType()).isEqualTo("CDN");
    Assertions.assertThat(configuration.getSearchDir()).isEqualTo("/Users/jpomykala/Workspace/");
  }

  @Test
  public void shouldLoadConfigurationWithCurrentDirectory() throws Exception {
    //given
    ClassLoader classLoader = getClass().getClassLoader();
    String pathToConfig = classLoader.getResource("simplelocalize-without-search-dir.yml").toURI().toString().replace("file:", "");

    //when
    Configuration configuration = loader.load(pathToConfig);

    //then
    Assertions.assertThat(configuration.getSearchDir()).isEqualTo(".");
  }

}
