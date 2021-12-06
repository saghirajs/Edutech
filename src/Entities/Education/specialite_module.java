/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities.Education;

/**
 *
 * @author saghir
 */
public class specialite_module {
    
    private int specialite_id;
    private int module_id;

    public specialite_module(int specialite_id, int module_id) {
        this.specialite_id = specialite_id;
        this.module_id = module_id;
    }

    public specialite_module() {
    }

    public int getSpecialite_id() {
        return specialite_id;
    }

    public int getModule_id() {
        return module_id;
    }
    
    
    
}
