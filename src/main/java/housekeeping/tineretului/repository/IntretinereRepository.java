package housekeeping.tineretului.repository;

import housekeeping.tineretului.model.Intretinere;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Repository
public interface IntretinereRepository extends CrudRepository<Intretinere, Long> {

    @Query(value = "SELECT * FROM intretinere", nativeQuery = true)
    List<Intretinere> findIntretinere();

    @Modifying
    @Query(value = "INSERT INTO intretinere (amount, creation_date) values (:amount, :creationDate)", nativeQuery = true)
    void addIntretinere(BigDecimal amount, Date creationDate);
}
