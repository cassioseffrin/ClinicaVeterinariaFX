package model.clinica;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author cassioseffrin
 */
public class Veterinario extends Pessoa implements Serializable {

    private final static String ARQUIVO = "/Users/cassioseffrin/clinica/colectionVeterinario.dat";

    private String CRBIO;

    public String getCRBIO() {
        return CRBIO;
    }

    public void setCRBIO(String CRBIO) {
        this.CRBIO = CRBIO;
    }

    public Veterinario(String CRBIO, String nome, long cpf,   String sexo, LocalDate dataNascimento, String endereco) {
        super(nome, cpf,  sexo, dataNascimento, endereco);
        this.CRBIO = CRBIO;
    }

    @Override
    public String toString() {
        return "Veterinario{" + "CRBIO=" + CRBIO + '}';
    }
    
    

}
