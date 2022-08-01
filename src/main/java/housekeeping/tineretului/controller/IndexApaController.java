package housekeeping.tineretului.controller;

import housekeeping.tineretului.model.IndexApa;
import housekeeping.tineretului.service.IndexApaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexApaController {

    @Autowired
    private IndexApaService indexApaService;

    @PostMapping("/housekeeping/waterIndex/addWaterIndex")
    public ResponseEntity<?> addIndexApa(@RequestBody IndexApa indexApa){

        if (indexApaService.findByMonthAndYear(indexApa) == null){
            return new ResponseEntity<>(indexApaService.createIndexApa(indexApa), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("/housekeeping/waterIndex/updateWaterIndex")
    public ResponseEntity<?> updateIndexApa(@RequestBody IndexApa indexApa){
        return new ResponseEntity<>(indexApaService.updateIndexApa(indexApa), HttpStatus.CREATED);
    }

    @PostMapping("/housekeeping/waterIndex/deleteWaterIndex")
    public ResponseEntity<?> deleteIndexApa(@RequestBody IndexApa indexApa){
        indexApaService.deteleIndexApa(indexApa);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/housekeeping/waterIndex/getAllIndexes")
    public ResponseEntity<?> getAllIndexes(){
        return new ResponseEntity<>(indexApaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/household/waterIndex/getTotal")
    public ResponseEntity<?> getTotal(){
        return new ResponseEntity<>(indexApaService.getTotal(), HttpStatus.OK);
    }

}
