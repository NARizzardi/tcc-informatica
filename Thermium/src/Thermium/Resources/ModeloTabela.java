/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thermium.Resources;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rosiv
 */
public class ModeloTabela extends AbstractTableModel {
    private ArrayList linhas = null;
    private String[] colunas = null;
    private int classeTabela = -1;

    
       
    public ModeloTabela(ArrayList linhas, String[] colunas, int classeTabela) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.classeTabela = classeTabela;
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int numColuna) {
        return colunas[numColuna];
    }

    @Override
    public Object getValueAt(int numLinha, int numColuna) {
        Object[] linha = (Object[]) getLinhas().get(numLinha);
        return linha[numColuna];
    }
    
    public int getClasseTabela() {
        return classeTabela;
    }

    public void setClasseTabela(int classeTabela) {
        this.classeTabela = classeTabela;
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    @Override
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        if(classeTabela==0){
                        return Integer.class;
                        } else if (classeTabela==1){
                            return String.class;
                        }
                    case 3:
                        return Double.class;
                    case 4:
                        return Integer.class;
                    default:
                        return String.class;
                }
            }
    
    
    
}
