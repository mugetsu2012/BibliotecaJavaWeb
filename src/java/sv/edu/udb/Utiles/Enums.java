/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Utiles;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Douglas
 */
public class Enums {

    public static enum Roles {
        Admin(1), Alumno(2), Profesor(3);

        private int value;
        private static Map map = new HashMap<>();

        private Roles(int value) {
            this.value = value;
        }

        static {
            for (Roles rol : Roles.values()) {
                map.put(rol.value, rol);
            }
        }

        public static Roles valueOf(int rol) {
            return (Roles) map.get(rol);
        }

        public int getValue() {
            return value;
        }
    }
}
