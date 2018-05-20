package br.com.aurindo.reader.model.desemprego;

import javax.persistence.*;

@Entity
public class SexoDim {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "sexoGenerator")
    @TableGenerator(name = "sexoGenerator", allocationSize = 1)
    private long id;
    private String sexo;

    public SexoDim(String sexo) {
        this.sexo = sexo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
