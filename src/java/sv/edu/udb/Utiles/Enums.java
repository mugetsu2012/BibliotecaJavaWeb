/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Utiles;

/**
 *
 * @author Douglas
 */
public class Enums {
    
    public enum Roles {
        Admin(1), Alumno(2),Profesor(3);
        
        private final int id;
        Roles(int id) { this.id = id; }
        public int getValue() { return id; }
    }
}
