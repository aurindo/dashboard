package br.com.aurindo.reader.model.ipca;

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
    private DataIpcaDim data;

    public IpcaFactor(
                      String month,
                      int year) {
        data = new DataIpcaDim(year, month);
    }

    public IpcaFactor(double habitacao,
                      double vestuario,
                      double transportes,
                      double educacao,
                      String month,
                      int year) {
        this.habitacao = habitacao;
        this.vestuario = vestuario;
        this.transportes = transportes;
        this.educacao = educacao;
        data = new DataIpcaDim(year, month);
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

    public DataIpcaDim getData() {
        return data;
    }

    public void setData(DataIpcaDim data) {
        this.data = data;
    }
}
