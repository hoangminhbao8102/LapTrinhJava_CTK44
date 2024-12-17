/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author 20113
 */
public class ChartUtils {
    public static JFreeChart createBookChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Số lượng", "Văn học");
        dataset.addValue(5, "Số lượng", "Khoa học");

        return ChartFactory.createBarChart(
                "Thống kê sách",
                "Thể loại",
                "Số lượng",
                dataset
        );
    }
}
