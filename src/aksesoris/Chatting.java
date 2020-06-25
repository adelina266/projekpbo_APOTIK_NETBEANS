/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aksesoris;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;


public class Chatting extends javax.swing.JFrame implements Runnable{
    Socket client;
    ServerSocket server;
    BufferedReader Server_Reader, Client_BefferedReader;
    BufferedWriter Server_Writer, Client_Writer;

    /**
     * Creates new form Chatting
     */
    
    public Chatting() {
        super(""); //SetTitle
        initComponents();
        //Menampilkan hasil ditengah window
          this.setLocationRelativeTo(null);
    }
    
    private void getReadConnec(){
        try {
            try {
                try {
                    server = new ServerSocket(2000);
                    this.setTitle("Please Wait...");
                } catch (IOException ex) {
                    System.out.println("Could not listen");
                    System.exit(-1);
                }
                client = server.accept();
                this.setTitle("Connected" + client.getInetAddress());
            } catch (IOException ex) {
                System.out.println("Accept Failed");
                System.exit(-1);
            }

            Server_Reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            Server_Writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException ex) {
            System.out.println("Read Failed");
            System.exit(-1);
        }

    }
    
     private void getStoppedServer() {
        try {
            Server_Reader.close();
            Server_Writer.close();
            ButtonOn.setText("ON");
            this.setTitle("Disconnected");
        } catch (IOException ex) {
            //Logger.getLogger(Chats.class.getName()).log(Level.SEVERE, null, ex);
             
        }
    }
     
     public void getButtonOn(){
        if (ButtonOn.getText().equals("ON")) {
            ButtonOn.setText("OFF");
            getReadConnec();
            Thread thread = new Thread(this);
            thread.start();
        } else if (ButtonOn.getText().equals("OFF")) {
            getStoppedServer();
        }
    }
     
    public void getSend(){
         try {
            Server_Writer.write(Username.getText() + ": " + TextChat.getText());
            Server_Writer.newLine();
            Server_Writer.flush();
        } catch (IOException ex) {
            //Logger.getLogger(Chats.class.getName()).log(Level.SEVERE, null, ex);
        }
        ListChat.add("Server : " + TextChat.getText());
        TextChat.setText("");
    }
     
    
    
    //Background color
    public void getBackgroundColor(){
        Color c = JColorChooser.showDialog(null,"Background Color",jPanel.getBackground());
        jPanel.setBackground(c);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dialog = new javax.swing.JDialog();
        ColorChooser = new javax.swing.JColorChooser();
        jPanel = new javax.swing.JPanel();
        ButtonOn = new javax.swing.JButton();
        Send = new javax.swing.JToggleButton();
        JUsername = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        TextChat = new java.awt.TextArea();
        ListChat = new java.awt.List();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        BackgroundColor = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();

        javax.swing.GroupLayout DialogLayout = new javax.swing.GroupLayout(Dialog.getContentPane());
        Dialog.getContentPane().setLayout(DialogLayout);
        DialogLayout.setHorizontalGroup(
            DialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DialogLayout.setVerticalGroup(
            DialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        jPanel.setBackground(new java.awt.Color(204, 0, 204));

        ButtonOn.setText("ON");
        ButtonOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOnActionPerformed(evt);
            }
        });

        Send.setText("SEND");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });

        JUsername.setForeground(new java.awt.Color(255, 255, 255));
        JUsername.setText("Username");

        Username.setText("Server");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(JUsername)
                        .addGap(18, 18, 18)
                        .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonOn, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                    .addComponent(ListChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(TextChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Send, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JUsername)
                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonOn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ListChat, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextChat, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        File.setText("File");

        BackgroundColor.setText("Background Color");
        BackgroundColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackgroundColorActionPerformed(evt);
            }
        });
        File.add(BackgroundColor);

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        File.add(Exit);

        jMenuBar1.add(File);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendActionPerformed
        getSend();// TODO add your handling code here:
    }//GEN-LAST:event_SendActionPerformed

    private void ButtonOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOnActionPerformed
       getButtonOn();
    }//GEN-LAST:event_ButtonOnActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_ExitActionPerformed

    private void BackgroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackgroundColorActionPerformed
        getBackgroundColor();// TODO add your handling code here:
    }//GEN-LAST:event_BackgroundColorActionPerformed
     
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
            java.util.logging.Logger.getLogger(Chatting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chatting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chatting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chatting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chatting().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BackgroundColor;
    private javax.swing.JButton ButtonOn;
    private javax.swing.JColorChooser ColorChooser;
    private javax.swing.JDialog Dialog;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu File;
    private javax.swing.JLabel JUsername;
    private java.awt.List ListChat;
    private javax.swing.JToggleButton Send;
    private java.awt.TextArea TextChat;
    private javax.swing.JTextField Username;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
       while (true) {
                    try {
                        ListChat.add(Server_Reader.readLine());
                    } catch (IOException ex) {
                        //Logger.getLogger(Chats.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
    }
}