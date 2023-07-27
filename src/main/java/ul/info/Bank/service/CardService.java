package ul.info.Bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ul.info.Bank.model.dto.CardDto;
import ul.info.Bank.model.entity.Card;
import ul.info.Bank.repository.CardRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRep;

    public List<Card> getAll() {
        return cardRep.findAll();
    }

    public CardDto getCard(Long id) {
        Optional<Card> c = this.cardRep.findById(id);

        if (c.isPresent()) {
            Card d = c.get();
            return new CardDto(d.getId(), d.getPan(), d.getCvv(), d.getEx_date(), d.getCurrency(), d.getAmount());
        } else
            return new CardDto();
    }

    public CardDto getCard(String pan, String cvv, LocalDate exp) {
        List<Card> cards = cardRep.findAll();
        return cards.stream()
                .filter(card -> card.getPan().equals(pan) && card.getCvv().equals(cvv) && card.getEx_date().equals(exp))
                .map(c -> new CardDto(c.getId(), c.getPan(), c.getCvv(), c.getEx_date(), c.getCurrency(), c.getAmount()))
                .findFirst().orElse(new CardDto());
    }

    public CardDto saveCard(CardDto ex) {
        Card c = new Card(ex.getPan(), ex.getCvv(), ex.getExDate(), ex.getCurrency(), ex.getAmount());
        cardRep.save(c);
        ex.setId(c.getId());
        return ex;
    }

    public Boolean deleteCard(Long id) {
        Optional<Card> c = this.cardRep.findById(id);
        if (c.isPresent()) {
            this.cardRep.deleteById(id);
            return true;
        } else
            return false;
    }

    public Double addAmount(Long id, Double amount) {
        Optional<Card> c = this.cardRep.findById(id);
        if (c.isPresent()) {
            Card d = c.get();
            if ((d.getAmount() + amount) >= 0) {
                d.setAmount(d.getAmount() + amount);
                cardRep.save(d);
                return d.getAmount();
            }
        }
        return -1.0;
    }

    public Boolean transfer(Long id_first_card, String pan_second_card, Double amount) {
        if (amount < 0) return false;
        Optional<Card> cardByPan = cardRep.getCardByPan(pan_second_card);
        if (cardByPan.isPresent()) {
            Card c1 = cardByPan.get();
            Card from = this.cardRep.findById(id_first_card).get();
            if (from.getCurrency().equals(c1.getCurrency())) {
                if (addAmount(id_first_card, amount * -1) != -1.0) {
                    addAmount(c1.getId(), amount);
                    return true;
                }
            }
        }
        return false;
    }
}