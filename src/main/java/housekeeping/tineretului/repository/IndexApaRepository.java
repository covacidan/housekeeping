package housekeeping.tineretului.repository;


import housekeeping.tineretului.model.IndexApa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexApaRepository extends CrudRepository<IndexApa, Long> {

    @Query(value = "SELECT * FROM index_apa WHERE luna = :month and an = :year", nativeQuery = true)
    IndexApa findByMonthAndYear(int month, int year);
}
