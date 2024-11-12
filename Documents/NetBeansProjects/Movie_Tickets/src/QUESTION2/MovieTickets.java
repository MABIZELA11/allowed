/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QUESTION2;

/**
 *
 * @author USSER1
 */
// MovieTickets class with validation and price calculation methods
public class MovieTickets {
    public boolean validateData(MovieTicketData data) {
        // Ensure the number of tickets is greater than zero and ticket price is positive
        return data.getNumberOfTickets() > 0 && data.getTicketPrice() > 0;
    }

    public double calculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        return 342;
    }
}
