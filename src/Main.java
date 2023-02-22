import gerenciador.Jogador;
import gerenciador.Time;
import gerenciador.exceptions.MeuTimeException;
import gerenciador.interfaces.MeuTimeImpl;
import gerenciador.interfaces.MeuTimeInterface;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        MeuTimeInterface meuTimeInterface = new MeuTimeImpl();
        Time time = new Time(1L, null, "Cruzeiro", LocalDate.now(), "Azul", "Branco");
        meuTimeInterface.adicionarTime(time);

        Jogador jogador = new Jogador(1L, "Neymar", LocalDate.now().plusYears(4), 10, BigDecimal.valueOf(10000L));
        Jogador jogador2 = new Jogador(2L, "Ronaldo", LocalDate.now().plusYears(2), 12, BigDecimal.valueOf(30000L));
        Jogador jogador3 = new Jogador(3L, "Cristiano Ronaldo", LocalDate.now().plusYears(10), 20, BigDecimal.valueOf(30000L));

        try {

            meuTimeInterface.incluirJogador(jogador, 1L);
            meuTimeInterface.incluirJogador(jogador2, 1L);
            meuTimeInterface.incluirJogador(jogador3, 1L);

            var jogadores = meuTimeInterface.buscarJogadoresTime(1L);
            System.out.println(jogadores);

            var melhorJogador = meuTimeInterface.buscarMelhorJogadorDoTime(1L);
            System.out.println(melhorJogador);

            var jogadorMaiorSalario = meuTimeInterface.buscarJogadorMaiorSalario(1L);
            System.out.println(jogadorMaiorSalario);

            var nomeJogador = meuTimeInterface.buscarNomeJogador(2L);
            System.out.println(nomeJogador);

            var jogadoresTodosOsTimes = meuTimeInterface.buscarJogadoresDeTodosOsTimes();
            System.out.println(jogadoresTodosOsTimes);

            var jogadorMaisVelho = meuTimeInterface.buscarJogadorMaisVelho();
            System.out.println(jogadorMaisVelho);

            var topJogadores = meuTimeInterface.buscarTopJogadores(2);
            System.out.println(topJogadores);


        } catch (MeuTimeException e) {
            System.out.println(e.getMessage());
        }


    }

}
