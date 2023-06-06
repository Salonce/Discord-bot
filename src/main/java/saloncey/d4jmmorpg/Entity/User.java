package saloncey.d4jmmorpg.Entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name="users")
public class User {
    public User(){
        this.fullApTime = Instant.now();
        this.coins = 0L;
    }

    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Attributes attributes;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Equipment equipment;

    private Long coins;
    private Instant fullApTime;


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

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
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

    public Instant getFullApTime() {
        return fullApTime;
    }

    public void setFullApTime(Instant fullApTime) {
        this.fullApTime = fullApTime;
    }
}
