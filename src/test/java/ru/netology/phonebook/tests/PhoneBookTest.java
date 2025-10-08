package ru.netology.phonebook.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.phonebook.PhoneBook;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @Test
    @DisplayName("Проверка метода findByNumber на получение получении имени по номеру телефона")
    public void givenNumber_whenCheckNameByNumber_thenGetResult() {
        phoneBook.add("Вася", "9951519999");
        phoneBook.add("Петрович", "55551854555");
        String result = phoneBook.findByNumber("9951519999");
        assertThat(result, equalTo("Вася"));
        String result2 = phoneBook.findByNumber("22519859515");
        assertThat(result2, equalTo("null"));
    }

    @Test
    @DisplayName("Проверка метода findByName на получение  номера телефона по имени")
    public void givenName_whenCheckNumberByName_thenGetResult() {
        phoneBook.add("Ffxdfdx", "5151515151");
        phoneBook.add("Задов", "558454541");
        String result = phoneBook.findByName("Задов");
        assertThat(result, equalTo("558454541"));
        String result2 = phoneBook.findByName("Вася");
        assertThat(result2, equalTo(null));
    }

    @Test
    @DisplayName("Проверка метода printAllNames на вывод имен по альфавиту")
    public void givenPhoneBook_whenFormNamesAlphabetically_thenPrintNames() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = System.out;
        System.setOut(new PrintStream(baos));
        phoneBook.add("Petrov", "8151515151");
        phoneBook.add("Sidorov", "9854514545156");
        phoneBook.add("Glazov", "5415182151");
        phoneBook.printAllNames();
        System.setOut(printStream);
        String methodOutput = baos.toString().trim();
        assertThat(methodOutput, equalTo("Glazov\r\nPetrov\r\nSidorov"));
    }
}
