package br.com.aurindo.reader.model.cotacaoDolar;

import br.com.aurindo.reader.model.desemprego.AnoDim;
import br.com.aurindo.reader.model.ipca.MesDim;

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
    private AnoDim anoDim;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private MesDim mesDim;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private DiaDim diaDim;

    public CotacaoDolarFactor(double cotacaoCompra, double cotacaoVenda, AnoDim anoDim, MesDim mesDim, DiaDim diaDim) {
        this.cotacaoCompra = cotacaoCompra;
        this.cotacaoVenda = cotacaoVenda;
        this.anoDim = anoDim;
        this.mesDim = mesDim;
        this.diaDim = diaDim;
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

    public AnoDim getAnoDim() {
        return anoDim;
    }

    public void setAnoDim(AnoDim anoDim) {
        this.anoDim = anoDim;
    }

    public MesDim getMesDim() {
        return mesDim;
    }

    public void setMesDim(MesDim mesDim) {
        this.mesDim = mesDim;
    }

    public DiaDim getDiaDim() {
        return diaDim;
    }

    public void setDiaDim(DiaDim diaDim) {
        this.diaDim = diaDim;
    }

}
