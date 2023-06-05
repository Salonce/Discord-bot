package saloncey.d4jmmorpg.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {
    public Item(){}
    public Item(String id){
        this.id = id;
    }

    @Id
    private String id;
    private String name;

    private int itemType;
    private int value;
    private int attack;
    private int defense;

}
