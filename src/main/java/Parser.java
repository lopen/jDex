import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Parser {

        // arraylist of all pokemon
        private HashMap<Long, Pokemon> allPokemon;

        /**
         * Constructor, reads json file and does stuff with it :)
         */
        public Parser() {
                allPokemon = new HashMap<Long, Pokemon>();

                JSONParser jsonParser = new JSONParser();

                // This solution needs to be fixed
                // maybe fix this later on when the application is more complete *shrug*
                String workingDir = System.getProperty("user.dir");
                try (FileReader reader = new FileReader(workingDir + "\\src\\main\\java\\pokedex.json")) {
                        // Read file
                        Object obj = jsonParser.parse(reader);

                        JSONArray pokemonList = (JSONArray) obj;

                        pokemonList.forEach( pkm -> parsePokemon( (JSONObject) pkm ) );

                } catch (ParseException e) {
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        /**
         * parsePokemon, takes data from the pokemon JSONObject and
         * uses it to create a Pokemon type, which is then added to allPokemon list.
         * @param pokemon pokemon object from JSON file
         */
        public void parsePokemon(JSONObject pokemon) {

                // pokemon id
                Long id = (Long) pokemon.get("id");

                // pokemon names
                JSONObject names = (JSONObject) pokemon.get("name");
                String english = (String) names.get("english");
                String japanese = (String) names.get("japanese");
                String chinese = (String) names.get("chinese");
                String french = (String) names.get("french");
                String[] allNames = {english, japanese, chinese, french};

                // pokemon type
                JSONArray type = (JSONArray) pokemon.get("type");
                ArrayList<String> types = new ArrayList<String>();
                for (Object o : type) {
                        types.add((String) o);
                }

                // pokemon base stats
                JSONObject base = (JSONObject) pokemon.get("base");
                Long HP = (Long) base.get("HP");
                Long Attack = (Long) base.get("Attack");
                Long Defense = (Long) base.get("Defense");
                Long SpAttack = (Long) base.get("Sp. Attack");
                Long SpDefense = (Long) base.get("Sp. Defense");
                Long Speed = (Long) base.get("Speed");
                Long[] allBase = {HP, Attack, Defense, SpAttack, SpDefense, Speed};

                // create pokemon
                Pokemon poke = new Pokemon(id, allNames, types, allBase);
                allPokemon.put(id, poke);
        }

        /**
         * getAllPokemon, getter for the allPokemon HashMap
         * @return allPokemon
         */
        public HashMap<Long, Pokemon> getAllPokemon() {
                return allPokemon;
        }
}
