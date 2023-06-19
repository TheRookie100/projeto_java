import java.util.GregorianCalendar;

class HoraTrabalhada {
    private GregorianCalendar dataTrab;
    private double qtdeHoras;
    private Projeto projeto;

    public HoraTrabalhada(double qtdeHoras, Projeto projeto) {
        this.dataTrab = new GregorianCalendar();
        this.qtdeHoras = qtdeHoras;
        this.projeto = projeto;
    }

    public HoraTrabalhada(Projeto projeto2, double qtdeHoras2) {
    }

    public GregorianCalendar getDataTrab() {
        return dataTrab;
    }

    public double getQtdeHoras() {
        return qtdeHoras;
    }

    public Projeto getProjeto() {
        return projeto;
    }

}