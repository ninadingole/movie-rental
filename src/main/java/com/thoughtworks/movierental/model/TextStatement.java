package com.thoughtworks.movierental.model;

class TextStatement {

  private String customerName;
  private Rentals rentals;

  public TextStatement(String customerName, Rentals rentals) {
    this.customerName = customerName;
    this.rentals      = rentals;
  }

  public String generate() {
    return header() + body() + footer();
  }

  private String header() {
    return "Rental Record for " + customerName + "\n";
  }

  private String body() {
    String body = "";
    for (Rental rental : rentals) {
      body += "\t" + rental.getMovie().getTitle() + "\t" +
          String.valueOf(rental.amount()) + "\n";
    }
    return body;
  }

  private String footer() {
    return "Amount owed is " + String.valueOf(rentals.totalAmount()) +
        "\n" + "You earned " + String.valueOf(rentals.totalFrequentRenterPoints())
        + " frequent renter points";
  }
}