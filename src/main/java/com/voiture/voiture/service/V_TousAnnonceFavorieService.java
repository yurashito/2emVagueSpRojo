package com.voiture.voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.voiture.repository.V_TousAnnonceFavorieRepository;

@Service
public class V_TousAnnonceFavorieService {
    private final V_TousAnnonceFavorieRepository  v_TousAnnonceFavorieRepository;

    @Autowired
    public V_TousAnnonceFavorieService(V_TousAnnonceFavorieRepository v_TousAnnonceFavorieRepository) {
        this.v_TousAnnonceFavorieRepository = v_TousAnnonceFavorieRepository;
    }
    

    
    
}
