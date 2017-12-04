package model.clinica;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import javafx.util.converter.LocalDateStringConverter;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author cassioseffrin
 */
public abstract class Pessoa implements Acoes, Serializable {

    private String nome;
    private long cpf;

    private String sexo;
    private LocalDate dataNascimento;
    private String endereco;

    
    
    
    public Pessoa(String nome, long cpf, String sexo, LocalDate dataNascimento, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public Pessoa() {
    }

    @Override
    public int mover(int metros, int posicaoAtual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dormir(int horas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalDate consultar(String idenficacao, LocalDate ultimaConsulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        return nome;
    }
 

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @JsonIgnore
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public static int getIdade(LocalDate nascimento, LocalDate dataAtual) {
        if ((nascimento != null) && (dataAtual != null)) {
            return Period.between(nascimento, dataAtual).getYears();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        
        return "Pessoa{" + "nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + ", idade: " +getIdade(dataNascimento, LocalDate.now()) +'}';
    }
    
    
    

}
