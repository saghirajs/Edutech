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
public class module_matiere {

    private int module_id;
    private int matiere_id;

    public module_matiere(int module_id, int matiere_id) {
        this.module_id = module_id;
        this.matiere_id = matiere_id;
    }

    public module_matiere() {
    }

    public int getModule_id() {
        return module_id;
    }

    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }

    public int getMatiere_id() {
        return matiere_id;
    }

    public void setMatiere_id(int matiere_id) {
        this.matiere_id = matiere_id;
    }
    
    
}
