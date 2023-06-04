package saloncey.d4jmmorpg.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="inventory")
public class Inventory {

    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    public Inventory(){};

    public Inventory(Long id){
        this.id = id;
    };

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
