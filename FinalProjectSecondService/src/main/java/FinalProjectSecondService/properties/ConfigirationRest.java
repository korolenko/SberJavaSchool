package FinalProjectSecondService.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigirationRest {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
