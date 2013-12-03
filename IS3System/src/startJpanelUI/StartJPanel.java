/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package startJpanelUI;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import userInterface.IS3SystemUI;
import userInterface.MainPagePanel;

/**
 *
 * @author CeCeSOTI
 */
public class StartJPanel extends javax.swing.JPanel {

    private String param1;
    private String param2;
    private String country;
	
	
    private static ArrayList<String> keys = new ArrayList<String>();
    private HashMap <String, HashMap <String, String>> data = new HashMap <String, HashMap <String, String>>();
    private HashMap <String, String> item = new HashMap <String, String>();
    
    private IS3SystemUI parent;

    /**
     * Creates new form StartJPanel
     */
    public void accessFile() throws FileNotFoundException{
        FileReader reader = new FileReader(".\\WHO-data.csv");
        Scanner fScan = new Scanner(reader);
        keys = new  ArrayList<String> (Arrays.asList(fScan.nextLine().split("\\;")));
        String c;
        System.out.println(keys.toString());
        while(fScan.hasNextLine()){
            int i = 1;
            String line = fScan.nextLine();
            Scanner lScan = new Scanner(line);
            lScan.useDelimiter(";");
            item = new HashMap <String, String>();
            c = lScan.next();
            while(lScan.hasNext()){
                String value = lScan.next();
                item.put(keys.get(i), value);
                i++;
            }
            
            System.out.println(item.toString());
            data.put(c, item);
        }
        
    }
    public void putData(){
        Object [] theCountries = data.keySet().toArray();
        Arrays.sort(theCountries);
        for( Object o: theCountries )
            jComboBox3.addItem(o);
    }
    
    public void putParams(){
        Object [] parameters = keys.toArray(new String[keys.size()]);
        Arrays.sort(parameters);
        for(Object param: parameters){
            jComboBox1.addItem(param);
            jComboBox2.addItem(param);
        }
    }
    
    public StartJPanel(IS3SystemUI parent) throws FileNotFoundException {
        initComponents();
        accessFile();
        putData();
        putParams();
        this.parent = parent;
    }
	
	//get data
    public HashMap <String, HashMap <String, String>> getData(){
        return data;
    }
    
	//get parameter 1 as a string
    public String getParam1(){
        return param1;
    }
    
	//get parameter 2 as a string
    public String getParam2(){
        return param2;
    }

	//get country as a string
    public String getCountry(){
        return country;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(689, 545));
        setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/startJpanelUI/OlympicsImage.jpg"))); // NOI18N
        jLabel2.setOpaque(true);
        add(jLabel2);
        jLabel2.setBounds(220, 70, 240, 180);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Olympics Statistics");
        jLabel3.setOpaque(true);
        add(jLabel3);
        jLabel3.setBounds(220, 20, 240, 40);

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("First Parameter:");
        jLabel4.setOpaque(true);
        add(jLabel4);
        jLabel4.setBounds(120, 270, 190, 50);

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Second Parameter:");
        jLabel5.setOpaque(true);
        add(jLabel5);
        jLabel5.setBounds(360, 270, 190, 50);

        jComboBox1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        add(jComboBox1);
        jComboBox1.setBounds(120, 340, 190, 30);

        jComboBox2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        add(jComboBox2);
        jComboBox2.setBounds(360, 340, 190, 30);

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Choose a country:");
        jLabel6.setOpaque(true);
        add(jLabel6);
        jLabel6.setBounds(250, 390, 170, 50);

        jComboBox3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        add(jComboBox3);
        jComboBox3.setBounds(250, 460, 170, 40);

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jButton1.setText("Help");
        add(jButton1);
        jButton1.setBounds(20, 473, 110, 40);

        jButton2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jButton2.setText("Main page");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(543, 473, 120, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/startJpanelUI/TheWorld.jpg"))); // NOI18N
        jLabel1.setOpaque(true);
        add(jLabel1);
        jLabel1.setBounds(-6, -6, 690, 540);
    }// </editor-fold>//GEN-END:initComponents
	
	    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        param1 = (String) jComboBox1.getSelectedItem();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        String value = (String) jComboBox2.getSelectedItem();
        if(!param1.equals(value)){
            param2 = value;
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        country = (String) jComboBox3.getSelectedItem();
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MainPagePanel p = new MainPagePanel(parent);
        p.setBounds(0, 0, (int)p.getPreferredSize().getWidth(), (int)p.getPreferredSize().getHeight());
        p.setVisible(true);
        
        parent.getContentPane().removeAll();
        parent.validate();
        parent.repaint();
            
        parent.getContentPane().add(p);
        parent.pack();
        parent.validate();
        parent.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
