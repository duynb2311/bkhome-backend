package duy.nb.finalproject.demo.controller;

import duy.nb.finalproject.demo.service.DistrictService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/district")
public class DistrictController {
    private DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping
    public List<Map<String,Object>> findDistrictByProvinceCode(@RequestParam("provinceCode") String provinceCode){
        List<Map<String,Object>> res =districtService.findDistrictByProvinceCode(provinceCode);
        return res;
    }
}
