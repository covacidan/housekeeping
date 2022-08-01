package housekeeping.tineretului.service;

import housekeeping.tineretului.model.Intretinere;
import housekeeping.tineretului.repository.IntretinereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class IntretinereServiceImpl implements IntretinereService {

    @Autowired
    private final IntretinereRepository intretinereRepository;

    public IntretinereServiceImpl(IntretinereRepository intretinereRepository) {
        this.intretinereRepository = intretinereRepository;
    }

    @Override
    public void addIntretinere(BigDecimal amount, Date createdDate){
        intretinereRepository.addIntretinere(amount, createdDate);
    }

    @Override
    public List<Intretinere> getIntretinere(){
        return intretinereRepository.findIntretinere();
    }

    @Override
    public List<Intretinere> findAll(){
        return (List<Intretinere>) intretinereRepository.findAll();
    }
}
