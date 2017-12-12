 
package model.clinica;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author cassioseffrin
 */
public class USState {
 
    private String name;
    private String abbr;
    private String capital;
    private int population;
    private int area;
    private String flag;
   
    public USState(String name, String abbr, String capital, int population, int area, String flag) {
        this.name = name;
        this.abbr = abbr;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
    
        public static ObservableList statesList = FXCollections.observableArrayList(
            new USState("Alabama", "AL", "Montgomery", 4833722, 135767, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Flag_of_Alabama.svg/23px-Flag_of_Alabama.svg.png"),
            new USState("Wyoming", "WY", "Cheyenne", 582658, 253335, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Flag_of_Wyoming.svg/22px-Flag_of_Wyoming.svg.png")
    );
   
}
