/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thermium.VIEW;

import Thermium.Resources.JTextFieldLimit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JOptionPane;

import Thermium.ENTITY.Elemento;
import Thermium.DAO.ElementoDAO;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.InputMismatchException;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import Thermium.Resources.TextoParentese;
import Thermium.Resources.ModeloTabela;
import Thermium.ENTITY.SubstanciaElemento;
import Thermium.DAO.SubstanciaElementoDAO;

/**
 *
 * @author rosiv
 */
public class ElementoVIEW extends javax.swing.JInternalFrame {

	/**
	 * Creates new form SubstanciaVIEW
	 */
	public ElementoVIEW() {
		initComponents();
		setarListeners();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){

            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                Graphics2D g2d = (Graphics2D) grphcs;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0,
                    getBackground().brighter().brighter(), 0, getHeight(),
                    getBackground().darker().darker());
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());

            }

        };
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSimbolo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNumAtomico = new javax.swing.JTextField();
        botaoLimpar = new javax.swing.JButton();
        botaoInserir = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botaoAlterar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 51, 0)));

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerenciamento de Elementos");

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Nome");

        jLabel7.setFont(jLabel6.getFont());
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Símbolo");

        txtSimbolo.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N

        jLabel8.setFont(jLabel6.getFont());
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Número atômico");

        txtNumAtomico.setFont(txtSimbolo.getFont());

        botaoLimpar.setFont(jLabel6.getFont());
        botaoLimpar.setText("Limpar");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        botaoInserir.setBackground(botaoLimpar.getBackground());
        botaoInserir.setFont(botaoLimpar.getFont());
        botaoInserir.setText("Inserir");
        botaoInserir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInserirActionPerformed(evt);
            }
        });

        txtNome.setFont(txtSimbolo.getFont());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(txtSimbolo.getFont());
        jTable1.setGridColor(botaoLimpar.getBackground());
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);
        preencherTabela();

        jTable1.getTableHeader().setReorderingAllowed(false);

        botaoAlterar.setVisible(false);
        botaoAlterar.setBackground(botaoLimpar.getBackground());
        botaoAlterar.setFont(botaoLimpar.getFont());
        botaoAlterar.setText("Alterar");
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });

        botaoCancelar.setVisible(false);
        botaoCancelar.setBackground(botaoAlterar.getBackground());
        botaoCancelar.setFont(botaoAlterar.getFont());
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoExcluir.setVisible(false);
        botaoExcluir.setBackground(botaoAlterar.getBackground());
        botaoExcluir.setFont(botaoAlterar.getFont());
        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtSimbolo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumAtomico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(botaoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSimbolo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNumAtomico, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        txtNome.setDocument
        (new JTextFieldLimit(4));
        txtNumAtomico.setDocument (new JTextFieldLimit(9));
        txtNome.setDocument
        (new JTextFieldLimit(30));

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

    
	private void preencherTabela() {
		String[] colunas = new String[] { "Nome", "Símbolo", "Número Atômico"};

		ArrayList dados = new ArrayList();

		List<Elemento> elementos = eDAO.getList();
                

		for (Elemento e : elementos) {
			dados.add(
					new Object[] { e.getNome(), e.getSimbolo(), e.getNumeroAtomico()});
		}

		ModeloTabela modelo = new ModeloTabela(dados, colunas, 0);
                
		jTable1.setModel(modelo);
                
                //Alinha numeros para a esqueda (tava bugado)
                DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
                leftRenderer.setHorizontalAlignment(JLabel.LEFT);
                jTable1.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);

		// JOptionPane.showMessageDialog(null, jTable1.getModel().getValueAt(0, 4));

	}

	private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoAlterarActionPerformed
		int op = JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja alterar esse Elemento?",
				"Alteração", JOptionPane.YES_NO_OPTION);

		if (op == 0) {
			Elemento e = eDAO.encontrar(selectedNumAtomico);

			String nome = pegarNome();
			if (nome == null)
				return;

			e.setNome(nome);
			

			eDAO.atualizar(e);
			preencherTabela();
			limparCampos();
			reorganizarComponentes();
		}

	}// GEN-LAST:event_botaoAlterarActionPerformed

	private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoCancelarActionPerformed
		limparCampos();
		reorganizarComponentes();
	}// GEN-LAST:event_botaoCancelarActionPerformed

	private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoExcluirActionPerformed
            
                
		Elemento e = eDAO.encontrar(selectedNumAtomico);

		int op = JOptionPane.showConfirmDialog(rootPane,
				"Excluir esse elemento (" + e.getNome() + ") excluirá também todas as substâncias ligadas a ele. Você tem certeza da sua ação?", "Exclusão",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

		if (op == 0) {
			eDAO.remover(e);
			preencherTabela();
			limparCampos();
			reorganizarComponentes();
		}
	}// GEN-LAST:event_botaoExcluirActionPerformed

	private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoLimparActionPerformed
		limparCampos();
	}// GEN-LAST:event_botaoLimparActionPerformed

	private void botaoInserirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoInserirActionPerformed
		String nome = pegarNome();
		if (nome == null)
			return;

		String simbolo = pegarSimbolo();
		if (simbolo == null)
			return;

		int numAtomico = pegarNumAtomico();
		if (numAtomico == -1)
			return;

	
                if (eDAO.pesquisarSimbolo(simbolo) != null) {
                        JOptionPane.showMessageDialog(rootPane, "Um elemento com esse símbolo já foi cadastrado.", "Erro",
                                        JOptionPane.ERROR_MESSAGE);
                        return;
                } else if (eDAO.encontrar(numAtomico) != null){
                    JOptionPane.showMessageDialog(rootPane, "Um elemento com esse número atômico já foi cadastrado.", "Erro",
                                        JOptionPane.ERROR_MESSAGE);
                        return;
                }
                
                Elemento elemento = new Elemento(nome, numAtomico, simbolo);
                
                eDAO.salvar(elemento);
                
                JOptionPane.showMessageDialog(rootPane, "Cadastro de elemento realizado!", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                preencherTabela();
                limparCampos();
	}// GEN-LAST:event_botaoInserirActionPerformed



	private String pegarNome() {
		String nome = txtNome.getText();
		if (!verificarStringObrigatoria(nome)) {
			JOptionPane.showMessageDialog(rootPane, "Insira o nome do elemento!", "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		} else {
			return nome;
		}
	}

	private String pegarSimbolo() {
		String simbolo = txtSimbolo.getText();
		if (!verificarStringObrigatoria(simbolo)) {
			JOptionPane.showMessageDialog(rootPane, "Insira o Símbolo!", "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		} else if(!Character.isUpperCase(simbolo.charAt(0))){
                        JOptionPane.showMessageDialog(rootPane, "O símbolo deve começar com letra maiúscula!", "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
                }else {
                    if(simbolo.contains(" ")){
                        JOptionPane.showMessageDialog(rootPane, "Retire os caracteres de espaço do campo 'Símbolo'.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return null;
                    }
                        String vetor = simbolo.substring(1);
                        for(char c : vetor.toCharArray()){
                            if (!Character.isLowerCase(c)){
                                JOptionPane.showMessageDialog(rootPane, "O símbolo deve ser composto de letras e ter apenas a primeira letra maiúscula!", "Erro", JOptionPane.ERROR_MESSAGE);
                                return null;
                            }
                        }
			return simbolo;
		}
	}

	

	private int pegarNumAtomico() {
            return converterIntPositiva(txtNumAtomico.getText(), "Numero Atômico");
	}
        
        public int converterIntPositiva(String valor, String tipo) {
		int num;

		try {
			num = Integer.parseInt(valor);

			if (num <= 0) {
				JOptionPane.showMessageDialog(rootPane, "O " + tipo + " deve ser um valor positivo!", "Erro",
					JOptionPane.ERROR_MESSAGE);
				num = -1;
			}

		} catch (java.lang.NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane, "Informe um valor numérico inteiro válido para " + "'" + tipo + "'.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			num = -1;
		}

		return num;
	}

	

	

	private void setarListeners() {
		txtNome.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(final FocusEvent pE) {
			}

			@Override
			public void focusGained(final FocusEvent pE) {
				txtNome.selectAll();
			}
		});

		txtNumAtomico.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(final FocusEvent pE) {
			}

			@Override
			public void focusGained(final FocusEvent pE) {
				txtNumAtomico.selectAll();
			}
		});

		txtSimbolo.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(final FocusEvent pE) {
			}

			@Override
			public void focusGained(final FocusEvent pE) {
				txtSimbolo.selectAll();
			}
		});

		jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (jTable1.getSelectedRow() > -1) {
					int linha = jTable1.getSelectedRow();
					txtNome.setText(jTable1.getValueAt(linha, jTable1.getColumn("Nome").getModelIndex()).toString());
					txtSimbolo.setText(jTable1.getValueAt(linha, jTable1.getColumn("Símbolo").getModelIndex()).toString());
                                        txtNumAtomico.setText(jTable1.getValueAt(linha, jTable1.getColumn("Número Atômico").getModelIndex()).toString());
					
					selectedNumAtomico = Integer.parseInt(txtNumAtomico.getText());

					botaoAlterar.setVisible(true);
                                        botaoCancelar.setVisible(true);
                                        botaoInserir.setEnabled(false);
					botaoLimpar.setEnabled(false);
                                        txtNumAtomico.setEnabled(false);
					txtSimbolo.setEnabled(false);
					                                    
                                        if(selectedNumAtomico >= 1 && selectedNumAtomico <=118){
                                            botaoExcluir.setEnabled(false);
                                        }else{
                                            botaoExcluir.setEnabled(true);
                                        }
                                        botaoExcluir.setVisible(true);
                                        
                                       
                                        
                                        

				}
			}
		});
	}

	private void reorganizarComponentes() {
		botaoAlterar.setVisible(false);
		botaoExcluir.setVisible(false);
		botaoCancelar.setVisible(false);
		botaoInserir.setEnabled(true);
		botaoLimpar.setEnabled(true);
                txtNumAtomico.setEnabled(true);
		txtSimbolo.setEnabled(true);
	}

	private void limparCampos() {
		txtNome.setText("");
		txtSimbolo.setText("");
		txtNumAtomico.setText("");
	}

	

	public boolean verificarStringObrigatoria(String str) {
		if (str.isEmpty()) {
			return false;
		} else
			return true;
	}

	private ElementoDAO eDAO = new ElementoDAO();
	private int selectedNumAtomico = -1;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAlterar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoInserir;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumAtomico;
    private javax.swing.JTextField txtSimbolo;
    // End of variables declaration//GEN-END:variables




   

}
