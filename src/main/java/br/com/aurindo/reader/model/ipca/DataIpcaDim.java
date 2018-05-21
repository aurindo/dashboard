package br.com.aurindo.reader.model.ipca;

import br.com.aurindo.reader.model.cotacaoDolar.MonthEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity
public class DataIpcaDim {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "dataIpcaGenerator")
    @TableGenerator(name = "dataIpcaGenerator", allocationSize = 1)
    private Long id;

    private Date date;

    public DataIpcaDim(int year, String month) {
        this.date = Date.from(
                LocalDate.of(year, MonthEnum.valueOf(month).getIndex(), 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}
