package ru.netology.phonebook;

import java.util.Map;
import java.util.Optional;
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

    public String findByNumber(String phoneNumber) {
        Optional<String> key = phoneBookMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(phoneNumber))
                .map(Map.Entry::getKey)
                .findFirst();
        return key.orElse("null");
    }

    public String findByName(String name) {
        return null;
    }
}