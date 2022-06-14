package tests.RestAssuredTests;

import com.APItest.APIUtils;
import models.Booking;
import models.Bookingdates;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import сore.appconfig.Config;

@SpringJUnitConfig(Config.class)
public class BookingTestSuit {

    Logger logger = LoggerFactory.getLogger(BookingTestSuit.class);

    @Autowired
    public APIUtils apiUtil;

    @Before
    public void testPreparation() {
        apiUtil.initTest();
    }

    @Test
    public void checkThatGetBookingEndpointIsWorking() {
        apiUtil.checkEndpointStatusCode("/booking/", 200);
        logger.info("Endpoint is online");
    }

    @Test
    public void checkEndpointHeaderProperties() {
        apiUtil.checkEndpointHeaderProperty("/booking/", "content-type", "application/json; charset=utf-8");
        apiUtil.checkEndpointHeaderProperty("/booking/", "Server", "Cowboy");
    }

    @Test
    public void createBookingCheck() {
        Integer bookingId = apiUtil.createNewBooking("Jon", "Smith", 100, true, "2018-06-01", "2018-10-01");
        logger.info("Booking id=" + bookingId);
        Booking responseBooking = apiUtil.getBookingByIDtoObject(bookingId);
        Bookingdates bookingDates = responseBooking.getBookingdates();
        Assert.assertTrue(responseBooking.getFirstname().equalsIgnoreCase("Jon"));
        Assert.assertTrue(responseBooking.getLastname().equalsIgnoreCase("Smith"));
        Assert.assertEquals(100, (int) responseBooking.getTotalprice());
        Assert.assertTrue(responseBooking.getDepositpaid());
        Assert.assertTrue(bookingDates.getCheckin().equalsIgnoreCase("2018-06-01"));
        Assert.assertTrue(bookingDates.getCheckout().equalsIgnoreCase("2018-10-01"));
        logger.info("Booking has valid data");
        logger.info(String.valueOf(responseBooking));
    }
}
