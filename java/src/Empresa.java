
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

class Empresa {
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Projeto> projetos;

    public Empresa(String nomeEmp) {

        this.funcionarios = new ArrayList<Funcionario>();

        this.projetos = new ArrayList<Projeto>();
    }

    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);

    }

    public void removeFuncionario(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                if (funcionario.getHorasTrabalhadas().size() == 0) {
                    funcionarios.remove(funcionario);

                } else {
                    System.out
                            .println("O funcionário não pode ser excluído pois possui horas trabalhadas cadastradas.");
                }
                break;
            }
        }
    }

    public void addProjeto(Projeto projeto) {
        projetos.add(projeto);
    }

    public void addHoraTrabalhada(Funcionario funcionario, Projeto projeto, double qtdeHoras) {
        funcionario.addHoraTrabalhada(projeto, qtdeHoras);
    }

    public void removeHoraTrabalhada(Funcionario funcionario, Projeto projeto, GregorianCalendar dataTrab) {
        funcionario.addHoraTrabalhada(projeto, dataTrab);
    }

    public double getValorPago(Funcionario funcionario, int mes, int ano) {
        return funcionario.getValorPago(mes, ano);
    }

    public double getHorasTrabalhadas(Projeto projeto, int mes, int ano) {
        double horasTrabalhadas = 0;
        for (Funcionario funcionario : funcionarios) {
            for (HoraTrabalhada horaTrabalhada : funcionario.getHorasTrabalhadas()) {
                if (horaTrabalhada.getProjeto().equals(projeto)
                        && horaTrabalhada.getDataTrab().get(Calendar.MONTH) == mes
                        && horaTrabalhada.getDataTrab().get(Calendar.YEAR) == ano) {
                    horasTrabalhadas += horaTrabalhada.getQtdeHoras();
                }
            }
        }
        return horasTrabalhadas;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public ArrayList<Projeto> getProjetos() {
        return projetos;
    }

    public void gravarDados() {

    }

    public void lerDados() {

    }
}
