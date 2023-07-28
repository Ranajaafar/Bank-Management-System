package ul.info.Bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ul.info.Bank.model.entity.Card;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    Optional<Card> getCardByPan(String pan);
}
