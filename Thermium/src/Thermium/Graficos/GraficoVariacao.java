//https://stackoverflow.com/questions/10124079/different-color-for-different-series-in-xyline-chart-jfreechart
package Thermium.Graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;

import Thermium.ENTITY.Substancia;

public class GraficoVariacao extends JFrame {

	private JFreeChart chart;
	private XYSeries gr = null;
	private double entalpiaReagentes = 0;
	private double entalpiaProdutos = 0;
	private String reagente = "";
	private String produto = "";
	private String title;
	private List<Integer> quantidadesReagentes;
	private List<Integer> quantidadesProdutos;
	private List<Substancia> reagentes;
	private List<Substancia> produtos;

	final XYSeriesCollection data = new XYSeriesCollection();

	public GraficoVariacao(final String title, List<Integer> quantidadesReagentes, List<Substancia> reagentes,
			List<Integer> quantidadesProdutos, List<Substancia> produtos) {
		super(title);

		this.reagentes = reagentes;
		this.produtos = produtos;
		this.quantidadesProdutos = quantidadesProdutos;
		this.quantidadesReagentes = quantidadesReagentes;
		this.title = title;
		this.setIconImage(new ImageIcon(getClass().getResource("/Thermium//Resources//Images//Logo.png")).getImage());
		gerarGrafico();

	}

	private void gerarGrafico() {
		for (int i = 0; i < reagentes.size(); i++) {
			for (int j = 0; j < quantidadesReagentes.get(i); j++) {
				entalpiaReagentes += reagentes.get(i).getEntalpia();
			}
			String strReagente = quantidadesReagentes.get(i).toString() + substring(reagentes.get(i).getFormula()) + "("
					+ reagentes.get(i).getEstado() + ")";

			reagente = reagente.concat(strReagente);

			if (i != reagentes.size() - 1) {
				reagente = reagente.concat(" - ");
			}

		}

		for (int i = 0; i < produtos.size(); i++) {
			for (int j = 0; j < quantidadesProdutos.get(i); j++) {
				entalpiaProdutos += produtos.get(i).getEntalpia();
			}
			String strProduto = quantidadesProdutos.get(i).toString() + substring(produtos.get(i).getFormula()) + "("
					+ produtos.get(i).getEstado() + ")";

			produto = produto.concat(strProduto);
			if (i != produtos.size() - 1) {
				produto = produto.concat(" - ");
			}
		}

		data.addSeries(adicionarReagente());
		data.addSeries(adicionarVariacao());
		data.addSeries(adicionarProduto());

		gerarPlot(title, data);
		resizePlot();
	}

	private String substring(String string) {

		string = string.replaceAll("0", "\u2080");
		string = string.replaceAll("1", "\u2081");
		string = string.replaceAll("2", "\u2082");
		string = string.replaceAll("3", "\u2083");
		string = string.replaceAll("4", "\u2084");
		string = string.replaceAll("5", "\u2085");
		string = string.replaceAll("6", "\u2086");
		string = string.replaceAll("7", "\u2087");
		string = string.replaceAll("8", "\u2088");
		string = string.replaceAll("9", "\u2089");

		return string;
	}

	private XYSeries adicionarReagente() {

		gr = new XYSeries("Reagentes");
		gr.add(0, entalpiaReagentes);
		gr.add(10, entalpiaReagentes);
		return gr;
	}

	private XYSeries adicionarVariacao() {

		gr = new XYSeries("Variação");
		gr.add(10, entalpiaReagentes);
		gr.add(13, entalpiaProdutos);

		return gr;
	}

	private XYSeries adicionarProduto() {

		gr = new XYSeries("Produtos");
		gr.add(13, entalpiaProdutos);
		gr.add(23, entalpiaProdutos);
		return gr;
	}

	@SuppressWarnings("deprecation")
	private void gerarPlot(String title, XYSeriesCollection data2) {
		chart = ChartFactory.createXYLineChart(title, "Tempo de reação", "Níveis de entalpia", data,
				PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Color.white);
		ValueAxis domain = plot.getDomainAxis();
		domain.setVisible(false);
		domain.setRange(0, 23);

		markPlot(plot);

		plot.getRenderer().setToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance());

		plot.getRenderer().setSeriesStroke(0, new BasicStroke(2));
		plot.getRenderer().setSeriesPaint(0, Color.BLACK);
		plot.getRenderer().setSeriesStroke(1, new BasicStroke(2));
		plot.getRenderer().setSeriesPaint(1, Color.RED);
		plot.getRenderer().setSeriesStroke(2, new BasicStroke(2));
		plot.getRenderer().setSeriesPaint(2, Color.BLACK);

		ChartPanel cp = new ChartPanel(chart);

		cp.setPreferredSize(new java.awt.Dimension(1000, 540));
		setContentPane(cp);

	}

	private void markPlot(XYPlot plot) {
		Color color = new Color(0, 0, 0, 0);
		Font font = new Font("Candara", Font.PLAIN, 20);
		Font f = new Font("SansSerif", Font.PLAIN, 16);
		double variacao = entalpiaProdutos - entalpiaReagentes;
		variacao = Math.floor(variacao);
		if (entalpiaProdutos > entalpiaReagentes) {
			Marker marcadorReagentes = new ValueMarker(entalpiaReagentes);
			marcadorReagentes.setLabel(reagente);
			marcadorReagentes.setLabelFont(font);
			marcadorReagentes.setPaint(color);
			marcadorReagentes.setLabelAnchor(RectangleAnchor.TOP_LEFT);
			marcadorReagentes.setLabelTextAnchor(TextAnchor.TOP_LEFT);
			plot.addRangeMarker(marcadorReagentes);

			Marker marcadorProdutos = new ValueMarker(entalpiaProdutos);
			marcadorProdutos.setPaint(color.brighter());
			marcadorProdutos.setLabel(produto);
			marcadorProdutos.setLabelFont(font);
			marcadorProdutos.setPaint(color);
			marcadorProdutos.setLabelAnchor(RectangleAnchor.BOTTOM_RIGHT);
			marcadorProdutos.setLabelTextAnchor(TextAnchor.BOTTOM_RIGHT);
			plot.addRangeMarker(marcadorProdutos);

			Marker marcadorVariacao = new ValueMarker((entalpiaProdutos + entalpiaReagentes) / 2);
			marcadorVariacao.setLabel("▲H = " + variacao);
			marcadorVariacao.setPaint(color);
			marcadorVariacao.setLabelFont(f);
			marcadorVariacao.setLabelAnchor(RectangleAnchor.CENTER);
			marcadorVariacao.setLabelTextAnchor(TextAnchor.BASELINE_CENTER);
			plot.addRangeMarker(marcadorVariacao);

			Marker tipoReacao = new ValueMarker(getPlotSize());
			tipoReacao.setLabel("Reação Endotérmica     ");
			tipoReacao.setPaint(color);
			tipoReacao.setLabelFont(font);
			tipoReacao.setLabelAnchor(RectangleAnchor.BOTTOM_RIGHT);
			tipoReacao.setLabelTextAnchor(TextAnchor.BOTTOM_RIGHT);
			plot.addRangeMarker(tipoReacao);
		} else if (entalpiaProdutos < entalpiaReagentes) {

			Marker marcadorReagentes = new ValueMarker(entalpiaReagentes);
			marcadorReagentes.setLabel(reagente);
			marcadorReagentes.setLabelFont(font);
			marcadorReagentes.setPaint(color);
			marcadorReagentes.setLabelAnchor(RectangleAnchor.BOTTOM_LEFT);
			marcadorReagentes.setLabelTextAnchor(TextAnchor.BOTTOM_LEFT);
			plot.addRangeMarker(marcadorReagentes);

			Marker marcadorProdutos = new ValueMarker(entalpiaProdutos);
			marcadorProdutos.setPaint(color.brighter());
			marcadorProdutos.setLabel(produto);
			marcadorProdutos.setLabelFont(font);
			marcadorProdutos.setPaint(color);
			marcadorProdutos.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
			marcadorProdutos.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
			plot.addRangeMarker(marcadorProdutos);

			Marker marcadorVariacao = new ValueMarker((entalpiaReagentes + entalpiaProdutos) / 2);
			marcadorVariacao.setLabel("▲H = " + variacao);
			marcadorVariacao.setLabelFont(f);
			marcadorVariacao.setPaint(color);
			marcadorVariacao.setLabelAnchor(RectangleAnchor.CENTER);
			marcadorVariacao.setLabelTextAnchor(TextAnchor.BASELINE_CENTER);
			plot.addRangeMarker(marcadorVariacao);

			Marker tipoReacao = new ValueMarker(getPlotSize());
			tipoReacao.setLabel("Reação exotérmica     ");
			tipoReacao.setPaint(color);
			tipoReacao.setLabelFont(font);
			tipoReacao.setLabelAnchor(RectangleAnchor.BOTTOM_RIGHT);
			tipoReacao.setLabelTextAnchor(TextAnchor.BOTTOM_RIGHT);
			plot.addRangeMarker(tipoReacao);
		} else if (entalpiaProdutos == entalpiaReagentes) {
			Marker marcadorReagentes = new ValueMarker(entalpiaReagentes);
			marcadorReagentes.setLabel(reagente);
			marcadorReagentes.setLabelFont(font);
			marcadorReagentes.setPaint(color);
			marcadorReagentes.setLabelAnchor(RectangleAnchor.BOTTOM_LEFT);
			marcadorReagentes.setLabelTextAnchor(TextAnchor.BOTTOM_LEFT);
			plot.addRangeMarker(marcadorReagentes);

			Marker marcadorProdutos = new ValueMarker(entalpiaProdutos);
			marcadorProdutos.setPaint(color.brighter());
			marcadorProdutos.setLabel(produto);
			marcadorProdutos.setLabelFont(font);
			marcadorProdutos.setPaint(color);
			marcadorProdutos.setLabelAnchor(RectangleAnchor.BOTTOM_RIGHT);
			marcadorProdutos.setLabelTextAnchor(TextAnchor.BOTTOM_RIGHT);
			plot.addRangeMarker(marcadorProdutos);

			Marker marcadorVariacao = new ValueMarker((entalpiaReagentes + entalpiaProdutos) / 2);
			marcadorVariacao.setLabel("▲H = " + variacao);
			marcadorVariacao.setLabelFont(f);
			marcadorVariacao.setPaint(color);
			marcadorVariacao.setLabelAnchor(RectangleAnchor.CENTER);
			marcadorVariacao.setLabelTextAnchor(TextAnchor.BASELINE_CENTER);
			plot.addRangeMarker(marcadorVariacao);
		}

	}

	private double getPlotSize() {
		if (entalpiaProdutos != entalpiaReagentes) {
			if (entalpiaReagentes > entalpiaProdutos) {
				double distancia = (entalpiaReagentes - entalpiaProdutos) / 2;
				double endPlot = (entalpiaProdutos - distancia);
				return endPlot;
			} else {
				double distancia = (entalpiaProdutos - entalpiaReagentes) / 2;
				double endPlot = (entalpiaReagentes - distancia);
				chart.getXYPlot().getRangeAxis().setRange(entalpiaReagentes - distancia, entalpiaProdutos + distancia);
				return endPlot;
			}

		}
		return 0;

	}

	private void resizePlot() {
		if (entalpiaProdutos != entalpiaReagentes) {
			if (entalpiaReagentes > entalpiaProdutos) {
				double distancia = (entalpiaReagentes - entalpiaProdutos) / 2;
				chart.getXYPlot().getRangeAxis().setRange(entalpiaProdutos - distancia, entalpiaReagentes + distancia);
			} else {
				double distancia = (entalpiaProdutos - entalpiaReagentes) / 2;
				chart.getXYPlot().getRangeAxis().setRange(entalpiaReagentes - distancia, entalpiaProdutos + distancia);
			}
		} else {
			if (entalpiaProdutos == 0) {
				chart.getXYPlot().getRangeAxis().setRange(-10, 10);
			} else {
				chart.getXYPlot().getRangeAxis().setRange(entalpiaProdutos / 2, entalpiaProdutos * 1.5);
			}
		}

	}

	public void salvarImagem() {
		String nomeGrafico = gerarNome();
		File dir = new File("Graficos/Variacao");
		dir.mkdirs();
		File file = new File(dir, nomeGrafico + ".png");
		try {
			ChartUtilities.saveChartAsPNG(file, chart, 1000, 540);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String gerarNome() {
		String letras = "123456789";

		Random random = new Random();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String armazenaChaves = "";
		armazenaChaves = armazenaChaves.concat(dtf.format(localDate).toString());
		armazenaChaves = armazenaChaves.replaceAll("/", "");
		armazenaChaves = armazenaChaves.concat("-");

		int index = -1;
		for (int i = 0; i < 8; i++) {
			index = random.nextInt(letras.length());
			armazenaChaves += letras.substring(index, index + 1);
		}

		return armazenaChaves;
	}

}
