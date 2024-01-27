package duy.nb.finalproject.demo.repository;

import duy.nb.finalproject.demo.entities.StopNearest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StopNearestRepository extends JpaRepository<StopNearest, Integer> {
    List<StopNearest> findByStopIdOrderByDistanceDesc(int stopId);

    List<StopNearest> findByStopIdOrderByDistanceAsc(int stopId);

    List<StopNearest> findByPostId(int postId);
}
