package locadora;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Locacao {
    private Date dataLocacao;
    private ArrayList<Filme> listaFilmes;
    private double valorTotalApagar;

    public Locacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
        this.listaFilmes = new ArrayList<>();
        this.valorTotalApagar = 0.0;
    }

    public void addFilme(Filme filme) {
        if (filme == null) return;
        listaFilmes.add(filme);
        valorTotalApagar += filme.getValorLocacao();
    }

    public Date getDataLocacao() { return dataLocacao; }
    public double getValorTotalApagar() { return valorTotalApagar; }
    public ArrayList<Filme> getListaFilmes() { return listaFilmes; }

    public String filmesComoString() {
        if (listaFilmes.isEmpty()) {
            return "Nenhum filme";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listaFilmes.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(listaFilmes.get(i).getTitulo());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(dataLocacao) + " | Filmes: " + filmesComoString() + " | Total: R$ " + String.format("%.2f", valorTotalApagar);
    }
}