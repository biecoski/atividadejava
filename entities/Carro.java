package entities;

public class Carro extends Veiculo {
    private int numeroDePortas;

    public Carro(String placa, int ano, String modelo, String marca, int numeroDePortas) {
        super(placa, ano, modelo, marca);
        this.numeroDePortas = numeroDePortas;
    }

    public int getNumeroDePortas() {
        return numeroDePortas;
    }

    public void setNumeroDePortas(int numeroDePortas) {
        this.numeroDePortas = numeroDePortas;
    }

    @Override
    public String toString() {
        return String.format("Carro: %s, Placa: %s, Ano: %d, Modelo: %s, Marca: %s, Portas: %d",
                 getPlaca(), getAno(), getModelo(), getMarca(), numeroDePortas);
    }
}
