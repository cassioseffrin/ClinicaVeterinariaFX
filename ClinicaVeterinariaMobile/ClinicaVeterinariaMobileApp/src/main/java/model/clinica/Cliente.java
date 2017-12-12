package model.clinica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlRootElement;
import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 *
 * @author cassioseffrin
 */
 @XmlRootElement
public class Cliente extends Pessoa implements Serializable, Acoes {

    
    private Integer id;
    
  
    private LocalDate dataCadastro;
    private String telefone;
    private String observacao;

    private final static String ARQUIVO = "/Users/cassioseffrin/clinica/colectionCliente.dat";
    public static final long serialVersionUID = 5000493038443485120L;

    public Cliente(LocalDate dataCadastro, String telefone, String observacao, String nome, long cpf, String sexo, LocalDate dataNascimento, String endereco) {
        super(nome, cpf, sexo, dataNascimento, endereco);
        this.dataCadastro = dataCadastro;
        this.telefone = telefone;
        this.observacao = observacao;
    }

    public Cliente() {

    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return  super.toString() +  ", Cadastro: " + dataCadastro + ", telefone: " + telefone + ", observacao=" + observacao;
    }

 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
    public static boolean gravarColecao(HashSet<Cliente> lstClientes) {
        File f = new File(ARQUIVO);
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lstClientes);
            oos.close();
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
        
        return true;

       
    }
    
    
     public static HashSet<Cliente> lerColecao() throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File(ARQUIVO);
        FileInputStream fis;
        fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object col = ois.readObject();
        HashSet<Cliente> colecaoDeserializable = (HashSet<Cliente>) col;
        ois.close();
        return colecaoDeserializable; 
    }
     
     public static Cliente procurarCliente(long cpf){
        try {
            HashSet<Cliente> lista = lerColecao();
 
            for (Cliente c: lista){
                if (c.getCpf() == cpf){
                    return c;
                }    
            }                      
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;       
    }

}
