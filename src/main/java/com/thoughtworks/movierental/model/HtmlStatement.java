package com.thoughtworks.movierental.model;

class HtmlStatement {

  private String customerName;
  private Rentals rentals;

  public HtmlStatement(String name, Rentals rentals) {
    this.customerName = name;
    this.rentals      = rentals;
  }

  public String generate() {
    return htmlHeader() + htmlBody() + htmlFooter();
  }

  private String htmlHeader() {
    return "<h1>" + "Rental Record for " + customerName + "</h1>" + "<br/>";
  }

  private String htmlBody() {
    String body = "";
    for (Rental rental : rentals) {
      body += " " + rental.getMovie().getTitle() + " " +
          String.valueOf(rental.amount()) + "<br/>";
    }
    return body;
  }

  private String htmlFooter() {
    return "Amount owed is " + "<b>" +  String.valueOf(rentals.totalAmount()) + "</b>" +
        "<br/>" + "You earned " + "<b>" +  String.valueOf(rentals.totalFrequentRenterPoints()) + "</b>"
        + " frequent renter points" + "<br/>";
  }
}