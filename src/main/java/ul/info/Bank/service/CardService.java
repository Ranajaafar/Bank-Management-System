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



    //get all card in the database
    public List<Card> getAll() {
        return cardRep.findAll();
    }



    //get card with specific id
    public CardDto getCard(Long id) {
        Optional<Card> c = this.cardRep.findById(id);

        if (c.isPresent()) {
            Card d = c.get();
            return new CardDto(d.getId(), d.getPan(), d.getCvv(), d.getEx_date(), d.getCurrency(), d.getAmount());
        }
        return new CardDto();
    }

    //get card that has specific pan,cvv,exp
    public CardDto getCard(String pan, String cvv, LocalDate exp) {
        CardDto ca=new CardDto(),cb=new CardDto();
        ca.setPan(pan); ca.setCvv(cvv); ca.setExDate(exp);
        List<Card> cards = cardRep.findAll();
        return cards.stream()
                .filter(card -> {CardDto.toDto(card,cb); return ca.equals(cb); })
                .map(c -> new CardDto(c.getId(), c.getPan(), c.getCvv(), c.getEx_date(), c.getCurrency(), c.getAmount()))
                .findFirst().orElse(new CardDto());
    }

    //create a new card
    public CardDto saveCard(CardDto ex) {
        Card c = new Card(ex.getPan(), ex.getCvv(), ex.getExDate(), ex.getCurrency(), ex.getAmount());
        cardRep.save(c);
        ex.setId(c.getId());
        return ex;
    }

    //delete card that has specific id
    public Boolean deleteCard(Long id) {
        Optional<Card> c = this.cardRep.findById(id);
        if (c.isPresent()) {
            this.cardRep.deleteById(id);
            return true;
        }
        return false; //return false if the card with specific id doesn't exist
    }


   //add amount to a specific card
    public Double addAmount(Long id, Double amount) { //amount can be negative
        Optional<Card> c = this.cardRep.findById(id);
        if (c.isPresent()) {
            Card d = c.get();
            if ((d.getAmount() + amount) >= 0) {
                d.setAmount(d.getAmount() + amount);
                cardRep.save(d);
                return d.getAmount();
            }
        }
        return -1.0;  //return -1 if the card with specific id doesn't exist or (if the amount <0 and there isn't enough money in the card)
    }



    //Transfer money between 2 cards from first card to the second
    public Boolean transfer(Long id_first_card, String pan_second_card, Double amount) {
        if (amount < 0) return false;
        Optional<Card> cardByPan = cardRep.getCardByPan(pan_second_card);
        if (cardByPan.isPresent()) {
            Card To = cardByPan.get();
            Optional<Card> cardById = cardRep.findById(id_first_card);
            if (cardById.isPresent()) {
                Card from = cardById.get();
                if ((from.getCurrency()).equals(To.getCurrency())) {
                    if (addAmount(id_first_card, amount * -1) != -1.0) {
                        addAmount(To.getId(), amount);
                        return true;
                    }
                }
            }
        }
        return false; //return false if one of the card doesn't exist or there isn't enough money in the first card or the 2 cards do not have the same currency(USD par example)
    }
}