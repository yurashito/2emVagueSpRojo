package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.voiture.voiture.modele.V_TousAnnonceFavorie;

public interface V_TousAnnonceFavorieRepository extends   JpaRepository<V_TousAnnonceFavorie , Integer> {
    
}
