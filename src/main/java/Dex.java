import java.util.HashMap;

public class Dex {

    private HashMap<Long, Pokemon> allPokemon;
    private Pokemon currentPokemon;
    private Long currentLong;

    public Dex() {
        parse();
        setCurrentPokemon(1L);
    }

    public void parse() {
        Parser parser = new Parser();
        allPokemon = parser.getAllPokemon();
    }

    public HashMap<Long, Pokemon> getAllPokemon() {
        return allPokemon;
    }

    public void setCurrentPokemon(Long current) {
        // assign the current pokemon
        currentPokemon = allPokemon.get(current);
        currentLong = current;
    }

    public Pokemon getCurrentPokemon() {
        return currentPokemon;
    }

    public Long getCurrentLong() {
        return currentLong;
    }

    public Pokemon getPreviousPokemon() {
        return allPokemon.get(getCurrentLong() - 1L);
    }

    public Pokemon getNextPokemon() {
        return allPokemon.get(getCurrentLong() + 1L);
    }

    public Pokemon searchPokemon(Long id) {
        setCurrentPokemon(id);
        return currentPokemon;
    }
}
