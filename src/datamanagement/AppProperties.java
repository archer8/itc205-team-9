package datamanagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppProperties {
  private static AppProperties self = null;
  private Properties properties;

  /**
   * AppProperties does something.
   *
   * @return Returns self.
   */
  public static AppProperties getInstance() {
    if (self == null) {
      self = new AppProperties();
    }
    return self;
  }

  private AppProperties() {
    properties = new Properties();
    try {
      properties.load(new FileInputStream("Properties.prop"));
    } catch (IOException e) {
      throw new RuntimeException("Could not read property file");
    }
  }

  public Properties getProperties() {
    return properties;
  }
}
