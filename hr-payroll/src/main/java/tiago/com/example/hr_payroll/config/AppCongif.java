package tiago.com.example.hr_payroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppCongif {

    @Bean /*padrão de projeto singleton, instância única*/
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
