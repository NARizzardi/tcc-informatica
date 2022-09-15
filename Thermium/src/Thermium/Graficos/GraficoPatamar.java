package Thermium.Graficos;

import java.awt.BasicStroke;
import java.awt.Color;
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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Thermium.ENTITY.Substancia;

public class GraficoPatamar extends JFrame {

	private List<Substancia> substancias;
	private JFreeChart chart;

	public GraficoPatamar(final String title, List<Substancia> substancias) {
		super(title);

		this.substancias = substancias;
		this.setIconImage(new ImageIcon(getClass().getResource("/Thermium//Resources//Images//Logo.png")).getImage());

		final XYSeriesCollection data = new XYSeriesCollection();
		for (int i = 0; i < substancias.size(); i++) {
			Substancia s = substancias.get(i);
			data.addSeries(adicionarLinha(s));

		}

		gerarPlot(title, data);
		if (data.getSeriesCount() != 1) {
			resizePlot();
		} else {
			resizePlotOneSeries();
		}
	}

	private XYSeries adicionarLinha(Substancia s) {

		XYSeries gr = null;

		gr = new XYSeries(s.getFormula() + "(" + s.getEstado() + ")");
		gr.add(0, s.getEntalpia());
		gr.add(1, s.getEntalpia());

		return gr;
	}

	private void resizePlot() {
		double menor = pegarMaiorEntalpia();
		double maior = pegarMenorEntalpia();
		if (maior != menor) {
			double distancia = (maior - menor) / 2;
			chart.getXYPlot().getRangeAxis().setRange(menor - distancia, maior + distancia);
		} else {
			if (maior == 0) {
				chart.getXYPlot().getRangeAxis().setRange(-10, 10);
			} else {
				chart.getXYPlot().getRangeAxis().setRange(menor / 2, maior * 1.5);
			}
		}
	}

	private void resizePlotOneSeries() {
		double valor = pegarMaiorEntalpia();
		if (valor > 0) {
			chart.getXYPlot().getRangeAxis().setRange(valor / 2, valor * 1.5);
		} else if (valor == 0) {
			chart.getXYPlot().getRangeAxis().setRange(-10, 10);
		} else {
			chart.getXYPlot().getRangeAxis().setRange(valor * 1.5, valor / 2);
		}

	}

	private double pegarMenorEntalpia() {
		Substancia s = substancias.get(0);
		double entalpia = s.getEntalpia();
		for (int i = 0; i < substancias.size(); i++) {
			s = substancias.get(i);
			if (entalpia < s.getEntalpia()) {
				entalpia = s.getEntalpia();
			}

		}
		return entalpia;
	}

	private double pegarMaiorEntalpia() {
		Substancia s = substancias.get(0);
		double entalpia = s.getEntalpia();
		for (int i = 0; i < substancias.size(); i++) {
			s = substancias.get(i);
			if (entalpia > s.getEntalpia()) {
				entalpia = s.getEntalpia();
			}

		}
		return entalpia;
	}

	@SuppressWarnings("deprecation")
	private void gerarPlot(String title, XYSeriesCollection data) {

		chart = ChartFactory.createXYLineChart(title, null, "Níveis de entalpia", data, PlotOrientation.VERTICAL, true,
				true, false);

		XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Color.white);

		ValueAxis domain = plot.getDomainAxis();
		domain.setVisible(false);
		domain.setRange(0, 15);

		plot.getRenderer().setToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance());
		engrossarLinha(plot);

		ChartPanel cp = new ChartPanel(chart);
		cp.setPreferredSize(new java.awt.Dimension(1000, 540));
		setContentPane(cp);

		
	}


	private void engrossarLinha(XYPlot plot) {
		for (int i = 0; i < plot.getSeriesCount(); i++) {
			plot.getRenderer().setSeriesStroke(i, new BasicStroke(2));
		}

	}

	public void salvarImagem() {
		String nomeGrafico = gerarNome();
		File dir = new File("Graficos/Patamar");
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
		for (int i = 0; i < 6; i++) {
			index = random.nextInt(letras.length());
			armazenaChaves += letras.substring(index, index + 1);
		}

		return armazenaChaves;
	}

}