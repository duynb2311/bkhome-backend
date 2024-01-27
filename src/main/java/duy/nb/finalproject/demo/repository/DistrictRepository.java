package duy.nb.finalproject.demo.repository;

import duy.nb.finalproject.demo.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface DistrictRepository extends JpaRepository<District, String> {
    @Query("Select d.code as code, d.name as name from District d where d.provinceCode = :code ")
    List<Map<String,Object>> findDistrictByProvinceCode(@Param("code") String code);
}
