package ul.info.Bank.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ul.info.Bank.model.entity.Card;

import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private Long id;
    private String pan;
    private String cvv;
    private LocalDate exDate;
    private String currency;
    private Double amount;

    public static void toDto(Card c, CardDto c1){
        c1.setPan(c.getPan()); c1.setCvv(c.getCvv()); c1.setExDate(c.getEx_date());
    }


    //1. explicit param otherObject
    @Override
    public boolean equals(Object otherObject){
        //2.a quick test to see if the objsare identical
        if (this == otherObject) return true;
        // 3.must return false if the explicit paramis null
        if (otherObject== null) return false;
        // 4.if the classes don't match, they can't be equal: reflection meth. getClass()
        if (getClass() != otherObject.getClass()) return false;

        CardDto var = (CardDto) otherObject;
        //5. test whether the fields have identical values
        // 2 Cards are equal if they have same  pan, cvv,  exp
        return Objects.equals(cvv, var.cvv)
                && Objects.equals(pan, var.pan)
                && Objects.equals(exDate, var.exDate);
    }
}
