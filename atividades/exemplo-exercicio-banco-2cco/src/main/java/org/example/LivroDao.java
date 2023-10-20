package org.example;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class LivroDao {

  private JdbcTemplate con;

  public LivroDao(JdbcTemplate con) {
    this.con = con;
  }

  public List<Livro> listar() {
    return con.query(
        "SELECT * FROM livro",
        new BeanPropertyRowMapper<>(Livro.class));
  }

  public List<Livro> buscarPorNome(String nome) {
    return con.query("SELECT * FROM livro WHERE nome LIKE ?",
        new BeanPropertyRowMapper<>(Livro.class), "%" + nome + "%");
  }

  public void cadastrar(Livro livro) {
    con.update("INSERT INTO livro (nome, preco) VALUES (?, ?)",
        livro.getNome(), livro.getPreco());
  }

  public void atualizar(Livro livro) {
    con.update("UPDATE livro SET nome = ?, preco = ? WHERE id = ?",
        livro.getNome(), livro.getPreco(), livro.getId());
  }

  public void remover(Integer id) {
    con.update("DELETE FROM livro WHERE id = ?", id);
  }
}
