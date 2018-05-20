package br.com.aurindo.reader.model.desemprego;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AnoDim implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "anoGenerator")
    @TableGenerator(name = "anoGenerator", allocationSize = 1)
    private long id;
    private int ano;

    public AnoDim(int ano) {
        this.ano = ano;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
