import java.util.Date;

public class Aluno extends Usuario{
    private String escola;
    Livro[] livrosAluno = new Livro[5];

    public Aluno(String nome, String cpf, Date data, int id, String escola) {
        super(nome, cpf, data, id);
        this.escola = escola;
    }
    void imprimirUsuario(){
        super.imprimirUsuario();
        System.out.println("Escola: "+escola);
    }
}
