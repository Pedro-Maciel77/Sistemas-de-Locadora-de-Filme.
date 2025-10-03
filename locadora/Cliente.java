package locadora;

public class Cliente {
    private String nome;
    private Conta conta;

    public Cliente(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não deve ser vazio");
        }
        this.nome = nome;
    }

    public String getNome() { return nome; }
    public Conta getConta() { return conta; }
    public void setConta(Conta conta) { this.conta = conta; }
    
    @Override
    public String toString() {
        return nome + (conta != null ? " (Conta: " + conta.getSaldoDevedor() + ")" : "");
    }
}
