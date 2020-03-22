package com.slotvinskiy;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String name;
    private List<Person> persons = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", list=" + persons +
                '}';
    }
}
