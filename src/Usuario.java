import java.util.Date;

public class Usuario {
    /*

boolean devolverLivro(Livro): deverá fazer a devolução de um livro

boolean pegarLivro(Livro): deverá pegar um livro para empréstimo

void imprimirLivros(): deverá imprimir todos os livros que estão em empréstimo pelo usuário
 */

    protected String nome;
    protected String cpf;
    protected Date data;
    protected int id;

    Usuario(String nome, String cpf, Date data, int id){
        this.nome = nome;
        this.cpf = cpf;
        this.data = data;
        this.id = id;

    }

    boolean devolverLivro(){
        return true;
    }
    boolean pegarLivro(){
        return true;
    }
    void imprimirLivros(){

    }

}
