public class Livro {

    private String titulo;
    private String autor;
    private int ano_de_publicacao;
    private String editora;
    private int codigoLivro;
    private String cpf = null;

    public Livro(String titulo, String autor, int ano_de_publicacao, String editora, int codigoLivro) {
        this.titulo = titulo;
        this.ano_de_publicacao = ano_de_publicacao;
        this.autor = autor;
        this.editora = editora;
        this.codigoLivro = codigoLivro;
    }

    void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public int getCodigoLivro() {
        return codigoLivro;
    }

    public void imprimir(){

        System.out.println("Dados do livro:");
        System.out.println("Título: "+ titulo);
        System.out.println("Autor: "+ autor);
        System.out.println("Editora: "+ editora);
        System.out.println("Ano de publicação: "+ ano_de_publicacao);
        System.out.println("Código do livro: "+ codigoLivro);
        System.out.println();

    }
}
