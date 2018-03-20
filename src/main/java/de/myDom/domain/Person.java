package de.myDom.domain;

import java.io.Serializable;

public class Person implements Serializable {
    private final String name;
    private final Auto auto;

    public static final Person THE_BOSS = new Person("The Boss", new Auto("Audi", "A5", 325));

    public Person(String name, Auto auto) {
        this.name = name;
        this.auto = auto;
    }

    public String getName() {
        return name;
    }

    public Auto getAuto() {
        return auto;
    }

    public static Person create(String name, Auto auto) {
        if (name.equals(THE_BOSS.getName())) {
            return THE_BOSS;
        }
        return new Person(name, auto);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", auto=" + auto +
                '}';
    }
}
