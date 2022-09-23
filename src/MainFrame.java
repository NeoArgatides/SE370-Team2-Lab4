import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Card Shuffle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}