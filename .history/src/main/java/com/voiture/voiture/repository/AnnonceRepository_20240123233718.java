package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.voiture.voiture.modele.Annonce;
import.java.u

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    List<Annonce> findByUtilisateurId(Long utilisateurId);
}