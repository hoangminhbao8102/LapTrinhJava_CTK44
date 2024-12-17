/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author 20113
 */
public class LoadingScreen extends JFrame {
    private final JProgressBar progressBar;
    private final JLabel loadingLabel;
    private final Runnable nextScreen; // Runnable để mở màn hình tiếp theo

    public LoadingScreen(Runnable nextScreen) {
        this.nextScreen = nextScreen;

        setTitle("Loading...");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Panel chính
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label loading
        loadingLabel = new JLabel("Đang tải dữ liệu...", SwingConstants.CENTER);
        loadingLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(loadingLabel, BorderLayout.NORTH);

        // Thanh tiến trình
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(66, 135, 245));
        mainPanel.add(progressBar, BorderLayout.CENTER);

        add(mainPanel);

        // Giả lập quá trình loading
        simulateLoading();
    }

    private void simulateLoading() {
        SwingWorker<Void, Integer> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(30); // Giả lập thời gian tải
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    publish(i);
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                int value = chunks.get(chunks.size() - 1);
                progressBar.setValue(value);
                loadingLabel.setText("Đang tải dữ liệu... " + value + "%");
            }

            @Override
            protected void done() {
                dispose(); // Đóng LoadingScreen
                SwingUtilities.invokeLater(nextScreen); // Chạy màn hình tiếp theo
            }
        };
        worker.execute();
    }
}
