/*
 * Copyright (C) 2016 Ernesto Serrano <info at ernesto.es>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package practica5;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author ernesto
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonGroupTools = new javax.swing.ButtonGroup();
        jToolBarTools = new javax.swing.JToolBar();
        jToggleButtonPoint = new javax.swing.JToggleButton();
        jToggleButtonLine = new javax.swing.JToggleButton();
        jToggleButtonRectangle = new javax.swing.JToggleButton();
        jToggleButtonEllipse = new javax.swing.JToggleButton();
        jPanelCenter = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();
        jPanelToolBarColor = new javax.swing.JPanel();
        jPanelColors = new javax.swing.JPanel();
        jButtonColorBlack = new javax.swing.JButton();
        jButtonColorRed = new javax.swing.JButton();
        jButtonColorBlue = new javax.swing.JButton();
        jButtonColorWhite = new javax.swing.JButton();
        jButtonColorYellow = new javax.swing.JButton();
        jButtonColorGreen = new javax.swing.JButton();
        jCheckBoxFillColor = new javax.swing.JCheckBox();
        jCheckBoxMove = new javax.swing.JCheckBox();
        jStatusBar = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemNew = new javax.swing.JMenuItem();
        jMenuOpen = new javax.swing.JMenuItem();
        jMenuSave = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuPrint = new javax.swing.JMenu();
        jMenuItemPrinter = new javax.swing.JMenuItem();
        jMenuItemFile = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemCopy = new javax.swing.JMenuItem();
        jMenuItemCut = new javax.swing.JMenuItem();
        jMenuItemPaste = new javax.swing.JMenuItem();
        jMenuView = new javax.swing.JMenu();
        jCheckBoxMenuItemStatusBar = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 500));

        jToolBarTools.setRollover(true);

        jButtonGroupTools.add(jToggleButtonPoint);
        jToggleButtonPoint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica5/images/Lapiz.gif"))); // NOI18N
        jToggleButtonPoint.setSelected(true);
        jToggleButtonPoint.setToolTipText("Punto");
        jToggleButtonPoint.setFocusable(false);
        jToggleButtonPoint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButtonPoint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButtonPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonPointActionPerformed(evt);
            }
        });
        jToolBarTools.add(jToggleButtonPoint);

        jButtonGroupTools.add(jToggleButtonLine);
        jToggleButtonLine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica5/images/Linea.gif"))); // NOI18N
        jToggleButtonLine.setToolTipText("Linea");
        jToggleButtonLine.setFocusable(false);
        jToggleButtonLine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButtonLine.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButtonLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonLineActionPerformed(evt);
            }
        });
        jToolBarTools.add(jToggleButtonLine);

        jButtonGroupTools.add(jToggleButtonRectangle);
        jToggleButtonRectangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica5/images/Rectangulo.gif"))); // NOI18N
        jToggleButtonRectangle.setToolTipText("Rectangulo");
        jToggleButtonRectangle.setFocusable(false);
        jToggleButtonRectangle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButtonRectangle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButtonRectangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonRectangleActionPerformed(evt);
            }
        });
        jToolBarTools.add(jToggleButtonRectangle);

        jButtonGroupTools.add(jToggleButtonEllipse);
        jToggleButtonEllipse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica5/images/Ovalo.gif"))); // NOI18N
        jToggleButtonEllipse.setToolTipText("Elipse");
        jToggleButtonEllipse.setFocusable(false);
        jToggleButtonEllipse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButtonEllipse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButtonEllipse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonEllipseActionPerformed(evt);
            }
        });
        jToolBarTools.add(jToggleButtonEllipse);

        getContentPane().add(jToolBarTools, java.awt.BorderLayout.PAGE_START);

        jPanelCenter.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelCenter.add(escritorio, java.awt.BorderLayout.CENTER);

        jPanelToolBarColor.setLayout(new java.awt.BorderLayout());

        jPanelColors.setLayout(new java.awt.GridLayout(2, 0));

        jButtonColorBlack.setBackground(java.awt.Color.black);
        jButtonColorBlack.setMinimumSize(new java.awt.Dimension(100, 100));
        jButtonColorBlack.setPreferredSize(new java.awt.Dimension(29, 29));
        jButtonColorBlack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonColorBlackMouseClicked(evt);
            }
        });
        jPanelColors.add(jButtonColorBlack);

        jButtonColorRed.setBackground(java.awt.Color.red);
        jButtonColorRed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonColorRedMouseClicked(evt);
            }
        });
        jPanelColors.add(jButtonColorRed);

        jButtonColorBlue.setBackground(java.awt.Color.blue);
        jButtonColorBlue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonColorBlueMouseClicked(evt);
            }
        });
        jPanelColors.add(jButtonColorBlue);

        jButtonColorWhite.setBackground(java.awt.Color.white);
        jButtonColorWhite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonColorWhiteMouseClicked(evt);
            }
        });
        jPanelColors.add(jButtonColorWhite);

        jButtonColorYellow.setBackground(java.awt.Color.yellow);
        jButtonColorYellow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonColorYellowMouseClicked(evt);
            }
        });
        jPanelColors.add(jButtonColorYellow);

        jButtonColorGreen.setBackground(java.awt.Color.green);
        jButtonColorGreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonColorGreenMouseClicked(evt);
            }
        });
        jPanelColors.add(jButtonColorGreen);

        jPanelToolBarColor.add(jPanelColors, java.awt.BorderLayout.WEST);
        jPanelColors.getAccessibleContext().setAccessibleParent(jPanelToolBarColor);

        jCheckBoxFillColor.setText("Rellenar");
        jCheckBoxFillColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxFillColorMouseClicked(evt);
            }
        });
        jPanelToolBarColor.add(jCheckBoxFillColor, java.awt.BorderLayout.EAST);

        jCheckBoxMove.setText("Mover");
        jCheckBoxMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMoveActionPerformed(evt);
            }
        });
        jPanelToolBarColor.add(jCheckBoxMove, java.awt.BorderLayout.CENTER);

        jPanelCenter.add(jPanelToolBarColor, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanelCenter, java.awt.BorderLayout.CENTER);

        jStatusBar.setText("Barra Estado");
        jStatusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jStatusBar, java.awt.BorderLayout.SOUTH);

        jMenuFile.setText("Archivo");

        jMenuItemNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.META_MASK));
        jMenuItemNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica5/images/NuevoBoceto.gif"))); // NOI18N
        jMenuItemNew.setText("Nuevo");
        jMenuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNewActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemNew);

        jMenuOpen.setText("Abrir");
        jMenuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOpenActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuOpen);

        jMenuSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.META_MASK));
        jMenuSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica5/images/Guardar.gif"))); // NOI18N
        jMenuSave.setText("Guardar");
        jMenuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSaveActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuSave);
        jMenuFile.add(jSeparator2);

        jMenuPrint.setText("Imprimir");

        jMenuItemPrinter.setText("Impresora");
        jMenuPrint.add(jMenuItemPrinter);

        jMenuItemFile.setText("Fichero");
        jMenuPrint.add(jMenuItemFile);

        jMenuFile.add(jMenuPrint);
        jMenuFile.add(jSeparator1);

        jMenuItemExit.setText("Salir");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExit);

        jMenuBar.add(jMenuFile);

        jMenuEdit.setText("Editar");

        jMenuItemCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.META_MASK));
        jMenuItemCopy.setText("Copiar");
        jMenuEdit.add(jMenuItemCopy);

        jMenuItemCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.META_MASK));
        jMenuItemCut.setText("Cortar");
        jMenuEdit.add(jMenuItemCut);

        jMenuItemPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.META_MASK));
        jMenuItemPaste.setText("Pegar");
        jMenuEdit.add(jMenuItemPaste);

        jMenuBar.add(jMenuEdit);

        jMenuView.setText("Ver");

        jCheckBoxMenuItemStatusBar.setSelected(true);
        jCheckBoxMenuItemStatusBar.setText("Barra de estado");
        jCheckBoxMenuItemStatusBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItemStatusBarActionPerformed(evt);
            }
        });
        jMenuView.add(jCheckBoxMenuItemStatusBar);

        jMenuBar.add(jMenuView);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNewActionPerformed
        // TODO add your handling code here:
        
        VentanaInterna vi = new VentanaInterna();
        //escritorio.add(vi);
        escritorio.add(vi);
        vi.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemNewActionPerformed

    private void jMenuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOpenActionPerformed
        // TODO add your handling code here:
        
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showOpenDialog(this);
        if( resp == JFileChooser.APPROVE_OPTION) {
            File f = dlg.getSelectedFile();
            //Código 
        
            VentanaInterna vi = new VentanaInterna(f);
            //escritorio.add(vi);
            escritorio.add(vi);
            vi.setVisible(true);
            
            
        }
        
        
    }//GEN-LAST:event_jMenuOpenActionPerformed

    private void jMenuSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSaveActionPerformed

        
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showSaveDialog(this);
        if( resp == JFileChooser.APPROVE_OPTION) {
            File f = dlg.getSelectedFile();
            //Código 
        
            /*
            VentanaInterna vi = new VentanaInterna(f);
            //escritorio.add(vi);
            escritorio.add(vi);
            vi.setVisible(true);
            */
            
        }
        
        
        
    }//GEN-LAST:event_jMenuSaveActionPerformed

    private void jCheckBoxMenuItemStatusBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItemStatusBarActionPerformed
        
        this.jStatusBar.setVisible(jCheckBoxMenuItemStatusBar.getState());
        
    }//GEN-LAST:event_jCheckBoxMenuItemStatusBarActionPerformed

    private void jToggleButtonPointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonPointActionPerformed
        
        Config.setSelectedTool(Config.Tool.POINT);
        this.jStatusBar.setText("Punto");
    }//GEN-LAST:event_jToggleButtonPointActionPerformed

    private void jToggleButtonLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonLineActionPerformed
        Config.setSelectedTool(Config.Tool.LINE);
        this.jStatusBar.setText("Linea");
    }//GEN-LAST:event_jToggleButtonLineActionPerformed

    private void jToggleButtonRectangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonRectangleActionPerformed
        Config.setSelectedTool(Config.Tool.RECTANGLE);
        this.jStatusBar.setText("Rectangulo");
    }//GEN-LAST:event_jToggleButtonRectangleActionPerformed

    private void jToggleButtonEllipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonEllipseActionPerformed
        Config.setSelectedTool(Config.Tool.ELLIPSE);
        this.jStatusBar.setText("Elipse");
    }//GEN-LAST:event_jToggleButtonEllipseActionPerformed

    private void jButtonColorBlackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonColorBlackMouseClicked
        Config.setSelectedColor(evt.getComponent().getBackground());
    }//GEN-LAST:event_jButtonColorBlackMouseClicked

    private void jButtonColorWhiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonColorWhiteMouseClicked
        Config.setSelectedColor(evt.getComponent().getBackground());
    }//GEN-LAST:event_jButtonColorWhiteMouseClicked

    private void jButtonColorRedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonColorRedMouseClicked
        Config.setSelectedColor(evt.getComponent().getBackground());
    }//GEN-LAST:event_jButtonColorRedMouseClicked

    private void jButtonColorBlueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonColorBlueMouseClicked
        Config.setSelectedColor(evt.getComponent().getBackground());
    }//GEN-LAST:event_jButtonColorBlueMouseClicked

    private void jButtonColorYellowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonColorYellowMouseClicked
        Config.setSelectedColor(evt.getComponent().getBackground());
    }//GEN-LAST:event_jButtonColorYellowMouseClicked

    private void jButtonColorGreenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonColorGreenMouseClicked
        Config.setSelectedColor(evt.getComponent().getBackground());
    }//GEN-LAST:event_jButtonColorGreenMouseClicked

    private void jCheckBoxFillColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxFillColorMouseClicked
        Config.setFillColor(this.jCheckBoxFillColor.isSelected());
    }//GEN-LAST:event_jCheckBoxFillColorMouseClicked

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jCheckBoxMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMoveActionPerformed
        // TODO add your handling code here:
        Config.setMove(this.jCheckBoxMove.isSelected());
    }//GEN-LAST:event_jCheckBoxMoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton jButtonColorBlack;
    private javax.swing.JButton jButtonColorBlue;
    private javax.swing.JButton jButtonColorGreen;
    private javax.swing.JButton jButtonColorRed;
    private javax.swing.JButton jButtonColorWhite;
    private javax.swing.JButton jButtonColorYellow;
    private javax.swing.ButtonGroup jButtonGroupTools;
    private javax.swing.JCheckBox jCheckBoxFillColor;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItemStatusBar;
    private javax.swing.JCheckBox jCheckBoxMove;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemCopy;
    private javax.swing.JMenuItem jMenuItemCut;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemFile;
    private javax.swing.JMenuItem jMenuItemNew;
    private javax.swing.JMenuItem jMenuItemPaste;
    private javax.swing.JMenuItem jMenuItemPrinter;
    private javax.swing.JMenuItem jMenuOpen;
    private javax.swing.JMenu jMenuPrint;
    private javax.swing.JMenuItem jMenuSave;
    private javax.swing.JMenu jMenuView;
    private javax.swing.JPanel jPanelCenter;
    private javax.swing.JPanel jPanelColors;
    private javax.swing.JPanel jPanelToolBarColor;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel jStatusBar;
    private javax.swing.JToggleButton jToggleButtonEllipse;
    private javax.swing.JToggleButton jToggleButtonLine;
    private javax.swing.JToggleButton jToggleButtonPoint;
    private javax.swing.JToggleButton jToggleButtonRectangle;
    private javax.swing.JToolBar jToolBarTools;
    // End of variables declaration//GEN-END:variables
}
