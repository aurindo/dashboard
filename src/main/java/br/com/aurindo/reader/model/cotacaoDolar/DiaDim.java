package br.com.aurindo.reader.model.cotacaoDolar;

import javax.persistence.*;

@Entity
public class DiaDim {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "diaGenerator")
    @TableGenerator(name = "diaGenerator", allocationSize = 1)
    private Long id;

    private int dia;

    public DiaDim(int dia) {
        this.dia = dia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
}
