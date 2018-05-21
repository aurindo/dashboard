package br.com.aurindo.reader.model.cotacaoDolar;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CotacaoDolarFactor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "cotacaoDolarGenerator")
    @TableGenerator(name = "cotacaoDolarGenerator", allocationSize = 1)
    private Long id;
    private double cotacaoCompra;
    private double cotacaoVenda;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private DataCotacaoDim dataCotacaoDim;

    public CotacaoDolarFactor(double cotacaoCompra, double cotacaoVenda, int ano, String mes, int dia) {
        this.cotacaoCompra = cotacaoCompra;
        this.cotacaoVenda = cotacaoVenda;
        this.dataCotacaoDim = new DataCotacaoDim(ano, mes, dia);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCotacaoCompra() {
        return cotacaoCompra;
    }

    public void setCotacaoCompra(double cotacaoCompra) {
        this.cotacaoCompra = cotacaoCompra;
    }

    public double getCotacaoVenda() {
        return cotacaoVenda;
    }

    public void setCotacaoVenda(double cotacaoVenda) {
        this.cotacaoVenda = cotacaoVenda;
    }

    public DataCotacaoDim getDataCotacaoDim() {
        return dataCotacaoDim;
    }

    public void setDataCotacaoDim(DataCotacaoDim dataCotacaoDim) {
        this.dataCotacaoDim = dataCotacaoDim;
    }
}
