package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringLearnApplication.class, args);
        SpringLearnApplication application = context.getBean(SpringLearnApplication.class);
        application.displayDate();
        application.displayCountry();
        application.displayCountryPrototype();
        application.displayCountries();
        context.close();
    }

    public void displayDate() {
        LOGGER.info("START displayDate");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Parsed date: {}", date);
        } catch (ParseException e) {
            LOGGER.error("Error parsing date", e);
        }
        ((ClassPathXmlApplicationContext) context).close();
        LOGGER.info("END displayDate");
    }

    public void displayCountry() {
        LOGGER.info("START displayCountry");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        Country anotherCountry = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country);
        LOGGER.debug("Same singleton instance: {}", country == anotherCountry);
        ((ClassPathXmlApplicationContext) context).close();
        LOGGER.info("END displayCountry");
    }

    public void displayCountryPrototype() {
        LOGGER.info("START displayCountryPrototype");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country prototypeCountry = context.getBean("countryPrototype", Country.class);
        Country anotherPrototypeCountry = context.getBean("countryPrototype", Country.class);
        LOGGER.debug("Prototype country : {}", prototypeCountry);
        LOGGER.debug("Prototype same instance: {}", prototypeCountry == anotherPrototypeCountry);
        ((ClassPathXmlApplicationContext) context).close();
        LOGGER.info("END displayCountryPrototype");
    }

    public void displayCountries() {
        LOGGER.info("START displayCountries");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<?> countryList = context.getBean("countryList", List.class);
        LOGGER.debug("Country list size: {}", countryList.size());
        for (Object countryObject : countryList) {
            Country country = (Country) countryObject;
            LOGGER.debug("Country : {}", country);
        }
        ((ClassPathXmlApplicationContext) context).close();
        LOGGER.info("END displayCountries");
    }
}
