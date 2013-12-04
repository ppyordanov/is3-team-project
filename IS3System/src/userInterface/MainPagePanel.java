/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import helppage.HelpPage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author Samsung
 */
public class MainPagePanel extends javax.swing.JPanel implements ActionListener{

    private IS3SystemUI parent;
    private JPanel previous;
    private String paramx, paramy, country, continent;
    private ScatterPlotPanel scatterPlotPanel;
    
    public MainPagePanel(String paramx, String paramy, String country, String continent, HashMap<String, HashMap<String, String>> data) throws IOException{
        initComponents();
        
        this.paramx = paramx;
        this.paramy = paramy;
        this.country = country;
        this.continent = continent;
        
        BufferedImage im = ImageIO.read(new File("TheWorld.jpg"));
        BackgroundPanel bg = new BackgroundPanel(im,0);
        bg.setSize((int)this.getPreferredSize().getWidth(), (int)this.getPreferredSize().getHeight());
        bg.setLocation(0, 0);
        bg.setVisible(true);
        
        //creating new scatterPlotPanel
        scatterPlotPanel = new ScatterPlotPanel(this.paramx, this.paramy, this.country, data);
        scatterPlotPanel.setSize(300, 300);
        scatterPlotPanel.setLocation(150,105);
        scatterPlotPanel.setVisible(true);

        this.add(scatterPlotPanel);
        this.add(bg);
        drawScatterPlot();
        
	xAxisOption.addActionListener(this);
        yAxisOption.addActionListener(this);
        continentBox.addActionListener(this);
        savePlotButton.addActionListener(this);
        clearButton.addActionListener(this);
        helpButton.addActionListener(this);
        backButton.addActionListener(this);
    }
    
     /**
     * Creates new form MainPagePanel
     */
    public MainPagePanel(IS3SystemUI myParent, JPanel prev, String px, String py, String country, HashMap<String, HashMap<String, String>> data) throws IOException {
        this(px, py, country, "", data);
        xAxisOption.setSelectedItem((Object)px);
        yAxisOption.setSelectedItem((Object)py);
        this.parent = myParent;
        this.previous = prev;
    }
    
    private void drawScatterPlot(){
      scatterPlotPanel.setParamx(paramx);
      scatterPlotPanel.setParamy(paramy);
      scatterPlotPanel.setContinent(continent);
      scatterPlotPanel.setCountry(country);
      scatterPlotPanel.updateUI();
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if( e.getSource().equals(savePlotButton) ){
            boolean isPrinted = scatterPlotPanel.printInFile(this.paramx, this.paramy);
            
            if(isPrinted)
                printDoneLabel.setText("Exported plot successfully");
        }
        else if(e.getSource().equals(clearButton)){
            minX_Slider.setValue(0);
            minY_Slider.setValue(0);
            maxX_Slider.setValue(0);
            maxY_Slider.setValue(0);
            scatterPlotPanel.updateUI();
        }
        else if(e.getSource().equals(helpButton)){
            HelpPage h = null;
            try {
                h = new HelpPage(parent,this);
            } catch (IOException ex) {
                Logger.getLogger(MainPagePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            h.setBounds(0, 0, (int)h.getPreferredSize().getWidth(), (int)h.getPreferredSize().getHeight());
            h.setVisible(true);
            
            parent.getContentPane().removeAll();
            parent.validate();
            parent.repaint();
            
            parent.getContentPane().add(h);
            parent.pack();
            parent.validate();
            parent.repaint();
        }
        else if(e.getSource().equals(backButton)){
            previous.setBounds(0, 0, (int)previous.getPreferredSize().getWidth(), (int)previous.getPreferredSize().getHeight());
            previous.setVisible(true);
            
            parent.getContentPane().removeAll();
            parent.validate();
            parent.repaint();
            
            parent.getContentPane().add(previous);
            parent.pack();
            parent.validate();
            parent.repaint(); 
        }
        else{
            JComboBox cb = (JComboBox)e.getSource();
            String selectedItem = (String)cb.getSelectedItem();

            if( cb.equals(xAxisOption) ){
                this.paramx = selectedItem;
                scatterPlotPanel.setParamx(paramx);
            }
            else if(cb.equals(yAxisOption)){
                this.paramy = selectedItem;
                scatterPlotPanel.setParamy(paramy);
            }
            else if(cb.equals(continentBox)){
                this.continent = selectedItem;
                scatterPlotPanel.setContinent(continent);
            }
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

        backButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        xAxisPanel = new javax.swing.JPanel();
        minX_Slider = new javax.swing.JSlider();
        maxX_Slider = new javax.swing.JSlider();
        minLabelX = new javax.swing.JLabel();
        maxLabelX = new javax.swing.JLabel();
        yAxisPanel = new javax.swing.JPanel();
        maxY_Slider = new javax.swing.JSlider();
        minY_Slider = new javax.swing.JSlider();
        yAxisOption = new javax.swing.JComboBox();
        yAxisLabel = new javax.swing.JLabel();
        xAxisOption = new javax.swing.JComboBox();
        xAxisLabel = new javax.swing.JLabel();
        detailsLabel = new javax.swing.JLabel();
        minLabelY = new javax.swing.JLabel();
        maxLabelY = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        countryTextBox = new javax.swing.JTextField();
        countryLabel = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        savePlotButton = new javax.swing.JButton();
        continentLabel = new javax.swing.JLabel();
        continentBox = new javax.swing.JComboBox();
        printDoneLabel = new javax.swing.JLabel();

        setAutoscrolls(true);

        backButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backButton.setText("Go Back");

        helpButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        helpButton.setText("Help");

        titleLabel.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        titleLabel.setText("Olympics Statistics");

        minX_Slider.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        minX_Slider.setMajorTickSpacing(10);
        minX_Slider.setMinorTickSpacing(5);
        minX_Slider.setPaintLabels(true);
        minX_Slider.setPaintTicks(true);
        minX_Slider.setSnapToTicks(true);
        minX_Slider.setValue(0);
        minX_Slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                minX_SliderStateChanged(evt);
            }
        });

        maxX_Slider.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        maxX_Slider.setMajorTickSpacing(10);
        maxX_Slider.setMinorTickSpacing(5);
        maxX_Slider.setPaintLabels(true);
        maxX_Slider.setPaintTicks(true);
        maxX_Slider.setSnapToTicks(true);
        maxX_Slider.setValue(0);
        maxX_Slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                maxX_SliderStateChanged(evt);
            }
        });

        minLabelX.setText("Min");

        maxLabelX.setText("Max");

        javax.swing.GroupLayout xAxisPanelLayout = new javax.swing.GroupLayout(xAxisPanel);
        xAxisPanel.setLayout(xAxisPanelLayout);
        xAxisPanelLayout.setHorizontalGroup(
            xAxisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xAxisPanelLayout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(xAxisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, xAxisPanelLayout.createSequentialGroup()
                        .addComponent(maxLabelX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maxX_Slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, xAxisPanelLayout.createSequentialGroup()
                        .addComponent(minLabelX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minX_Slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        xAxisPanelLayout.setVerticalGroup(
            xAxisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, xAxisPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(xAxisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxX_Slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxLabelX))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(xAxisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minX_Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(minLabelX)))
        );

        maxY_Slider.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        maxY_Slider.setForeground(new java.awt.Color(0, 0, 0));
        maxY_Slider.setMajorTickSpacing(10);
        maxY_Slider.setMinorTickSpacing(5);
        maxY_Slider.setOrientation(javax.swing.JSlider.VERTICAL);
        maxY_Slider.setPaintLabels(true);
        maxY_Slider.setPaintTicks(true);
        maxY_Slider.setToolTipText("");
        maxY_Slider.setValue(0);
        maxY_Slider.setName(""); // NOI18N
        maxY_Slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                maxY_SliderStateChanged(evt);
            }
        });

        minY_Slider.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        minY_Slider.setMajorTickSpacing(10);
        minY_Slider.setMinorTickSpacing(5);
        minY_Slider.setOrientation(javax.swing.JSlider.VERTICAL);
        minY_Slider.setPaintLabels(true);
        minY_Slider.setPaintTicks(true);
        minY_Slider.setValue(0);
        minY_Slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                minY_SliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout yAxisPanelLayout = new javax.swing.GroupLayout(yAxisPanel);
        yAxisPanel.setLayout(yAxisPanelLayout);
        yAxisPanelLayout.setHorizontalGroup(
            yAxisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yAxisPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(maxY_Slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minY_Slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(508, 508, 508))
        );
        yAxisPanelLayout.setVerticalGroup(
            yAxisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yAxisPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(yAxisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minY_Slider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxY_Slider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122))
        );

        yAxisOption.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TeamSize", "Bronze", "Silver", "Gold", "pop2010", "GDP2011", "F2012", "M2012", "Population median age (years)", "Healthy life expectancy (HALE) at birth (years) both sexes", "Health_expenditure_public_pct_of_GDP", "Health_expenditure_public_pct_of_government_expenditure", "Medical_Doctors" }));

        yAxisLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        yAxisLabel.setText("Y axis:");

        xAxisOption.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bronze", "TeamSize", "Silver", "Gold", "pop2010", "GDP2011", "F2012", "M2012", "Population median age (years)", "Healthy life expectancy (HALE) at birth (years) both sexes", "Health_expenditure_public_pct_of_GDP", "Health_expenditure_public_pct_of_government_expenditure", "Medical_Doctors" }));
        xAxisOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xAxisOptionActionPerformed(evt);
            }
        });

        xAxisLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        xAxisLabel.setText("X axis:");

        detailsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        detailsLabel.setText("Details:");

        minLabelY.setText("Min");

        maxLabelY.setText("Max");

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/OlympicsImage.jpg"))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        countryLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        countryLabel.setForeground(new java.awt.Color(255, 255, 255));
        countryLabel.setText("Country:");

        clearButton.setText("Clear selections");

        savePlotButton.setText("Save scatter plot");

        continentLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        continentLabel.setForeground(new java.awt.Color(255, 255, 255));
        continentLabel.setText("Continent:");

        continentBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Africa", "America", "Asia", "Europe", "Oceania/Australia" }));

        printDoneLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        printDoneLabel.setForeground(new java.awt.Color(255, 255, 255));
        printDoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(savePlotButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(countryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(continentLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(continentBox, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(countryTextBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(printDoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(countryLabel))
                    .addComponent(countryTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(continentLabel))
                    .addComponent(continentBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(savePlotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(printDoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(xAxisLabel)
                                .addGap(4, 4, 4)
                                .addComponent(xAxisOption, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(xAxisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(246, 246, 246))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yAxisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(maxLabelY)
                                .addGap(31, 31, 31)
                                .addComponent(minLabelY, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(764, 764, 764))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(yAxisLabel)
                                .addGap(4, 4, 4)
                                .addComponent(yAxisOption, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleLabel)
                                .addGap(48, 48, 48)))
                        .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(detailsLabel))
                            .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(yAxisLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(yAxisOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(yAxisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maxLabelY)
                            .addComponent(minLabelY))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xAxisLabel)
                    .addComponent(xAxisOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(xAxisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(detailsLabel)
                            .addGap(83, 83, 83)
                            .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void maxY_SliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_maxY_SliderStateChanged
       if( maxY_Slider.getValue() <= minY_Slider.getValue() )
           maxY_Slider.setValue(minY_Slider.getValue());

        scatterPlotPanel.setMaxSliderY(maxY_Slider.getValue());
    }//GEN-LAST:event_maxY_SliderStateChanged

    private void minY_SliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_minY_SliderStateChanged
       if( minY_Slider.getValue() >= maxY_Slider.getValue() )
           minY_Slider.setValue(maxY_Slider.getValue());
       scatterPlotPanel.setMinSliderY(minY_Slider.getValue());
    }//GEN-LAST:event_minY_SliderStateChanged

    private void maxX_SliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_maxX_SliderStateChanged
        if( maxX_Slider.getValue() <= minX_Slider.getValue() )
            maxX_Slider.setValue(minX_Slider.getValue());
        scatterPlotPanel.setMaxSliderX(maxX_Slider.getValue());
    }//GEN-LAST:event_maxX_SliderStateChanged

    private void minX_SliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_minX_SliderStateChanged
        if( minX_Slider.getValue() >= maxX_Slider.getValue() )
            minX_Slider.setValue(maxX_Slider.getValue());
        scatterPlotPanel.setMinSliderX(minX_Slider.getValue());
    }//GEN-LAST:event_minX_SliderStateChanged

    private void xAxisOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xAxisOptionActionPerformed

    }//GEN-LAST:event_xAxisOptionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox continentBox;
    private javax.swing.JLabel continentLabel;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JTextField countryTextBox;
    private javax.swing.JLabel detailsLabel;
    private javax.swing.JButton helpButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel maxLabelX;
    private javax.swing.JLabel maxLabelY;
    private javax.swing.JSlider maxX_Slider;
    private javax.swing.JSlider maxY_Slider;
    private javax.swing.JLabel minLabelX;
    private javax.swing.JLabel minLabelY;
    private javax.swing.JSlider minX_Slider;
    private javax.swing.JSlider minY_Slider;
    private javax.swing.JLabel printDoneLabel;
    private javax.swing.JButton savePlotButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel xAxisLabel;
    private javax.swing.JComboBox xAxisOption;
    private javax.swing.JPanel xAxisPanel;
    private javax.swing.JLabel yAxisLabel;
    private javax.swing.JComboBox yAxisOption;
    private javax.swing.JPanel yAxisPanel;
    // End of variables declaration//GEN-END:variables

}
