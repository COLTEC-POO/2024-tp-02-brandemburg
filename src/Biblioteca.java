import java.util.Date;
import java.util.Scanner;

public class Biblioteca {
    /*

void realizarEmprestimo(): deverá inicializar o processo de empréstimo

void realizarDevolucao(): deverá iniciar o processo de devolução
     */

    private String nome = "Biblioteca do Matheus";
    Usuario[] usuariosCadastrados = new Usuario[1];
    int quantidadeUsuarios;
    Livro[] livrosBiblioteca = new Livro[1];
    int quantidadeLivros = 0;
    private int escolha = 10;
    private int infinito = 0;

    public static void main(String[] args){
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarLivro(
                "O Triste Fim de Policarpo Quaresma",
                "Lima Barreto",
                1915,
                "Fundação Editora Unesp"
        );
        biblioteca.cadastrarLivro(
                "Grande Sertão: Veredas",
                "João Guimarães Rosa",
                1956,
                "Editora Nova Fronteira"
        );
        biblioteca.cadastrarLivro(
                "Dom Casmurro",
                "Machado de Assis",
                1899,
                "Editora Garnier"
        );
        biblioteca.cadastrarLivro(
                "Memórias Póstumas de Brás Cubas",
                "Machado de Assis",
                1881,
                "Editora Globo"
        );
        biblioteca.cadastrarLivro(
                "Capitães da Areia",
                "Jorge Amado",
                1937,
                "Companhia das Letras"
        );
        biblioteca.cadastrarLivro(
                "Quincas Borba",
                "Machado de Assis",
                1891,
                "Editora Garnier"
        );
        biblioteca.cadastrarLivro(
                "São Bernardo",
                "Graciliano Ramos",
                1934,
                "Editora Record"
        );
        biblioteca.cadastrarLivro(
                "Claro Enigma",
                "Carlos Drummond de Andrade",
                1951,
                "Companhia Editora Nacional"
        );
        biblioteca.cadastrarLivro(
                "Vidas Secas",
                "Graciliano Ramos",
                1938,
                "Editora Record"
        );
        biblioteca.cadastrarLivro(
                "Terra Sonâmbula",
                "Mia Couto",
                1992,
                "Editora Companhia das Letras"
        );
        biblioteca.cadastrarLivro(
                "A Hora da Estrela",
                "Clarice Lispector",
                1977,
                "Editora Rocco"
        );
        biblioteca.cadastrarLivro(
                "O Cortiço",
                "Aluísio Azevedo",
                1890,
                "Editora Globo"
        );
        biblioteca.cadastrarLivro(
                "A Casa das Sete Mulheres",
                "Leticia Wierzchowski",
                2002,
                "Editora LeYa"
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
                    "4) cadastrar usuário\n");
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

                    break;
                case 3:
                    biblioteca.imprimirUsuários();
                    biblioteca.escolha = 10;
                    break;
                case 4:
                    biblioteca.cadastrarUsuario();
                    biblioteca.escolha = 10;
                    break;
            }
        }
        scanner.close();

    }
    void imprimirLivros(){
        for (Livro livro: livrosBiblioteca){
            if (livro != null) {
                livro.imprimir();
            }
        }
    }
    void imprimirUsuários(){
        for (Usuario usuario: usuariosCadastrados){
            if (usuario != null) {
                usuario.imprimirUsuario();
            }
        }
    }
    void cadastrarLivro(String titulo, String autor, int ano_de_publicacao, String editora){

        if(quantidadeLivros >= livrosBiblioteca.length){

            Livro[] auxiliar = new Livro[livrosBiblioteca.length * 2];

            for (int i = 0; i < livrosBiblioteca.length; i++){
                auxiliar[i] = livrosBiblioteca[i];
            }
            livrosBiblioteca = auxiliar;
        }

        livrosBiblioteca[quantidadeLivros] = new Livro(titulo, autor, ano_de_publicacao, editora);
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
        //scanner.nextLine();

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
        scanner.close();
    }
}
