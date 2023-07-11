package Salonce.DiscordBot.Entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name="users")
public class User {
    public User(){
        this.fullApTime = Instant.now();
    }

    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Attributes attributes;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Resources resources;

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

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

    public Instant getFullApTime() {
        return fullApTime;
    }

    public void setFullApTime(Instant fullApTime) {
        this.fullApTime = fullApTime;
    }
}
