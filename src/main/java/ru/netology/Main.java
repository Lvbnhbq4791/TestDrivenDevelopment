package ru.netology;

import ru.netology.phonebook.PhoneBook;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        int numberOfContacts;
        numberOfContacts = phoneBook.add("Ivanov", "88005553535");
        System.out.println(numberOfContacts);
        String nameContact;
        nameContact = phoneBook.findByNumber("88005553535");
        System.out.println(nameContact);
        nameContact = phoneBook.findByNumber("5151515151");
        System.out.println(nameContact);
    }
}