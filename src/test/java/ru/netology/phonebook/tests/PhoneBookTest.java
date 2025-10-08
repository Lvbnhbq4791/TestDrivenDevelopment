package ru.netology.phonebook.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.phonebook.PhoneBook;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PhoneBookTest {
    private PhoneBook phoneBook;

    @BeforeEach
    void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    @DisplayName("Проверка метода addToPhoneBook на добавление контакта")
    public void givenNameAndPhone_whenAddToPhoneBook_thenNewContactCreated() {
        int result = phoneBook.add("Иванов", "999999");
        phoneBook.add("Иванов Иван", "+79211234567");
        assertThat(result, equalTo(1));
    }

    @Test
    @DisplayName("Проверка метода getContactsByName на запрет добавления контакта с одинаковым именем")
    public void givenNameAndPhone_whenCheckNameInPhoneBook_thenWriteDownIfNot() {
        int result1;
        int result2;
        phoneBook.add("Иванов", "999999");
        result1 = phoneBook.add("Петров", "555555");
        assertThat(result1, equalTo(2));
        result2 = phoneBook.add("Иванов", "444444");
        assertThat(result2, equalTo(2));
    }
}
