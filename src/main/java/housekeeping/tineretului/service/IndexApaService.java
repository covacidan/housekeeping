package housekeeping.tineretului.service;

import housekeeping.tineretului.dto.IndexTotal;
import housekeeping.tineretului.model.IndexApa;

import java.util.List;

public interface IndexApaService {
    IndexApa findByMonthAndYear(IndexApa indexApa);

    IndexApa createIndexApa(IndexApa indexApa);

    IndexApa updateIndexApa(IndexApa indexApa);

    void deteleIndexApa(IndexApa indexApa);

    List<IndexApa> findAll();

    IndexTotal getTotal();
}
