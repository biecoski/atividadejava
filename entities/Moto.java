package entities;

public class Moto extends Veiculo {
    private boolean temCarenagem;

    public Moto(String placa, int ano, String modelo, String marca,  boolean temCarenagem) {
        super(placa, ano, modelo, marca);
        this.temCarenagem = temCarenagem;
    }

    public boolean isTemCarenagem() {
        return temCarenagem;
    }

    public void setTemCarenagem(boolean temCarenagem) {
        this.temCarenagem = temCarenagem;
    }

    @Override
    public String toString() {
        return String.format("Moto: %s, Placa: %s, Ano: %d, Modelo: %s, Marca: %s, Carenagem: %s",
                 getPlaca(), getAno(), getModelo(), getMarca(), temCarenagem ? "Sim" : "Não");
    }
}
