package com.thoughtworks.movierental.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class TextStatementTest {

  @Test
  public void shouldGenerateStatementGivenAllMovieTypes(){
    String expectedStatement = "Rental Record for john\n" +
        "\tdangal\t3.5\n" +
        "\tpadmavat\t6.0\n" +
        "\tangrybirds\t3.0\n" +
        "Amount owed is 12.5\n" +
        "You earned 4 frequent renter points";

    Movie children    = new Movie("angrybirds", Movie.CHILDRENS);
    Movie regular     = new Movie("dangal", Movie.REGULAR);
    Movie newRelease  = new Movie("padmavat", Movie.NEW_RELEASE);

    Rentals rentals = new Rentals();
    rentals.add(new Rental(regular, 3));
    rentals.add(new Rental(newRelease, 2));
    rentals.add(new Rental(children, 4));

    String statement = new TextStatement("john", rentals).generate();
    assertEquals(expectedStatement, statement);
  }

}