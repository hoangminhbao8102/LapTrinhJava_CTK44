/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

/**
 *
 * @author 20113
 */
public class StatsFrame extends JFrame {
    public StatsFrame() {
        setTitle("Thống Kê Sách");
        setSize(800, 600);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Sách", "Văn học");
        dataset.addValue(15, "Sách", "Khoa học");
        dataset.addValue(5, "Sách", "Thiếu nhi");

        JFreeChart chart = ChartFactory.createBarChart(
                "Thống kê số lượng sách",
                "Thể loại",
                "Số lượng",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}