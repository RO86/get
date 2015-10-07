package de.goeuro.writer;

import de.goeuro.model.CityPosition;

/**
 * @author Radwa Osama
 * @since 10:30 AM - 10/7/2015
 */
public class CityPositionCSVWriter extends CSVWriter<CityPosition> {

  @Override
  public String header() {
    return "Id,Name,Type,Latitude,Longitude";
  }

  @Override
  public String map(CityPosition row) {
    return row.getId() + COMMA +
      row.getName() + COMMA +
      row.getType() + COMMA +
      row.getGeoPosition().getLatitude() + COMMA +
      row.getGeoPosition().getLongitude();
  }
}
