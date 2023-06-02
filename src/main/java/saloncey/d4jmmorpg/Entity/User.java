package saloncey.d4jmmorpg.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attributes_id", referencedColumnName = "id")
    private Attributes attributes;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
}
