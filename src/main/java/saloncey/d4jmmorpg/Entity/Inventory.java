package saloncey.d4jmmorpg.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long itemA;
    private Long itemB;

    public Long getItemA() {
        return itemA;
    }

    public void setItemA(Long itemA) {
        this.itemA = itemA;
    }

    public Long getItemB() {
        return itemB;
    }

    public void setItemB(Long itemB) {
        this.itemB = itemB;
    }
}
