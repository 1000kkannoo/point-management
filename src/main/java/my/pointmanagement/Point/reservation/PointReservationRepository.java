package my.pointmanagement.Point.reservation;

import my.pointmanagement.Message.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointReservationRepository extends JpaRepository<PointReservation,Long> {
}
