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

    public String idToString() {
        return "ID: " + getId();
    }

    public String allNames() {
        String eng = "English: " + getNames()[0];
        String jap = "Japanese: " + getNames()[1];
        String chi = "Chinese: " + getNames()[2];
        String fre = "French: " + getNames()[3];

        return "<html><body>" + eng + "<br>" + jap + "<br>" + chi + "<br>" + fre + "</body></html>";
    }

    public String allStats() {
        String hp = "HP: " + getBase()[0];
        String att = "Attack: " + getBase()[1];
        String def = "Defense: " + getBase()[2];
        String spatt = "Sp. Attack: " + getBase()[3];
        String spdef = "Sp. Defense: " + getBase()[4];
        String speed = "Speed: " + getBase()[5];

        return "<html><body>" + hp + "<br>" + att + "<br>" + def + "<br>" + spatt + "<br>" + spdef + "<br>" + speed + "</body></html>";
    }

    public String getImageId() {
        if ((getId() + "").length() == 1) {
            return "00" + getId();
        } else if ((getId() + "").length() == 2) {
            return "0" + getId();
        } else {
            return "" + getId();
        }
    }
}
