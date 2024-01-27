package duy.nb.finalproject.demo.service;

import duy.nb.finalproject.demo.repository.ProvinceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProvinceService {
    private ProvinceRepository provinceRepository;

    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    public List<Map<String, Object>> getAllProvince(){
        return provinceRepository.getAllProvince();
    }
}
