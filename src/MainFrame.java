import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Card Shuffle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);

        JButton btnShuffle = new JButton("Shuffle");
        btnShuffle.addActionListener(new ActionListener() { //redraw bars button
            public void actionPerformed(ActionEvent e) {

            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnShuffle);
        getContentPane().add(BorderLayout.SOUTH, btnPanel);
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}