import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class LondonMusicalTicket extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> infoList;

    // JDBC URL, username, and password of Derby server
    String url = "jdbc:derby://localhost:1527/yourdatabase";
    String user = "username";
    String password = "password";



    public LondonMusicalTicket() {
		
		
		
		

        try {
          
		 // Establish a connection
    Connection connection = DriverManager.getConnection(url, user, password);

    // Print a message to the console indicating a successful connection
    System.out.println("Connection to the database established successfully!");


            // Your database operations go here

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		
		
        // Set layout manager
        setLayout(new BorderLayout());

        // Create buttons
        JButton musicalListButton = new JButton("Musical List");
        JButton showScheduleButton = new JButton("Show Schedule");
        JButton bookTicketButton = new JButton("Book Ticket");
        JButton exitButton = new JButton("Exit");

        // Create list model and list
        listModel = new DefaultListModel<>();
        infoList = new JList<>(listModel);
        infoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(infoList);

        // Add buttons to the frame
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(musicalListButton);
        buttonPanel.add(showScheduleButton);
        buttonPanel.add(bookTicketButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(listScrollPane, BorderLayout.CENTER);

        // Add action listeners for the buttons
        musicalListButton.addActionListener(createActionListener("Musical List"));
        showScheduleButton.addActionListener(createActionListener("Show Schedule"));
        bookTicketButton.addActionListener(createActionListener("Book Ticket"));
        exitButton.addActionListener(createActionListener("Exit"));

        // Set frame properties
        setTitle("London Musical Ticket System");
        setSize(getScreenWidth() * 3 / 5, getScreenHeight() * 3 / 5); // Set size to 60% of screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setResizable(false);
    }

    private ActionListener createActionListener(final String buttonName) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateListContent(buttonName);
            }
        };
    }

    private void updateListContent(String buttonName) {
        listModel.clear();
        listModel.addElement("Button Clicked: " + buttonName);

        // Add 20 clickable items to the list
        for (int i = 1; i <= 20; i++) {
            String itemText = "<html>"; // Start HTML for multiline text
            itemText += "<div style='border: 1px solid black; padding: 5px; margin: 5px;'>"; // Add border, padding, and margin
            if ("Musical List".equals(buttonName)) {
                // Add code to show musical list
                itemText += "<b>Movie name:</b> The Phantom of the Opera<br>";
                itemText += "<b>Runtime:</b> 2h 30m<br>";
                itemText += "<b>Categories:</b> Drama<br>";
                itemText += "<b>Venue:</b> Her Majesty's Theatre<br>";
                itemText += "<b>Age:</b> All Ages";
            } else if ("Show Schedule".equals(buttonName)) {
                // Add code to show schedule
                itemText += "Schedule " + i;
            } else if ("Book Ticket".equals(buttonName)) {
                // Add code to book tickets
                itemText += "Ticket " + i;
            }
            itemText += "</div>"; // End border, padding, and margin div
            itemText += "</html>"; // End HTML for multiline text
            listModel.addElement(itemText);
        }
    }

    private int getScreenWidth() {
        return Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    private int getScreenHeight() {
        return Toolkit.getDefaultToolkit().getScreenSize().height;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LondonMusicalTicket().setVisible(true);
            }
        });
    }
}
