/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.zowayix.ROMRecognizer;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author megan
 */
public class GUI extends javax.swing.JFrame {

	private static final long serialVersionUID = -7190543310189730445L;

	private List<String> filters = null;

	/**
	 * Creates new form GUI
	 */
	public GUI() {
		initComponents();
		filters = new ArrayList<>(ROMRecognizer.getKnownExtensions().keySet());
		TableContextMenuListener.addTableHeaderEventHandlers(resultList);
	}


	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT
	 * modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datLabel = new javax.swing.JLabel();
        datField = new javax.swing.JTextField();
        datButton = new javax.swing.JButton();
        romLabel = new javax.swing.JLabel();
        romButton = new javax.swing.JButton();
        romField = new javax.swing.JTextField();
        scanButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultList = new javax.swing.JTable();
        quitButton = new javax.swing.JButton();
        workerLabel = new javax.swing.JLabel();
        workerSpinner = new javax.swing.JSpinner();
        filterButton = new javax.swing.JButton();
        filterCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("The ROM Recognizer");

        datLabel.setLabelFor(datField);
        datLabel.setText("DAT directory:");

        datButton.setText("...");
        datButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datButtonActionPerformed(evt);
            }
        });

        romLabel.setLabelFor(romField);
        romLabel.setText("ROM directory:");

        romButton.setText("...");
        romButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                romButtonActionPerformed(evt);
            }
        });

        scanButton.setText("Scan!");
        scanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanButtonActionPerformed(evt);
            }
        });

        resultList.setAutoCreateRowSorter(true);
        resultList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Filename", "Name", "CRC32", "MD5", "SHA-1", "Path", "Platform", "ROM Name", "Description", "Size", "Status", "File Type (from Ext)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Long.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        resultList.setFillsViewportHeight(true);
        resultList.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jScrollPane1.setViewportView(resultList);

        quitButton.setText("Quit");
        quitButton.setToolTipText("");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        workerLabel.setLabelFor(workerSpinner);
        workerLabel.setText("Worker threads:");

        workerSpinner.setModel(new javax.swing.SpinnerNumberModel(256, 1, null, 1));

        filterButton.setText("...");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        filterCheck.setText("Only scan specific extensions");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(datLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(romLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(romField, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(romButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scanButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(workerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(workerSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datLabel)
                    .addComponent(datField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(romLabel)
                    .addComponent(romField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(romButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scanButton)
                    .addComponent(quitButton)
                    .addComponent(workerLabel)
                    .addComponent(workerSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterButton)
                    .addComponent(filterCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void datButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datButtonActionPerformed
		JFileChooser chooser = new JFileChooser(datField.getText());
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			datField.setText(chooser.getSelectedFile().getPath());
		}
    }//GEN-LAST:event_datButtonActionPerformed

    private void romButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_romButtonActionPerformed
		JFileChooser chooser = new JFileChooser(romField.getText());
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			romField.setText(chooser.getSelectedFile().getPath());
		}

    }//GEN-LAST:event_romButtonActionPerformed

    private void scanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanButtonActionPerformed
		if (datField.getText().length() == 0) {
			JOptionPane.showMessageDialog(this, "You need to specify a DAT file directory!", "borf", JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (!new File(datField.getText()).isDirectory()) {
			JOptionPane.showMessageDialog(this, "The DAT directory specified doesn't exist or isn't a directory", "borf", JOptionPane.WARNING_MESSAGE);
			return;
		}

		SwingWorker<Void, Void> woiker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				doScan();
				return null;
			}
		};

		woiker.execute();

    }//GEN-LAST:event_scanButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_quitButtonActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
		FilenameFilterChooser ffc = new FilenameFilterChooser(this, true);
		filters = ffc.editFilterList(filters);
    }//GEN-LAST:event_filterButtonActionPerformed

	private void toggleEnabled() {
		datField.setEnabled(!datField.isEnabled());
		datButton.setEnabled(!datButton.isEnabled());
		romField.setEnabled(!romField.isEnabled());
		romButton.setEnabled(!romButton.isEnabled());
		scanButton.setEnabled(!scanButton.isEnabled());
	}

	private void doScan() {
		try {
			toggleEnabled();
			resultList.setAutoCreateRowSorter(false);
			resultList.setRowSorter(null);

			//TODO Put a progress bar in there
			ExecutorService exeggutor = Executors.newSingleThreadExecutor((Runnable r) -> {
				Thread t = new Thread(r);
				t.setPriority(Thread.NORM_PRIORITY + 1);
				return t;
			});
			Future<Collection<Game>> gameList = exeggutor.submit(() -> ROMRecognizer.getAllDataFiles(new File(datField.getText())));

			int workerCount;
			try {
				workerSpinner.commitEdit();
			} catch (ParseException pex) {
				//borf
			}
			workerCount = (int) workerSpinner.getModel().getValue();

			((DefaultTableModel) resultList.getModel()).setRowCount(0);
			if (filterCheck.isSelected()) {
				ROMRecognizer.scanGames(gameList, new File(romField.getText()), resultList, workerCount, filters);
			} else {

				ROMRecognizer.scanGames(gameList, new File(romField.getText()), resultList, workerCount);
			}

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, ex, "Ah fuck, I can't believe you've done this", JOptionPane.ERROR_MESSAGE);
		} finally {
			toggleEnabled();
			resultList.setAutoCreateRowSorter(true);
		}
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
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GUI().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton datButton;
    private javax.swing.JTextField datField;
    private javax.swing.JLabel datLabel;
    private javax.swing.JButton filterButton;
    private javax.swing.JCheckBox filterCheck;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton quitButton;
    private javax.swing.JTable resultList;
    private javax.swing.JButton romButton;
    private javax.swing.JTextField romField;
    private javax.swing.JLabel romLabel;
    private javax.swing.JButton scanButton;
    private javax.swing.JLabel workerLabel;
    private javax.swing.JSpinner workerSpinner;
    // End of variables declaration//GEN-END:variables

	/*private static class TableContextMenuListener extends MouseAdapter {

		private final JTable table;
		private final TableColumnModel model;

		public TableContextMenuListener(JTable table) {
			this.table = table;
			this.model = table.getColumnModel();
		}

		private void decideShowContextMenu(MouseEvent e) {
			if (e.isPopupTrigger()) {
				showContextMenu(e);
				e.consume();
			}
		}

		private void showContextMenu(MouseEvent e) {
			int colIndex = table.columnAtPoint(e.getPoint());
			JPopupMenu menu = new JPopupMenu();

			JMenuItem hideItem = new JMenuItem("Hide Column");
			hideItem.addActionListener((ActionEvent ae) -> {
				TableColumn column = model.getColumn(table.convertColumnIndexToModel(colIndex));
				column.setPreferredWidth(0);
				column.setMinWidth(0);
				column.setMaxWidth(0);
			});

			JMenu showSubmenu = new JMenu("Show Hidden");
			for (int i = 0; i < model.getColumnCount(); ++i) {
				TableColumn column = model.getColumn(i);
				if (column.getWidth() == 0) {
					JMenuItem showItem = new JMenuItem(column.getHeaderValue().toString());
					showItem.addActionListener((ActionEvent e1) -> {
						column.setMaxWidth(Integer.MAX_VALUE);
						column.setPreferredWidth(75); //According to getWidth(), default value
					});
					showSubmenu.add(showItem);
				}
			}

			menu.add(hideItem);
			if (showSubmenu.getMenuComponentCount() > 0) {
				menu.add(showSubmenu);
			}
			menu.show(e.getComponent(), e.getX(), e.getY());
		}

		@Override
		public void mousePressed(MouseEvent e) {
			decideShowContextMenu(e);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			decideShowContextMenu(e);
		}

	}*/
}
