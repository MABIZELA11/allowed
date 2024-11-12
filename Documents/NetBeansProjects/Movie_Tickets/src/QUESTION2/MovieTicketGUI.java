package QUESTION2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

// MovieTicketData class to store individual ticket data


public class MovieTicketGUI extends JFrame {
    private JComboBox<String> movieComboBox;
    private JTextField numberOfTicketsField;
    private JTextField ticketPriceField;
    private JTextArea ticketReportArea;
    private MovieTickets movieTickets = new MovieTickets();

    public MovieTicketGUI() {
        setTitle("Movie Tickets");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(null);

        // Combo box for movie selection
        movieComboBox = new JComboBox<>(new String[]{"Napoleon", "Oppenheimer", "Damsel"});
        movieComboBox.setBounds(20, 20, 150, 25);
        add(movieComboBox);

        // Number of tickets
        JLabel ticketsLabel = new JLabel("Number of Tickets:");
        ticketsLabel.setBounds(20, 60, 150, 25);
        add(ticketsLabel);

        numberOfTicketsField = new JTextField();
        numberOfTicketsField.setBounds(150, 60, 100, 25);
        add(numberOfTicketsField);

        // Ticket price
        JLabel priceLabel = new JLabel("Ticket Price:");
        priceLabel.setBounds(20, 100, 150, 25);
        add(priceLabel);

        ticketPriceField = new JTextField();
        ticketPriceField.setBounds(150, 100, 100, 25);
        add(ticketPriceField);

        // Report area
        ticketReportArea = new JTextArea();
        ticketReportArea.setEditable(false);
        ticketReportArea.setBounds(20, 140, 350, 100);
        add(ticketReportArea);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        processItem.addActionListener(new ProcessAction());
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> clearFields());
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);
        setVisible(true);
    }

    private void clearFields() {
        movieComboBox.setSelectedIndex(0);
        numberOfTicketsField.setText("");
        ticketPriceField.setText("");
        ticketReportArea.setText("");
    }

    private class ProcessAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String movieName = (String) movieComboBox.getSelectedItem();
            int numberOfTickets;
            double ticketPrice;

            try {
                numberOfTickets = Integer.parseInt(numberOfTicketsField.getText());
                ticketPrice = Double.parseDouble(ticketPriceField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(MovieTicketGUI.this, "Please enter valid numbers.");
                return;
            }

            MovieTicketData data = new MovieTicketData(movieName, numberOfTickets, ticketPrice);

            if (!movieTickets.validateData(data)) {
                JOptionPane.showMessageDialog(MovieTicketGUI.this, "Invalid data entered. Please check your input.");
                return;
            }

            double total = movieTickets.calculateTotalTicketPrice(numberOfTickets, ticketPrice);
            ticketReportArea.setText(String.format("MOVIE NAME: %s\nMOVIE TICKET PRICE: R %.2f\nNUMBER OF TICKETS: %d\nTOTAL TICKET PRICE: R %.2f",
                    movieName, ticketPrice, numberOfTickets, total));

            saveReportToFile(movieName, ticketPrice, numberOfTickets, total);
        }

        private void saveReportToFile(String movieName, double ticketPrice, int numberOfTickets, double total) {
            try (FileWriter writer = new FileWriter("report.txt")) {
                writer.write("MOVIE TICKET REPORT\n");
                writer.write("******************************\n");
                writer.write(String.format("MOVIE NAME: %s\n", movieName));
                writer.write(String.format("MOVIE TICKET PRICE: R %.2f\n", ticketPrice));
                writer.write(String.format("NUMBER OF TICKETS: %d\n", numberOfTickets));
                writer.write(String.format("TOTAL TICKET PRICE: R %.2f\n", total));
                writer.write("******************************\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(MovieTicketGUI.this, "Error saving report to file.");
            }
        }
    }

    public static void main(String[] args) {
        new MovieTicketGUI();
    }
}
