/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package movie_tickets;

/**
 *
 * @author USSER1
 */
public interface IMovieTickets {
    int TotalMovieSales(int[] movieTickets);
    String TopMovie(String[] movies, int[] totalSales);
}
