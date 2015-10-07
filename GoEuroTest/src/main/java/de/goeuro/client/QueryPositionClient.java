package de.goeuro.client;

import de.goeuro.model.Position;

import java.util.List;

/**
 * @author Radwa Osama
 * @since 9:45 AM - 10/7/2015
 */
public interface QueryPositionClient {

  // Find list of suggested positions
  public List<Position> suggestCityPosition(String name);
}
