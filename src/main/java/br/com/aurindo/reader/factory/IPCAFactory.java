package br.com.aurindo.reader.factory;

import br.com.aurindo.reader.model.desemprego.AnoDim;
import br.com.aurindo.reader.model.ipca.IpcaFactor;
import br.com.aurindo.reader.model.ipca.MesDim;

public class IPCAFactory {

    private IPCAFactory(){}

    public static IpcaFactor createIPCAFactor(
            double habitacao,
            double vestuario,
            double transportes,
            double educacao,
            int ano,
            String mes) {

        AnoDim anoDim = new AnoDim(ano);
        MesDim mesDim = new MesDim(mes);

        return new IpcaFactor(
                habitacao,
                vestuario,
                transportes,
                educacao,
                mesDim,
                anoDim);
    }

}
