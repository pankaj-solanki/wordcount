/**
 * 
 */
package wordcount.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @author pankaj
 *
 */
@Profile("dev")
@Configuration
@PropertySource("classpath:application-dev.properties")
public class DevConfig {

}
