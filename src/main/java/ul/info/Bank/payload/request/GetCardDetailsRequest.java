package ul.info.Bank.payload.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetCardDetailsRequest {
    private String pan;
    private String cvv;
    private LocalDate exp;
}
