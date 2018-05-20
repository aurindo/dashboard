package br.com.aurindo.reader.model.ipca;

import br.com.aurindo.reader.model.desemprego.AnoDim;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class IpcaFactor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ipcaGenerator")
    @TableGenerator(name = "ipcaGenerator", allocationSize = 1)
    private Long id;

    private double habitacao;
    private double vestuario;
    private double transportes;
    private double educacao;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private AnoDim anoDim;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private MesDim mesDim;

    public IpcaFactor(
                      MesDim mesDim,
                      AnoDim anoDim) {
        this.anoDim = anoDim;
        this.mesDim = mesDim;
    }

    public IpcaFactor(double habitacao,
                      double vestuario,
                      double transportes,
                      double educacao,
                      MesDim mesDim,
                      AnoDim anoDim) {
        this.habitacao = habitacao;
        this.vestuario = vestuario;
        this.transportes = transportes;
        this.educacao = educacao;
        this.anoDim = anoDim;
        this.mesDim = mesDim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getHabitacao() {
        return habitacao;
    }

    public void setHabitacao(double habitacao) {
        this.habitacao = habitacao;
    }

    public double getVestuario() {
        return vestuario;
    }

    public void setVestuario(double vestuario) {
        this.vestuario = vestuario;
    }

    public double getTransportes() {
        return transportes;
    }

    public void setTransportes(double transportes) {
        this.transportes = transportes;
    }

    public double getEducacao() {
        return educacao;
    }

    public void setEducacao(double educacao) {
        this.educacao = educacao;
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
}
