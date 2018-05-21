package br.com.aurindo.reader.model.cotacaoDolar;

public enum MonthEnum {

    jan(1), fev(2), mar(3), abr(4), mai(5), jun(6), jul(7), ago(8), set(9), out(10), nov(11), dez(12);

    private int index;

    private MonthEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
