package housekeeping.tineretului.service;

import housekeeping.tineretului.model.Intretinere;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface IntretinereService {
    void addIntretinere(BigDecimal amount, Date createdDate);

    List<Intretinere> getIntretinere();

    List<Intretinere> findAll();
}
