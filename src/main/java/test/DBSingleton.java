/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author cassioseffrin
 */
public class DBSingleton {
    
    private DBSingleton() {
    }
    
    public static DBSingleton getInstance() {
        return DBSingletonHolder.INSTANCE;
    }
    
    private static class DBSingletonHolder {

        private static final DBSingleton INSTANCE = new DBSingleton();
    }
}
