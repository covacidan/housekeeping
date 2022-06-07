package housekeeping.tineretului.service;

import housekeeping.tineretului.dto.IntretinereRequest;
import housekeeping.tineretului.model.Intretinere;
import housekeeping.tineretului.repository.IntretinereRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Service
public class IntretinereService {

    private final IntretinereRepository intretinereRepository;

    public IntretinereService(IntretinereRepository intretinereRepository) {
        this.intretinereRepository = intretinereRepository;
    }

    @Transactional
    public void addIntretinere(BigDecimal amount, Date createdDate){
        intretinereRepository.addIntretinere(amount, createdDate);
    }

    public List<Intretinere> getIntretinere(){
        return intretinereRepository.findIntretinere();
    }
}
