package duy.nb.finalproject.demo.service;

import duy.nb.finalproject.demo.repository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DistrictService {
    private DistrictRepository districtRepository;

    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public List<Map<String,Object>> findDistrictByProvinceCode(String code){
        List<Map<String,Object>> district = districtRepository.findDistrictByProvinceCode(code);
        return district;
    }
}
