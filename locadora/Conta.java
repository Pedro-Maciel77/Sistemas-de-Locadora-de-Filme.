package locadora;

import java.util.ArrayList;
import java.util.Date;

public class Conta {
    private int numero;
    private Cliente titular;
    private double saldoDevedor;
    private ArrayList<Locacao> historicoLocacao;

    public Conta(int numero, Cliente titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldoDevedor = 0.0;
        this.historicoLocacao = new ArrayList<>();
        titular.setConta(this);
    }

    public void locarFilmes(Filme[] filmes) {
        if (filmes == null || filmes.length == 0) {
            throw new IllegalArgumentException("Array de filmes não pode ser vazio");
        }
        
        // Limite máximo de 10 filmes por locação
        if (filmes.length > 10) {
            throw new IllegalArgumentException("Máximo de 10 filmes por locação");
        }
        
        Locacao loc = new Locacao(new Date());
        for (Filme f : filmes) {
            if (f != null) {
                loc.addFilme(f);
            }
        }
        
        // Só adiciona se houver pelo menos 1 filme válido
        if (loc.getListaFilmes().size() > 0) {
            historicoLocacao.add(loc);
            saldoDevedor += loc.getValorTotalApagar();
        }
    }

    public String extratoHistorico() {
        StringBuilder sb = new StringBuilder();
        sb.append("═".repeat(60)).append("\n");
        sb.append(" HISTÓRICO DE LOCAÇÕES - ").append(titular.getNome()).append("\n");
        sb.append("═".repeat(60)).append("\n");
        
        if (historicoLocacao.isEmpty()) {
            sb.append("   Nenhuma locação realizada\n");
        } else {
            for (int i = 0; i < historicoLocacao.size(); i++) {
                sb.append("   Locação #").append(i + 1).append(": ")
                  .append(historicoLocacao.get(i).toString()).append("\n");
            }
        }
        sb.append("─".repeat(60)).append("\n");
        sb.append("   SALDO DEVEDOR: R$ ").append(String.format("%.2f", saldoDevedor)).append("\n");
        sb.append("═".repeat(60)).append("\n");
        return sb.toString();
    }

    public void pagarDebito(double valor) {
        if (valor <= 0) return;
        saldoDevedor -= valor;
        if (saldoDevedor < 0) saldoDevedor = 0;
    }

    // getters
    public double getSaldoDevedor() { return saldoDevedor; }
    public int getNumero() { return numero; }
    public Cliente getTitular() { return titular; }
    public ArrayList<Locacao> getHistoricoLocacao() { return historicoLocacao; }
}