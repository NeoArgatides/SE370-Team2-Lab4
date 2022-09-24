import javax.imageio.ImageWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame {
    ImageIcon[] cards = new ImageIcon[52];

    public MainFrame() {
        setTitle("Card Shuffle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);

        cards[0] = new ImageIcon(new ImageIcon("PlayingCards/2_of_clubs.png").getImage().getScaledInstance(100, 145, Image.SCALE_DEFAULT));
        cards[1] = new ImageIcon(new ImageIcon("PlayingCards/2_of_diamonds.png").getImage().getScaledInstance(100, 145, Image.SCALE_DEFAULT));

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(26, 108, 14));
        getContentPane().add(BorderLayout.CENTER, mainPanel);
        mainPanel.setLayout(new GridLayout(4, 13));

        JButton btnShuffle = new JButton("Shuffle");
        btnShuffle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cards = shuffle(cards).clone();
            }
        });

        for(int i = 0; i < 52; i++) {
            JLabel label = new JLabel();
            label.setIcon(cards[i]);
            mainPanel.add(label);
        }

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnShuffle);
        getContentPane().add(BorderLayout.SOUTH, btnPanel);
    }

    private ImageIcon[] shuffle(ImageIcon[] ar) {
        Random rand = new Random();

        for (int i = 0; i < ar.length; i++) {
            int randomIndexToSwap = rand.nextInt(ar.length);
            ImageIcon temp = ar[randomIndexToSwap];
            ar[randomIndexToSwap] = ar[i];
            ar[i] = temp;
        }

        return ar;
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}