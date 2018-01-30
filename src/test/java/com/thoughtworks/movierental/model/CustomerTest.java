package com.thoughtworks.movierental.model;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CustomerTest {

    @Test
    public void shouldGenerateStatementGivenAllMovieTypes(){
        String expectedStatement = "Rental Record for john\n" +
            "\tdangal\t3.5\n" +
            "\tpadmavat\t6.0\n" +
            "\tangrybirds\t3.0\n" +
            "Amount owed is 12.5\n" +
            "You earned 4 frequent renter points";

        Customer john     = new Customer("john", "john@test.com");
        Movie children    = new Movie("angrybirds", Movie.CHILDRENS);
        Movie regular     = new Movie("dangal", Movie.REGULAR);
        Movie newRelease  = new Movie("padmavat", Movie.NEW_RELEASE);

        john.addRental(new Rental(regular, 3));
        john.addRental(new Rental(newRelease, 2));
        john.addRental(new Rental(children, 4));

        String statement = john.statement();
        assertEquals(expectedStatement, statement);
    }

    @Test
    public void shouldGenerateHtmlStatementGivenAllMovieTypes(){
        String expectedStatement = "<h1>Rental Record for john</h1><br/>" +
            " dangal 3.5<br/>" +
            " padmavat 6.0<br/>" +
            " angrybirds 3.0<br/>" +
            "Amount owed is <b>12.5</b><br/>" +
            "You earned <b>4</b> frequent renter points<br/>";

        Customer john     = new Customer("john", "john@test.com");
        Movie children    = new Movie("angrybirds", Movie.CHILDRENS);
        Movie regular     = new Movie("dangal", Movie.REGULAR);
        Movie newRelease  = new Movie("padmavat", Movie.NEW_RELEASE);

        john.addRental(new Rental(regular, 3));
        john.addRental(new Rental(newRelease, 2));
        john.addRental(new Rental(children, 4));

        String statement = john.htmlStatement();
        assertEquals(expectedStatement, statement);
    }
}