import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame {
    ImageIcon[] cards = new ImageIcon[52];
    JLabel[] holder = new JLabel[52];

    public MainFrame() {
        setTitle("Card Shuffle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);

        for(int i = 0; i < 52; i++) { //get images
            cards[i] = new ImageIcon(new ImageIcon("PlayingCards/" + (i+1) + ".png").getImage().getScaledInstance(100, 145, Image.SCALE_DEFAULT));
        }

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(26, 108, 14));
        getContentPane().add(BorderLayout.CENTER, mainPanel);
        mainPanel.setLayout(new GridLayout(4, 13));

        JButton btnShuffle = new JButton("Shuffle");
        btnShuffle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { //shuffle cards and update display
                cards = shuffle(cards).clone();
                for(int i = 0; i < 52; i++) {
                    holder[i].setIcon(cards[i]);
                }
                repaint();
            }
        });

        for(int i = 0; i < 52; i++) { //initialize card display
            holder[i] = new JLabel();
            holder[i].setIcon(cards[i]);
            mainPanel.add(holder[i]);
        }

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnShuffle);
        getContentPane().add(BorderLayout.SOUTH, btnPanel);
    }

    private ImageIcon[] shuffle(ImageIcon[] ar) { //shuffle card array
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