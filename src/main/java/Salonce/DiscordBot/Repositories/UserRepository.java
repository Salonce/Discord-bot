package Salonce.DiscordBot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Salonce.DiscordBot.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
