package duy.nb.finalproject.demo.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "wards")
public class Ward {
    @Id
    private String code;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "name_en")
    @NotNull
    private String nameEn;
    @Column(name = "full_name")
    @NotNull
    private String fullName;
    @Column(name = "full_name_en")
    @NotNull
    private String fullNameEn;
    @Column(name = "code_name")
    @NotNull
    private String codeName;
    @Column(name = "district_code")
    @NotNull
    private String districtCode;
    @Column(name = "administrative_unit_id")
    @NotNull
    private String unitId;

    public Ward() {
    }

    public Ward(String name, String nameEn, String fullName, String fullNameEn, String codeName, String districtCode, String unitId) {
        this.name = name;
        this.nameEn = nameEn;
        this.fullName = fullName;
        this.fullNameEn = fullNameEn;
        this.codeName = codeName;
        this.districtCode = districtCode;
        this.unitId = unitId;
    }

    public Ward(String code, String name, String nameEn, String fullName, String fullNameEn, String codeName, String districtCode, String unitId) {
        this.code = code;
        this.name = name;
        this.nameEn = nameEn;
        this.fullName = fullName;
        this.fullNameEn = fullNameEn;
        this.codeName = codeName;
        this.districtCode = districtCode;
        this.unitId = unitId;
    }
}
