import java.util.Date;
import java.util.Scanner;

public class Biblioteca {
    /*
void cadastrarUsuario(): deverá cadastrar um novo usuário na biblioteca

void realizarEmprestimo(): deverá inicializar o processo de empréstimo

void realizarDevolucao(): deverá iniciar o processo de devolução
     */

    private String nome = "Biblioteca do Matheus";
    Usuario[] usuariosCadastrados = new Usuario[10];
    int quantidadeUsuarios;
    Livro[] livrosBiblioteca = new Livro[1];
    int quantidadeLivros = 0;
    private int escolha = 0;
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
        System.out.println("Digite a opção que deseja: ");
        System.out.println
                (
                "0) Sair" +
                "1) listar livros  " +
                "2) cadastrar livro" +
                "3) cadastrar usuário");
        Scanner scanner = new Scanner(System.in);
        biblioteca.escolha = scanner.nextInt();

        while (biblioteca.infinito == 0) {
            switch (biblioteca.escolha) {

                case 0:
                    System.out.println("Saindo...");
                    biblioteca.infinito = 1;
                    break;
                case 1:
                    biblioteca.imprimirLivros();
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Digite o tipo de usuário:" +
                            "1) Morador" +
                            "2) Aluno" +
                            "3) Professor");
                    int tipoUsuario = scanner.nextInt();

                    System.out.println("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();

                    System.out.println("Digite o cpf do usuário: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Digite o id");
                    int id = scanner.nextInt();


                    biblioteca.cadastrarUsuario(nome, cpf, new Date(), id, tipoUsuario);
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
    void cadastrarUsuario(String nome, String cpf, Date data, int id, int tipoUsuario){
        Scanner scanner = new Scanner(System.in);
        if (quantidadeUsuarios >= usuariosCadastrados.length){
            Usuario[] auxiliar = new Usuario[usuariosCadastrados.length * 2];

            for (int i = 0; i < usuariosCadastrados.length; i++){
                auxiliar[i] = usuariosCadastrados[i];
            }
            usuariosCadastrados = auxiliar;
        }

        switch (tipoUsuario) {
            case 1:
                usuariosCadastrados[quantidadeUsuarios] = new Morador(nome, cpf, data, id);
                quantidadeUsuarios++;
                break;
            case 2:

                System.out.println("Digite sua escola: ");
                String escola = scanner.nextLine();

                usuariosCadastrados[quantidadeUsuarios] = new Aluno(nome, cpf, data, id, escola);
                quantidadeUsuarios++;
                break;
            case 3:

                System.out.println("Digite sua formação: ");
                String formacao = scanner.nextLine();

                usuariosCadastrados[quantidadeUsuarios] = new Professor(nome, cpf, data, id, formacao);
                quantidadeUsuarios++;
                break;
        }
    }
}
