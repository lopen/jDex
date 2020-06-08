import java.util.ArrayList;

public class Pokemon {

    // fields
    private Long id;
    private String name;
    private String[] names;
    private ArrayList<String> type;
    private Long[] base;

    // constructor
    public Pokemon(Long id, String[] names, ArrayList<String> type, Long[] base){
        this.id = id;
        this.name = names[0];
        this.names = names;
        this.type = type;
        this.base = base;
    }

    // Getters

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String[] getNames(){
        return names;
    }

    public ArrayList<String> getType(){
        return type;
    }

    public Long[] getBase(){
        return base;
    }
}
