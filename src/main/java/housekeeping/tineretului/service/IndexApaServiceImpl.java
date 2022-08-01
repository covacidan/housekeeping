package housekeeping.tineretului.service;

import housekeeping.tineretului.dto.IndexTotal;
import housekeeping.tineretului.model.IndexApa;
import housekeeping.tineretului.repository.IndexApaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class IndexApaServiceImpl implements IndexApaService{

    @Autowired
    private IndexApaRepository indexApaRepository;

    @Override
    public IndexApa findByMonthAndYear(IndexApa indexApa){
        return indexApaRepository.findByMonthAndYear(indexApa.getLuna(), indexApa.getAn());
    }

    @Override
    public IndexApa createIndexApa(IndexApa indexApa){

        return indexApaRepository.save(indexApa);
    }

    @Override
    public IndexApa updateIndexApa(IndexApa indexApa){
        return indexApaRepository.save(indexApa);
    }

    @Override
    public void deteleIndexApa(IndexApa indexApa){
        indexApaRepository.delete(indexApa);
    }

    @Override
    public List<IndexApa> findAll(){
        return (List<IndexApa>) indexApaRepository.findAll();
    }

    @Override
    public IndexTotal getTotal(){
        IndexTotal indexTotal = new IndexTotal();
        List<IndexApa> listaApa = findAll();
        Collections.sort(listaApa);

        IndexApa index1 = listaApa.get(listaApa.size()-1);
        IndexApa index2 = listaApa.get(listaApa.size()-2);

        Double indexBucatarieRece = index1.getBucatarieRece() - index2.getBucatarieRece();
        Double indexBucatarieCald = index1.getBucatarieCald() - index2.getBucatarieCald();
        Double indexBaieRece = index1.getBaieRece() - index2.getBaieRece();
        Double indexBaieCald = index1.getBaieCald() - index2.getBaieCald();
        Double indexBServRece = index1.getBaieServiciuRece() - index2.getBaieServiciuRece();
        Double indexBServCald = index1.getBaieServiciuCald() - index2.getBaieServiciuCald();

        indexTotal.setBucatarieRece(round(indexBucatarieRece,3));
        indexTotal.setBucatarieCald(round(indexBucatarieCald,3));
        indexTotal.setBaieRece(round(indexBaieRece, 3));
        indexTotal.setBaieCald(round(indexBaieCald,3));
        indexTotal.setBaieServiciuRece(round(indexBServRece,3));
        indexTotal.setBaieServiciuCald(round(indexBServCald, 3));

        indexTotal.setTotalRece(round(indexBucatarieRece + indexBaieRece + indexBServRece,3));
        indexTotal.setTotalCald(round(indexBucatarieCald + indexBaieCald + indexBServCald,3));

        return indexTotal;
    }

    private static double round(double value, int places){
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
