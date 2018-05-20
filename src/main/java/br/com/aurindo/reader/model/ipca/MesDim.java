package br.com.aurindo.reader.model.ipca;

import javax.persistence.*;

@Entity
public class MesDim {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "mesGenerator")
    @TableGenerator(name = "mesGenerator", allocationSize = 1)
    private Long id;

    private String mes;

    public MesDim(String mes) {
        this.mes = mes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
