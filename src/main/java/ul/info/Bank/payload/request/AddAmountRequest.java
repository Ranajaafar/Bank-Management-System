package ul.info.Bank.payload.request;

import lombok.Data;

@Data
public class AddAmountRequest {
    private Long id;
    private Double amount;
}
