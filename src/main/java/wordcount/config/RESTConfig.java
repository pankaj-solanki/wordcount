/**
 * 
 */
package wordcount.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author pankaj
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "wordcount")
public class RESTConfig {

  @Autowired
  private Environment environment;

}
