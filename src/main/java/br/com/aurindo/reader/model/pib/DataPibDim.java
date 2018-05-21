package br.com.aurindo.reader.model.pib;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity
public class DataPibDim {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "dataPibGenerator")
    @TableGenerator(name = "dataPibGenerator", allocationSize = 1)
    private Long id;

    private Date date;

    public DataPibDim(int year) {
        this.date = Date.from(
                LocalDate.of(year, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}
