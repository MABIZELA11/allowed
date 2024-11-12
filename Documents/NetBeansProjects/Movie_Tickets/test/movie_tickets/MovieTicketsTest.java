/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package movie_tickets;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USSER1
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MovieTicketsTest {

    // Test for TotalMovieSales
    @Test
    public void testCalculateTotalSales_ReturnsExpectedTotalSales() {
        MovieTickets movieTickets = new MovieTickets();
        
        int[] napoleonSales = {3000, 1500, 1700};  // Total should be 6200
        int[] oppenheimerSales = {3500, 1200, 1600};  // Total should be 6300
        
        int napoleonTotal = movieTickets.TotalMovieSales(napoleonSales);
        int oppenheimerTotal = movieTickets.TotalMovieSales(oppenheimerSales);
        
        assertEquals("Total sales for Napoleon should be 6200", 6200, napoleonTotal);
        assertEquals("Total sales for Oppenheimer should be 6300", 6300, oppenheimerTotal);
    }

    // Test for TopMovie
    @Test
    public void testTopMovieSales_ReturnsTopMovie() {
        MovieTickets movieTickets = new MovieTickets();
        
        String[] movies = {"Napoleon", "Oppenheimer"};
        int[] totalSales = {6200, 6300};  // Oppenheimer has higher sales
        
        String topMovie = movieTickets.TopMovie(movies, totalSales);
        
        assertEquals("Top movie should be Oppenheimer", "Oppenheimer", topMovie);
    }
}
