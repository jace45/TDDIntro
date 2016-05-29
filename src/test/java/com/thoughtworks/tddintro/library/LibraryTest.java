package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {
    private List<String> books;
    private PrintStream printStream;
    private DateTimeFormatter dateTimeFormatter;
    private Library library;
    private DateTime time;


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */


    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
        library = new Library(books, printStream, dateTimeFormatter);
        time = new DateTime();
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        //Given
        String title = "Book Title";
        books.add(title);

        //Action
        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        //Assert
        verify(printStream).println("Book Title\n");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        //Action
        library.listBooks();

        //Assert
        verify(printStream).println("");
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {

        books.add("Book Title");
        books.add("Title Book");

        //Action
        library.listBooks();

        //Assert
        verify(printStream).println("Book Title\nTitle Book\n");

        // implement me
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class

        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {

        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        // add a verify here
        verify(printStream).println("Welcome to the library! The current time is ");

    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

        when(dateTimeFormatter.print(time)).thenReturn("10:22 pm");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);
        // implement me
        // then move common test variables into a setup method
        verify(printStream).println(contains("10:22 pm"));

    }
}