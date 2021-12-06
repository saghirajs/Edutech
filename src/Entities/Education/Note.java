/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Education;

/**
 *
 * @author ousse
 */
public class Note {
    private int id;
    private int matiere;
    private int etudiant;
    private String nomEtud;
    private Float noteDs;
    private Float noteCc;
    private Float noteEx;
    private Float moy;

    public Note() {
    }

    public Note(int id, int matiere, int etudiant, Float noteDs, Float noteCc, Float noteEx, Float moy) {
        this.id = id;
        this.matiere = matiere;
        this.etudiant = etudiant;
        this.noteDs = noteDs;
        this.noteCc = noteCc;
        this.noteEx = noteEx;
        this.moy = moy;
    }

    public Note(int id, int matiere, int etudiant, String nomEtud, Float noteDs, Float noteCc, Float noteEx, Float moy) {
        this.id = id;
        this.matiere = matiere;
        this.etudiant = etudiant;
        this.nomEtud = nomEtud;
        this.noteDs = noteDs;
        this.noteCc = noteCc;
        this.noteEx = noteEx;
        this.moy = moy;
    }

   
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatiere() {
        return matiere;
    }

    public void setMatiere(int matiere) {
        this.matiere = matiere;
    }

    public int getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(int etudiant) {
        this.etudiant = etudiant;
    }

    public Float getNoteDs() {
        return noteDs;
    }

    public void setNoteDs(Float noteDs) {
        this.noteDs = noteDs;
    }

    public Float getNoteCc() {
        return noteCc;
    }

    public void setNoteCc(Float noteCc) {
        this.noteCc = noteCc;
    }

    public Float getNoteEx() {
        return noteEx;
    }

    public void setNoteEx(Float noteEx) {
        this.noteEx = noteEx;
    }

    public Float getMoy() {
        return moy;
    }

    public void setMoy(Float moy) {
        this.moy = moy;
    }

    public String getNomEtud() {
        return nomEtud;
    }

    public void setNomEtud(String nomEtud) {
        this.nomEtud = nomEtud;
    }

    @Override
    public String toString() {
        return "Note{" + "nomEtud=" + nomEtud + ", noteDs=" + noteDs + ", noteCc=" + noteCc + ", noteEx=" + noteEx + ", moy=" + moy + '}';
    }

    
    

    
    
    
}
