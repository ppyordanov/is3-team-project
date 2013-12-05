/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;
import javax.imageio.ImageIO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DeCekoMon
 */
public class ScatterPlotPanel extends javax.swing.JPanel {

    private ArrayList<Point> selected;
    private HashMap<String, HashMap<String, String>> csvData;
    private String paramx, paramy, country;
    private int maxSliderx, maxSlidery, minSliderx,minSlidery;
    private JTable details;
    
    /**
     * Creates new form ScatterPlotPanel
     */
    public ScatterPlotPanel(String px, String py, String country, HashMap<String, HashMap<String, String>> data, JTable details) {
        initComponents();
        
        selected = new ArrayList<Point>();
        paramx = px;
        paramy = py;
        this.country = country;
        maxSliderx = 100;
        maxSlidery = 100;
        minSliderx = 0;
        minSlidery = 0;
        
        csvData = data;
        this.details = details;
    }

     public void paintComponent(Graphics g){   
         g.clearRect(0, 0, getSize().width, getSize().height);
         if(paramx.equals(""))
            paramx = "TeamSize";
         if(paramy.equals(""))
            paramy = "Bronze";
         g.setColor(Color.green);

         double scalex = calculateScaleValue(paramx);
         double scaley = calculateScaleValue(paramy);
         drawGraphLines(g , scalex, scaley);
         for(Entry csvEntry : csvData.entrySet()){
             String tempX = ((HashMap<String,String>)csvEntry.getValue()).get(paramx);
             String tempY = ((HashMap<String,String>)csvEntry.getValue()).get(paramy);
             int xValue = -1;
             int yValue = -1;
             

                xValue = (int) getStringAsDouble(tempX);

                yValue = (int) getStringAsDouble(tempY);

             // System.out.println("Paramx is " + xValue + "  and paramy is " + yValue);
              if(xValue < 0 || yValue < 0)
                  continue;
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
                       if( p.getSelected() == 1){
                            g.setColor(Color.red);  
                       }
                        ok = true; break;
                  }
                }
             
             if(!ok)
                    selected.add(new Point(xValue, yValue, (String)csvEntry.getKey()));
    
             g.fillOval(xValue, yValue, 5, 5);
           
             
         }

         
    }
    private void drawGraphLines(Graphics g, double scalex, double scaley){
        g.setColor(Color.BLACK);
        for(int i = 5; i < 300; i+=30){
            double scaleValuex = (double) i / scalex;
            double scaleValuey = (double) i / scaley;
            
            int scaleNumx = (int) scaleValuex;
            int scaleNumy = (int) scaleValuey;
            
            String scaleStringx = "";
            String scaleStringy = "";
            
            if(scaleNumx > 1000000){
                scaleNumx /= 1000000;
                scaleStringx = Integer.toString(scaleNumx);
                scaleStringx+="M";
            }
            else scaleStringx = Integer.toString(scaleNumx);
             g.drawString(scaleStringx, i, getSize().height - 5);
             
                         
            if(scaleNumy > 1000000){
                scaleNumy /= 1000000;
                scaleStringy = Integer.toString(scaleNumy);
                scaleStringy+="M";
            }
             else scaleStringy = Integer.toString(scaleNumy);
            g.drawString(scaleStringy, 5, getSize().height - i);
        }
        g.drawLine(0, getSize().height/2, getSize().width, getSize().height/2);
        g.drawLine(getSize().width/2, 0, getSize().width/2, getSize().height);
       
    }
     private double getStringAsDouble(String temp){
         double result = -1.0;
         if(temp != null && !temp.equals("") && temp.length() < 10 && !temp.contains("E")){
                temp = temp.replaceFirst(",", ".");
                temp = temp.replaceAll(",", "");
                result = Double.parseDouble(temp);
         }
         return result;
         
     }
     
     
     private double calculateScaleValue(String param){
         double scale = 0.0;
         int paramMax = 0;
         int size = 0;
        for(Entry csvEntry : csvData.entrySet()){
            String temp = ((HashMap<String,String>)csvEntry.getValue()).get(param);

                double curParamDouble = getStringAsDouble(temp);
                if(curParamDouble < 0) 
                    continue;
                int curParamVal = (int) curParamDouble; 
                paramMax = Math.max(paramMax, curParamVal);
                size++; 
            
        }
        scale =(double) getSize().height / paramMax ;
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

    public boolean printInFile(String xAxis, String yAxis){
        plotInfoLabel.setText("Olympics statistics, X axis: " + xAxis + ", Y axis: " + yAxis);
        
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        this.paint(g);
        
        try { 
            ImageIO.write(image, "png", new File(".//test.png"));
        } catch (IOException e) { return false; }
        
        plotInfoLabel.setText("");
        
        return true;
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
     
     private class Point{
         int x,y,selected;
         String name;
         
         public Point(){
             x = y = 0;
         }
         public Point(int x, int y, String name){
             this.x = x;
             this.y = y;
             this.name = name;
             selected = 0;
         }
         public Point(int x, int y, int selected, String name){
             this(x,y, name);
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

        plotInfoLabel = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        setForeground(new java.awt.Color(204, 204, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        plotInfoLabel.setBackground(new java.awt.Color(255, 255, 255));
        plotInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        plotInfoLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plotInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plotInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        int evntX = evt.getX();
        int evntY = evt.getY();
        for(Point p : selected){
            if(Math.abs(evntX - p.getX()) <= 7 && 
               Math.abs(evntY - p.getY()) <= 7){
                if(p.getSelected() == 0){
                    p.setSelected(1);
                    
                    DefaultTableModel model = (DefaultTableModel) details.getModel();
                    
                    HashMap<String, String> items = (HashMap<String, String>)csvData.get(p.name);
                    Object []row = new Object[items.size()+1];
                    int i = 0;
                    
                    row[i] = p.name;
                    for(Entry item: items.entrySet()){
                        i++;
                        String curItem = (String)item.getValue();
                        row[i] = curItem;
                    }
                    
                    model.addRow(row);
                }
                else
                    p.setSelected(0);
                break;
            }
           
        }
         this.repaint();
        
    }//GEN-LAST:event_formMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel plotInfoLabel;
    // End of variables declaration//GEN-END:variables
}
