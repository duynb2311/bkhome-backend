package duy.nb.finalproject.demo.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "provinces")
public class Province {
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
    private int fullNameEn;
    @Column(name = "code_name")
    @NotNull
    private String codeName;
    @Column(name = "administrative_unit_id")
    @NotNull
    private int unitId;
    @Column(name = "administrative_region_id")
    @NotNull
    private int regionId;

    public Province() {
    }

    public Province(String name, String nameEn, String fullName, int fullNameEn, String codeName, int unitId, int regionId) {
        this.name = name;
        this.nameEn = nameEn;
        this.fullName = fullName;
        this.fullNameEn = fullNameEn;
        this.codeName = codeName;
        this.unitId = unitId;
        this.regionId = regionId;
    }

    public Province(String code, String name, String nameEn, String fullName, int fullNameEn, String codeName, int unitId, int regionId) {
        this.code = code;
        this.name = name;
        this.nameEn = nameEn;
        this.fullName = fullName;
        this.fullNameEn = fullNameEn;
        this.codeName = codeName;
        this.unitId = unitId;
        this.regionId = regionId;
    }
}
