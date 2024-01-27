package duy.nb.finalproject.demo.repository;

import duy.nb.finalproject.demo.entities.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StopRepository extends JpaRepository<Stop, Integer> {
    List<Stop> findByBusNum(String num);

    @Query("Select distinct s.busNum as busNum from Stop s")
    List<Object> findAllBusNum();
}
