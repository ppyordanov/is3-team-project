/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author DeCekoMon
 */
public class ScatterPlotPanel extends javax.swing.JPanel {

    
    public HashMap<String, HashMap<String, ArrayList<String>>> csvData;
    public String paramx, paramy, country, continent;
    /**
     * Creates new form ScatterPlotPanel
     */
    public ScatterPlotPanel() {
        
        initComponents();
    }

     public void paintComponent(Graphics g){
        
        
    }
     public void setParamx(String px){
         paramx = px;
     }
     public void setParamy(String py){
         paramy = py;
     }
     public void setCountry(String ctry){
         country = ctry;
     }
     public void setContinent(String cntnt){
         continent = cntnt;
     }
     
     public String getParamx(){
         return paramx;
     }
     public String getParamy(){
         return paramy;
     }
     public String getCountry(){
         return country;
     }
     public String getContinent(){
         return continent;
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
