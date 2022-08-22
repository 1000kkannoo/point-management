package my.pointmanagement.Point.wallet;

import my.pointmanagement.Point.reservation.PointReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointWalletRepository extends JpaRepository<PointWallet,Long> {
}
