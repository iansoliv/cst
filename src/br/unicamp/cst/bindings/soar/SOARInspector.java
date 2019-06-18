/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicamp.cst.bindings.soar;

import br.unicamp.cst.representation.owrl.AbstractObject;
import br.unicamp.cst.util.AbstractObjectEditor;
import br.unicamp.cst.util.AbstractObjectEditorListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author gudwin
 */
public class SOARInspector extends javax.swing.JFrame implements Observer,AbstractObjectEditorListener {
    
    int debugstate = 0;
    JSoarCodelet SoarCodelet;
    ImageIcon pause_icon = new ImageIcon(getClass().getClassLoader().getResource("pause-icon.png")); 
    ImageIcon play_icon = new ImageIcon(getClass().getClassLoader().getResource("play-icon.png"));
    WorkingMemoryPanel wmp;

    /**
     * Creates new form MindView
     */
    public SOARInspector(JSoarCodelet soar) {
        initComponents();
        SoarCodelet = soar;
        this.setTitle("SOARInspector");
        jSplitPane1.setDividerLocation(0.5);
        jSplitPane1.setResizeWeight(.5d);
        wmp = new WorkingMemoryPanel(soar); 
        wmp.setSize(jScrollPane1.getWidth(), jScrollPane1.getHeight());
        jScrollPane1.setViewportView(wmp);
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        startstop = new javax.swing.JButton();
        mstep = new javax.swing.JButton();
        step = new javax.swing.JButton();
        currentPhase = new javax.swing.JTextField();
        jSplitPane2 = new javax.swing.JSplitPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        input_link = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        output_link = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jFile = new javax.swing.JMenu();
        mLoadRules = new javax.swing.JMenuItem();
        jExit = new javax.swing.JMenuItem();
        jDebug = new javax.swing.JMenu();
        jStart = new javax.swing.JMenuItem();
        jStop = new javax.swing.JMenuItem();
        jWatch = new javax.swing.JMenuItem();
        mInsertInputLink = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        startstop.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("pause-icon.png"))); // NOI18N
        startstop.setToolTipText("Play/Pause");
        startstop.setFocusable(false);
        startstop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        startstop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        startstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startstopActionPerformed(evt);
            }
        });
        jToolBar1.add(startstop);

        mstep.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("skip-forward-icon.png"))); // NOI18N
        mstep.setToolTipText("micro-step");
        mstep.setEnabled(false);
        mstep.setFocusable(false);
        mstep.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mstep.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mstep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mstepActionPerformed(evt);
            }
        });
        jToolBar1.add(mstep);

        step.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("forward-icon.png"))); // NOI18N
        step.setToolTipText("step");
        step.setEnabled(false);
        step.setFocusable(false);
        step.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        step.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        step.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stepActionPerformed(evt);
            }
        });
        jToolBar1.add(step);

        currentPhase.setText("Current Phase: <HALT>");
        currentPhase.setPreferredSize(new java.awt.Dimension(100000, 44));
        jToolBar1.add(currentPhase);

        jSplitPane2.setDividerLocation(220);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane1.setDividerLocation(500);
        jSplitPane1.setLastDividerLocation(451);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(902, 450));

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel3.setMinimumSize(new java.awt.Dimension(100, 30));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel1.setText("InputLink:");
        jLabel1.setPreferredSize(new java.awt.Dimension(71, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(402, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        input_link.setMinimumSize(new java.awt.Dimension(6, 300));
        input_link.setPreferredSize(new java.awt.Dimension(6, 300));
        jScrollPane2.setViewportView(input_link);

        jPanel1.add(jScrollPane2);

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanel4.setMinimumSize(new java.awt.Dimension(100, 30));
        jPanel4.setPreferredSize(new java.awt.Dimension(391, 30));

        jLabel2.setText("OutputLink:");
        jLabel2.setPreferredSize(new java.awt.Dimension(84, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(4, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4);

        jScrollPane3.setViewportView(output_link);

        jPanel2.add(jScrollPane3);

        jSplitPane1.setRightComponent(jPanel2);

        jSplitPane2.setLeftComponent(jSplitPane1);

        jScrollPane1.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane1.setOpaque(false);
        jSplitPane2.setRightComponent(jScrollPane1);

        jFile.setText("File");

        mLoadRules.setText("Load Rules");
        mLoadRules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLoadRulesActionPerformed(evt);
            }
        });
        jFile.add(mLoadRules);

        jExit.setText("Exit");
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitActionPerformed(evt);
            }
        });
        jFile.add(jExit);

        jMenuBar1.add(jFile);

        jDebug.setText("Debug");

        jStart.setText("Start");
        jStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStartActionPerformed(evt);
            }
        });
        jDebug.add(jStart);

        jStop.setText("Stop");
        jStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStopActionPerformed(evt);
            }
        });
        jDebug.add(jStop);

        jWatch.setText("Watch");
        jWatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jWatchActionPerformed(evt);
            }
        });
        jDebug.add(jWatch);

        mInsertInputLink.setText("Insert InputLink");
        mInsertInputLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mInsertInputLinkActionPerformed(evt);
            }
        });
        jDebug.add(mInsertInputLink);

        jMenuBar1.add(jDebug);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStopActionPerformed
        stopDebugState();
    }//GEN-LAST:event_jStopActionPerformed

    private void jStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStartActionPerformed
        startDebugState();  
    }//GEN-LAST:event_jStartActionPerformed

    private void jExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jExitActionPerformed

    private void mstepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mstepActionPerformed
        mstepDebugState();
    }//GEN-LAST:event_mstepActionPerformed

    private void startstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startstopActionPerformed
        if (debugstate == 0) {
           startDebugState();
        }
        else {
           stopDebugState();   
        }
    }//GEN-LAST:event_startstopActionPerformed

    private void stepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stepActionPerformed
        // TODO add your handling code here:
        stepDebugState();
    }//GEN-LAST:event_stepActionPerformed

    private void jWatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jWatchActionPerformed
        // TODO add your handling code here:
        WorkingMemoryViewer wmi = new WorkingMemoryViewer("SOAR Working Memory",SoarCodelet);
        wmi.setVisible(true);
    }//GEN-LAST:event_jWatchActionPerformed

    private void mInsertInputLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mInsertInputLinkActionPerformed
        AbstractObject il = new AbstractObject("InputLink");
        AbstractObjectEditor aoe = new AbstractObjectEditor(il);
        aoe.addListener(this);
        aoe.setVisible(true);
        SoarCodelet.getJsoar().setInputLinkAO(il);
    }//GEN-LAST:event_mInsertInputLinkActionPerformed

    private void mLoadRulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLoadRulesActionPerformed
        // TODO add your handling code here:
        String soarRulesPath="";
        try {
		JFileChooser chooser = new JFileChooser();
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		  soarRulesPath = chooser.getSelectedFile().getCanonicalPath();
		  //System.out.println("You chose to open this file: "+soarRulesPath);
                }
            } catch (Exception e) { e.printStackTrace(); }
        if (!soarRulesPath.equals(""))
           SoarCodelet.getJsoar().loadRules(soarRulesPath);
    }//GEN-LAST:event_mLoadRulesActionPerformed

    public void update(Observable arg0, Object arg1) {
        this.repaint();
    }
    
    public int getDebugState() {
        return(debugstate);
    }
    
    public void startDebugState() {
        startstop.setIcon(play_icon); // NOI18N 
        mstep.setEnabled(true);
        step.setEnabled(true);
        setPhaseIndication();
        wmp.updateTree();
        //wmp.setVisible(true);
        debugstate = 1;
        try {
           //sb.c.stop();
        } catch (Exception e) {
           e.printStackTrace();
        } 
    }
    
    public void stopDebugState() {
        startstop.setIcon(pause_icon); // NOI18N 
        mstep.setEnabled(false);
        step.setEnabled(false);
        stepDebugState();
        setPhaseIndication();
        //wmp.setVisible(false);
        debugstate = 0;
        try {
              //sb.c.start();
        } catch (Exception e) {
              e.printStackTrace();
        }
    }
    
    public void stepDebugState() {
        if (debugstate == 1) {
          try {
            SoarCodelet.getJsoar().step();
            set_input_link_text(SoarCodelet.getInputLinkAsString());
            set_output_link_text(SoarCodelet.getOutputLinkAsString());
            setPhaseIndication();
            wmp.updateTree();
            //wmp.setVisible(true);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
    }
    
    public void mstepDebugState() {
        if (debugstate == 1) {
          try {
            SoarCodelet.getJsoar().mstep();
            set_input_link_text(SoarCodelet.getInputLinkAsString());
            set_output_link_text(SoarCodelet.getOutputLinkAsString());
            setPhaseIndication();
            wmp.updateTree();
            //wmp.setVisible(true);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
    }
    
    public void setPhaseIndication() {
        int phase = SoarCodelet.getJsoar().getPhase();
        if (phase == -1)
               currentPhase.setText("Current Phase: "+"<HALT>");
        else if (phase == 0)
               currentPhase.setText("Current Phase: "+"<INPUT>"); 
        else if (phase == 1)
               currentPhase.setText("Current Phase: "+"<PROPOSE>");
        else if (phase == 2)
               currentPhase.setText("Current Phase: "+"<DECISION>");
        else if (phase == 3)
               currentPhase.setText("Current Phase: "+"<APPLY>");
        else if (phase == 4)
               currentPhase.setText("Current Phase: "+"<OUTPUT>"); 
        else if (phase == 5)
               currentPhase.setText("Current Phase: "+"<HALT>"); 
    }
    
    public void set_input_link_text(String text) {
        input_link.setText(text);
    }
    
    public void set_output_link_text(String text) {
        output_link.setText(text);
    }
    
    @Override
    public void notifyRootChange(AbstractObject ao) {
        SoarCodelet.getJsoar().setInputLinkAO(ao);
    }
    
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
            java.util.logging.Logger.getLogger(WorkingMemoryViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WorkingMemoryViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WorkingMemoryViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WorkingMemoryViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        String soarRulesPath="";
        try {
		JFileChooser chooser = new JFileChooser();
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		  soarRulesPath = chooser.getSelectedFile().getCanonicalPath();
		  //System.out.println("You chose to open this file: "+soarRulesPath);
                }
            } catch (Exception e) { e.printStackTrace(); }
        JSoarCodelet soarCodelet = new TestJSoarCodelet(soarRulesPath);
        SOARInspector si = new SOARInspector(soarCodelet);
        si.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField currentPhase;
    private javax.swing.JTextPane input_link;
    private javax.swing.JMenu jDebug;
    private javax.swing.JMenuItem jExit;
    private javax.swing.JMenu jFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JMenuItem jStart;
    private javax.swing.JMenuItem jStop;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem jWatch;
    private javax.swing.JMenuItem mInsertInputLink;
    private javax.swing.JMenuItem mLoadRules;
    private javax.swing.JButton mstep;
    private javax.swing.JTextPane output_link;
    private javax.swing.JButton startstop;
    private javax.swing.JButton step;
    // End of variables declaration//GEN-END:variables
}
