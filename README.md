# Backend para gerenciar times de futebol

Você é responsável por construir o backend de um novo gerenciador de times de futebol. Após fecharem o escopo do projeto, você e sua equipe definiram a `@interface` que o software deve implementar. A interface é a seguinte :


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

Os dados devem ficar armazenados na memória.

## Requisitos de Sistema

- Parâmetros com `*` são obrigatórios.
- Os parâmetros, com exceção de identificadores, são sempre íntegros e farão sentido.

### @Desafio("adicionarTime)"

Realiza a inclusão de um novo time.

- Long `id`* Identificador do time
- String `nome`* Nome do Time
- LocalDate `dataCriacao`* Data de criação do time
- String `corUniformePrincipal`* Cor do uniforme principal do time
- String `corUniformeSecundario`* Cor do uniforme secundário do time

### @Desafio("incluirJogador)"

Realiza a inclusão de um novo jogador.

- Long `id`* Identificador do Jogador
- Long `idTime`* Identificador do time
- String `nome`* Nome do Jogador
- LocalDate `dataNascimento`* Data de nascimento do Jogador
- Integer `nivelHabilidade`* Nível de habilidade do jogador (0 a 100)
- BigDecimal `salario`* Salário do jogador



## Tópicos

Neste desafio você aprenderá:

- Variáveis e métodos
- Operadores matemáticos
- Controle de fluxo
- Listas
- Tratamento de exceções





