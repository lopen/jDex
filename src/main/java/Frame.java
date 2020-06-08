import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Frame extends JFrame{

    // Fields for main panels in frame
    private JPanel navbar;
    private JPanel infoBox;
    private String currentPkmnName = "bulb";
    private HashMap<Long, Pokemon> allPokemon;

    public Frame(HashMap<Long, Pokemon> allPokemon){
        super("Pokedex");
        this.allPokemon = allPokemon;
        makeFrame();
    }

    public void makeFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setResizable(false);

        // making the navbar
        navbar = new JPanel();
        navbar.setSize(400, 50);
        navbar.setBackground(Color.BLUE);

        // making the info box
        infoBox = new JPanel();
        infoBox.setSize(400,450);
        infoBox.setBackground(Color.RED);

        // navbar content
        JButton prevBtn = new JButton("Previous");
        prevBtn.setSize(50,50);
        JButton nextBtn = new JButton("Next");
        nextBtn.setSize(50,50);
        JLabel currentPkmn = new JLabel(currentPkmnName);
        // need to add sprite labels of the next and previous pokemon

        // info box content
        // current pokemon name and number
        // pokemon picture, large
        // stats

        // adding content to navbar
        navbar.add(prevBtn);
        navbar.add(currentPkmn);
        navbar.add(nextBtn);

        // adding content to frame
        add(navbar);
        add(infoBox);


        setVisible(true);
    }
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected ImageIcon createImageIcon(String path,
                                        String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
