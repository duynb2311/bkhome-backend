package duy.nb.finalproject.demo.service;

import duy.nb.finalproject.demo.entities.Stop;
import duy.nb.finalproject.demo.exception.NotFoundException;
import duy.nb.finalproject.demo.repository.StopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopService {
    private StopRepository stopRepository;

    public StopService(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    public Stop createStop(Stop stop){
        Stop createStop = stopRepository.save(stop);
        return createStop;
    }

    public List<Stop> findByBusNum(String num){
        List<Stop> stops = stopRepository.findByBusNum(num);
        if(stops.isEmpty()){
            throw new NotFoundException("Can't find BusStop!");
        }else {
            return stops;
        }
    }

    public List<Object> findAllBusNum(){
        return stopRepository.findAllBusNum();
    }
}
