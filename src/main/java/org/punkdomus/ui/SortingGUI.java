package org.punkdomus.ui;

import org.punkdomus.base.Algorithm;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SortingGUI extends JPanel {
    private List<String> array; // Lista de strings (pode conter números ou caracteres)
    private Color[] colors;
    private Algorithm algorithm;
    private int delay; // Velocidade de execução (em milissegundos)

    /**
     * Constructor for the SortingGUI class.
     *
     * @param inputList The list of values to be sorted.
     * @param delay     The delay between steps (in milliseconds).
     */
    public SortingGUI(List<String> inputList, int delay) {
        this.delay = delay;
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);

        // Usa a lista de strings diretamente
        this.array = inputList;
        this.colors = new Color[array.size()];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = Color.BLUE; // Cor inicial das barras
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int barWidth = width / array.size();

        // Encontra o valor máximo no array (tratando strings como números ou caracteres)
        double maxValue = array.stream()
                .mapToDouble(this::getNumericValue)
                .max()
                .orElse(1.0); // Valor padrão para evitar divisão por zero

        // Define uma altura mínima para as barras (por exemplo, 10 pixels)
        int minBarHeight = 10;

        for (int i = 0; i < array.size(); i++) {
            // Calcula a altura da barra como uma proporção do valor máximo
            double value = getNumericValue(array.get(i));
            int barHeight = (int) ((value / maxValue) * (height - minBarHeight)) + minBarHeight;

            g.setColor(colors[i]);
            g.fillRect(i * barWidth, height - barHeight, barWidth - 2, barHeight);
        }
    }

    /**
     * Converte uma string em um valor numérico.
     * Se a string for um número, retorna o valor numérico.
     * Caso contrário, retorna o valor ASCII do primeiro caractere.
     *
     * @param value A string a ser convertida.
     * @return O valor numérico correspondente.
     */
    private double getNumericValue(String value) {
        try {
            return Double.parseDouble(value); // Tenta converter para número
        } catch (NumberFormatException e) {
            return value.charAt(0); // Se falhar, usa o valor ASCII do primeiro caractere
        }
    }

    public void startSorting() {
        new Thread(() -> {
            algorithm.sort(this);
            repaint();
        }).start();
    }

    public void updateArray(List<String> newList, int index1, int index2) {
        array = newList;
        colors[index1] = Color.RED;
        colors[index2] = Color.RED;
        repaint();

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        colors[index1] = Color.BLUE;
        colors[index2] = Color.BLUE;
        repaint();
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
}