/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package QUESTION2;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author USSER1
 */


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MovieTicketsTest {

    @Test
    public void testCalculateTotalTicketPrice() {
        // Arrange
        MovieTickets movieTickets = new MovieTickets();
        int numberOfTickets = 5;
        double ticketPrice = 50.0;

        // Act
        double result = movieTickets.calculateTotalTicketPrice(numberOfTickets, ticketPrice);

        // Assert
        assertEquals("Total ticket price should be 342", 342, result, 0.001);
    }

    @Test
    public void testCalculateTotalTicketPriceWithDifferentInput() {
        // Arrange
        MovieTickets movieTickets = new MovieTickets();
        int numberOfTickets = 3;
        double ticketPrice = 100.0;

        // Act
        double result = movieTickets.calculateTotalTicketPrice(numberOfTickets, ticketPrice);

        // Assert
        assertEquals("Total ticket price should be 342 even with different input", 342, result, 0.001);
    }
}
