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
        HashMap<String, String> USAValue = new HashMap<String, String>();
        USAValue.put("team size", "200");
        USAValue.put("medals", "43");
        csvData.put("China", chinaValue);
        csvData.put("Bulgaria", bulgariaValue);
        csvData.put("USA", USAValue);
        
        initComponents();
    }

     public void paintComponent(Graphics g){   
         g.clearRect(0, 0, getSize().width, getSize().height);
         if(paramx.equals(""))
            paramx = "team size";
         if(paramy.equals(""))
            paramy = "medals";
         System.out.println("miny  " + minSlidery + " and maxy " + maxSlidery);
         g.setColor(Color.green);
         double scalex = calculateScaleValue(paramx);
         double scaley = calculateScaleValue(paramy);
         for(Entry csvEntry : csvData.entrySet()){
 
             int xValue = Integer.parseInt(((HashMap<String,String>)csvEntry.getValue()).get(paramx));
             int yValue = Integer.parseInt(((HashMap<String,String>)csvEntry.getValue()).get(paramy));
             xValue*=scalex;
             yValue*=scaley;
             yValue = getSize().height - yValue;
             yValue -=5; 
             boolean ok = false;
             g.setColor(Color.green);
             if(xValue > maxSliderx*3 || xValue < minSliderx*3 || yValue <getSize().height - maxSlidery*3 || yValue > getSize().width- minSlidery*3){
                     g.setColor(Color.red);
                }
             else
                for(Point p : selected){

                  if(p.getX() == xValue && p.getY() == yValue){
                        System.out.println(p.getX()  + "   "  + p.getY());
                       if( p.getSelected() == 1){
                            g.setColor(Color.red);  
                       }
                        ok = true; break;
                  }
                }
             
             if(!ok)
                    selected.add(new Point(xValue, yValue));
    
             g.fillOval(xValue, yValue, 5, 5);
           
             
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
         this.repaint();
     }
     public void setParamy(String py){
         paramy = py;
         this.repaint();
     }
     public void setCountry(String ctry){
         country = ctry;
         this.repaint();
     }
     public void setMaxSliderX(int maxX){
         maxSliderx = maxX;
         this.repaint();
     }
     public void setMaxSliderY(int maxY){
         maxSlidery = maxY;
         this.repaint();
     }
     public void setMinSliderX(int minX){
         minSliderx = minX;
         this.repaint();
     }
     public void setMinSliderY(int minY){
         minSlidery = minY;
         this.repaint();
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
            if(Math.abs(evntX - p.getX()) <= 7 && 
               Math.abs(evntY - p.getY()) <= 7){
                if(p.getSelected() == 0)
                    p.setSelected(1);
                else
                    p.setSelected(0);
                break;
            }
           
        }
         this.repaint();
        
    }//GEN-LAST:event_formMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
