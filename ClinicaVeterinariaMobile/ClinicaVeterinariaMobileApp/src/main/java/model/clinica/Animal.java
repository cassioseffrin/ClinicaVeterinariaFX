 
package model.clinica;

import java.time.LocalDate;

/**
 *
 * @author cassioseffrin
 */
public  class Animal implements Acoes{
    
    private int id;
    
    private String nome;
    private LocalDate dataNascimento;
    private int peso;
    private String cor;
    private int posicaoAtual ;

    public Animal(String nome, LocalDate dataNascimento, int peso, String cor, int posicaoAtual) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.cor = cor;
        this.posicaoAtual = posicaoAtual;
    }

    public Animal() {
       
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getPosicaoAtual() {
        return posicaoAtual;
    }

    public void setPosicaoAtual(int posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
}
