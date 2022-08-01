package housekeeping.tineretului.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "index_apa")
public class IndexApa implements Comparable<IndexApa> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "an")
    private int an;

    @Column(name = "luna")
    private int luna;

    @Column(name = "bucatarie_rece")
    private Double bucatarieRece;

    @Column(name = "bucatarie_cald")
    private Double bucatarieCald;

    @Column(name = "baie_rece")
    private Double baieRece;

    @Column(name = "baie_cald")
    private Double baieCald;

    @Column(name = "baie_serviciu_rece")
    private Double baieServiciuRece;

    @Column(name = "baie_serviciu_cald")
    private Double baieServiciuCald;

    @Column(name = "added_date")
    private Date addedDate;

    @Override
    public int compareTo(IndexApa ia) {
//        if (this.getId() > ia.getId() )
//            return 1;
//
//        return -1;

        if (this.getAn() == ia.getAn()){
            if (this.getLuna() > ia.getLuna())
                return 1;
            else
                return -1;
        }
        return 0;
    }
}
