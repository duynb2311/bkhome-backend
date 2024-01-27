package duy.nb.finalproject.demo.controller;

import duy.nb.finalproject.demo.service.WardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/ward")
public class WardController {
    private WardService wardService;

    public WardController(WardService wardService) {
        this.wardService = wardService;
    }

    @GetMapping
    public List<Map<String , Object>> getWardByDistrictCode(@RequestParam("districtCode") String districtCode){
        return wardService.getWardByDistrictCode(districtCode);
    }
}
