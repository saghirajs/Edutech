/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities.Education;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author saghir
 */
public class Module {
        private int idModule;
	private String nomModule;
	private int coefModule;
        List<Matiere> matieres;
        private int id;
        private String nom;
        private int coef;
        private String specialite;
        private int idSpecialite;
        
        
        public Module(int id, String nom, int coef, String specialite) {
        this.id = id;
        this.nom = nom;
        this.coef = coef;
        this.specialite = specialite;
        
    }
        public Module(int idModule, int idSpecialite, String nomModule, int coefModule) {
        this.idModule = idModule;
        this.idSpecialite = idSpecialite;
        this.nomModule = nomModule;
        this.coefModule = coefModule;
    }
	
	
        public Module(String nomModule, int coefModule) {
        this.matieres=new ArrayList<>();
        this.nomModule = nomModule;
        this.coefModule = coefModule;
        }
        
    public Module() {
        this.matieres=new ArrayList<>();
    }

    public Module(int idModule, String nomModule, int coefModule) {
        this.idModule = idModule;
        this.nomModule = nomModule;
        this.coefModule = coefModule;
    }

    public int getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(int idSpecialite) {
        this.idSpecialite = idSpecialite;
    }
        
       
	
	
        

    

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    
    
	public int getIdModule() {
		return idModule;
	}
	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}
	public String getNomModule() {
		return nomModule;
	}
	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}
	public int getCoefModule() {
		return coefModule;
	}
	public void setCoefModule(int coefModule) {
		this.coefModule = coefModule;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coefModule;
		result = prime * result + idModule;
		result = prime * result + ((nomModule == null) ? 0 : nomModule.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (coefModule != other.coefModule)
			return false;
		if (idModule != other.idModule)
			return false;
		if (nomModule == null) {
			if (other.nomModule != null)
				return false;
		} else if (!nomModule.equals(other.nomModule))
			return false;
		return true;
	}

    @Override
    public String toString() {
        return "Module{" + "idModule=" + idModule + ", nomModule=" + nomModule + ", coefModule=" + coefModule + ", matieres=" + matieres + ", id=" + id + ", nom=" + nom + ", coef=" + coef + ", specialite=" + specialite + '}';
    }
	
}
