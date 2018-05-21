package br.com.aurindo.reader.model.pib;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class PibFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "pibGenerator")
    @TableGenerator(name = "pibGenerator", allocationSize = 1)
    private Long id;

    private BigDecimal valor;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private DataPibDim dataPibDim;

    public PibFactor(BigDecimal valor, DataPibDim ano) {
        this.valor = valor;
        this.dataPibDim = ano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public DataPibDim getDataPibDim() {
        return dataPibDim;
    }

    public void setDataPibDim(DataPibDim dataPibDim) {
        this.dataPibDim = dataPibDim;
    }
}
