package locadora;

public class Filme {
    private String titulo;
    private double valorLocacao;

    public Filme(String titulo, double valorLocacao) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser vazio");
        }
        if (valorLocacao < 0) {
            throw new IllegalArgumentException("Valor de locação não pode ser negativo");
        }
        this.titulo = titulo;
        this.valorLocacao = valorLocacao;
    }

    public String getTitulo() { return titulo; }
    public double getValorLocacao() { return valorLocacao; }

    @Override
    public String toString() {
        return titulo + " (R$ " + String.format("%.2f", valorLocacao) + ")";
    }
}