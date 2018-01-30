package com.thoughtworks.movierental.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class HtmlStatementTest {

  @Test
  public void shouldGenerateHtmlStatementGivenAllMovieTypes(){
    String expectedStatement = "<h1>Rental Record for john</h1><br/>" +
        " dangal 3.5<br/>" +
        " padmavat 6.0<br/>" +
        " angrybirds 3.0<br/>" +
        "Amount owed is <b>12.5</b><br/>" +
        "You earned <b>4</b> frequent renter points<br/>";

    Movie children    = new Movie("angrybirds", Movie.CHILDRENS);
    Movie regular     = new Movie("dangal", Movie.REGULAR);
    Movie newRelease  = new Movie("padmavat", Movie.NEW_RELEASE);

    Rentals rentals = new Rentals();
    rentals.add(new Rental(regular, 3));
    rentals.add(new Rental(newRelease, 2));
    rentals.add(new Rental(children, 4));

    String statement = new HtmlStatement("john", rentals).generate();
    assertEquals(expectedStatement, statement);
  }

}