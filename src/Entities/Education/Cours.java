/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Education;

import java.io.File;
import javafx.collections.ObservableList;

/**
 *
 * @author saghir
 */

public class Cours {

    private int id;
    private String nomCours;
    private String chapitre;
    private String video;
    private String aUnFichier;
    private String aUnVideo;

    public Cours() {
    }

    public Cours(int id, String nom, String chapitre, String video, String aUnFichier, String aUnVideo) {
        this.id = id;
        this.nomCours = nom;
        this.chapitre = chapitre;
        this.video = video;
        this.aUnFichier = aUnFichier;
        this.aUnVideo = aUnVideo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public String getChapitre() {
        return chapitre;
    }

    public void setChapitre(String chapitre) {
        this.chapitre = chapitre;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getaUnFichier() {
        return aUnFichier;
    }

    public void setaUnFichier(String aUnFichier) {
        this.aUnFichier = aUnFichier;
    }

    public String getaUnVideo() {
        return aUnVideo;
    }

    public void setaUnVideo(String aUnVideo) {
        this.aUnVideo = aUnVideo;
    }

    
}
