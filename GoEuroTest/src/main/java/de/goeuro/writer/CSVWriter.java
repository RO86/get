package de.goeuro.writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

  private static final Logger log = LoggerFactory.getLogger(CSVWriter.class);

  public abstract String header();

  public abstract String map(T row);

  public void write(List<T> rows, String name) {
    String fileName = String.format("export_%s_%s%s", name, System.currentTimeMillis(), ".csv");
    log.debug("writing csv file with name " + fileName);
    try (PrintWriter pw = new PrintWriter(new File(fileName))) {
      pw.write(header());
      pw.write(NEW_LINE);
      for (T row : rows) {
        String sRow = map(row);
        log.debug("writing " + sRow);
        pw.write(sRow);
        pw.write(NEW_LINE);
      }
      log.debug("done exporting data");
    } catch (Exception e) {
      log.error("Can't export data", e);
    }
  }

}
