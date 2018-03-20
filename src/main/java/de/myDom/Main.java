package de.myDom;

import de.myDom.domain.Auto;
import de.myDom.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        Auto a = new Auto("BMW", "325", 218);
        Person p = new Person("Arno", a);

        context.getBean(Service.class).writePerson(p);
        Person per = context.getBean(Service.class).readPerson();
        LOGGER.info(per.toString());

//        Auto b = new Auto("Mercedes-Benz", "C-Klasse", 204);
//        Person p2 = Person.create("The Boss", b);
//
//        context.getBean(Service.class).writePerson(p2);
//        Person per2 = context.getBean(Service.class).readPerson();
//        LOGGER.info(per2.toString());

        context.getBean(Service.class).nothing();
        LOGGER.info("Ende.");
    }



}
