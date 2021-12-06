/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities.Education;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author saghir
 */
public class Matiere {
    private int idMatiere;
    private String nomMatiere;
    private int coefMatiere;
    private int id;
    private String nom;
    private int coef;
    private int module;
    private int professeur;
    private String nomModule;
    private String de_croissant;
    private String nomProf;
    private int idProf;
    private int idClasse;
    private int idModule;
    private ObservableList<Cours> cours;

    public Matiere(int idMatiere, String nomMatiere, int coefMatiere, String de_croissant) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
        this.coefMatiere = coefMatiere;
        this.de_croissant = de_croissant;
    }

    public Matiere(int idMatiere, String nomMatiere, int coefMatiere) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
        this.coefMatiere = coefMatiere;
    }
    
    
    

    public Matiere() {
        
    }
   

    public ObservableList<Cours> getCours() {
        return cours;
    }

    public void setCours(ObservableList<Cours> c) {
        this.cours = c;
    }

    public Matiere(String nomMatiere, int coefficient) {
        this.cours = FXCollections.observableArrayList();

        this.nomMatiere = nomMatiere;
        this.coefMatiere = coefficient;
    }

    public Matiere(int idMatiere, int idProf, int idClasse, int idModule, String nomMatiere, int coefMatiere) {
        this.cours = FXCollections.observableArrayList();
        this.idMatiere = idMatiere;
        this.idProf = idProf;
        this.idClasse = idClasse;
        this.idModule = idModule;
        this.nomMatiere = nomMatiere;
        this.coefMatiere = coefMatiere;
    }

    public Matiere(int idMatiere, int idModule, String nomMatiere, int coefMatiere) {
        this.cours = FXCollections.observableArrayList();
        this.idMatiere = idMatiere;
        this.idModule = idModule;
        this.nomMatiere = nomMatiere;
        this.coefMatiere = coefMatiere;
    }
    

    
    
    public Matiere(int id, String nom, int coef, String nomModule, String nomProf) {
        this.id = id;
        this.nom = nom;
        this.coef = coef;
        this.nomModule = nomModule;
        this.nomProf = nomProf;
        
    }
    

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public int getProfesseur() {
        return professeur;
    }

    public void setProfesseur(int professeur) {
        this.professeur = professeur;
    }

    public String getNomModule() {
        return nomModule;
    }

    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }

    public String getNomProf() {
        return nomProf;
    }

    public void setNomProf(String nomProf) {
        this.nomProf = nomProf;
    }

    
    

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public int getId() {
        return idMatiere;
    }

    public void setId(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public int getCoefMatiere() {
        return coefMatiere;
    }

    public void setCoefMatiere(int coefficient) {
        this.coefMatiere = coefficient;
    }

    @Override
    public int hashCode() {
        int hash=0;
        hash = this.idMatiere;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matiere other = (Matiere) obj;
        if (this.idMatiere != other.idMatiere) {
            return false;
        }
        if (!Objects.equals(this.nomMatiere, other.nomMatiere)) {
            return false;
        }
        return true;
    }

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    @Override
    public String toString() {
        return "Matiere{" + "idMatiere=" + idMatiere + ", nomMatiere=" + nomMatiere + ", coefMatiere=" + coefMatiere + ", id=" + id + ", nom=" + nom + ", coef=" + coef + ", module=" + module + ", professeur=" + professeur + ", nomModule=" + nomModule + ", nomProf=" + nomProf + ", idProf=" + idProf + ", idClasse=" + idClasse + ", idModule=" + idModule + ", cours=" + cours + '}';
    }
    

   
    

    
    
    
}
