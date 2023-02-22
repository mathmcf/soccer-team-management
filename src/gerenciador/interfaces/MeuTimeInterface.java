package gerenciador.interfaces;

import gerenciador.Jogador;
import gerenciador.Time;
import gerenciador.exceptions.MeuTimeException;

import java.math.BigDecimal;
import java.util.List;

public interface MeuTimeInterface {

    void adicionarTime(Time time);

    void incluirJogador(Jogador jogador, Long idTime) throws MeuTimeException;

    void definirCapitao(Long idJogador, Long idTime) throws MeuTimeException;

    Jogador buscarCapitaoDoTime(Long idTime) throws MeuTimeException;

    String buscarNomeJogador(Long idJogador) throws MeuTimeException;

    List<Jogador> buscarJogadoresDeTodosOsTimes() throws MeuTimeException;

    String getNomeTime(Long idTime) throws MeuTimeException;

    Jogador buscarJogadorMaiorSalario(Long idTime) throws MeuTimeException;

    BigDecimal buscarSalarioDoJogador(Long idJogador) throws MeuTimeException;

    List<Jogador> getJogadoresDoTime(Long idTime) throws MeuTimeException;

    Jogador buscarMelhorJogadorDoTime(Long idTime) throws MeuTimeException;

    Jogador buscarJogadorMaisVelho() throws MeuTimeException;

    List<Time> buscarTimes();

    List<Jogador> buscarTopJogadores(Integer numJogadores);

    List<Jogador> buscarJogadoresTime(Long idTime) throws MeuTimeException;

}
