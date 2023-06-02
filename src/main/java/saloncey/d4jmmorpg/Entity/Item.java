package saloncey.d4jmmorpg.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}