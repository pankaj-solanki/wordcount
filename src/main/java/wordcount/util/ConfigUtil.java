/**
 * 
 */
package wordcount.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author pankaj
 *
 */
@Component
public class ConfigUtil {

  private static Environment environment;
  private static final String COMMA = ",";

  @Autowired
  public void setEnvironment(Environment environment) {
    ConfigUtil.environment = environment;
  }

  public static String getProperty(String key) {
    return environment.getProperty(key);
  }

  public static String getProperty(String key, String defaultValue) {
    return environment.getProperty(key, defaultValue);
  }

  public static String[] getPropertyValueArray(String key) {
    System.out.println("Reading property " + key);
    String value = getProperty(key);
    System.out.println("Values = " + value);
    if (value != null) {
      return value.split(COMMA);
    }
    return null;
  }

}
