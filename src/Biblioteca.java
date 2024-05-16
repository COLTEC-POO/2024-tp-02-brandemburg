import java.util.Date;
import java.util.Scanner;

public class Biblioteca {

    private String nome = "Biblioteca do Matheus";
    Usuario[] usuariosCadastrados = new Usuario[1];
    int quantidadeUsuarios;
    Livro[] livrosBiblioteca = new Livro[1];
    int quantidadeLivros = 0;
    private int escolha = 10;
    private int infinito = 0;

    public static void main(String[] args){
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarLivroDentro(
                "O Triste Fim de Policarpo Quaresma",
                "Lima Barreto",
                1915,
                "Fundação Editora Unesp"
        );
        biblioteca.cadastrarLivroDentro(
                "Grande Sertão: Veredas",
                "João Guimarães Rosa",
                1956,
                "Editora Nova Fronteira"
        );
        biblioteca.cadastrarLivroDentro(
                "Dom Casmurro",
                "Machado de Assis",
                1899,
                "Editora Garnier"
        );
        biblioteca.cadastrarLivroDentro(
                "Memórias Póstumas de Brás Cubas",
                "Machado de Assis",
                1881,
                "Editora Globo"
        );
        biblioteca.cadastrarLivroDentro(
                "Capitães da Areia",
                "Jorge Amado",
                1937,
                "Companhia das Letras"
        );
        biblioteca.cadastrarLivroDentro(
                "Quincas Borba",
                "Machado de Assis",
                1891,
                "Editora Garnier"
        );
        biblioteca.cadastrarLivroDentro(
                "São Bernardo",
                "Graciliano Ramos",
                1934,
                "Editora Record"
        );
        biblioteca.cadastrarLivroDentro(
                "Claro Enigma",
                "Carlos Drummond de Andrade",
                1951,
                "Companhia Editora Nacional"
        );
        biblioteca.cadastrarLivroDentro(
                "Vidas Secas",
                "Graciliano Ramos",
                1938,
                "Editora Record"
        );
        biblioteca.cadastrarLivroDentro(
                "Terra Sonâmbula",
                "Mia Couto",
                1992,
                "Editora Companhia das Letras"
        );
        biblioteca.cadastrarLivroDentro(
                "A Hora da Estrela",
                "Clarice Lispector",
                1977,
                "Editora Rocco"
        );
        biblioteca.cadastrarLivroDentro(
                "O Cortiço",
                "Aluísio Azevedo",
                1890,
                "Editora Globo"
        );
        biblioteca.cadastrarLivroDentro(
                "A Casa das Sete Mulheres",
                "Leticia Wierzchowski",
                2002,
                "Editora LeYa"
        );
        //Moradores
        biblioteca.cadastrarUsuarioDentro(
                1,
                "José",
                "134.091.391-32",
                0,
                null
        );
        biblioteca.cadastrarUsuarioDentro(
                1,
                "Maria",
                "210.564.783-45",
                1,
                null
        );
        biblioteca.cadastrarUsuarioDentro(
                1,
                "Carlos",
                "055.789.123-98",
                2,
                null
        );
        //Professor
        biblioteca.cadastrarUsuarioDentro(
                3,
                "João",
                "055.182.316-98",
                3,
                "Ciências da computação"
        );


        System.out.println("Bem vindo a "+ biblioteca.nome);
        Scanner scanner = new Scanner(System.in);
        while (biblioteca.infinito == 0) {

            System.out.println("Digite a opção que deseja: ");
            System.out.println
                    (
                    "0) Sair\n" +
                    "1) listar livros\n" +
                    "2) cadastrar livro\n" +
                    "3) listar usuários\n" +
                    "4) cadastrar usuário\n"+
                    "5) Pegar livro\n" +
                    "6) Devolver livro\n"+
                    "7)Listar livros emprestados"
                    );
            biblioteca.escolha = scanner.nextInt();
            scanner.nextLine();
            switch (biblioteca.escolha) {

                case 0:
                    System.out.println("Saindo...");
                    biblioteca.infinito = 1;
                    break;
                case 1:
                    biblioteca.imprimirLivros();
                    biblioteca.escolha = 10;
                    break;
                case 2:
                    biblioteca.cadastrarLivro();
                    break;
                case 3:
                    biblioteca.imprimirUsuarios();
                    biblioteca.escolha = 10;
                    break;
                case 4:
                    biblioteca.cadastrarUsuario();
                    biblioteca.escolha = 10;
                    break;
                case 5:
                    biblioteca.realizarEmprestimo();
                    biblioteca.escolha = 10;
                    break;
                case 6:
                    biblioteca.realizarDevolucao();
                    biblioteca.escolha = 10;
                    break;
                case 7:
                    System.out.println("Digite o id de seu usuário:");
                    int usuarioSelecionado = scanner.nextInt();
                    scanner.nextLine();

                    biblioteca.usuariosCadastrados[usuarioSelecionado].imprimirLivrosEmprestados(biblioteca.usuariosCadastrados[usuarioSelecionado].getVetor());

                    break;
            }
        }

    }
    void imprimirLivros(){
        for (Livro livro: livrosBiblioteca){
            if (livro != null) {
                livro.imprimir();
            }
        }
    }
    void imprimirUsuarios(){
        for (Usuario usuario: usuariosCadastrados){
            if (usuario != null) {
                usuario.imprimirUsuario();
            }
        }
    }
    void cadastrarLivro(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.println("Digite o autor do livro: ");
        String autor = scanner.nextLine();

        System.out.println("Digite o ano de publicação do livro: ");
        int ano_de_publicacao = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a editora do livro: ");
        String editora = scanner.nextLine();

        cadastrarLivroDentro(titulo,autor,ano_de_publicacao,editora);
    }
    void cadastrarLivroDentro(String titulo, String autor, int ano_de_publicacao, String editora){

        if(quantidadeLivros >= livrosBiblioteca.length){

            Livro[] auxiliar = new Livro[livrosBiblioteca.length * 2];

            for (int i = 0; i < livrosBiblioteca.length; i++){
                auxiliar[i] = livrosBiblioteca[i];
            }
            livrosBiblioteca = auxiliar;
        }

        livrosBiblioteca[quantidadeLivros] = new Livro(titulo, autor, ano_de_publicacao, editora, quantidadeLivros);
        quantidadeLivros++;
    }

    /*
    * tipo 1: Morador
    * tipo 2: Aluno
    * tipo 3: Professor
    * */
    void cadastrarUsuario(){
        Scanner scanner = new Scanner(System.in);
        if (quantidadeUsuarios >= usuariosCadastrados.length){
            Usuario[] auxiliar = new Usuario[usuariosCadastrados.length * 2];

            for (int i = 0; i < usuariosCadastrados.length; i++){
                auxiliar[i] = usuariosCadastrados[i];
            }
            usuariosCadastrados = auxiliar;
        }

        System.out.println(
                "Digite o tipo de usuário:\n" +
                "1) Morador\n" +
                "2) Aluno\n" +
                "3) Professor\n");
        int tipoUsuario = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o nome do usuário: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o cpf do usuário: ");
        String cpf = scanner.nextLine();

        System.out.println("Digite o id");
        int id = scanner.nextInt();
        scanner.nextLine();

        switch (tipoUsuario) {
            case 1:
                usuariosCadastrados[quantidadeUsuarios] = new Morador(nome, cpf, new Date(), id);
                System.out.println("Morador criado");
                quantidadeUsuarios++;
                break;
            case 2:
                System.out.println("Digite sua escola: ");
                String escola = scanner.nextLine();

                usuariosCadastrados[quantidadeUsuarios] = new Aluno(nome, cpf, new Date(), id, escola);
                System.out.println("Aluno criado");
                quantidadeUsuarios++;
                break;
            case 3:

                System.out.println("Digite sua formação: ");
                String formacao = scanner.nextLine();

                usuariosCadastrados[quantidadeUsuarios] = new Professor(nome, cpf, new Date(), id, formacao);
                System.out.println("Professor criado");
                quantidadeUsuarios++;
                break;
            default:
                System.out.println("Opção inválida!\n");
        }
    }
    void cadastrarUsuarioDentro(int tipoUsuario, String nome, String cpf, int id, String Escola_Ou_Formacao){
        if (quantidadeUsuarios >= usuariosCadastrados.length){
            Usuario[] auxiliar = new Usuario[usuariosCadastrados.length * 2];

            for (int i = 0; i < usuariosCadastrados.length; i++){
                auxiliar[i] = usuariosCadastrados[i];
            }
            usuariosCadastrados = auxiliar;
        }
        switch (tipoUsuario) {
            case 1:
                usuariosCadastrados[quantidadeUsuarios] = new Morador(nome, cpf, new Date(), id);
                System.out.println("Morador criado");
                quantidadeUsuarios++;
                break;
            case 2:
                usuariosCadastrados[quantidadeUsuarios] = new Aluno(nome, cpf, new Date(), id, Escola_Ou_Formacao);
                System.out.println("Aluno criado");
                quantidadeUsuarios++;
                break;
            case 3:
                usuariosCadastrados[quantidadeUsuarios] = new Professor(nome, cpf, new Date(), id, Escola_Ou_Formacao);
                System.out.println("Professor criado");
                quantidadeUsuarios++;
                break;
            default:
                System.out.println("Opção inválida!\n");
        }
    }
    /*
void realizarDevolucao(): deverá iniciar o processo de devolução
     */
        void realizarEmprestimo(){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite o número correspondente ao seu usuário(Seu id): ");
            imprimirUsuarios();

            int UsuarioSelecionado = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o livro que gostaria de pegar(Id do livro): ");
            int LivroEscolhido = scanner.nextInt();
            scanner.nextLine();

            if (livroDisponivel(livrosBiblioteca[LivroEscolhido])) {

                if (usuariosCadastrados[UsuarioSelecionado].pegarLivro(livrosBiblioteca[LivroEscolhido])) {
                    System.out.println("Livro emprestádo com sucesso!\n");
                    livrosBiblioteca[LivroEscolhido].setCpf(usuariosCadastrados[UsuarioSelecionado].getCpf());
                } else {
                    System.out.println("Falha ao emprestar o livro, limite de livros atingido!");
                }
            }else {
                System.out.println("Livro já emprestado!");
            }
        }
        void realizarDevolucao(){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite o número correspondente ao usuário(Seu id): ");
            int UsuarioSelecionado = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o livro que gostaria de devolver: ");
            usuariosCadastrados[UsuarioSelecionado].imprimirLivrosEmprestados(usuariosCadastrados[UsuarioSelecionado].getVetor());
            int LivroEscolhido = scanner.nextInt();
            scanner.nextLine();

            usuariosCadastrados[UsuarioSelecionado].devolverLivro(livrosBiblioteca[LivroEscolhido]);
            livrosBiblioteca[LivroEscolhido].setCpf(null);
            System.out.println("Livro devolvido com sucesso!");
        }

        private boolean livroDisponivel(Livro livro){
            if (livro.getCpf() == null) {
                return true;
            }else {
                return false;
            }
        }
}
