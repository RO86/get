package de.goeuro.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Radwa Osama
 * @since 9:25 AM - 10/7/2015
 */
public class Position {

  @JsonProperty("_id")
  private long id;

  private String name;

  private String type;

  @JsonProperty("geo_position")
  private GeoPosition geoPosition;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public GeoPosition getGeoPosition() {
    return geoPosition;
  }

  public void setGeoPosition(GeoPosition geoPosition) {
    this.geoPosition = geoPosition;
  }

  @Override
  public String toString() {
    return "CityPosition{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", type='" + type + '\'' +
      ", geoPosition=" + geoPosition +
      '}';
  }
}
