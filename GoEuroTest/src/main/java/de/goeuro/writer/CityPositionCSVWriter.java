package de.goeuro.writer;

import de.goeuro.model.Position;

/**
 * @author Radwa Osama
 * @since 10:30 AM - 10/7/2015
 */
public class CityPositionCSVWriter extends CSVWriter<Position> {

  @Override
  public String map(Position row) {
    return row.getId() + COMMA +
      row.getName() + COMMA +
      row.getType() + COMMA +
      row.getGeoPosition().getLatitude() + COMMA +
      row.getGeoPosition().getLongitude();
  }
}
