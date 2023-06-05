package saloncey.d4jmmorpg.Entity;

import jakarta.persistence.*;

@Entity
public class Equipment {

    public Equipment(){};
    public Equipment(User user){
        this.user = user;
    }

    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    private String PrimaryHandId;
    private String SecondaryHandId;
    private String SetId;
    private String BootsId;

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

    public String getPrimaryHandId() {
        return PrimaryHandId;
    }

    public void setPrimaryHandId(String primaryHandId) {
        PrimaryHandId = primaryHandId;
    }

    public String getSecondaryHandId() {
        return SecondaryHandId;
    }

    public void setSecondaryHandId(String secondaryHandId) {
        SecondaryHandId = secondaryHandId;
    }

    public String getSetId() {
        return SetId;
    }

    public void setSetId(String setId) {
        SetId = setId;
    }

    public String getBootsId() {
        return BootsId;
    }

    public void setBootsId(String bootsId) {
        BootsId = bootsId;
    }
}
