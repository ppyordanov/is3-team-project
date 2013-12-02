/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;
import javax.imageio.ImageIO;

/**
 *
 * @author DeCekoMon
 */
public class ScatterPlotPanel extends javax.swing.JPanel {

    public ArrayList<Point> selected;
    public HashMap<String, HashMap<String, String>> csvData;
    public String paramx, paramy, country, continent;
    public int maxSliderx, maxSlidery, minSliderx,minSlidery;
    /**
     * Creates new form ScatterPlotPanel
     */
    public ScatterPlotPanel() {
        selected = new ArrayList<Point>();
        maxSliderx = 100;
        maxSlidery = 100;
        minSliderx = 0;
        minSlidery = 0;
        csvData = new HashMap<String, HashMap<String, String>>();
        HashMap<String, String> bulgariaValue = new HashMap<String, String>();
        bulgariaValue.put("team size", "30");
        bulgariaValue.put("medals", "3");
        HashMap<String, String> chinaValue = new HashMap<String, String>();
        chinaValue.put("team size", "233");
        chinaValue.put("medals", "47");
        csvData.put("China", chinaValue);
        csvData.put("Bulgaria", bulgariaValue);
        
        initComponents();
    }

     public void paintComponent(Graphics g){    
         if(paramx.equals(""))
            paramx = "team size";
         if(paramy.equals(""))
            paramy = "medals";
         System.out.println("paramx is " + paramx + " and paramy is " + paramy);
         g.setColor(Color.green);
         double scalex = calculateScaleValue(paramx);
         double scaley = calculateScaleValue(paramy);
         for(Entry csvEntry : csvData.entrySet()){
 
             int xValue = Integer.parseInt(((HashMap<String,String>)csvEntry.getValue()).get(paramx));
             int yValue = Integer.parseInt(((HashMap<String,String>)csvEntry.getValue()).get(paramy));
             xValue*=scalex;
             scaley*=scaley;
             yValue = this.getSize().height - yValue;
             yValue -=5; 
             boolean ok = false;
             for(Point p : selected){
                 if(p.getX() == xValue && p.getY() == yValue){
                     if( p.getSelected() == 1 ){
                         System.out.println("ok we are here!");
                         g.setColor(Color.red);  
                     }
                      ok = true; break;
                 }
             }
             if(!ok)
                    selected.add(new Point(xValue, yValue));
    
             g.fillOval(xValue, yValue, 5, 5);
             g.setColor(Color.green);
             
         }

         
    }
     private double calculateScaleValue(String param){
         double scale = 0.0;
         int paramSum = 0;
         int size = 0;
        for(Entry csvEntry : csvData.entrySet()){
            paramSum += Integer.parseInt(((HashMap<String,String>)csvEntry.getValue()).get(param));
            size++;
        }
        scale = (double) (getSize().height/2) / (paramSum / size) ;
         return scale;
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

    public void printInFile(){
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        this.paint(g);
        try { 
            ImageIO.write(image, "png", new File(".//test.png"));
        } catch (IOException e) {}
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
     
     private class Point{
         int x,y,selected;
         public Point(){
             x = y = 0;
         }
         public Point(int x, int y){
             this.x = x;
             this.y = y;
             selected = 0;
         }
         public Point(int x, int y, int selected){
             this(x,y);
             this.selected = selected;
         }
         int getX(){
             return x;
         }
         int getY(){
             return y;
         }
         int getSelected(){
             return selected;
         }
         void setX(int x){
             this.x = x;
         }
         void setY(int y){
             this.y = y;
         }
         void setSelected(int selected){
             this.selected = selected;
         }
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        int evntX = evt.getX();
        int evntY = evt.getY();
        for(Point p : selected){
            if(Math.abs(evntX - p.getX()) <= 5 && 
               Math.abs(evntY - p.getY()) <= 5){
                if(p.getSelected() == 0)
                    p.setSelected(1);
                else
                    p.setSelected(0);
                break;
            }
        }
        
    }//GEN-LAST:event_formMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
