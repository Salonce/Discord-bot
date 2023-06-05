package saloncey.d4jmmorpg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saloncey.d4jmmorpg.Entity.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
