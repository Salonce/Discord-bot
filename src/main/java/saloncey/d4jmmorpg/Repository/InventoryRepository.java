package saloncey.d4jmmorpg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saloncey.d4jmmorpg.Entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
