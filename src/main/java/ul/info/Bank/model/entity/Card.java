package ul.info.Bank.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Card")
@Data
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=16,nullable=false,unique = true)
    private String pan;

    @Column(length=3,nullable=false)
    private String cvv;

    @Column(nullable=false)
    private LocalDate ex_date;

    @Column(length=3,nullable=false)
    private String currency;

    @Column(nullable=false)
    private Double amount;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public Card(String pan, String cvv, LocalDate exDate, String currency, Double amount) {
        this.pan = pan;
        this.cvv = cvv;
        this.ex_date = exDate;
        this.currency = currency;
        this.amount = amount;
    }
}
