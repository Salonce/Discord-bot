package saloncey.d4jmmorpg.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Attributes attributes;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Inventory inventory;



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
