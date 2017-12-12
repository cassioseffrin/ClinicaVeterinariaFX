 
package model.clinica;

/**
 *
 * @author cassioseffrin
 */
public class Density {
 
    public enum DENSITY {
        D000(0,10), 
        D010(10,50),
        D050(50,100),
        D100(100,250),
        D250(250,500),
        D500(500,10000);
        
        final double ini;
        final double end;

        public double getIni() {
            return ini;
        }

        public double getEnd() {
            return end;
        }
        
        
        
        
        private DENSITY(double ini, double end){
            this.ini=ini;
            this.end=end;
        }
 
        public static DENSITY getDensity (double density){
            for(DENSITY d: DENSITY.values()){
                if(d.getIni() <= density && density < d.getEnd()){
                    return d;
                }
            }
            return DENSITY.D000;
        }
        
    }
}  
