package duy.nb.finalproject.demo.controller;

import duy.nb.finalproject.demo.entities.Stop;
import duy.nb.finalproject.demo.service.StopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stops")
public class StopController {
    private StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @PostMapping("/new")
    public Stop createStop(@RequestBody Stop stop){;
        return stopService.createStop(stop);
    }
    @GetMapping("/{busNum}")
    public List<Stop> findByBusNum(@PathVariable String busNum){
        return stopService.findByBusNum(busNum);
    }

    @GetMapping("/allbusnum")
    public List<Object> findAllBusNum(){
        return stopService.findAllBusNum();
    }
}
