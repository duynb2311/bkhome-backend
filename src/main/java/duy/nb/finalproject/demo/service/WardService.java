package duy.nb.finalproject.demo.service;

import duy.nb.finalproject.demo.repository.WardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WardService {
    private WardRepository wardRepository;

    public WardService(WardRepository wardRepository) {
        this.wardRepository = wardRepository;
    }

    public List<Map<String , Object>> getWardByDistrictCode(String code){
        return wardRepository.getWardByDistrictCode(code);
    }
}
