package exe.gba.minhasolucao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CRUD {
    private Conexao conexao;
    private JdbcTemplate con;

    public CRUD(){
        this.conexao = new Conexao();
        this.con = conexao.getConexaoDoBanco();
        con.execute("""
                CREATE TABLE IF NOT EXISTS livro (
                    id_livro INT PRIMARY KEY AUTO_INCREMENT,
                    nome varchar(255),
                    preco numeric(5,2)
                )
                """);
    }

    public void inserirLivro (String nome, Double preco){
        con.update("""
                INSERT INTO livro (nome, preco) VALUES(
                ?,
                ?
                );
                """, nome, preco);
    }

    public void listarLivros(){
        List<Livro> listaBusca = con.query("SELECT * FROM livro;", new BeanPropertyRowMapper<>(Livro.class));

        System.out.println(listaBusca);
    }

    public void atualizarLivro(Integer idLivro, String novoNome, Double novoPreco) {
        con.update("""
                UPDATE livro SET nome = ?, preco = ? WHERE id_livro = ?;
                """, novoNome, novoPreco, idLivro);
    }

    public void deletarLivro (Integer idLivro) {
        con.update("""
                DELETE FROM livro WHERE id_livro = ?;
                """, idLivro);
    }

    public void buscarLivro (String nome) {
        List<Livro> listaBusca = con.query("SELECT * FROM livro WHERE nome LIKE '%%%s%%';".formatted(nome), new BeanPropertyRowMapper<>(Livro.class));
        System.out.println(listaBusca);
    }
}
