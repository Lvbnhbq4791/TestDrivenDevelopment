package ru.netology.phonebook;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    protected Map<String, String> phoneBookMap;

    public PhoneBook() {
        this.phoneBookMap = new TreeMap<>();
    }

    public int add(String name, String phoneNumber) {
        if (!phoneBookMap.containsKey(name)) phoneBookMap.put(name, phoneNumber);
        return phoneBookMap.size();
    }

}