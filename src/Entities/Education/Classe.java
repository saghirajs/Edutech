package Entities.Education;

public class Classe {
	private int idClasse;
        private int id;
	private int numClasse;
        private String nom;
        private String annee;
	
	public Classe(int idClasse, int numClasse) {
		super();
		this.idClasse = idClasse;
		this.numClasse = numClasse;
	}

    public Classe(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
        
        
       
        
        public Classe(int id, String nom, String annee) {
        this.id = id;
        this.nom = nom;
        this.annee = annee;
    }

	public Classe(int numClasse) {
		super();
		this.numClasse = numClasse;
	}

	public Classe() {
		super();
	}

	public int getIdClasse() {
		return idClasse;
	}
        public int getId() {
        return id;
    }

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}
        public void setId(int id) {
        this.id = id;
    }

	public int getNumClasse() {
		return numClasse;
	}
        

	public void setNumClasse(int numClasse) {
		this.numClasse = numClasse;
	}
        public String getNom() {
        return nom;
    }
        public void setNom(String nom) {
        this.nom = nom;
    }
        public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + idClasse;
//		result = prime * result + numClasse;
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Classe other = (Classe) obj;
//		if (idClasse != other.idClasse)
//			return false;
//		if (numClasse != other.numClasse)
//			return false;
//		return true;
//	}

//	@Override
//	public String toString() {
//		return "Classe [idClasse=" + idClasse + ", numClasse=" + numClasse + "]";
//	}

    @Override
    public String toString() {
        return "Classe{" + "idClasse=" + idClasse + ", id=" + id + ", numClasse=" + numClasse + ", nom=" + nom + ", annee=" + annee + '}';
    }
	
	
	

}
