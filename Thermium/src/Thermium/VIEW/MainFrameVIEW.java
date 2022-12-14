/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Thermium.VIEW;

import Thermium.DAO.SubstanciaDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultDesktopManager;
import javax.swing.DesktopManager;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author rosiv
 */
public class MainFrameVIEW extends javax.swing.JFrame {

	List<JInternalFrame> telas = new ArrayList<JInternalFrame>();

	/** Creates new form MainFrameVIEW */
	public MainFrameVIEW() {
		RefineryUtilities.positionFrameOnScreen(this, 0.28, 0.2);
		this.setIconImage(new ImageIcon(getClass().getResource("/Thermium//Resources//Images//Logo.png")).getImage());
		initComponents();
		this.setResizable(false);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItemSubstancias = new javax.swing.JMenuItem();
        jMenuItemElementos = new javax.swing.JMenuItem();
        jMenuReacao = new javax.swing.JMenu();
        jMenuItemInserirReacao = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(102, 51, 0)));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(842, 620));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Thermium/Resources/Images/MainViewLogo.png"))); // NOI18N

        jButton4.setText("Rea????es");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Subst??ncias");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Elementos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(217, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jMenuCadastro.setText("Cadastro");

        jMenuItemSubstancias.setText("Subst??ncias");
        jMenuItemSubstancias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSubstanciasActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemSubstancias);

        jMenuItemElementos.setText("Elementos");
        jMenuItemElementos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemElementosActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemElementos);

        jMenuBar1.add(jMenuCadastro);

        jMenuReacao.setText("Rea????o");

        jMenuItemInserirReacao.setText("Rea????o");
        jMenuItemInserirReacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInserirReacaoActionPerformed(evt);
            }
        });
        jMenuReacao.add(jMenuItemInserirReacao);

        jMenuBar1.add(jMenuReacao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
                fecharTelasAbertas();
		ElementoVIEW eView = new ElementoVIEW();
		telas.add(eView);
		jDesktopPane1.add(eView);
		eView.show();
                hideComponents();
                eView.addInternalFrameListener(new InternalFrameAdapter(){
                    public void internalFrameClosing(InternalFrameEvent e){
                        showComponents();
                    }
                });
                
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
                fecharTelasAbertas();
		SubstanciaVIEW sView = new SubstanciaVIEW();
		telas.add(sView);
		jDesktopPane1.add(sView);
		sView.show();
                hideComponents();
                sView.addInternalFrameListener(new InternalFrameAdapter(){
                    public void internalFrameClosing(InternalFrameEvent e){
                        showComponents();
                    }
                });

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                fecharTelasAbertas();
		InsercaoReacaoVIEW irView = new InsercaoReacaoVIEW(this);
		telas.add(irView);
		jDesktopPane1.add(irView);
		irView.show();
                hideComponents();
                irView.addInternalFrameListener(new InternalFrameAdapter(){
                    public void internalFrameClosing(InternalFrameEvent e){
                        showComponents();
                    }
                });
    }//GEN-LAST:event_jButton4ActionPerformed

	private void jMenuItemSubstanciasActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItemSubstanciasActionPerformed
		fecharTelasAbertas();
		SubstanciaVIEW sView = new SubstanciaVIEW();
		telas.add(sView);
		jDesktopPane1.add(sView);
		sView.show();
                hideComponents();
                sView.addInternalFrameListener(new InternalFrameAdapter(){
                    public void internalFrameClosing(InternalFrameEvent e){
                        showComponents();
                    }
                });
	}// GEN-LAST:event_jMenuItemSubstanciasActionPerformed

	private void jMenuItemElementosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItemElementosActionPerformed
		fecharTelasAbertas();
		ElementoVIEW eView = new ElementoVIEW();
		telas.add(eView);
		jDesktopPane1.add(eView);
		eView.show();
                hideComponents();
                eView.addInternalFrameListener(new InternalFrameAdapter(){
                    public void internalFrameClosing(InternalFrameEvent e){
                        showComponents();
                    }
                });
                
                
	}// GEN-LAST:event_jMenuItemElementosActionPerformed

	private void jMenuItemInserirReacaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItemInserirReacaoActionPerformed
		// TODO add your handling code here:
		fecharTelasAbertas();
		InsercaoReacaoVIEW irView = new InsercaoReacaoVIEW(this);
		telas.add(irView);
		jDesktopPane1.add(irView);
		irView.show();
                hideComponents();
                irView.addInternalFrameListener(new InternalFrameAdapter(){
                    public void internalFrameClosing(InternalFrameEvent e){
                        showComponents();
                    }
                });
	}// GEN-LAST:event_jMenuItemInserirReacaoActionPerformed

	public void mostrarTelaReacao(ReacaoVIEW reacaoView) {
		telas.add(reacaoView);
		jDesktopPane1.add(reacaoView);
		reacaoView.show();
		reacaoView.toFront();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainFrameVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFrameVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFrameVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFrameVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrameVIEW().setVisible(true);
			}
		});
	}

	@Override
	public void setIconImage(Image image) {
		super.setIconImage(image); // To change body of generated methods, choose Tools | Templates.
	}

	private JInternalFrame internalFrameAberto = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    public javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuItemElementos;
    private javax.swing.JMenuItem jMenuItemInserirReacao;
    private javax.swing.JMenuItem jMenuItemSubstancias;
    private javax.swing.JMenu jMenuReacao;
    // End of variables declaration//GEN-END:variables

	private void fecharTelasAbertas() {
		for (JInternalFrame tela : telas) {
			tela.doDefaultCloseAction();
		}
	}

    private void hideComponents() {
        jButton4.setVisible(false);
        jButton5.setVisible(false);
        jButton6.setVisible(false);
        jLabel2.setVisible(false);  
//To change body of generated methods, choose Tools | Templates.
    }
    
    private void showComponents(){
        jButton4.setVisible(true);
        jButton5.setVisible(true);
        jButton6.setVisible(true);
        jLabel2.setVisible(true); 
    }

}
