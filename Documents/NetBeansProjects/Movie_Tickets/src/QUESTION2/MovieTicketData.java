/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QUESTION2;

/**
 *
 * @author USSER1
 */
public class MovieTicketData {
   
    private String movieName;
    private int numberOfTickets;
    private double ticketPrice;

    public MovieTicketData(String movieName, int numberOfTickets, double ticketPrice) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        this.ticketPrice = ticketPrice;
    }

    // Getters
    public String getMovieName() {
        return movieName;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    // Setters
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}


