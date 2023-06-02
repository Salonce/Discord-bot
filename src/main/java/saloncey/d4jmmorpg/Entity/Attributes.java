package saloncey.d4jmmorpg.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="attributes")
public class Attributes {

    public Attributes(){};

    @Id
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Attributes(Long id){
        this.endurance = 1L;
        this.intelligence = 1L;
        this.wisdom = 1L;
        this.strength = 1L;
        this.dexterity = 1L;
        this.charisma = 1L;

        this.id = id;
    }

    private Long endurance;
    private Long intelligence;
    private Long wisdom;
    private Long strength;
    private Long dexterity;
    private Long charisma;


    public Long getEndurance() {
        return endurance;
    }

    public void setEndurance(Long endurance) {
        this.endurance = endurance;
    }

    public Long getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Long intelligence) {
        this.intelligence = intelligence;
    }

    public Long getWisdom() {
        return wisdom;
    }

    public void setWisdom(Long wisdom) {
        this.wisdom = wisdom;
    }

    public Long getStrength() {
        return strength;
    }

    public void setStrength(Long strength) {
        this.strength = strength;
    }

    public Long getDexterity() {
        return dexterity;
    }

    public void setDexterity(Long dexterity) {
        this.dexterity = dexterity;
    }

    public Long getCharisma() {
        return charisma;
    }

    public void setCharisma(Long charisma) {
        this.charisma = charisma;
    }

    public void increaseEndurance(Long number){
        this.endurance = this.endurance + number;
    }
    public void increaseIntelligence(Long number){
        this.intelligence = this.intelligence + number;
    };
    public void increaseWisdom(Long number){
        this.wisdom = this.wisdom + number;
    };
    public void increaseStrength(Long number){
        this.strength = this.strength + number;
    };
    public void increaseDexterity(Long number){
        this.dexterity = this.dexterity + number;
    };
    public void increaseCharisma(Long number){
        this.charisma = this.charisma + number;
    };

    @OneToOne(mappedBy = "attributes")
    private User user;

}
