package gerenciador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Time {

    private Long id;
    private Jogador capitao;
    private String nome;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;
    private List<Jogador> jogadores;

    public Time(Long id) {
        this.id = id;
    }

    public Time(Long id, Jogador capitao, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        this.id = id;
        this.capitao = capitao;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
        this.jogadores = new ArrayList<>();
    }

    public Jogador adicionarJogador(Jogador jogador) {

        this.jogadores.add(jogador);

        return jogador;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogador getCapitao() {
        return capitao;
    }

    public void setCapitao(Jogador capitao) {
        this.capitao = capitao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public void setCorUniformePrincipal(String corUniformePrincipal) {
        this.corUniformePrincipal = corUniformePrincipal;
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public void setCorUniformeSecundario(String corUniformeSecundario) {
        this.corUniformeSecundario = corUniformeSecundario;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", capitao=" + capitao +
                ", nome='" + nome + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", corUniformePrincipal='" + corUniformePrincipal + '\'' +
                ", corUniformeSecundario='" + corUniformeSecundario + '\'' +
                ", jogadores=" + jogadores +
                '}';
    }


}
