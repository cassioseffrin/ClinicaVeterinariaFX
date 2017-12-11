package model.dao;

import model.clinica.Animal;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.database.DatabaseMySQL;

/**
 *
 * @author cassioseffrin
 */
public final class AnimalDAO {

    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public AnimalDAO() {
        Connection con = DatabaseMySQL.getConnection();
        setConnection((com.mysql.jdbc.Connection) con);
    }

    public boolean inserir(Animal animal) {
        String sql = "INSERT INTO animal(nome, peso, cor) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, animal.getNome());
            stmt.setLong(2, animal.getPeso());
            stmt.setString(3, animal.getCor());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Integer id) {
        String sql = "DELETE FROM animal WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Animal> listar() {
        String sql = "SELECT * FROM animal";
        List<Animal> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Animal animal = new Animal();
                animal.setId(resultado.getInt("id"));
                animal.setNome(resultado.getString("nome"));
                animal.setPeso(resultado.getInt("peso"));
                animal.setCor(resultado.getString("cor"));
                retorno.add(animal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public boolean atualizar(Animal animalSelecionado) {
        String sql = "UPDATE animal SET nome=?, peso=?, cor=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, animalSelecionado.getNome());
            stmt.setInt(2, animalSelecionado.getPeso());
            stmt.setString(3, animalSelecionado.getCor());
            stmt.setInt(4, animalSelecionado.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
