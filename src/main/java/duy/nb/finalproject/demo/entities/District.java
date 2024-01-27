package duy.nb.finalproject.demo.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "districts")
public class District {
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
    @Column(name = "province_code")
    @NotNull
    private String provinceCode;
    @Column(name = "administrative_unit_id")
    @NotNull
    private int unitId;

    public District() {
    }

    public District(String name, String nameEn, String fullName, String fullNameEn, String codeName, String provinceCode, int unitId) {
        this.name = name;
        this.nameEn = nameEn;
        this.fullName = fullName;
        this.fullNameEn = fullNameEn;
        this.codeName = codeName;
        this.provinceCode = provinceCode;
        this.unitId = unitId;
    }

    public District(String code, String name, String nameEn, String fullName, String fullNameEn, String codeName, String provinceCode, int unitId) {
        this.code = code;
        this.name = name;
        this.nameEn = nameEn;
        this.fullName = fullName;
        this.fullNameEn = fullNameEn;
        this.codeName = codeName;
        this.provinceCode = provinceCode;
        this.unitId = unitId;
    }
}
