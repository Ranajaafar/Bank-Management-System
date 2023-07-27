package ul.info.Bank.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ul.info.Bank.model.entity.Card;

import java.time.LocalDate;
import java.util.HashMap;

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
}
