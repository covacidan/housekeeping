package housekeeping.tineretului.controller;

import housekeeping.tineretului.dto.IntretinereRequest;
import housekeeping.tineretului.model.Intretinere;
import housekeeping.tineretului.service.IntretinereServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IntretinereController {
    private final IntretinereServiceImpl intretinereServiceImpl;

    public IntretinereController(IntretinereServiceImpl intretinereServiceImpl) {
        this.intretinereServiceImpl = intretinereServiceImpl;
    }

    @GetMapping("/housekeeping/intretinere/get")
    public List<Intretinere> getIntretinere(){
        return intretinereServiceImpl.getIntretinere();
    }

    @PostMapping("/housekeeping/intretinere/add")
    public void addIntretinere(
            @RequestBody IntretinereRequest intretinere
    ){
        intretinereServiceImpl.addIntretinere(intretinere.getAmount(), intretinere.getCreatedDate());
    }

    @GetMapping("/housekeeping/intretinere/all")
    public List<Intretinere> getAllIntretinere(){
        return intretinereServiceImpl.findAll();
    }
}
