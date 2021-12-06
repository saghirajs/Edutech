/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Utilisateur;

import java.util.Date;
import javafx.scene.image.ImageView;

/**
 *
 * @author william
 */
public class Utilisateur {
    private int id;
private String username;
private String username_canonical;
private String email;
private String email_canonical;
private int enabled;
private String salt;
private String password;
private String confiramation_token;
private String roles;
private int cin;
private int numtel;
private Date datenaissance;
private String adresse;
private String profil;
private String nom;
private String prenom;
private int idcl;
private float mg;
private String nomCl;

    public Utilisateur(int id, String username, String username_canonical, String email, String email_canonical, int enabled, String salt, String password, String confiramation_token, String roles, int cin, int numtel, Date datenaissance, String adresse, String profil, String nom, String prenom) {
        this.id = id;
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.confiramation_token = confiramation_token;
        this.roles = roles;
        this.cin = cin;
        this.numtel = numtel;
        this.datenaissance = datenaissance;
        this.adresse = adresse;
        this.profil = profil;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Utilisateur(int id, String username, String email, int cin, int idcl, String nomCl) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.cin = cin;
        this.idcl = idcl;
        this.nomCl = nomCl;
    }

    public Utilisateur(int id, String username, String email, int cin, int idcl, float mg, String nomCl) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.cin = cin;
        this.idcl = idcl;
        this.mg = mg;
        this.nomCl = nomCl;
    }
    
    

    public String getNomCl() {
        return nomCl;
    }

    public void setNomCl(String nomCl) {
        this.nomCl = nomCl;
    }

    

    public int getIdcl() {
        return idcl;
    }

    public void setIdcl(int idcl) {
        this.idcl = idcl;
    }

    public float getMg() {
        return mg;
    }

    public void setMg(float mg) {
        this.mg = mg;
    }
    

    public Utilisateur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfiramation_token() {
        return confiramation_token;
    }

    public void setConfiramation_token(String confiramation_token) {
        this.confiramation_token = confiramation_token;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", username=" + username + ", username_canonical=" + username_canonical + ", email=" + email + ", email_canonical=" + email_canonical + ", enabled=" + enabled + ", salt=" + salt + ", password=" + password + ", confiramation_token=" + confiramation_token + ", roles=" + roles + ", cin=" + cin + ", numtel=" + numtel + ", datenaissance=" + datenaissance + ", adresse=" + adresse + ", profil=" + profil + ", nom=" + nom + ", prenom=" + prenom + ", idcl=" + idcl + ", mg=" + mg + ", nomCl=" + nomCl + '}';
    }

    

   


    
            
	

	
	
}