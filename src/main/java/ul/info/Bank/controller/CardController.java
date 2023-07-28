package ul.info.Bank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ul.info.Bank.common.response.BaseResponse;
import ul.info.Bank.common.util.ResponseFactory;
import ul.info.Bank.model.dto.CardDto;
import ul.info.Bank.model.entity.Card;
import ul.info.Bank.payload.request.AddAmountRequest;
import ul.info.Bank.payload.request.GetCardDetailsRequest;
import ul.info.Bank.payload.request.TransferRequest;
import ul.info.Bank.service.CardService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CardController {

    private final CardService cardservice;
    private final ResponseFactory rf = ResponseFactory.getInstance();


    //The user should be able to issue a card by sending all the card details through an API. The cards should be stored in the database.
    @PostMapping("/issue-card")
    public BaseResponse<CardDto> issue(@RequestBody CardDto request) {
        return rf.success(cardservice.saveCard(request));
    }



    @GetMapping("/get-all-cards")
    public BaseResponse<List<Card>> getAll(){
        return rf.success(cardservice.getAll());
    }





    //User can get a card by sending a get request with the card id, Only retrieve the card details when this is met
    @GetMapping("/get-card-details/{id}")
    public BaseResponse<CardDto> getDetails(@PathVariable("id") Long id){
        CardDto card=cardservice.getCard(id);
        return (card.getId()!=null) ?
                rf.success(card) :
                rf.fail("Card not found", "GetDetails-001", "Please try a different card id");
    }




    //User can get a card by sending a post request with the PAN(16 digits number), CVV(3 digits secret) and expiry date(MM/yy), Only retrieve the card details when these are met
    @PostMapping("/get-card-details")
    public BaseResponse<CardDto> getDetails(@RequestBody GetCardDetailsRequest request){
        CardDto card=cardservice.getCard(request.getPan(),request.getCvv(),request.getExp());
        return (card.getId()!=null) ?
                rf.success(card) :
                rf.fail("Card not found", "GetDetails-002", "Please try a different card details");

    }


    //User can delete a card by sending a delete request with the card token, Only delete the card when the id is valid.
    //we can use post
     @DeleteMapping("/delete-card/{id}")
     public BaseResponse<?> delete(@PathVariable("id") Long id){
        return (cardservice.deleteCard(id)) ?
                rf.success(null) :
                rf.fail("Card not found", "Delete-001", "Please try a different card id");
     }


     //This API adds an amount to a card, the value can be negative so the amount will decrease.
     @PostMapping("/add-amount")
     public BaseResponse<Double> AddAmount(@RequestBody AddAmountRequest request){
         Double res = cardservice.addAmount(request.getId(), request.getAmount());
         return (res >= 0.0) ? rf.success(res) : rf.fail("error adding amount", "AddAmount-001", "try again later");
     }

     //this API is to Transfer money to somebody else's card on the same system
     @PostMapping("/transfer")
     public BaseResponse<?> transfer(@RequestBody TransferRequest request){
         return cardservice.transfer(request.getFirstCardId(),request.getSecondCardPan(),request.getAmount()) ?
                 rf.success(null) :
                 rf.fail("Transfer failed", "Transfer-001", "Please check the values and try again.");
     }

}
