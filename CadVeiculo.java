import entities.Carro;
import entities.Moto;
import entities.Veiculo;
import service.VeiculoService;

import java.util.Scanner;

public class CadVeiculo {
    private static final Scanner scanner = new Scanner(System.in);
    private static final VeiculoService veiculoService = new VeiculoService();

    public static void main(String[] args) {
        while (true) {
            limparTela();
            exibirMenu();
            int opcao = lerOpcao();
            try {
                switch (opcao) {
                    case 1 -> cadastrarCarro();
                    case 2 -> cadastrarMoto();
                    case 3 -> listarVeiculos();
                    case 4 -> pesquisarVeiculo();
                    case 5 -> removerVeiculo();
                    case 6 -> {
                        System.out.println("Saindo do sistema...");
                        return;
                    }
                    default -> System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private static void exibirMenu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Menu Principal");
        System.out.println("1. Cadastrar Carro");
        System.out.println("2. Cadastrar Moto");
        System.out.println("3. Listar Veículos");
        System.out.println("4. Pesquisar Veículo por Placa");
        System.out.println("5. Remover Veículo por Placa");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida! Escolha uma opção: ");
            }
        }
    }

    private static void cadastrarCarro() {
        limparTela();
        try {
            System.out.println("Cadastro de Carro");
            System.out.print("Informe a placa: ");
            String placa = scanner.nextLine();
            System.out.print("Informe o ano: ");
            int ano = lerInteiro();
            System.out.print("Informe o modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Informe a marca: ");
            String marca = scanner.nextLine();
            System.out.print("Informe o número de portas: ");
            int numeroDePortas = lerInteiro();

            Carro carro = new Carro(placa, ano, modelo, marca, numeroDePortas);
            veiculoService.cadastrarVeiculo(carro);
            System.out.println("Veículo cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("NÃO FOI POSSÍVEL CADASTRAR O VEÍCULO.");
            System.out.println(e.getMessage());
        } finally {
            esperarEnter();
        }
    }

    private static void cadastrarMoto() {
        limparTela();
        try {
            System.out.println("Cadastro de Moto");
            System.out.print("Informe a placa: ");
            String placa = scanner.nextLine();
            System.out.print("Informe o ano: ");
            int ano = lerInteiro();
            System.out.print("Informe o modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Informe a marca: ");
            String marca = scanner.nextLine();
            boolean temCarenagem = lerBoolean("A moto tem carenagem? (Sim/Não): ");

            Moto moto = new Moto(placa, ano, modelo, marca, temCarenagem);
            veiculoService.cadastrarVeiculo(moto);
            System.out.println("Veículo cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("NÃO FOI POSSÍVEL CADASTRAR O VEÍCULO.");
            System.out.println(e.getMessage());
        } finally {
            esperarEnter();
        }
    }

    private static void listarVeiculos() {
        limparTela();
        System.out.println("Lista de Veículos Cadastrados:");
        for (Veiculo veiculo : veiculoService.listarVeiculos()) {
            if (veiculo instanceof Carro) {
                Carro carro = (Carro) veiculo;
                System.out.printf("Tipo: Carro - Placa: %s, Ano: %d, Modelo: %s, Marca: %s, Portas: %d%n",
                        carro.getPlaca(), carro.getAno(), carro.getModelo(), carro.getMarca(), carro.getNumeroDePortas());
            } else if (veiculo instanceof Moto) {
                Moto moto = (Moto) veiculo;
                System.out.printf("Tipo: Moto - Placa: %s, Ano: %d, Modelo: %s, Marca: %s, Carenagem: %s%n",
                        moto.getPlaca(), moto.getAno(), moto.getModelo(), moto.getMarca(), moto.isTemCarenagem() ? "Sim" : "Não");
            }
        }
        esperarEnter();
    }
    

    private static void pesquisarVeiculo() {
        limparTela();
        System.out.print("Informe a placa do veículo a ser pesquisado: ");
        String placa = scanner.nextLine();
        Veiculo veiculo = veiculoService.pesquisarPorPlaca(placa);
        if (veiculo != null) {
            System.out.println(veiculo);
        } else {
            System.out.println("Veículo não encontrado.");
        }
        esperarEnter();
    }

    private static void removerVeiculo() {
        limparTela();
        System.out.print("Informe a placa do veículo a ser removido: ");
        String placa =
        scanner.nextLine();
        try {
            veiculoService.removerPorPlaca(placa);
            System.out.println("Veículo removido com sucesso!");
        } catch (Exception e) {
            System.out.println("NÃO FOI POSSÍVEL REMOVER O VEÍCULO.");
            System.out.println(e.getMessage());
        }
        esperarEnter();
    }

    private static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void esperarEnter() {
        System.out.println("Pressione Enter para voltar ao Menu Inicial");
        scanner.nextLine();
    }

    private static int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida! Informe um número: ");
            }
        }
    }

    private static boolean lerBoolean(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().toLowerCase();
            if ("true".equals(entrada) || "false".equals(entrada)) {
                return Boolean.parseBoolean(entrada);
            } else {
                System.out.print("Entrada inválida! Escolha uma opção (Sim/Não): ");
            }
        }
    }
}