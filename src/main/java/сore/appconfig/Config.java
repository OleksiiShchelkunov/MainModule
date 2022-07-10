package сore.appconfig;


import com.APItest.APIUtils;
import drivers.DriverFactory;
import models.Booking;
import models.BookingDates;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pageClasses.LoginPage;

@Configuration
@ComponentScan(basePackages = "com.APItest, models, pageClasses, drivers")
@Import({APIUtils.class, Booking.class, LoginPage.class, DriverFactory.class})

public class Config {

    @Bean
    public static APIUtils apiUtil() {
        return new APIUtils();
    }

    @Bean
    public static Booking booking() {
        return new Booking();
    }

    @Bean
    public static BookingDates bookingDates() {
        return new BookingDates();
    }

//    @Bean
//    public WebDriver driver () {
//        WebDriver driver = DriverFactory.getNewDriver("Chrome");
//        return driver;
//    }

    @Bean
    public LoginPage loginPage () {
        return new LoginPage(DriverFactory.getNewDriver("Chrome"));
    }
}

