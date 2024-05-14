public class Livro {

    private String titulo;
    private String autor;
    private int ano_de_publicacao;
    private String editora;

    public Livro(String titulo, String autor, int ano_de_publicacao, String editora) {
        this.titulo = titulo;
        this.ano_de_publicacao = ano_de_publicacao;
        this.autor = autor;
        this.editora = editora;
    }

    public void imprimir(){

        System.out.println("Dados do livro:");
        System.out.println("Título: "+ titulo);
        System.out.println("Autor: "+ autor);
        System.out.println("Editora: "+ editora);
        System.out.println("Ano de publicação: "+ ano_de_publicacao);
        System.out.println();

    }
}
