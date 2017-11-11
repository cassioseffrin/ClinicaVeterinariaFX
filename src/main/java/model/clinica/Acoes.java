 
package model.clinica;

import java.time.LocalDate;

/**
 *
 * @author cassioseffrin
 */
public interface Acoes {
    
    public int mover (int metros, int posicaoAtual);
    public  void dormir (int horas );
    public LocalDate consultar (String idenficacao,
LocalDate ultimaConsulta);
}
