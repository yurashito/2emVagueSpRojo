package com.voiture.voiture.modele;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.voiture.voiture.connex.Connexion;
import com.voiture.voiture.modele.V_TousAnnonceFavorie;
import com.voiture.voiture.connex.Connexion;

@Entity
@Table(name="V_TousAnnonceFavorie")
public class V_TousAnnonceFavorie {
    @Id
    int idfavorie;
    int idannonce;
    Timestamp dateheureannonce;
    String description;
    String imatricule;
    int idcategorie  ;
    String nomcategorie  ;
    int idmarque ;
    String nommarque ;
    int idcarburant ;
    String nomcarburant ;
    int idmodel ;
    String nommodel ;
    int idboitedevitesse ;
    String nomboitedevitesse ;
    int idcouleur ;
    String nomcouleur ;
    int idutilisateur ;
    String nomutilisateur ;
    int idlieu ;
    String nomlieu ;
    double annee ;
    double prix ;
    double pourcentagealaina ;
    int etatannonce;

    public int getIdfavorie() {
        return idfavorie;
    }
    public void setIdfavorie(int idfavorie) {
        this.idfavorie = idfavorie;
    }
    public int getIdannonce() {
        return idannonce;
    }
    public void setIdannonce(int idannonce) {
        this.idannonce = idannonce;
    }
    public Timestamp getDateheureannonce() {
        return dateheureannonce;
    }
    public void setDateheureannonce(Timestamp dateheureannonce) {
        this.dateheureannonce = dateheureannonce;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImatricule() {
        return imatricule;
    }
    public void setImatricule(String imatricule) {
        this.imatricule = imatricule;
    }
    public int getIdcategorie() {
        return idcategorie;
    }
    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }
    public String getNomcategorie() {
        return nomcategorie;
    }
    public void setNomcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }
    public int getIdmarque() {
        return idmarque;
    }
    public void setIdmarque(int idmarque) {
        this.idmarque = idmarque;
    }
    public String getNommarque() {
        return nommarque;
    }
    public void setNommarque(String nommarque) {
        this.nommarque = nommarque;
    }
    public int getIdcarburant() {
        return idcarburant;
    }
    public void setIdcarburant(int idcarburant) {
        this.idcarburant = idcarburant;
    }
    public String getNomcarburant() {
        return nomcarburant;
    }
    public void setNomcarburant(String nomcarburant) {
        this.nomcarburant = nomcarburant;
    }
    public int getIdmodel() {
        return idmodel;
    }
    public void setIdmodel(int idmodel) {
        this.idmodel = idmodel;
    }
    public String getNommodel() {
        return nommodel;
    }
    public void setNommodel(String nommodel) {
        this.nommodel = nommodel;
    }
    public int getIdboitedevitesse() {
        return idboitedevitesse;
    }
    public void setIdboitedevitesse(int idboitedevitesse) {
        this.idboitedevitesse = idboitedevitesse;
    }
    public String getNomboitedevitesse() {
        return nomboitedevitesse;
    }
    public void setNomboitedevitesse(String nomboitedevitesse) {
        this.nomboitedevitesse = nomboitedevitesse;
    }
    public int getIdcouleur() {
        return idcouleur;
    }
    public void setIdcouleur(int idcouleur) {
        this.idcouleur = idcouleur;
    }
    public String getNomcouleur() {
        return nomcouleur;
    }
    public void setNomcouleur(String nomcouleur) {
        this.nomcouleur = nomcouleur;
    }
    public int getIdutilisateur() {
        return idutilisateur;
    }
    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }
    public String getNomutilisateur() {
        return nomutilisateur;
    }
    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }
    public int getIdlieu() {
        return idlieu;
    }
    public void setIdlieu(int idlieu) {
        this.idlieu = idlieu;
    }
    public String getNomlieu() {
        return nomlieu;
    }
    public void setNomlieu(String nomlieu) {
        this.nomlieu = nomlieu;
    }
    public double getAnnee() {
        return annee;
    }
    public void setAnnee(double annee) {
        this.annee = annee;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public double getPourcentagealaina() {
        return pourcentagealaina;
    }
    public void setPourcentagealaina(double pourcentagealaina) {
        this.pourcentagealaina = pourcentagealaina;
    }
    public int getEtatannonce() {
        return etatannonce;
    }
    public void setEtatannonce(int etatannonce) {
        this.etatannonce = etatannonce;
    }
    public V_TousAnnonceFavorie(int idfavorie, int idannonce, Timestamp dateheureannonce, String description,
            String imatricule, int idcategorie, String nomcategorie, int idmarque, String nommarque, int idcarburant,
            String nomcarburant, int idmodel, String nommodel, int idboitedevitesse, String nomboitedevitesse,
            int idcouleur, String nomcouleur, int idutilisateur, String nomutilisateur, int idlieu, String nomlieu,
            double annee, double prix, double pourcentagealaina, int etatannonce) {
        this.idfavorie = idfavorie;
        this.idannonce = idannonce;
        this.dateheureannonce = dateheureannonce;
        this.description = description;
        this.imatricule = imatricule;
        this.idcategorie = idcategorie;
        this.nomcategorie = nomcategorie;
        this.idmarque = idmarque;
        this.nommarque = nommarque;
        this.idcarburant = idcarburant;
        this.nomcarburant = nomcarburant;
        this.idmodel = idmodel;
        this.nommodel = nommodel;
        this.idboitedevitesse = idboitedevitesse;
        this.nomboitedevitesse = nomboitedevitesse;
        this.idcouleur = idcouleur;
        this.nomcouleur = nomcouleur;
        this.idutilisateur = idutilisateur;
        this.nomutilisateur = nomutilisateur;
        this.idlieu = idlieu;
        this.nomlieu = nomlieu;
        this.annee = annee;
        this.prix = prix;
        this.pourcentagealaina = pourcentagealaina;
        this.etatannonce = etatannonce;
    }
    
    public V_TousAnnonceFavorie() {
    }

    public List<V_TousAnnonceFavorie> HistoriqueAnnonceUtilisateur(Connection connexion, int idUtilisateur) throws Exception{
        
        if(connexion == null || connexion.isClosed()){
            connexion = Connexion.getConnex();
         }
        String sql = "select * from V_TousAnnonceFavorie where idUtilisateur = ?";
        try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                
                preparedStatement.setInt(1, idUtilisateur);
                
                List<V_TousAnnonceFavorie> liste = new ArrayList<V_TousAnnonceFavorie>();
                ResultSet rs = preparedStatement.executeQuery();
                
                if(rs.next()) {
                    liste.add(new V_TousAnnonceFavorie(rs.getInt(1),rs.getInt(2),rs.getTimestamp(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getInt(12),rs.getString(13),rs.getInt(14),rs.getString(15),rs.getInt(16),rs.getString(17),rs.getInt(18),rs.getString(19),rs.getInt(20),rs.getString(21),rs.getDouble(22),rs.getDouble(23),rs.getDouble(24),rs.getInt(25)));      
                }
            return liste;    
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            connexion.close();
        }
        return null; 
    }
    
}
