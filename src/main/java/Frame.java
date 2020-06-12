import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class Frame extends JFrame{

    // Fields for main panels in frame
    private JPanel navbar;
    private JPanel infoBox;
    private Dex dex;
    private Icon pokeIcon;

    public Frame() throws IOException {
        super("Pokedex");
        dex = new Dex();
        makeFrame();
    }

    public void makeFrame() throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);

        // making the navbar
        navbar = new JPanel();
        navbar.setSize(400, 50);
        //navbar.setBackground(Color.BLUE);

        // making the info box
        infoBox = new JPanel();
        infoBox.setSize(400,350);
        //infoBox.setBackground(Color.RED);
        infoBox.setLayout(new GridLayout(2, 2));

        // navbar content
        JButton prevBtn = new JButton("Previous");
        prevBtn.setSize(50,50);
        JButton nextBtn = new JButton("Next");
        nextBtn.setSize(50,50);
        JLabel pokeIcon = new JLabel();
        pokeIcon.setIcon(setPokeIcon());
        JLabel currentPkmn = new JLabel(dex.getCurrentPokemon().getName());
        // add search function

        // info box content
        JLabel pokeImg = new JLabel();
        pokeImg.setIcon(setPokeImg());
        JLabel id = new JLabel(dex.getCurrentPokemon().idToString());
        JLabel names = new JLabel(dex.getCurrentPokemon().allNames());
        JLabel baseStats = new JLabel(dex.getCurrentPokemon().allStats());

        // previous and next button action listeners
        prevBtn.addActionListener(l -> {
            if (dex.getCurrentLong() != 1L) {
                dex.setCurrentPokemon(dex.getCurrentLong() - 1L);
                currentPkmn.setText(dex.getCurrentPokemon().getName());
                try {
                    pokeIcon.setIcon(setPokeIcon());
                    pokeImg.setIcon(setPokeImg());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                id.setText(dex.getCurrentPokemon().idToString());
                names.setText(dex.getCurrentPokemon().allNames());
                baseStats.setText(dex.getCurrentPokemon().allStats());
            }
        });
        nextBtn.addActionListener(l -> {
            if (!(dex.getCurrentLong() == (dex.getAllPokemon().size() - 1L))) {
                dex.setCurrentPokemon(dex.getCurrentLong() + 1L);
                currentPkmn.setText(dex.getCurrentPokemon().getName());
                try {
                    pokeIcon.setIcon(setPokeIcon());
                    pokeImg.setIcon(setPokeImg());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                id.setText(dex.getCurrentPokemon().idToString());
                names.setText(dex.getCurrentPokemon().allNames());
                baseStats.setText(dex.getCurrentPokemon().allStats());
            }
        });



        // adding content to navbar
        navbar.add(prevBtn);
        navbar.add(pokeIcon);
        navbar.add(currentPkmn);
        navbar.add(nextBtn);

        // adding content to infobox
        infoBox.add(pokeImg);
        infoBox.add(id);
        infoBox.add(names);
        infoBox.add(baseStats);

        // adding content to frame
        add(navbar);
        add(infoBox);
        
        setVisible(true);
    }

    public Icon setPokeImg() throws IOException {
        String workingDir = System.getProperty("user.dir");
        BufferedImage mainPic = ImageIO.read(new File(workingDir + "\\src\\main\\java\\thumbnails\\" + dex.getCurrentPokemon().getImageId() + ".png"));
        pokeIcon = new ImageIcon(mainPic);
        return pokeIcon;
    }

    public Icon setPokeIcon() throws IOException {
        String workingDir = System.getProperty("user.dir");
        BufferedImage mainPic = ImageIO.read(new File(workingDir + "\\src\\main\\java\\sprites\\" + dex.getCurrentPokemon().getIconId() + ".png"));
        pokeIcon = new ImageIcon(mainPic);
        return pokeIcon;
    }
}
