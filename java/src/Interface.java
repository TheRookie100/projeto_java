
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

class Interface {
    private Empresa empresa;
    private Scanner scanner;

    public Interface(Empresa empresa) {
        this.empresa = empresa;
        this.scanner = new Scanner(System.in);
    }

    public void apresentarMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("Sistema de Controle de Projetos Dev");
            System.out.println("1 - Cadastrar novo funcionário");
            System.out.println("2 - Cadastrar novo projeto");
            System.out.println("3 - Excluir funcionário");
            System.out.println("4 - Adicionar hora trabalhada para um funcionário");
            System.out.println("5 - Excluir hora trabalhada de um funcionário");
            System.out.println("6 - Listar valor a ser pago a um funcionário");
            System.out.println("7 - Listar número total de horas trabalhadas em um projeto");
            System.out.println("8 - Listar funcionários");
            System.out.println("9 - Listar projetos");
            System.out.println("0 - Sair do programa");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    cadastrarProjeto();
                    break;
                case 3:
                    excluirFuncionario();
                    break;
                case 4:
                    adicionarHoraTrabalhada();
                    break;
                case 5:
                    excluirHoraTrabalhada();
                    break;
                case 6:
                    listarValorPago();
                    break;
                case 7:
                    listarHorasTrabalhadas();
                    break;
                case 8:
                    listarFuncionarios();
                    break;
                case 9:
                    listarProjetos();
                    break;
                    case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }


    private void cadastrarFuncionario() {
        System.out.print("Digite o CPF do funcionário: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o nome do funcionário: ");
        String nomeFunc = scanner.nextLine();
        System.out.print("Digite o salário hora do funcionário: ");
        double salarioHora = scanner.nextDouble();
        scanner.nextLine();
        Funcionario funcionario = new Funcionario(cpf, nomeFunc, salarioHora);
        empresa.addFuncionario(funcionario);
        System.out.println("Funcionário cadastrado com sucesso.");
    }

    private void cadastrarProjeto() {
        System.out.print("Digite o nome do projeto: ");
        String nomeProj = scanner.nextLine();
        System.out.print("Digite a descrição do projeto: ");
        String descricao = scanner.nextLine();
        Projeto projeto = new Projeto(nomeProj, descricao);
        empresa.addProjeto(projeto);
        System.out.println("Projeto cadastrado com sucesso.");
    }

    private void excluirFuncionario() {
        System.out.print("Digite o CPF do funcionário a ser excluído: ");
        String cpf = scanner.nextLine();
        empresa.removeFuncionario(cpf);
    }

    private void adicionarHoraTrabalhada() {
        System.out.print("Digite o CPF do funcionário: ");
        String cpf = scanner.nextLine();
        Funcionario funcionario = null;
        for (Funcionario f : empresa.getFuncionarios()) {
            if (f.getCpf().equals(cpf)) {
                funcionario = f;
                break; //
            }
        }
        if (funcionario == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }
        System.out.print("Digite o nome do projeto: ");
        String nomeProj = scanner.nextLine();
        Projeto projeto = null;
        for (Projeto p : empresa.getProjetos()) {
            if (p.getNomeProj().equals(nomeProj)) {
                projeto = p;
                break;
            }
        }
        if (projeto == null) { //
            System.out.println("Projeto não encontrado.");
            return;
        }
        System.out.print("Digite a quantidade de horas trabalhadas: ");
        double qtdeHoras = scanner.nextDouble();
        scanner.nextLine();
        empresa.addHoraTrabalhada(funcionario, projeto, qtdeHoras);
        System.out.println("Hora trabalhada adicionada com sucesso.");
    }

    private void listarValorPago() {
        System.out.print("Digite o CPF do funcionário: ");
        String cpf = scanner.nextLine();
        Funcionario funcionario = null;
        for (Funcionario f : empresa.getFuncionarios()) {
            if (f.getCpf().equals(cpf)) {
                funcionario = f;
                break;
            }
        }
        if (funcionario == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }
        System.out.print("Digite o mês: ");
        int mes = scanner.nextInt() - 1;
        System.out.print("Digite o ano: ");
        int ano = scanner.nextInt();
        double valorPago = empresa.getValorPago(funcionario, mes, ano);
        System.out.println("Valor a ser pago: R$" + valorPago);
    }

    private void listarHorasTrabalhadas() {
        System.out.print("Digite o nome do projeto: ");
        String nomeProj = scanner.nextLine();
        Projeto projeto = null;
        for (Projeto p : empresa.getProjetos()) {
            if (p.getNomeProj().equals(nomeProj)) {
                projeto = p;
                break;
            }
        }
        if (projeto == null) {
            System.out.println("Projeto não encontrado.");
            return;
        }
        System.out.print("Digite o mês: ");
        int mes = scanner.nextInt() - 1;
        System.out.print("Digite o ano: ");
        int ano = scanner.nextInt();
        double horasTrabalhadas = empresa.getHorasTrabalhadas(projeto, mes, ano);
        System.out.println("Horas trabalhadas: " + horasTrabalhadas);
    }

    private void listarFuncionarios() {
        for (Funcionario funcionario : empresa.getFuncionarios()) {
            System.out.println("CPF: " + funcionario.getCpf());
            System.out.println("Nome: " + funcionario.getNomeFunc());
            System.out.println("Salário hora: R$" + funcionario.getSalarioHora());
            System.out.println("Horas trabalhadas:");
            for (HoraTrabalhada horaTrabalhada : funcionario.getHorasTrabalhadas()) {
                System.out.println("Data: " + horaTrabalhada.getDataTrab().get(Calendar.DAY_OF_MONTH) + "/"
                        + (horaTrabalhada.getDataTrab().get(Calendar.MONTH) + 1) + "/"
                        + horaTrabalhada.getDataTrab().get(Calendar.YEAR));
                System.out.println("Quantidade: " + horaTrabalhada.getQtdeHoras());
                System.out.println("Projeto: " + horaTrabalhada.getProjeto().getNomeProj());
            }
            System.out.println();
        }
    }

    private void listarProjetos() {
        for (Projeto projeto : empresa.getProjetos()) {
            System.out.println("Nome: " + projeto.getNomeProj());
            System.out.println("Descrição: " + projeto.getDescricao());
            System.out.println();
        }
    }

    // Na classe Interface
    private Funcionario buscarFuncionario(String cpf) {
        for (Funcionario f : empresa.getFuncionarios()) {
            if (f.getCpf().equals(cpf)) {
                return f;
            }
        }
        return null;
    }

    private Projeto buscarProjeto(String nomeProj) {
        for (Projeto p : empresa.getProjetos()) {
            if (p.getNomeProj().equals(nomeProj)) {
                return p;
            }
        }
        return null;
    }

    private void excluirHoraTrabalhada() {
        System.out.print("Digite o CPF do funcionário: ");
        String cpf = scanner.nextLine();
        Funcionario funcionario = buscarFuncionario(cpf);
        if (funcionario == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }
        System.out.print("Digite o nome do projeto: ");
        String nomeProj = scanner.nextLine();
        Projeto projeto = buscarProjeto(nomeProj);
        if (projeto == null) {
            System.out.println("Projeto não encontrado.");
            return;
        }
        System.out.print("Digite a data de trabalho (dd/mm/aaaa): ");
        String dataStr = scanner.nextLine();
        String[] dataArr = dataStr.split("/");
        int dia = Integer.parseInt(dataArr[0]);
        int mes = Integer.parseInt(dataArr[1]) - 1;
        int ano = Integer.parseInt(dataArr[2]);
        GregorianCalendar dataTrab = new GregorianCalendar(ano, mes, dia);
        try {
            funcionario.desativarHoraTrabalhada(projeto, dataTrab);
            System.out.println("Hora trabalhada removida com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
