  //Terá um for ou um while com row iterator para fazer as páginas
package framesPackage;

import connectionsPackage.EscolaDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import mainPackage.Escola;
import mainPackage.ReadSheet;

public class FrameRanking extends ReadSheet {

    //Constructor
    public FrameRanking() throws Exception {
        
        initComponents();
        readJTable();
//        try {
//           //ReadSheet.readTableMedio(mainTable);
//           //ReadSheet.readTableIniFin();
//           ReadSheet.readTableFin();
//        } catch (IOException ex) {
//            Logger.getLogger(FrameRanking.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) mainTable.getModel();

        EscolaDAO escolaDAO = new EscolaDAO();
        int i = 1;
        for (Escola escola : escolaDAO.readMed()) {
            modelo.addRow(new Object[]{
                i,
                escola.getNOME_ESC(),
                escola.getMED_INI(),
                escola.getMED_FIN(),
                escola.getMED_MED(),
                escola.getINI_IDEB(),
                escola.getFIN_IDEB(),
                escola.getMED_IDEB()
            });
            i++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        tfSearch = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ranking");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        mainTable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ranking", "Nome da Escola", "Anos Iniciais", "Anos Finais", "Ensino Médio", "IDEB Anos Iniciais", "IDEB Anos Finais", "IDEB Ensino Médio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mainTable.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(mainTable);
        mainTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (mainTable.getColumnModel().getColumnCount() > 0) {
            mainTable.getColumnModel().getColumn(0).setResizable(false);
            mainTable.getColumnModel().getColumn(2).setResizable(false);
            mainTable.getColumnModel().getColumn(3).setResizable(false);
            mainTable.getColumnModel().getColumn(4).setResizable(false);
            mainTable.getColumnModel().getColumn(5).setResizable(false);
            mainTable.getColumnModel().getColumn(6).setResizable(false);
            mainTable.getColumnModel().getColumn(7).setResizable(false);
        }

        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });
        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1229, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed

    }//GEN-LAST:event_tfSearchActionPerformed

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();
        String search = tfSearch.getText().toUpperCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        mainTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_tfSearchKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mainTable;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
