package br.com.aurindo.reader.factory;

import br.com.aurindo.reader.model.desemprego.AnoDim;
import br.com.aurindo.reader.model.desemprego.CorDim;
import br.com.aurindo.reader.model.desemprego.DesempregoFactor;
import br.com.aurindo.reader.model.desemprego.SexoDim;

public class DesempregoItemFactory {

    private DesempregoItemFactory(){}

    public static DesempregoFactor createDesempregoItemReaded(
            int ano,
            String cor,
            String sexo,
            double valorAbsoluto,
            double valorPercentual) {

        AnoDim anoDim = new AnoDim(ano);
        CorDim corDim = new CorDim(cor);
        SexoDim sexoDim = new SexoDim(sexo);

        return new DesempregoFactor(valorAbsoluto, valorPercentual, anoDim, corDim, sexoDim);
    }

}
