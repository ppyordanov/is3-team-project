/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Samsung
 */
public class MainPagePanel extends javax.swing.JPanel implements ActionListener{

    public String paramx, paramy, country, continent;
    public ScatterPlotPanel scatterPlotPanel;
    
    public MainPagePanel(String paramx, String paramy, String country, String continent){
        this.paramx = paramx;
        this.paramy = paramy;
        this.country = country;
        this.continent = continent;
        //creating new scatterPlotPanel
        scatterPlotPanel = new ScatterPlotPanel();
        scatterPlotPanel.setSize(200, 200);
        scatterPlotPanel.setLocation(200, 200);
        scatterPlotPanel.setVisible(true);

        this.add(scatterPlotPanel);
        initComponents();
        drawScatterPlot();
        
	xAxisOption.addActionListener(this);
        yAxisOption.addActionListener(this);
    }
    
     /**
     * Creates new form MainPagePanel
     */
    public MainPagePanel() {
        this("", "", "", "");
    }
    
    private void drawScatterPlot(){
      scatterPlotPanel.repaint();
    }
   
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String selectedItem = (String)cb.getSelectedItem();
        
        if( cb.equals(xAxisOption) )
            this.paramx = selectedItem;
        else
            this.paramy = selectedItem;
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
        yAxisPanel = new javax.swing.JPanel();
        maxY_Slider = new javax.swing.JSlider();
        minY_Slider = new javax.swing.JSlider();
        yAxisOption = new javax.swing.JComboBox();
        yAxisLabel = new javax.swing.JLabel();
        xAxisOption = new javax.swing.JComboBox();
        xAxisLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailsArea = new javax.swing.JTextArea();
        detailsLabel = new javax.swing.JLabel();

        setAutoscrolls(true);

        backButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backButton.setText("Go Back");

        helpButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        helpButton.setText("Help");

        titleLabel.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        titleLabel.setText("Pain Olympics");

        minX_Slider.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        minX_Slider.setMajorTickSpacing(10);
        minX_Slider.setMinorTickSpacing(5);
        minX_Slider.setPaintLabels(true);
        minX_Slider.setPaintTicks(true);
        minX_Slider.setSnapToTicks(true);
        minX_Slider.setValue(30);
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
        maxX_Slider.setValue(80);
        maxX_Slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                maxX_SliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout xAxisPanelLayout = new javax.swing.GroupLayout(xAxisPanel);
        xAxisPanel.setLayout(xAxisPanelLayout);
        xAxisPanelLayout.setHorizontalGroup(
            xAxisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xAxisPanelLayout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(xAxisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maxX_Slider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minX_Slider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        xAxisPanelLayout.setVerticalGroup(
            xAxisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, xAxisPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(maxX_Slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minX_Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE))
        );

        maxY_Slider.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        maxY_Slider.setForeground(new java.awt.Color(0, 0, 0));
        maxY_Slider.setMajorTickSpacing(10);
        maxY_Slider.setMinorTickSpacing(5);
        maxY_Slider.setOrientation(javax.swing.JSlider.VERTICAL);
        maxY_Slider.setPaintLabels(true);
        maxY_Slider.setPaintTicks(true);
        maxY_Slider.setToolTipText("");
        maxY_Slider.setValue(80);
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
        minY_Slider.setValue(30);
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

        yAxisOption.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Team size", "Bronze medals", "Silver medals", "Gold medals", "Population 2010", "GDP 2011", "Females 2012", "Males 2012", "Health_expenditure_public_pct_of_GDP", "Health_expenditure_public_pct_of_government_expenditure", "Medical_Doctors" }));

        yAxisLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        yAxisLabel.setText("Y axis:");

        xAxisOption.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Team size", "Bronze medals", "Silver medals", "Gold medals", "Population 2010", "GDP 2011", "Females 2012", "Males 2012", "Health_expenditure_public_pct_of_GDP", "Health_expenditure_public_pct_of_government_expenditure", "Medical_Doctors" }));

        xAxisLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        xAxisLabel.setText("X axis:");

        detailsArea.setEditable(false);
        detailsArea.setColumns(20);
        detailsArea.setRows(5);
        jScrollPane1.setViewportView(detailsArea);

        detailsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        detailsLabel.setText("Details:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(xAxisLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xAxisOption, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(xAxisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(detailsLabel)
                                    .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(yAxisLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(yAxisOption, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(yAxisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(114, 114, 114)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yAxisOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yAxisLabel))
                        .addGap(18, 18, 18)
                        .addComponent(yAxisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(xAxisOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xAxisLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(xAxisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(detailsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void maxY_SliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_maxY_SliderStateChanged
       if( maxY_Slider.getValue() <= minY_Slider.getValue() )
           maxY_Slider.setValue(minY_Slider.getValue());
    }//GEN-LAST:event_maxY_SliderStateChanged

    private void minY_SliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_minY_SliderStateChanged
       if( minY_Slider.getValue() >= maxY_Slider.getValue() )
           minY_Slider.setValue(maxY_Slider.getValue());
    }//GEN-LAST:event_minY_SliderStateChanged

    private void maxX_SliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_maxX_SliderStateChanged
        if( maxX_Slider.getValue() <= minX_Slider.getValue() )
            maxX_Slider.setValue(minX_Slider.getValue());
    }//GEN-LAST:event_maxX_SliderStateChanged

    private void minX_SliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_minX_SliderStateChanged
        if( minX_Slider.getValue() >= maxX_Slider.getValue() )
            minX_Slider.setValue(maxX_Slider.getValue());
    }//GEN-LAST:event_minX_SliderStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextArea detailsArea;
    private javax.swing.JLabel detailsLabel;
    private javax.swing.JButton helpButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider maxX_Slider;
    private javax.swing.JSlider maxY_Slider;
    private javax.swing.JSlider minX_Slider;
    private javax.swing.JSlider minY_Slider;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel xAxisLabel;
    private javax.swing.JComboBox xAxisOption;
    private javax.swing.JPanel xAxisPanel;
    private javax.swing.JLabel yAxisLabel;
    private javax.swing.JComboBox yAxisOption;
    private javax.swing.JPanel yAxisPanel;
    // End of variables declaration//GEN-END:variables

}
