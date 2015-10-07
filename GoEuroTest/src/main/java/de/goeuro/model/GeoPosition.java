package de.goeuro.model;

/**
 * @author Radwa Osama
 * @since 9:28 AM - 10/7/2015
 */
public class GeoPosition {

  private double latitude;

  private double longitude;

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  @Override
  public String toString() {
    return "GeoPosition{" +
      "latitude=" + latitude +
      ", longitude=" + longitude +
      '}';
  }
}
