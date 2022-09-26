import javax.imageio.ImageWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.util.Random;

public class MainFrame extends JFrame {
    ImageIcon[] cards = new ImageIcon[52];

    public MainFrame() {

        // calling File to path method
        //FileToPath();

        setTitle("Card Shuffle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);

        String fileName;
        for(int i = 0; i < 52; i++) {
            cards[i] = new ImageIcon(new ImageIcon("PlayingCards/" + String.valueOf(i+1) + ".png").getImage().getScaledInstance(100, 145, Image.SCALE_DEFAULT));
        }
        //cards[0] = new ImageIcon(new ImageIcon("PlayingCards/2_of_clubs.png").getImage().getScaledInstance(100, 145, Image.SCALE_DEFAULT));
        //cards[1] = new ImageIcon(new ImageIcon("PlayingCards/2_of_diamonds.png").getImage().getScaledInstance(100, 145, Image.SCALE_DEFAULT));

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

    // method to try and create a path from PlayingCards file to an array
    public void FileToPath(){
        // counter
        int i = 0;
        // PlayingCards file path
        File file = new File("C:\\Users\\JrRos\\Desktop\\HERE\\PlayingCards");
        Path path =file.toPath();

        // array to store all Cards in
        JLabel allCards[] = new JLabel[52];

        // for loop to get all png location from file into array
        for (File card : file.listFiles()){
            JLabel label = new JLabel("card ");

            // attempt at making all files to imageIcons
            label.setIcon(new ImageIcon(card.toPath().toString()));

            JTextArea text = new JTextArea();
            text.setText("Add subject here...");

            allCards[i] = label;

            System.out.println(label);
            i++;




        }


    }



    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}