package housekeeping.tineretului.controller;

import housekeeping.tineretului.dto.IntretinereRequest;
import housekeeping.tineretului.model.Intretinere;
import housekeeping.tineretului.service.IntretinereService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IntretinereController {
    private final IntretinereService intretinereService;

    public IntretinereController(IntretinereService intretinereService) {
        this.intretinereService = intretinereService;
    }

    @GetMapping("/intretinere")
    public List<Intretinere> getIntretinere(){
        return intretinereService.getIntretinere();
    }

    @PostMapping("/intretinere")
    public void addIntretinere(
            @RequestBody IntretinereRequest intretinere
    ){
        intretinereService.addIntretinere(intretinere.getAmount(), intretinere.getCreatedDate());
    }
}
