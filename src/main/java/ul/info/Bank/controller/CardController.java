package ul.info.Bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ul.info.Bank.common.response.BaseResponse;
import ul.info.Bank.common.util.ResponseFactory;
import ul.info.Bank.model.dto.CardDto;
import ul.info.Bank.model.entity.Card;
import ul.info.Bank.service.CardService;

import java.time.LocalDate;
import java.util.List;

import static ul.info.Bank.common.util.ResponseFactory.*;

@RestController
public class CardController {
    @Autowired
    private CardService cardservice;

    @PostMapping("/issueCard")
    public BaseResponse<CardDto> issue(@RequestBody CardDto c) {
        return success(cardservice.saveCard(c));
    }

    @GetMapping("/getAllCard")
    public BaseResponse<List<Card>> getAll(){
        return success(cardservice.getAll());
    }

    @GetMapping("/getDetailsCard/{id}")
    public CardDto getDetails(@PathVariable("id") Long id){
        return cardservice.getCard(id);
    }

    @GetMapping("/getDetailsCard")
    public CardDto getDetails(@RequestParam String pan, @RequestParam String cvv, @RequestParam LocalDate exp){
        return cardservice.getCard(pan,cvv,exp);
    }
    //we can use post
     @DeleteMapping("/deleteCard/{id}")
     public BaseResponse<?> delete(@PathVariable("id") Long id){
        return (cardservice.deleteCard(id)) ?
                success(null) :
                fail("Card not found", "Delete-001", "Please try a different card id");
     }
     @GetMapping("/AddAmount")
     public BaseResponse<Double> AddAmount(@RequestParam Long id,@RequestParam Double amountToAdd){
         Double res = cardservice.addAmount(id, amountToAdd);
         return (res >= 0.0) ? ResponseFactory.success(res) : ResponseFactory.fail("error adding amount", "AddAmount-001", "try again later");
     }

     //TODO: Change this to base response :P
     @GetMapping("/Transfer/{id}/{pan}/{amount}")
     public Boolean transfer(@PathVariable("id") Long idFirstCard,@PathVariable("pan") String panSecondCard,@PathVariable("amount") Double amount){
         return cardservice.transfer(idFirstCard,panSecondCard,amount);
     }

}
