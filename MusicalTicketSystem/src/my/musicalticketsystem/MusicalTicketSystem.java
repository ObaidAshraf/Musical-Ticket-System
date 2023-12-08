/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my.musicalticketsystem;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ubaid
 */
public class MusicalTicketSystem extends javax.swing.JFrame {

    /**
     * Creates new form MusicalTicketSystem
     */
    
    HashMap<String, ArrayList<String[]>> shows = new HashMap<String, ArrayList<String[]>>();
    HashMap<String, ArrayList<String[]>> slots = new HashMap<String, ArrayList<String[]>>();
    HashMap<String, ArrayList<String[]>> ticketsReserved = new HashMap<String, ArrayList<String[]>>();
//    HashMap<String, String[]> price = new HashMap<String, String[]>();
    
    public MusicalTicketSystem() {
        initComponents();
        
        init_gui();
        
        populate_data();
        
     }
    
    
    private void init_gui() {
        // Add initialization of fields here
        ticketCombobox.removeAllItems();
        ticketCombobox.addItem("Adult");
        ticketCombobox.addItem("Senior");
        ticketCombobox.addItem("Student");
        
        showsCombobox.removeAllItems();
        dateCombobox.removeAllItems();
        
        seatCombobox.removeAllItems();
        String[] rows = {"A", "B", "C"};
        
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= 10; j++) {
                seatCombobox.addItem(rows[i] + Integer.toString(j));
            }
        }
        
        set_components_state(false);
    }
    
    private void set_components_state(boolean  state) {
        bookTicketBtn.setEnabled(state);
        cancelTicketBtn.setEnabled(state);
        printReceiptBtn.setEnabled(state);
        showsCombobox.setEnabled(state);
        dateCombobox.setEnabled(state);
        slotCombobox.setEnabled(state);
        ticketCombobox.setEnabled(state);
        seatCombobox.setEnabled(state);
        filterBtn.setEnabled(state);
    }
    
    private void populate_list() {
        int row = 0;
        for (String i : shows.keySet()) {
            ((DefaultTableModel)showsTable.getModel()).addRow(new Object[] {i});
            row++;
        }
    }    

    private void populate_shows() {
        ArrayList<String[]> list = new ArrayList<String[]>();
        String[] data;
        int row = 0;
        showsCombobox.removeAllItems();
        for (String i : shows.keySet()) {
          showsCombobox.addItem(i);
          list = shows.get(i);
          for(int k = 0; k < list.size(); k++) {
            data = list.get(k);
            ((DefaultTableModel)showsTable.getModel()).addRow(new Object[] {data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]});
            row++;
          }
        }
    }
    
    private void print_receipt() {
        ArrayList<String[]> list = new ArrayList<String[]>();
        String[] data;
        for (String i : ticketsReserved.keySet()) {
          list = ticketsReserved.get(i);
          for(int k = 0; k < list.size(); k++) {
            data = list.get(k);
            for (int j = 0; j < data.length; j++)
                System.out.println(data[j]);
          }
        }
    }
    
    private void update_total_tickets() {
        ArrayList<String[]> list = new ArrayList<String[]>();
        String[] data;
        int total_tickets = 0;
        for (String i : ticketsReserved.keySet()) {
          list = ticketsReserved.get(i);
          total_tickets += list.size();
        }
        
        totalTicketsCount.setText(Integer.toString(total_tickets));
    }
    
    private void populate_slots() {
        String d = (String)dateCombobox.getSelectedItem();
        String m = (String)showsCombobox.getSelectedItem();
        ArrayList<String[]> list = shows.get(m);
        slotCombobox.removeAllItems();
        if (list == null)
            return;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[1].equals(d))
                slotCombobox.addItem(list.get(i)[6]);
        }
    }
    
    private void populate_dates() {
        String k = (String)showsCombobox.getSelectedItem();
        ArrayList<String[]> list = shows.get(k);
        if (list == null)
            return;
        dateCombobox.removeAllItems();
        for (int i = 0; i < list.size(); i++) {
            if (((DefaultComboBoxModel)dateCombobox.getModel()).getIndexOf(list.get(i)[1]) < 0)
                dateCombobox.addItem(list.get(i)[1]);
        }
    }
    
    private void filter_shows() {
        boolean found = false;
        int rowsRemoved = 0;
        ArrayList<Integer> rowsToRemove = new ArrayList<>();
        String d = filterTextBox.getText();
        String v;
        HashMap<String, ArrayList<String[]>> showsLocal = new HashMap<String, ArrayList<String[]>>();
        DefaultTableModel dtm = (DefaultTableModel)showsTable.getModel();
        for (int r = 0; r < dtm.getRowCount(); r++) {
            for (int c = 0; c < dtm.getColumnCount(); c++) {
                  v = (String)dtm.getValueAt(r, c);
                  if (v.contains(d)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                rowsToRemove.add(r);
            }
            found = false;
        }
        
        for (int r = 0; r < rowsToRemove.size(); r++) {
            dtm.removeRow(rowsToRemove.get(r)-rowsRemoved);
            rowsRemoved++;
        }
    }
    
    private void populate_data() {
        
        ArrayList<String[]> list = new ArrayList<String[]>();
        String[] data = {"ABBA Voyage", "12/9/2023", "1 hour 30 minutes", "Entertainment", "6+", "ABBA Venue", "07:45 PM", "171"};
        list.add(data);
        data = new String[] {"ABBA Voyage", "12/10/2023", "1 hour 30 minutes", "Entertainment", "6+", "ABBA Venue", "01:00 PM", "158"};
        list.add(data);
        data = new String[] {"ABBA Voyage", "12/10/2023", "1 hour 30 minutes", "Entertainment", "6+", "ABBA Venue", "06:00 PM", "126"};
        list.add(data);
        data = new String[] {"ABBA Voyage", "12/11/2023", "1 hour 30 minutes", "Entertainment", "6+", "ABBA Venue", "07:45 PM", "96"};
        list.add(data);
        shows.put("ABBA Voyage", list);

        list = new ArrayList<String[]>();        
        data = new String[] { "Mamma Mia", "12/7/2023", "2 hours 35 mins", "Family & Kids", "5+", "Novello Theatre", "03:00 PM", "38" };
        list.add(data);
        data = new String[] { "Mamma Mia", "12/7/2023", "2 hours 35 mins", "Family & Kids", "5+", "Novello Theatre", "07:30 PM", "62" };
        list.add(data);
        data = new String[] { "Mamma Mia", "12/8/2023", "2 hours 35 mins", "Family & Kids", "5+", "Novello Theatre", "07:30 PM", "44" };
        list.add(data);
        data = new String[] { "Mamma Mia", "12/9/2023", "2 hours 35 mins", "Family & Kids", "5+", "Novello Theatre", "07:30 PM", "75" };
        list.add(data);
        shows.put("Mamma Mia", list);
        
        list = new ArrayList<String[]>();        
        data = new String[] { "The Lion King", "12/7/2023", "2 hours 30 mins", "Family & Kids", "6+", "Lyceum Theatre", "07:30 PM", "48" };
        list.add(data);
        data = new String[] { "The Lion King", "12/8/2023", "2 hours 30 mins", "Family & Kids", "6+", "Lyceum Theatre", "07:30 PM", "70" };
        list.add(data);
        data = new String[] { "The Lion King", "12/9/2023", "2 hours 30 mins", "Family & Kids", "6+", "Lyceum Theatre", "02:30 PM", "48" };
        list.add(data);
        data = new String[] { "The Lion King", "12/9/2023", "2 hours 30 mins", "Family & Kids", "6+", "Lyceum Theatre", "07:30 PM", "82" };
        list.add(data);
        shows.put("The Lion King", list);
    }

    private void book_ticket() {
        
        ArrayList<String[]> list = new ArrayList<String[]>();
        String[] data;
        
        String cName = customerName.getText();
        String cEmail = customerEmail.getText();
        String showName = (String)showsCombobox.getSelectedItem();
        String showDate = (String)dateCombobox.getSelectedItem();
        String showSlot = (String)slotCombobox.getSelectedItem();
        String showTicket = (String)ticketCombobox.getSelectedItem();
        String showSeat = (String)seatCombobox.getSelectedItem();
     
        data = new String[] {cName, cEmail, showName, showDate, showSlot, showTicket, showSeat};
        list = ticketsReserved.get(cName);
        if (list == null) {
            list = new ArrayList<String[]>();
        }
        list.add(data);
        ticketsReserved.put(cName, list);
        
        update_total_tickets();
    }
    
    
    private void cancel_ticket() {
        
        ArrayList<String[]> list = new ArrayList<String[]>();
        
        String cName = customerName.getText();

        list = ticketsReserved.get(cName);
        if (list == null || list.isEmpty()) {
            return;
        }

        list.remove(0);
        
        update_total_tickets();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ticketPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        customerName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        customerEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        showsCombobox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        dateCombobox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        slotCombobox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        ticketCombobox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        seatCombobox = new javax.swing.JComboBox<>();
        bookTicketBtn = new javax.swing.JButton();
        printReceiptBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        cancelTicketBtn = new javax.swing.JButton();
        labelTotalTickets = new javax.swing.JLabel();
        totalTicketsCount = new javax.swing.JLabel();
        musicalPanel = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        filterTextBox = new javax.swing.JTextField();
        filterBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        showsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("London Musical Ticket System");
        setMinimumSize(new java.awt.Dimension(975, 382));

        ticketPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)), "Book Tickets"));

        jLabel1.setText("Customer Name");

        customerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Customer Email");

        customerEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerEmailActionPerformed(evt);
            }
        });

        jLabel3.setText("Select Show");

        showsCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        showsCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showsComboboxActionPerformed(evt);
            }
        });

        jLabel4.setText("Select date");

        dateCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        dateCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateComboboxActionPerformed(evt);
            }
        });

        jLabel5.setText("Select slot");

        slotCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        slotCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slotComboboxActionPerformed(evt);
            }
        });

        jLabel6.setText("Ticket");

        ticketCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Select Seat");

        seatCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bookTicketBtn.setText("Book Ticket");
        bookTicketBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTicketBtnActionPerformed(evt);
            }
        });

        printReceiptBtn.setText("Print receipt");
        printReceiptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printReceiptBtnActionPerformed(evt);
            }
        });

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        cancelTicketBtn.setText("Cancel Ticket");
        cancelTicketBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelTicketBtnActionPerformed(evt);
            }
        });

        labelTotalTickets.setText("Tickets Reserved");

        totalTicketsCount.setText("0");

        javax.swing.GroupLayout ticketPanelLayout = new javax.swing.GroupLayout(ticketPanel);
        ticketPanel.setLayout(ticketPanelLayout);
        ticketPanelLayout.setHorizontalGroup(
            ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ticketPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ticketPanelLayout.createSequentialGroup()
                        .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(labelTotalTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerName)
                            .addComponent(customerEmail)
                            .addComponent(showsCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(slotCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ticketCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(seatCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalTicketsCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(ticketPanelLayout.createSequentialGroup()
                        .addComponent(bookTicketBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelTicketBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(printReceiptBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 12, Short.MAX_VALUE))))
        );
        ticketPanelLayout.setVerticalGroup(
            ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ticketPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(customerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(showsCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(slotCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ticketCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(seatCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotalTickets)
                    .addComponent(totalTicketsCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookTicketBtn)
                    .addComponent(cancelTicketBtn)
                    .addComponent(printReceiptBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitBtn)
                .addGap(20, 20, 20))
        );

        musicalPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)), "Musical Shows"));

        jButton5.setText("Musical List");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Show Schedule");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel8.setText("Search");

        filterBtn.setText("Filter");
        filterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBtnActionPerformed(evt);
            }
        });

        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel();
        showsTable.setModel(tableModel);
        showsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date", "Run Time", "Category", "Age Limit", "Venue", "Slot", "Price (\u00A3)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(showsTable);

        javax.swing.GroupLayout musicalPanelLayout = new javax.swing.GroupLayout(musicalPanel);
        musicalPanel.setLayout(musicalPanelLayout);
        musicalPanelLayout.setHorizontalGroup(
            musicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musicalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(musicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(musicalPanelLayout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        musicalPanelLayout.setVerticalGroup(
            musicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musicalPanelLayout.createSequentialGroup()
                .addGroup(musicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jLabel8)
                    .addComponent(filterTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ticketPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(musicalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticketPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(musicalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customerEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerEmailActionPerformed

    private void showsComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showsComboboxActionPerformed
        populate_dates();
    }//GEN-LAST:event_showsComboboxActionPerformed

    private void bookTicketBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTicketBtnActionPerformed
        book_ticket();
    }//GEN-LAST:event_bookTicketBtnActionPerformed

    private void customerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void slotComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slotComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_slotComboboxActionPerformed

    private void dateComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateComboboxActionPerformed
      populate_slots();
    }//GEN-LAST:event_dateComboboxActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ((DefaultTableModel)showsTable.getModel()).setRowCount(0);
        populate_list();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ((DefaultTableModel)showsTable.getModel()).setRowCount(0);
        populate_shows();
        set_components_state(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void filterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBtnActionPerformed
        filter_shows();
    }//GEN-LAST:event_filterBtnActionPerformed

    private void printReceiptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printReceiptBtnActionPerformed
        print_receipt();
    }//GEN-LAST:event_printReceiptBtnActionPerformed

    private void cancelTicketBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelTicketBtnActionPerformed
        cancel_ticket();
    }//GEN-LAST:event_cancelTicketBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MusicalTicketSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MusicalTicketSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MusicalTicketSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MusicalTicketSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MusicalTicketSystem().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookTicketBtn;
    private javax.swing.JButton cancelTicketBtn;
    private javax.swing.JTextField customerEmail;
    private javax.swing.JTextField customerName;
    private javax.swing.JComboBox<String> dateCombobox;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton filterBtn;
    private javax.swing.JTextField filterTextBox;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTotalTickets;
    private javax.swing.JPanel musicalPanel;
    private javax.swing.JButton printReceiptBtn;
    private javax.swing.JComboBox<String> seatCombobox;
    private javax.swing.JComboBox<String> showsCombobox;
    private javax.swing.JTable showsTable;
    private javax.swing.JComboBox<String> slotCombobox;
    private javax.swing.JComboBox<String> ticketCombobox;
    private javax.swing.JPanel ticketPanel;
    private javax.swing.JLabel totalTicketsCount;
    // End of variables declaration//GEN-END:variables
}
