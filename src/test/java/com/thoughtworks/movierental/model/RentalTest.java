package com.thoughtworks.movierental.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class RentalTest {

  @Test
  public void shouldCalculateAmountForRegularMovie() {
    Movie movie = new Movie("Regular Movie", Movie.REGULAR);
    Rental rental = new Rental(movie, 3);
    double amount = rental.amount();
    assertEquals(3.5, amount, 0);
  }


  @Test
  public void shouldCalculateAmountForNewRelease() {
    Movie movie = new Movie("New Release Movie", Movie.NEW_RELEASE);
    Rental rental = new Rental(movie, 3);
    double amount = rental.amount();
    assertEquals(9, amount, 0);
  }

  @Test
  public void shouldCalculateAmountForChildrens() {
    Movie movie = new Movie("Childrens Movie", Movie.CHILDRENS);
    Rental rental = new Rental(movie, 4);
    double amount = rental.amount();
    assertEquals(3.0, amount, 0);
  }

  @Test
  public void shouldCalculateFrequentRenterPointsWithBonusForNewReleaseRentedFor3Days() {
    Movie movie = new Movie("New Release Movie", Movie.NEW_RELEASE);
    Rental rental = new Rental(movie, 4);
    int renterPoints = rental.frequentRenterPoints();
    assertEquals(2, renterPoints);
  }

  @Test
  public void shouldCalculateFrequentRenterPointsWithoutBonusForNewReleaseRentedFor1Day() {
    Movie movie = new Movie("New Release Movie", Movie.NEW_RELEASE);
    Rental rental = new Rental(movie, 1);
    int renterPoints = rental.frequentRenterPoints();
    assertEquals(1, renterPoints);
  }

  @Test
  public void shouldCalculateFrequentRenterPointsRegularMovie() {
    Movie movie = new Movie("Regular Movie", Movie.REGULAR);
    Rental rental = new Rental(movie, 5);
    int renterPoints = rental.frequentRenterPoints();
    assertEquals(1, renterPoints);
  }
}