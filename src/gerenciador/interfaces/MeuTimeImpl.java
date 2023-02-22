package gerenciador.interfaces;

import gerenciador.Jogador;
import gerenciador.Time;
import gerenciador.exceptions.MeuTimeException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeuTimeImpl implements MeuTimeInterface {

    private List<Time> listaTimes;

    public MeuTimeImpl() {

        this.listaTimes = new ArrayList<>();
    }

    @Override
    public void adicionarTime(Time time) {

        listaTimes.add(time);

    }

    @Override
    public void incluirJogador(Jogador jogador, Long idTime) throws MeuTimeException {

        var time = this.buscarTimeNaLista(idTime);
        time.adicionarJogador(jogador);
    }

    @Override
    public void definirCapitao(Long idJogador, Long idTime) throws MeuTimeException {

        var time = this.buscarTimeNaLista(idTime);
        var jogador = this.buscarJogadorNoTimePeloID(idJogador, time);

        time.setCapitao(jogador);

    }

    @Override
    public Jogador buscarCapitaoDoTime(Long idTime) throws MeuTimeException {

        var time = this.buscarTimeNaLista(idTime);
        return time.getCapitao();
    }

    @Override
    public String buscarNomeJogador(Long idJogador) throws MeuTimeException {


        var jogadores = this.buscarJogadoresDeTodosOsTimes();

        var jogador = jogadores.stream().filter(j -> idJogador.equals(j.getId())).findFirst();

        if (jogador.isEmpty()) {
            throw new MeuTimeException("O jogador não foi encontrado no time");
        }

        return jogador.get().getNome();

    }

    @Override
    public List<Jogador> buscarJogadoresDeTodosOsTimes() {

        List<Jogador> listaJogadores = new ArrayList<>();

        for (Time t : listaTimes) {
            listaJogadores.addAll(t.getJogadores());
        }

        return listaJogadores;

    }

    @Override
    public String getNomeTime(Long idTime) throws MeuTimeException {

        var time = this.buscarTimeNaLista(idTime);
        return time.getNome();

    }

    /* Fazer */
    @Override
    public Jogador buscarJogadorMaiorSalario(Long idTime) throws MeuTimeException {

        var time = this.buscarTimeNaLista(idTime);

        var jogadorDeMaiorSalario = time.getJogadores().get(0);
        for (Jogador jogador : time.getJogadores()) {

            if (0 < jogador.getSalario().compareTo(jogadorDeMaiorSalario.getSalario())) {
                jogadorDeMaiorSalario = jogador;
            }
        }

        return jogadorDeMaiorSalario;

    }

    /* Fazer */
    @Override
    public BigDecimal buscarSalarioDoJogador(Long idJogador) throws MeuTimeException {

        List<Jogador> listaJogadores = new ArrayList<>();

        for (Time time : listaTimes) {

            listaJogadores.addAll(time.getJogadores());
        }

        for (Jogador jogador : listaJogadores) {

            if (jogador.getId().equals(idJogador)) {

                return jogador.getSalario();
            }

        }

        throw new MeuTimeException("O jogador não foi encontrado");
    }

    @Override
    public List<Jogador> getJogadoresDoTime(Long timeId) throws MeuTimeException {

        return this.buscarTimeNaLista(timeId).getJogadores();

    }


    @Override
    public Jogador buscarMelhorJogadorDoTime(Long idTime) throws MeuTimeException {

        var time = buscarTimeNaLista(idTime);
        var jogadores = time.getJogadores();

        var jogadorMaiorHabilidade = jogadores.stream().max(Comparator.comparing(Jogador::getNivelHabilidade));

        if (jogadorMaiorHabilidade.isPresent()) {

            return jogadorMaiorHabilidade.get();
        }

        throw new MeuTimeException("Não existem jogares nesse time");

    }

    @Override
    public Jogador buscarJogadorMaisVelho() throws MeuTimeException {

        var listaJogadores = this.buscarJogadoresDeTodosOsTimes();

        return listaJogadores.stream().max(Comparator.comparing(Jogador::getDataNascimento)).orElseThrow(() -> new MeuTimeException("O jogador não foi encontrado em nenhum time"));


    }

    @Override
    public List<Time> buscarTimes() {

        return this.listaTimes;
    }

    @Override
    public List<Jogador> buscarTopJogadores(Integer numJogadores) {

        var listaJogadores = this.buscarJogadoresDeTodosOsTimes();

        var topJogadores = listaJogadores.stream().sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed()).toList();

        return topJogadores.subList(0, numJogadores + 1);
    }

    @Override
    public List<Jogador> buscarJogadoresTime(Long idTime) throws MeuTimeException {

        var time = this.buscarTimeNaLista(idTime);

        return time.getJogadores();

    }

    private Time buscarTimeNaLista(Long idTime) throws MeuTimeException {

        var timeOptional = listaTimes.stream().filter(time -> time.getId().equals(idTime)).findAny();

        if (timeOptional.isPresent()) {
            return timeOptional.get();
        }

        throw new MeuTimeException("O time não foi encontrado na lista");

    }

    private Jogador buscarJogadorNoTimePeloID(Long idJogador, Time time) throws MeuTimeException {

        var jogadores = time.getJogadores();
        var jogador = jogadores.stream().filter(jg -> jg.getId().equals(idJogador)).findAny();

        if (jogador.isEmpty()) {
            throw new MeuTimeException("O jogador não existe no time informado");
        }

        return jogador.get();
    }
}
