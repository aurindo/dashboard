package br.com.aurindo.reader.model.desemprego;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DesempregoFactor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "desempregoGenerator")
    @TableGenerator(name = "desempregoGenerator", allocationSize = 1)
    private Long id;
    private double valorAbsoluto;
    private double valorPercentual;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private AnoDim ano;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private CorDim cor;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private SexoDim sexo;

    public DesempregoFactor(double valorAbsoluto, double valorPercentual, AnoDim anoDim, CorDim corDim, SexoDim sexoDim) {
        this.valorAbsoluto = valorAbsoluto;
        this.valorPercentual = valorPercentual;

        this.ano = anoDim;
        this.cor = corDim;
        this.sexo = sexoDim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnoDim getAno() {
        return ano;
    }

    public void setAno(AnoDim ano) {
        this.ano = ano;
    }

    public CorDim getCor() {
        return cor;
    }

    public void setCor(CorDim cor) {
        this.cor = cor;
    }

    public SexoDim getSexo() {
        return sexo;
    }

    public void setSexo(SexoDim sexo) {
        this.sexo = sexo;
    }

    public double getValorAbsoluto() {
        return valorAbsoluto;
    }

    public void setValorAbsoluto(double valorAbsoluto) {
        this.valorAbsoluto = valorAbsoluto;
    }

    public double getValorPercentual() {
        return valorPercentual;
    }

    public void setValorPercentual(double valorPercentual) {
        this.valorPercentual = valorPercentual;
    }
}
