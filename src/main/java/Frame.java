import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Frame extends JFrame{

    // Fields for main panels in frame
    private JPanel navbar;
    private JPanel infoBox;
    private Dex dex;

    public Frame(){
        super("Pokedex");
        dex = new Dex();
        makeFrame();
    }

    public void makeFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);

        // making the navbar
        navbar = new JPanel();
        navbar.setSize(600, 50);
        navbar.setBackground(Color.BLUE);

        // making the info box
        infoBox = new JPanel();
        infoBox.setSize(600,350);
        infoBox.setBackground(Color.RED);
        infoBox.setLayout(new GridLayout());

        // navbar content
        JButton prevBtn = new JButton("Previous");
        prevBtn.setSize(50,50);
        JButton nextBtn = new JButton("Next");
        nextBtn.setSize(50,50);
        JLabel currentPkmn = new JLabel(dex.getCurrentPokemon().getName());
        // need to add sprite labels of the next and previous pokemon

        // info box content
        // current pokemon name and number
        // pokemon picture, large
        // stats
        JLabel englishName = currentPkmn;
        JLabel otherNames = new JLabel(dex.getCurrentPokemon().allNamesToString());

        // previous and next button action listeners
        prevBtn.addActionListener(l -> {
            if (dex.getCurrentLong() != 1L) {
                dex.setCurrentPokemon(dex.getCurrentLong() - 1L);
                currentPkmn.setText(dex.getCurrentPokemon().getName());
                otherNames.setText(dex.getCurrentPokemon().allNamesToString());
            }
        });
        nextBtn.addActionListener(l -> {
            if (!(dex.getCurrentLong() == (dex.getAllPokemon().size() - 1L))) {
                dex.setCurrentPokemon(dex.getCurrentLong() + 1L);
                currentPkmn.setText(dex.getCurrentPokemon().getName());
                otherNames.setText(dex.getCurrentPokemon().allNamesToString());
            }
        });



        // adding content to navbar
        navbar.add(prevBtn);
        navbar.add(currentPkmn);
        navbar.add(nextBtn);

        // adding content to infobox

        infoBox.add(otherNames);

        // adding content to frame
        add(navbar);
        add(infoBox);


        setVisible(true);
    }
}
