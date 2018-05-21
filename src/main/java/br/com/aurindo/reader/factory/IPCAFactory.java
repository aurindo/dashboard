package br.com.aurindo.reader.factory;

import br.com.aurindo.reader.model.ipca.IpcaFactor;

public class IPCAFactory {

    private IPCAFactory(){}

    public static IpcaFactor createIPCAFactor(
            double habitacao,
            double vestuario,
            double transportes,
            double educacao,
            int ano,
            String mes) {


        return new IpcaFactor(
                habitacao,
                vestuario,
                transportes,
                educacao,
                mes,
                ano);
    }

}
