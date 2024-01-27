package duy.nb.finalproject.demo.repository;

import duy.nb.finalproject.demo.entities.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface WardRepository extends JpaRepository<Ward, String> {
    @Query("Select w.code as code, w.name as name from Ward w where w.districtCode = :code")
    List<Map<String , Object>> getWardByDistrictCode(@Param("code") String code);
}
