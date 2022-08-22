package my.pointmanagement.Point.reservation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.pointmanagement.Point.idEntity;
import my.pointmanagement.Point.wallet.PointWallet;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class PointReservation extends idEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "point_wallet_id", nullable = false)
    PointWallet pointWallet;

    @Column(name = "amount", nullable = false, columnDefinition = "BIGINT")
    BigInteger amount; // 적립 금액

    @Column(name = "earned_date", nullable = false)
    LocalDate earnedDate; // 언제 적립할 건지

    @Column(name = "available_days", nullable = false)
    int availableDays; // 만료 일자 (유효일자)

    @Column(name = "is_executed", columnDefinition = "TINYINT", length = 1)
    boolean executed; // 실행 여부

    public PointReservation(
        PointWallet pointWallet,
        BigInteger amount,
        LocalDate earnedDate,
        int availableDays
    ){
        this.pointWallet = pointWallet;
        this.amount = amount;
        this.earnedDate = earnedDate;
        this.availableDays = availableDays;
        this.executed = false;
    }

    public void execute(){
        this.executed =true;
    }

    public LocalDate getExpireDate(){
        return this.earnedDate.plusDays(this.availableDays);
    }
}
