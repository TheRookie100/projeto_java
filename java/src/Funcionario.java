import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

class Funcionario {
    private String cpf;
    private String nomeFunc;
    private double salarioHora;
    private ArrayList<HoraTrabalhada> horasTrabalhadas;

    public Funcionario(String cpf, String nomeFunc, double salarioHora) {
        this.cpf = cpf;
        this.nomeFunc = nomeFunc;
        this.salarioHora = salarioHora;
        this.horasTrabalhadas = new ArrayList<HoraTrabalhada>();
    }

    public String getCpf() {
        return cpf;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public ArrayList<HoraTrabalhada> getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void addHoraTrabalhada(Projeto projeto, double qtdeHoras) {
        HoraTrabalhada horaTrabalhada = new HoraTrabalhada(qtdeHoras, projeto);
        horasTrabalhadas.add(horaTrabalhada);
    }

    public void removeHoraTrabalhada(Projeto projeto, GregorianCalendar dataTrab) {
        for (HoraTrabalhada horaTrabalhada : horasTrabalhadas) {
            if (horaTrabalhada.getProjeto().equals(projeto) && horaTrabalhada.getDataTrab().equals(dataTrab)) {
                horasTrabalhadas.remove(horaTrabalhada);
                break;
            }
        }
    }

    public void desativarHoraTrabalhada(Projeto projeto, GregorianCalendar dataTrab) throws Exception {
        boolean horaTrabalhadaEncontrada = false;
        for (HoraTrabalhada horaTrabalhada : horasTrabalhadas) {
            if (horaTrabalhada.getProjeto().equals(projeto) && horaTrabalhada.getDataTrab().equals(dataTrab)) {
                horasTrabalhadas.remove(horaTrabalhada);
                horaTrabalhadaEncontrada = true;
                break;
            }
        }
        if (!horaTrabalhadaEncontrada) {
            throw new Exception("Hora trabalhada não encontrada.");
        }
    }

    public double getValorPago(int mes, int ano) {
        double valorPago = 0;
        for (HoraTrabalhada horaTrabalhada : horasTrabalhadas) {
            if (horaTrabalhada.getDataTrab().get(Calendar.MONTH) == mes
                    && horaTrabalhada.getDataTrab().get(Calendar.YEAR) == ano) {
                valorPago += horaTrabalhada.getQtdeHoras() * salarioHora;
            }
        }
        return valorPago;
    }

    public void addHoraTrabalhada(Projeto projeto, GregorianCalendar dataTrab) {
    }
}
