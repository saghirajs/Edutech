package Entities.Utilisateur;


public class Etudiant extends Utilisateur{
	 int id ;
    String nom;
    String prenom;
    private int parent;
    private int classe;
    private int idEtudiant;
    
    

    public Etudiant(int id, String nom, String prenom, String email, String password, String cin, int numTel, String dateNaissance, String adresse, int type) {
//        super(id, nom, prenom, email, password, cin, numTel, dateNaissance, adresse, type);
    }
    public Etudiant() {
        super();
    }

    public Etudiant(int id, int parent, int classe, int idEtudiant) {
        this.id = id;
        this.parent = parent;
        this.classe = classe;
        this.idEtudiant = idEtudiant;
    }

    public Etudiant(int id, int parent, int idEtudiant, int id_user, String firstName, String lastName, String email, int cin, String plainPassword, String password, String role, int classe) {
        //super(id_user, firstName, lastName, email, cin, plainPassword, password, role, classe);
        this.id = id;
        this.parent = parent;
        this.classe = classe;
        this.idEtudiant = idEtudiant;
    }

    

   

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String toString() {
        return "Etudiant{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", parent=" + parent + ", classe=" + classe + ", idEtudiant=" + idEtudiant + '}';
    }
    
    

    



	


	
	
	
	
	
	

}
