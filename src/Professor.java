import java.util.Date;

public class Professor extends Usuario{

    private String formacao;
    Livro[] livrosProfessor = new Livro[10];

    public Professor(String nome, String cpf, Date data, int id, String formacao){
        super(nome, cpf, data, id);
        this.formacao = formacao;
    }
}
