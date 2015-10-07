package de.goeuro.client;

import de.goeuro.model.CityPosition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author Radwa Osama
 * @since 9:45 AM - 10/7/2015
 */
public class DefaultQueryPositionClient implements QueryPositionClient {

  private final static String CITY_POSITION_SUGGEST = "http://api.goeuro.com/api/v2/position/suggest/en/%s";

  private static final Logger log = LoggerFactory.getLogger(DefaultQueryPositionClient.class);

  @Override
  public List<CityPosition> suggestCityPosition(String name) {
    if (StringUtils.isEmpty(name)) {
      log.debug("invalid input name");
      throw new RuntimeException("invalid input name");
    }

    RestTemplate restTemplate = new RestTemplate();
    String url = String.format(CITY_POSITION_SUGGEST, name);
    log.debug("calling API with " + url);

    ResponseEntity<CityPosition[]> response;

    try {
      response = restTemplate.getForEntity(url, CityPosition[].class);
      log.debug("results returned ");
      return Arrays.asList(response.getBody());
    } catch (HttpClientErrorException e) {
      throw new RuntimeException(writeMessage(e.getStatusCode(), name), e);
    }
  }

  /**
   * @param status response from API
   * @param name   of input city
   * @return appropriate error message
   */
  private String writeMessage(HttpStatus status, String name) {
    return
      String.format("unexpected response (%s) for input \"%s\"", status, name);
  }
}
