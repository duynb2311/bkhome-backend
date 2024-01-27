package duy.nb.finalproject.demo.repository;

import duy.nb.finalproject.demo.entities.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ProvinceRepository extends JpaRepository<Province, String> {
    @Query("Select p.code as code, p.name as name from Province p")
    List<Map<String , Object>> getAllProvince();
}
