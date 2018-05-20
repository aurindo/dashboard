package br.com.aurindo.reader.model.desemprego;

import javax.persistence.*;

@Entity
public class CorDim {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "corGenerator")
    @TableGenerator(name = "corGenerator", allocationSize = 1)
    private long id;
    private String cor;

    public CorDim(String cor) {
        this.cor = cor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
