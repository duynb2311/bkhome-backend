package duy.nb.finalproject.demo.repository;

import duy.nb.finalproject.demo.dto.FilterDto;
import duy.nb.finalproject.demo.entities.Post;
import org.hibernate.sql.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUserIdOrderByCreateDateDesc(int id);

    List<Post> findByAddressContainingOrderByCreateDateDesc(String address);

    @Query("SELECT p FROM Post p" +
            " WHERE p.address LIKE CONCAT('%', :address, '%')" +
            " AND p.rentFee >= :minFee" +
            " AND p.rentFee <= :maxFee" +
            " AND p.area >= :minArea" +
            " AND p.area <= :maxArea"+
            " ORDER by p.createDate DESC")
    Page<Post> findWithFilterValue(
            @Param("address") String address,
            @Param("minFee") BigDecimal minFee,
            @Param("maxFee") BigDecimal maxFee,
            @Param("minArea") int minArea,
            @Param("maxArea") int maxArea,
            Pageable pageable);

    @Query("SELECT p FROM Post p" +
            " WHERE p.address LIKE CONCAT('%', :#{#filterDto.address}, '%')"+
            " AND p.type LIKE CONCAT('%', :#{#filterDto.type}, '%')"+
            " AND p.rentFee >= :#{#filterDto.minRentFee}" +
            " AND p.structure LIKE CONCAT('%', :#{#filterDto.bedroom}, '%')"+
            " AND p.structure LIKE CONCAT('%', :#{#filterDto.livingroom}, '%')"+
            " AND p.structure LIKE CONCAT('%', :#{#filterDto.kitchen}, '%')"+
            " AND p.structure LIKE CONCAT('%', :#{#filterDto.bathroom}, '%')"+
            " AND p.furniture LIKE CONCAT('%', :#{#filterDto.furniture1}, '%')"+
            " AND p.furniture LIKE CONCAT('%', :#{#filterDto.furniture2}, '%')"+
            " AND p.furniture LIKE CONCAT('%', :#{#filterDto.furniture4}, '%')"+
            " AND p.electricCost <= :#{#filterDto.maxElectricCost}" +
            " AND p.furniture LIKE CONCAT('%', :#{#filterDto.furniture5}, '%')"+
            " AND p.furniture LIKE CONCAT('%', :#{#filterDto.furniture6}, '%')"+
            " AND p.furniture LIKE CONCAT('%', :#{#filterDto.nonglanh}, '%')"+
            " AND p.otherFeature LIKE CONCAT('%', :#{#filterDto.feature1}, '%')"+
            " AND p.waterCost <= :#{#filterDto.maxWaterCost}"+
            " AND p.otherFeature LIKE CONCAT('%', :#{#filterDto.feature2}, '%')"+
            " AND p.area >= :#{#filterDto.minArea}" +
            " AND p.otherFeature LIKE CONCAT('%', :#{#filterDto.feature3}, '%')"+
            " AND p.otherFeature LIKE CONCAT('%', :#{#filterDto.feature4}, '%')"+
            " AND p.area <= :#{#filterDto.maxArea}" +
            " AND p.otherFeature LIKE CONCAT('%', :#{#filterDto.feature5}, '%')"+
            " AND p.rentFee <= :#{#filterDto.maxRentFee}" +
            " AND p.otherFeature LIKE CONCAT('%', :#{#filterDto.feature6}, '%')"+
            " AND p.rentDeposit <= :#{#filterDto.maxDeposit}"

    )
    List<Post> findWithDetailsFilter(@Param("filterDto") FilterDto filterDto);
}
