package service;

import entities.Carro;
import entities.Veiculo;

import java.util.ArrayList;
import java.util.List;



public class VeiculoService {
    private List<Veiculo> veiculos = new ArrayList<>();

    public void cadastrarVeiculo(Veiculo veiculo) throws Exception {
        validarVeiculo(veiculo);
        veiculos.add(veiculo);
    }

    private void validarVeiculo(Veiculo veiculo) throws Exception {
        if (veiculo.getPlaca() == null || veiculo.getPlaca().isEmpty() ||
            veiculo.getModelo() == null || veiculo.getModelo().isEmpty() ||
            veiculo.getAno() == 0) {
            throw new Exception("Campos obrigatórios em branco ou inválidos.");
        }

        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(veiculo.getPlaca())) {
                throw new Exception("Veículo com a mesma placa já cadastrado.");
            }
        }

        if (veiculo instanceof Carro) {
            Carro carro = (Carro) veiculo;
            if (carro.getNumeroDePortas() == 0) {
                throw new Exception("Carro não pode ter número de portas igual a 0.");
            }
        }
    }

    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }

    

    public Veiculo pesquisarPorPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public void removerPorPlaca(String placa) throws Exception {
        Veiculo veiculo = pesquisarPorPlaca(placa);
        if (veiculo != null) {
            veiculos.remove(veiculo);
        } else {
            throw new Exception("Veículo não encontrado.");
        }
    }
}