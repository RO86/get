package de.goeuro.writer;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Radwa Osama
 * @since 10:05 AM - 10/7/2015
 */
public abstract class CSVWriter<T> {

  public static final String NEW_LINE = "\n";
  public static final String COMMA = ",";

  public abstract String header();

  public abstract String map(T row);

  public void write(List<T> rows, String name) {
    String fileName = String.format("export_%s_%s%s", name, System.currentTimeMillis(), ".csv");
    try (PrintWriter pw = new PrintWriter(new File(fileName))) {
      pw.write(header());
      pw.write(NEW_LINE);
      for (T row : rows) {
        pw.write(map(row));
        pw.write(NEW_LINE);
      }
    } catch (Exception e) {
      throw new RuntimeException("Can't export data", e);
    }
  }

}
