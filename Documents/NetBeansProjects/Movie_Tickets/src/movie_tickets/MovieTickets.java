/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package movie_tickets;
//MABIZELA MAKWATSA
//

import QUESTION2.MovieTicketData;


/**
 *
 * @author USSER1
 */
public class MovieTickets implements IMovieTickets {
    // Non-static method to calculate total movie sales
    public int TotalMovieSales(int[] movieTickets) {
        int total = 0;
        for (int tickets : movieTickets) {
            total += tickets;
        }
        return total;
    }

    // Non-static method to determine the top-performing movie
    public String TopMovie(String[] movies, int[] totalSales) {
        int topIndex = 0;
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > totalSales[topIndex]) {
                topIndex = i;
            }
        }
        return movies[topIndex];
    }

    // Main method to display the movie ticket report
    public static void main(String[] args) {
        // Create an instance of MovieTickets to use non-static methods
        MovieTickets report = new MovieTickets();

        // Movie names
        String[] movies = {"Napoleon", "Oppenheimer"};
        
        // Ticket sales data for each month (Jan, Feb, Mar)
        int[][] ticketSales = {
            {3000, 1500, 1700},  // Napoleon's sales
            {3500, 1200, 1600}   // Oppenheimer's sales
        };

        // Calculate total sales for each movie
        int[] totalSales = new int[movies.length];
        for (int i = 0; i < movies.length; i++) {
            totalSales[i] = report.TotalMovieSales(ticketSales[i]);
        }

        // Display the movie ticket report
        System.out.println("MOVIE TICKET SALES REPORT - 2024");
        System.out.println("             JAN     FEB     MAR    TOTAL");
        System.out.println("           -----------------------------------");

        for (int i = 0; i < movies.length; i++) {
            System.out.printf("%-10s", movies[i]);
            for (int j = 0; j < ticketSales[i].length; j++) {
                System.out.printf("%8d", ticketSales[i][j]);
            }
            System.out.printf("%8d", totalSales[i]);
            System.out.println();
        }

        // Calculate and display column totals
        System.out.print("TOTAL      ");
        for (int j = 0; j < ticketSales[0].length; j++) {
            int monthTotal = 0;
            for (int i = 0; i < ticketSales.length; i++) {
                monthTotal += ticketSales[i][j];
            }
            System.out.printf("%8d", monthTotal);
        }
        System.out.printf("%8d", totalSales[0] + totalSales[1]);
        System.out.println();

        // Display the top-performing movie
        System.out.println("Top performing movie: " + report.TopMovie(movies, totalSales));
    }

    public boolean validateData(MovieTicketData data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public double calculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
