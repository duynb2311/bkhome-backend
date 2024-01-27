package duy.nb.finalproject.demo.controller;

import duy.nb.finalproject.demo.service.ProvinceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/province")
public class ProvinceController {
    private ProvinceService provinceService;

    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping
    public List<Map<String, Object>> getALlProvince(){
        return provinceService.getAllProvince();
    }
}
