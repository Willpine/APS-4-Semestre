  //Terá um for ou um while com row iterator para fazer as páginas
package framesPackage;

import connectionsPackage.EscolaDAO;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import mainPackage.Escola;
import mainPackage.ReadSheet;

public class FrameRanking extends ReadSheet {

    public static String ra;

    //Constructor
    public FrameRanking(String ra) throws Exception {
        this.ra = ra;
        initComponents();
        mainTable.getColumnModel().getColumn(1).setPreferredWidth(300);

//        try {
//           //ReadSheet.readTableMedio(mainTable);
//           //ReadSheet.readTableIniFin();
//           ReadSheet.readTableFin();
//        } catch (IOException ex) {
//            Logger.getLogger(FrameRanking.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void readJTable(int tipo) {
        DefaultTableModel modelo = (DefaultTableModel) mainTable.getModel();

        EscolaDAO escolaDAO = new EscolaDAO();
        int i = 1;
        if (tipo != 1) {
            for (Escola escola : escolaDAO.readMed(tipo)) {
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
        } else {
            for (Escola escola : escolaDAO.readMed(tipo)) {
            modelo.addRow(new Object[]{
                0,
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

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        tfSearch = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();
        cbRanking = new javax.swing.JComboBox<>();
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

        btnVoltar.setText("Voltar para o Menu");
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVoltarMousePressed(evt);
            }
        });

        btnSort.setText("Sort");
        btnSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSortMousePressed(evt);
            }
        });
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        cbRanking.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Ranking", "Ordem alfabética", "Por SAEB Anos Iniciais", "Por SAEB Anos finais", "Por SAEB Ensino Médio", "Por IDEB Anos Iniciais", "Por IDEB Anos Finais", "Por IDEB Ensino Médio" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1217, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSort, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnSort)
                    .addComponent(cbRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
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

    private void btnVoltarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMousePressed
        FrameMenu frm = new FrameMenu(ra);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        FrameRanking.this.dispose();
    }//GEN-LAST:event_btnVoltarMousePressed

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSortActionPerformed

    private void btnSortMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSortMousePressed
        int ind = cbRanking.getSelectedIndex();
        if (ind != 0) {
            DefaultTableModel dtm = (DefaultTableModel) mainTable.getModel();
            dtm.setRowCount(0);
            readJTable(cbRanking.getSelectedIndex());
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Sort!");
        }
    }//GEN-LAST:event_btnSortMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSort;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbRanking;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mainTable;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
