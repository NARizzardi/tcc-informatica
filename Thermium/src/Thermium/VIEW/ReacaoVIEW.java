/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thermium.VIEW;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import org.jfree.ui.RefineryUtilities;

import Thermium.DAO.ElementoDAO;
import Thermium.DAO.SubstanciaDAO;
import Thermium.ENTITY.Substancia;
import Thermium.Graficos.GraficoPatamar;
import Thermium.Graficos.GraficoVariacao;
import Thermium.Resources.Reacao;

/**
 *
 * @author rosiv
 */
public class ReacaoVIEW extends javax.swing.JInternalFrame {

	private List<Substancia> reagentes = new ArrayList<>();
	private List<Substancia> produtos = new ArrayList<>();
	private List<Integer> quantidadesReagentes = new ArrayList<>();
	private List<Integer> quantidadesProdutos = new ArrayList<>();
	private final Reacao reacao;

	/**
	 * Creates new form SubstanciaVIEW
	 * 
	 * @param reacao
	 * @param quantidadesReagentes
	 * @param quantidadesProdutos
	 */
	public ReacaoVIEW(Reacao reacao, List<Integer> quantidadesReagentes, List<Integer> quantidadesProdutos) {
		this.reagentes.addAll(reacao.getListaReagentes());
		this.produtos.addAll(reacao.getListaProdutos());
		this.reacao = reacao;
		this.quantidadesReagentes.addAll(quantidadesReagentes);
		this.quantidadesProdutos.addAll(quantidadesProdutos);

		initComponents();
		setarLabels();
		setarListeners();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings({ "unchecked", "serial" })
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
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
        botaoVerificar = new javax.swing.JButton();
        botaoGerarGrafico = new javax.swing.JButton();
        botaoBalancear = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        botaoApresentarEntalpias = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelReagentes = new javax.swing.JLabel();
        seta = new javax.swing.JLabel();
        jLabelProdutos = new javax.swing.JLabel();
        jLabelProdutos1 = new javax.swing.JLabel();
        seta1 = new javax.swing.JLabel();
        jLabelReagentes1 = new javax.swing.JLabel();
        jLabelReagentes2 = new javax.swing.JLabel();
        seta2 = new javax.swing.JLabel();
        jLabelProdutos2 = new javax.swing.JLabel();
        jLabelEntalpiaVariacao = new javax.swing.JLabel();
        txtStatusBalanceamento = new javax.swing.JLabel();
        botaoSalvarGrafico = new javax.swing.JButton();

        setClosable(true);
        setVisible(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 51, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(870, 637));

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reação");

        botaoVerificar.setFont(new java.awt.Font("Nirmala UI", 0, 20)); // NOI18N
        botaoVerificar.setText("Verificar Balanceamento");
        botaoVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVerificarActionPerformed(evt);
            }
        });

        botaoGerarGrafico.setFont(botaoVerificar.getFont());
        botaoGerarGrafico.setText("Gerar Gráfico");
        botaoGerarGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarGraficoActionPerformed(evt);
            }
        });

        botaoBalancear.setFont(botaoVerificar.getFont());
        botaoBalancear.setText("Balancear");
        botaoBalancear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBalancearActionPerformed(evt);
            }
        });

        botaoVoltar.setFont(botaoVerificar.getFont());
        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        botaoApresentarEntalpias.setFont(botaoVerificar.getFont());
        botaoApresentarEntalpias.setText("Apresentar Entalpias");
        botaoApresentarEntalpias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoApresentarEntalpiasActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 204, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(818, 277));

        jLabelReagentes.setFont(jLabel1.getFont());
        jLabelReagentes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelReagentes.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelReagentes.setMaximumSize(jLabelReagentes.getPreferredSize());
        jLabelReagentes.setMinimumSize(jLabelReagentes.getPreferredSize());
        jLabelReagentes.setPreferredSize(new java.awt.Dimension(368, 71));

        seta.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        seta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Thermium/Resources/Images/right-arrow.png"))); // NOI18N

        jLabelProdutos.setFont(jLabel1.getFont());
        jLabelProdutos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelProdutos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelProdutos.setMaximumSize(jLabelProdutos.getPreferredSize());
        jLabelProdutos.setMinimumSize(jLabelProdutos.getPreferredSize());
        jLabelProdutos.setPreferredSize(new java.awt.Dimension(364, 81));

        jLabelProdutos1.setFont(jLabel1.getFont());
        jLabelProdutos1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelProdutos1.setMaximumSize(jLabelProdutos.getPreferredSize());
        jLabelProdutos1.setMinimumSize(jLabelProdutos.getPreferredSize());
        jLabelProdutos1.setPreferredSize(new java.awt.Dimension(364, 61));

        seta1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        seta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Thermium/Resources/Images/right-arrow.png"))); // NOI18N

        jLabelReagentes1.setFont(jLabel1.getFont());
        jLabelReagentes1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelReagentes1.setMaximumSize(jLabelReagentes.getPreferredSize());
        jLabelReagentes1.setMinimumSize(jLabelReagentes.getPreferredSize());
        jLabelReagentes1.setPreferredSize(new java.awt.Dimension(368, 71));
        jLabelReagentes1.setVisible(false);

        jLabelReagentes2.setFont(jLabel1.getFont());
        jLabelReagentes2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelReagentes2.setMaximumSize(jLabelReagentes.getPreferredSize());
        jLabelReagentes2.setMinimumSize(jLabelReagentes.getPreferredSize());
        jLabelReagentes2.setPreferredSize(new java.awt.Dimension(368, 71));

        seta2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        seta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Thermium/Resources/Images/right-arrow.png"))); // NOI18N

        jLabelProdutos2.setFont(jLabel1.getFont());
        jLabelProdutos2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelProdutos2.setMaximumSize(jLabelProdutos.getPreferredSize());
        jLabelProdutos2.setMinimumSize(jLabelProdutos.getPreferredSize());
        jLabelProdutos2.setPreferredSize(new java.awt.Dimension(364, 61));

        jLabelEntalpiaVariacao.setFont(new java.awt.Font("Nirmala UI", 0, 40)); // NOI18N
        jLabelEntalpiaVariacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEntalpiaVariacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Thermium/Resources/Images/delta.png"))); // NOI18N
        jLabelEntalpiaVariacao.setText("H =");
        jLabelEntalpiaVariacao.setToolTipText("");
        jLabelEntalpiaVariacao.setMaximumSize(jLabelReagentes.getPreferredSize());
        jLabelEntalpiaVariacao.setMinimumSize(jLabelReagentes.getPreferredSize());
        jLabelEntalpiaVariacao.setPreferredSize(new java.awt.Dimension(370, 71));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabelEntalpiaVariacao, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelReagentes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelReagentes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelReagentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(seta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seta1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelProdutos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelProdutos1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabelProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelReagentes, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(seta, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelReagentes1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seta1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProdutos1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelReagentes2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seta2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProdutos2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEntalpiaVariacao, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jLabelProdutos1.setVisible(false);
        seta1.setVisible(false);
        jLabelReagentes2.setVisible(false);
        seta2.setVisible(false);
        jLabelProdutos2.setVisible(false);
        jLabelEntalpiaVariacao.setVisible(false);

        txtStatusBalanceamento.setFont(new java.awt.Font("Nirmala UI", 0, 36)); // NOI18N
        txtStatusBalanceamento.setForeground(new java.awt.Color(255, 51, 51));
        txtStatusBalanceamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        botaoSalvarGrafico.setVisible(false);
        botaoSalvarGrafico.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        botaoSalvarGrafico.setText("Salvar Gráfico");
        botaoSalvarGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarGraficoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(337, 337, 337)
                                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoSalvarGrafico))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botaoVerificar)
                                .addGap(18, 18, 18)
                                .addComponent(botaoBalancear)
                                .addGap(18, 18, 18)
                                .addComponent(botaoGerarGrafico)
                                .addGap(18, 18, 18)
                                .addComponent(botaoApresentarEntalpias)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtStatusBalanceamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStatusBalanceamento, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoGerarGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoApresentarEntalpias, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoBalancear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoSalvarGrafico))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSalvarGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarGraficoActionPerformed
        demo.salvarImagem();
        botaoSalvarGrafico.setVisible(false);
    }//GEN-LAST:event_botaoSalvarGraficoActionPerformed

	private void botaoApresentarEntalpiasActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoApresentarEntalpiasActionPerformed
                if(verificarBalanceamento())
		setarLabelEntalpia();

	}// GEN-LAST:event_botaoApresentarEntalpiasActionPerformed

	private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoVoltarActionPerformed
		this.dispose();
	}// GEN-LAST:event_botaoVoltarActionPerformed

	private void botaoBalancearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoBalancearActionPerformed
		balancear();
	}// GEN-LAST:event_botaoBalancearActionPerformed

	private void botaoGerarGraficoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoGerarGraficoActionPerformed
		if(verificarBalanceamento()){
                plotarGrafico();
                botaoSalvarGrafico.setVisible(true);
                }
	}// GEN-LAST:event_botaoGerarGraficoActionPerformed

	private void botaoVerificarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoVerificarActionPerformed
		verificarBalanceamento();
	}// GEN-LAST:event_botaoVerificarActionPerformed

	private void plotarGrafico() {
		demo = new GraficoVariacao("Variação de Entalpia",quantidadesReagentes, reagentes, quantidadesProdutos, produtos);

		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
		demo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		

	}

	private void setarLabels() {
		String strReagentes = "";
		String strProdutos = "";

		Substancia s;
		int sizeReagentes = reagentes.size();

		for (int i = 0; i < sizeReagentes; i++) {
			s = reagentes.get(i);
			if (quantidadesReagentes.get(i) != 1) {
				strReagentes = strReagentes.concat(quantidadesReagentes.get(i).toString());
			}
			strReagentes = strReagentes.concat(setarSubscrito(s.getFormula() + "(" + s.getEstado() + ")"));
			if (i != sizeReagentes - 1) {
				strReagentes = strReagentes.concat(" + ");
			}
		}
		jLabelReagentes.setText("<html>" + strReagentes + "</html>");

		int sizeProdutos = produtos.size();

		for (int i = 0; i < sizeProdutos; i++) {
			s = produtos.get(i);
			if (quantidadesProdutos.get(i) != 1) {
				strProdutos = strProdutos.concat(quantidadesProdutos.get(i).toString());
			}
			strProdutos = strProdutos.concat(setarSubscrito(s.getFormula() + "(" + s.getEstado() + ")"));
			if (i != sizeProdutos - 1) {
				strProdutos = strProdutos.concat(" + ");
			}
		}
		jLabelProdutos.setText("<html>" + strProdutos + "</html>");

		setarLabelTamanho();

	}

	private void setarListeners() {

	}

	private void reorganizarComponentes() {

	}

	private void limparCampos() {

	}

	private String setarSubscrito(String formula) {

		if (formula.contains("1")) {
			formula = formula.replaceAll("1", "<sub>1</sub>");
		}
		if (formula.contains("2")) {
			formula = formula.replace("2", "<sub>2</sub>");
		}
		if (formula.contains("3")) {
			formula = formula.replace("3", "<sub>3</sub>");
		}
		if (formula.contains("4")) {
			formula = formula.replace("4", "<sub>4</sub>");
		}
		if (formula.contains("5")) {
			formula = formula.replace("5", "<sub>5</sub>");
		}
		if (formula.contains("6")) {
			formula = formula.replace("6", "<sub>6</sub>");
		}
		if (formula.contains("7")) {
			formula = formula.replace("7", "<sub>7</sub>");
		}
		if (formula.contains("8")) {
			formula = formula.replace("8", "<sub>8</sub>");
		}
		if (formula.contains("9")) {
			formula = formula.replace("9", "<sub>9</sub>");
		}
		return formula;
	}

	private String tirarSubscrito(String formula) {

		formula = formula.replace("<html>", "");
		formula = formula.replace("</html>", "");

		if (formula.contains("<sub>")) {
			formula = formula.replace("<sub>", "");
			formula = formula.replace("</sub>", "");
		}
		return formula;
	}

	private SubstanciaDAO sDAO = new SubstanciaDAO();
	private ElementoDAO eDAO = new ElementoDAO();
	private GraficoVariacao demo;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoApresentarEntalpias;
    private javax.swing.JButton botaoBalancear;
    private javax.swing.JButton botaoGerarGrafico;
    private javax.swing.JButton botaoSalvarGrafico;
    private javax.swing.JButton botaoVerificar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEntalpiaVariacao;
    private javax.swing.JLabel jLabelProdutos;
    private javax.swing.JLabel jLabelProdutos1;
    private javax.swing.JLabel jLabelProdutos2;
    private javax.swing.JLabel jLabelReagentes;
    private javax.swing.JLabel jLabelReagentes1;
    private javax.swing.JLabel jLabelReagentes2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel seta;
    private javax.swing.JLabel seta1;
    private javax.swing.JLabel seta2;
    private javax.swing.JLabel txtStatusBalanceamento;
    // End of variables declaration//GEN-END:variables

	private void setarLabelTamanho() {
		Font labelFontReaegente = jLabelReagentes.getFont();
		String labelTextReagente = tirarSubscrito(jLabelReagentes.getText());

		int stringWidthReagente = jLabelReagentes.getFontMetrics(labelFontReaegente).stringWidth(labelTextReagente);
		int componentWidthReagente = jLabelReagentes.getPreferredSize().width;

		// Find out how much the font can grow in width.
		double widthRatioReagente = (double) componentWidthReagente / (double) stringWidthReagente;

		int newFontSizeReagente = (int) (labelFontReaegente.getSize() * widthRatioReagente);
		int componentHeightReagente = jLabelReagentes.getPreferredSize().height;

		// Pick a new font size so it will not be larger than the height of label.
		int fontSizeToUseReagente = Math.min(newFontSizeReagente, componentHeightReagente);
		if (fontSizeToUseReagente > 48)
			fontSizeToUseReagente = 48;

		Font labelFontProduto = jLabelProdutos.getFont();
		String labelTextProduto = tirarSubscrito(jLabelProdutos.getText());

		int stringWidthProduto = jLabelProdutos.getFontMetrics(labelFontProduto).stringWidth(labelTextProduto);
		int componentWidthProduto = jLabelProdutos.getPreferredSize().width;

		// Find out how much the font can grow in width.
		double widthRatioProduto = (double) componentWidthProduto / (double) stringWidthProduto;

		int newFontSizeProduto = (int) (labelFontReaegente.getSize() * widthRatioProduto);
		int componentHeightProduto = jLabelProdutos.getPreferredSize().height;

		// Pick a new font size so it will not be larger than the height of label.
		int fontSizeToUseProduto = Math.min(newFontSizeProduto, componentHeightProduto);
		if (fontSizeToUseProduto > 48)
			fontSizeToUseProduto = 48;

		if (fontSizeToUseProduto > fontSizeToUseReagente)
			fontSizeToUseProduto = fontSizeToUseReagente;
		else if (fontSizeToUseReagente > fontSizeToUseProduto)
			fontSizeToUseReagente = fontSizeToUseProduto;

		// Set the label's font size to the newly determined size.
		jLabelReagentes.setFont(new Font(labelFontReaegente.getName(), Font.PLAIN, fontSizeToUseReagente));

		// Set the label's font size to the newly determined size.
		jLabelProdutos.setFont(new Font(labelFontReaegente.getName(), Font.PLAIN, fontSizeToUseProduto));

	}

	private void setarLabelEntalpia() {
		String passo1Reagente = "";
		String passo1Produto = "";
		String passo2Reagente = "";
		String passo2Produto = "";
		String variacaoEntalpia = null;

		Substancia s;
		int sizeReagentes = reagentes.size();
		int sizeProdutos = produtos.size();

		for (int i = 0; i < sizeReagentes; i++) {
			s = reagentes.get(i);

			String reagente = s.getEntalpia().toString();

			if (quantidadesReagentes.get(i) != 1) {
				reagente = quantidadesReagentes.get(i).toString() + "(" + reagente.concat(")");
			}
			if (i != sizeReagentes - 1) {
				reagente = reagente.concat(" + ");
			}
			passo1Reagente = passo1Reagente.concat(reagente);
		}
		jLabelReagentes1.setText(passo1Reagente); /// 1.1

		for (int i = 0; i < sizeProdutos; i++) {
			s = produtos.get(i);

			String produto = s.getEntalpia().toString();

			if (quantidadesProdutos.get(i) != 1) {
				produto = quantidadesProdutos.get(i).toString() + "(" + produto.concat(")");
			}
			if (i != sizeProdutos - 1) {
				produto = produto.concat(" + ");
			}
			passo1Produto = passo1Produto.concat(produto);
		}
		jLabelProdutos1.setText(passo1Produto); /// 1.2

		double somaReagentes = 0, somaProdutos = 0;

		for (int i = 0; i < sizeReagentes; i++) {
			s = reagentes.get(i);
			somaReagentes = somaReagentes + (quantidadesReagentes.get(i) * s.getEntalpia());
		}
		jLabelReagentes2.setText(Double.toString(somaReagentes)); /// 2.1

		for (int i = 0; i < sizeProdutos; i++) {
			s = produtos.get(i);
			somaProdutos = somaProdutos + (quantidadesProdutos.get(i) * s.getEntalpia());
		}
		jLabelProdutos2.setText(Double.toString(somaProdutos)); /// 2.2

		jLabelEntalpiaVariacao.setText("H = " + (somaProdutos - somaReagentes) + " kJ/mol");

		setarTamanhosEntalpia();

		jLabelReagentes.setVisible(true);
		seta1.setVisible(true);
		jLabelProdutos.setVisible(true);
		jLabelReagentes1.setVisible(true);
		seta2.setVisible(true);
		jLabelProdutos1.setVisible(true);
		jLabelReagentes2.setVisible(true);
		jLabelProdutos2.setVisible(true);
		jLabelEntalpiaVariacao.setVisible(true);

	}

	private void setarTamanhosEntalpia() {
		Font labelFontReaegente = jLabelReagentes1.getFont();
		String labelTextReagente = tirarSubscrito(jLabelReagentes1.getText());

		int stringWidthReagente = jLabelReagentes1.getFontMetrics(labelFontReaegente).stringWidth(labelTextReagente);
		int componentWidthReagente = jLabelReagentes1.getPreferredSize().width;

		// Find out how much the font can grow in width.
		double widthRatioReagente = (double) componentWidthReagente / (double) stringWidthReagente;

		int newFontSizeReagente = (int) (labelFontReaegente.getSize() * widthRatioReagente);
		int componentHeightReagente = jLabelReagentes1.getPreferredSize().height;

		// Pick a new font size so it will not be larger than the height of label.
		int fontSizeToUseReagente = Math.min(newFontSizeReagente, componentHeightReagente);
		if (fontSizeToUseReagente > 40)
			fontSizeToUseReagente = 40;

		Font labelFontProduto = jLabelProdutos1.getFont();
		String labelTextProduto = tirarSubscrito(jLabelProdutos1.getText());

		int stringWidthProduto = jLabelProdutos1.getFontMetrics(labelFontProduto).stringWidth(labelTextProduto);
		int componentWidthProduto = jLabelProdutos1.getPreferredSize().width;

		// Find out how much the font can grow in width.
		double widthRatioProduto = (double) componentWidthProduto / (double) stringWidthProduto;

		int newFontSizeProduto = (int) (labelFontReaegente.getSize() * widthRatioProduto);
		int componentHeightProduto = jLabelProdutos1.getPreferredSize().height;

		// Pick a new font size so it will not be larger than the height of label.
		int fontSizeToUseProduto = Math.min(newFontSizeProduto, componentHeightProduto);
		if (fontSizeToUseProduto > 40)
			fontSizeToUseProduto = 40;

		int fontSizeToUse = (fontSizeToUseProduto > fontSizeToUseReagente ? fontSizeToUseReagente
				: fontSizeToUseProduto);
		fontSizeToUse = (fontSizeToUse > jLabelReagentes.getFont().getSize() ? jLabelReagentes.getFont().getSize()
				: fontSizeToUse);

		// Set the label's font size to the newly determined size.
		jLabelReagentes1.setFont(new Font(labelFontReaegente.getName(), Font.PLAIN, fontSizeToUse));
		jLabelProdutos1.setFont(new Font(labelFontReaegente.getName(), Font.PLAIN, fontSizeToUse));
		jLabelReagentes2.setFont(new Font(labelFontReaegente.getName(), Font.PLAIN, fontSizeToUse));
		jLabelProdutos2.setFont(new Font(labelFontReaegente.getName(), Font.PLAIN, fontSizeToUse));
	}

	private boolean verificarBalanceamento() {
		boolean balanceado = true;
		List<Integer> quantidadesTotal = new ArrayList<>();
		quantidadesTotal.addAll(quantidadesReagentes);
		quantidadesTotal.addAll(quantidadesProdutos);
		double[] coeficientesBalanceados = reacao.pegarCoeficientesBalanceados();

		for (int i = 0; i < quantidadesTotal.size(); i++) {
			if (coeficientesBalanceados[i] != quantidadesTotal.get(i)) {
				balanceado = false;
				break;
			}
		}

		if (balanceado) {
			setarBalanceamentoPositivo();
			return true;

		} else {
			botaoVerificar.setEnabled(false);
			txtStatusBalanceamento.setText("Reação não balanceada!");
			botaoGerarGrafico.setEnabled(false);
			botaoApresentarEntalpias.setEnabled(false);
			return false;
		}

	}

	private void balancear() {
		double[] coeficientesBalanceados = reacao.pegarCoeficientesBalanceados();
		int cont = 0;
		for (int i = 0; i < quantidadesReagentes.size(); i++) {
			this.quantidadesReagentes.set(i, (int) coeficientesBalanceados[cont]);
			cont++;
		}

		for (int i = 0; i < quantidadesProdutos.size(); i++) {
			this.quantidadesProdutos.set(i, (int) coeficientesBalanceados[cont]);
			cont++;
		}

		setarBalanceamentoPositivo();
		setarLabels();
	}

	private void setarBalanceamentoPositivo() {
		botaoBalancear.setEnabled(false);
		botaoVerificar.setEnabled(false);
		botaoGerarGrafico.setEnabled(true);
		botaoApresentarEntalpias.setEnabled(true);
		txtStatusBalanceamento.setText("Reação balanceada");
		txtStatusBalanceamento.setForeground(new Color(0, 153, 0));
	}

}