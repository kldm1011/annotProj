package de.myDom;

import de.myDom.annotation.LogExecutionTime;
import de.myDom.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class Service {
    private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);

    private static int counter = 1;

    /**
     * Serialisieren und in die Datei schreiben.
     * @param p Person
     */
    @LogExecutionTime(repeat = 10)
    public void writePerson(Person p) {
        try (
                FileOutputStream fos = new FileOutputStream("dummy.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(p);
        } catch (Exception e) {
            LOGGER.error("Fehler1:", e);
        }
    }

    /**
     * Aus der Datei lesen und deserialisieren.
     */
    @LogExecutionTime(repeat = 1)
    public Person readPerson() {
        try (
                FileInputStream fis = new FileInputStream("dummy.ser");
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            final Person p2 = (Person) ois.readObject();
            return p2;
        } catch (Exception e) {
            LOGGER.error("Fehler2:", e);
            return null;
        }
    }

    @LogExecutionTime(repeat = 3)
    public void nothing() {
        if(Math.random() < 0.5) {
            throw new NullPointerException();
        }
        LOGGER.warn(counter + ". rausgeschrieben");
        counter++;
    }
}
