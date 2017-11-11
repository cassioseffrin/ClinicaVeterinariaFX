/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

 
import model.clinica.Animal;
import model.clinica.Cliente;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import model.database.DatabaseMySQL;

/**
 *
 * @author cassioseffrin
 */
public class AnimalTest {
    
        public static void main(String a[]) {
        Cliente cassio = new Cliente(LocalDate.MAX, "249 9934.2344", "Cliente especial", "Jose", 3223343239L, "Masculino", LocalDate.MIN, "Rua C");

        Animal pepeu = new Animal();
        pepeu.setNome("Pet");
        pepeu.setCor("azul");
        pepeu.setPeso(5);

        Connection con = DatabaseMySQL.getConnection();
        AnimalDAO animalDao = new AnimalDAO();
        animalDao.setConnection((com.mysql.jdbc.Connection) con);
        animalDao.inserir(pepeu);
        

        List<Animal> lstAnimais =  animalDao.listar();
        
        System.out.println("tamanho" + lstAnimais.size());
            
       
        
        
        
 
    }
}
