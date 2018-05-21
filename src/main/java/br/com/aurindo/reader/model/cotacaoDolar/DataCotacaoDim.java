package br.com.aurindo.reader.model.cotacaoDolar;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity
public class DataCotacaoDim {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "dataCotcaoGenerator")
    @TableGenerator(name = "dataCotcaoGenerator", allocationSize = 1)
    private Long id;

    private Date date;

    public DataCotacaoDim(int year, String month, int day) {
        this.date = Date.from(
                LocalDate.of(year, new Integer(month), day).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
