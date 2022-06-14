package сore.appconfig;


import com.APItest.APIUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.APItest")
@Import({APIUtils.class})

public class Config {

    @Bean
    public static APIUtils apiUtil() {
        return new APIUtils();
    }
}