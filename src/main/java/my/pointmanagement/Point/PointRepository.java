package my.pointmanagement.Point;

import my.pointmanagement.Point.wallet.PointWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point,Long> {
}