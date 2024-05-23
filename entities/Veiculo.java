package entities;

public abstract class Veiculo {
    private String placa;
    private int ano;
    private String modelo;
    private String marca;


    public Veiculo(String placa, int ano, String modelo, String marca) {
        this.placa = placa;
        this.ano = ano;
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
}
