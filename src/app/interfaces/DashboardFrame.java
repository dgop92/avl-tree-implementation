package app.interfaces;

import java.awt.Dimension;
import java.awt.Toolkit;

import app.avltree.AVLTree;
import app.avltree.Node;
import inevaup.dialogs.InfoDialog;

import java.awt.Desktop;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class DashboardFrame extends javax.swing.JFrame {

    AVLTree avlTree;

    public DashboardFrame() {
        initComponents();
        centreWindow();

        avlTree = new AVLTree();
    }
    
    private void centreWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y - 25);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTextField_Node = new javax.swing.JTextField();
        jTextField_Delete = new javax.swing.JTextField();
        jTextField_Search = new javax.swing.JTextField();
        jButton_Insert = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        jButton_Search = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton_Web = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton_Print = new javax.swing.JButton();
        output_textarea = new javax.swing.JTextArea();

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton_Insert.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jButton_Insert.setText("Insert");
        jButton_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnInsert(evt);
            }
        });

        jButton_Delete.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jButton_Delete.setText("Delete");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnDelete(evt);
            }
        });

        jButton_Search.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jButton_Search.setText("Search");
        jButton_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnSearch(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Arbol Binario");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setText("Insertar nodo");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setText("Nodo a eliminar");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setText("Nodo a buscar");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel5.setText("Ver arbol en pagina web");

        jButton_Web.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jButton_Web.setText("WEB");
        jButton_Web.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnWeb(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel6.setText("Recorrido por niveles");

        jButton_Print.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jButton_Print.setText("Print");
        jButton_Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnTraverse(evt);
            }
        });

        output_textarea.setEditable(false);
        output_textarea.setBackground(new java.awt.Color(238, 238, 238));
        output_textarea.setColumns(20);
        output_textarea.setRows(5);
        output_textarea.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        output_textarea.setMargin(new java.awt.Insets(10, 10, 10, 10));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_Node, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Insert)
                            .addComponent(jLabel2))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jButton_Delete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_Search)
                        .addGap(62, 62, 62))))
            .addComponent(output_textarea)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton_Web)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jButton_Print)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Node, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Insert)
                    .addComponent(jButton_Delete)
                    .addComponent(jButton_Search))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Web)
                    .addComponent(jButton_Print))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(output_textarea, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void OnTraverse(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnTraverse
        if(avlTree.getRoot() == null){
            InfoDialog infoDialog = new InfoDialog(
                this,
                "Error",
                "Arbol vacio", 
                InfoDialog.TypeInfoDialog.ERROR_DIALOG
            );
            infoDialog.setVisible(true);
        }else{
            output_textarea.setText("");
            StringBuilder stringBuilder = new StringBuilder();
            avlTree.levelOrderTraversal(node -> {
                stringBuilder.append(node.data + ", ");
            });
            output_textarea.setText(stringBuilder.toString());
        }
    }//GEN-LAST:event_OnTraverse

    private void OnSearch(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnSearch
        if(isDataValid(jTextField_Search.getText())){
            int data = Integer.parseInt(jTextField_Search.getText());
            Node node = avlTree.searchNode(data);
            if (node != null){
                InfoDialog infoDialog = new InfoDialog(
                    this,
                    "Exito",
                    "El nodo encontrado tiene valor: " + node.data, 
                    InfoDialog.TypeInfoDialog.SUCCESS_DIALOG
                );
                infoDialog.setVisible(true);
            }else{
                InfoDialog infoDialog = new InfoDialog(
                    this,
                    "Info",
                    "El nodo no fue encontrado", 
                    InfoDialog.TypeInfoDialog.INFO_DIALOG
                );
                infoDialog.setVisible(true);
            }
            jTextField_Search.setText("");
        }
    }//GEN-LAST:event_OnSearch

    private void OnInsert(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnInsert
        if(isDataValid(jTextField_Node.getText())){
            int data = Integer.parseInt(jTextField_Node.getText());
            if (avlTree.searchNode(data) != null){
                InfoDialog infoDialog = new InfoDialog(
                    this,
                    "Error",
                    "Los valores ingresados deben ser unicos",
                    InfoDialog.TypeInfoDialog.ERROR_DIALOG
                );
                infoDialog.setVisible(true);
            }else{
                avlTree.insert(data);
                jTextField_Node.setText("");
            }
        }
    }//GEN-LAST:event_OnInsert

    private void OnDelete(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnDelete
        if(isDataValid(jTextField_Delete.getText())){
            int data = Integer.parseInt(jTextField_Delete.getText());
            avlTree.delete(data);
        }
    }//GEN-LAST:event_OnDelete

    private void OnWeb(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnWeb
        try {
            String link = avlTree.getLinkForVisualization();
            output_textarea.setText("");
            output_textarea.setText(link);
            openWebpage(new URL(link));
        } catch (Exception e) {
            InfoDialog infoDialog = new InfoDialog(
                this,
                "Error",
                "El arbol esta vacio",
                InfoDialog.TypeInfoDialog.ERROR_DIALOG
            );
            infoDialog.setVisible(true);
        } 
    }//GEN-LAST:event_OnWeb

    private boolean isDataValid(String rawData) {
        String errorMessage = "";
        try {
            int data = Integer.parseInt(rawData);
            if (Math.abs(data) > 100) {
                throw new Exception("Numero muy grande o pequeño");
            }
            
            return true;

        } catch (NumberFormatException e) {
            errorMessage = "Lo ingresado no es un número";
        } catch (Exception e){
            errorMessage = e.toString();
        }

        if (!errorMessage.equals("")){
            InfoDialog infoDialog = new InfoDialog(
                this,
                "Error",
                errorMessage,
                InfoDialog.TypeInfoDialog.ERROR_DIALOG
            );
            infoDialog.setVisible(true);
        }

        return false;
    }

    private boolean openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    private boolean openWebpage(URL url) {
        try {
            return openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }

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
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Insert;
    private javax.swing.JButton jButton_Print;
    private javax.swing.JButton jButton_Search;
    private javax.swing.JButton jButton_Web;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField_Delete;
    private javax.swing.JTextField jTextField_Node;
    private javax.swing.JTextField jTextField_Search;
    private javax.swing.JTextArea output_textarea;
    // End of variables declaration//GEN-END:variables
}
