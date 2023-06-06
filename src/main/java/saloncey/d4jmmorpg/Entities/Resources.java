package saloncey.d4jmmorpg.Entities;

import jakarta.persistence.*;

@Entity
public class Resources {
    public Resources(){
        this.coins = 0L;
        this.food = 0L;
        this.paintings = 0L;
    }

    private Long coins;
    private Long food;
    private Long paintings;

    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

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

    public Long getFood() {
        return food;
    }

    public void setFood(Long food) {
        this.food = food;
    }

    public Long getPaintings() {
        return paintings;
    }

    public void setPaintings(Long paintings) {
        this.paintings = paintings;
    }

    public Long getCoins() {
        return coins;
    }

    public void setCoins(Long coins) {
        this.coins = coins;
    }

    public void addCoins(Long coins) {
        this.coins += coins;
    }
}
