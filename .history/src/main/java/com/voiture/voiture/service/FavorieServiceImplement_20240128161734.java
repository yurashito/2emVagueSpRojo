package com.voiture.voiture.service;

import org.springframework.stereotype.Service;

import com.voiture.voiture.modele.Favorie;
import com.voiture.voiture.repository.FavorieRepository;

import lombok.AllArgsConstructor;
import java.util.*;
@Service
@AllArgsConstructor
public class FavorieServiceImplement implements FavorieService  {
    private final FavorieRepository favorieRepository;
    
    @Override
    public Favorie CreerFavorie(Favorie favorie){
        return favorieRepository.save(favorie);
    }

    public List<Favorie> select(){
        return this.favorieRepository.findAll();
    }

    public Favorie update(int idFavorie,Favorie modifier){
        return this.favorieRepository.findById(idFavorie).map(
            favorie ->{
                favorie.setIdfavorie(modifier.getIdfavorie());
                favorie.setIdannonce(modifier.getIdannonce());
                favorie.setIdutilisateur(modifier.getIdutilisateur());
                return favorieRepository.save(favorie);
            }
        ).orElseThrow(() -> new RuntimeException("favorie pas trouver"));
    }
    public Favorie deleteFavorie(int idFavorie){
        return this.favorieRepository.findById(idFavorie).map(
            favorie ->{
                favorie.setEtat(0);
                return favorieRepository.save(favorie);
            }
        ).orElseThrow(() -> new RuntimeException("favorie pas trouver"));
    }
    public Favorie mettreFavorie(int idAnnonce,int idUtilisateur){
            // Créer une nouvelle instance de Favorie avec les identifiants fournis et l'état
            Favorie favorie = new Favorie();
            favorie.setIdannonce(idAnnonce);
            favorie.setIdutilisateur(idUtilisateur);
            favorie.setEtat(1); // Supposons que 1 représente l'état pour "favori" 
            
            // Enregistrer la nouvelle instance dans le référentiel
            return favorieRepository.save(favorie);
        }
        
    
}