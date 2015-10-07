package de.goeuro;

/**
 * @author Radwa Osama
 * @since 9:32 AM - 10/7/2015
 */

import de.goeuro.client.DefaultQueryPositionClient;
import de.goeuro.client.QueryPositionClient;
import de.goeuro.model.Position;
import de.goeuro.writer.CityPositionCSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

  private static final Logger log = LoggerFactory.getLogger(Application.class);

  public static void main(String args[]) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    if (args == null || args.length == 0 || !StringUtils.hasText(args[0])) {
      log.error("Invalid input");
      return;
    }

    String cityName = String.join(" ", args).trim();
    log.debug("Input city name " + cityName);

    try {

      // Query suggestions for input city name
      QueryPositionClient client = new DefaultQueryPositionClient();
      List<Position> result = client.suggestCityPosition(cityName);

      // Write output into a CSV file
      CityPositionCSVWriter writer = new CityPositionCSVWriter();
      writer.write(result, cityName);

    } catch (RuntimeException e) {
      log.error("Run time exception was thrown: " + e.getMessage());
    }

  }
}