package com.voiture.voiture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.modele.*;
import com.voiture.voiture.service.*;

@RestController
@CrossOrigin
@RequestMapping("/V_favories")
public class V_TousAnnonceFavorieController {
    @PostMapping("/favorieParUtilisateur/{idUtilisateur}")
    public List<V_TousAnnonceFavorie> listeAnnoncePicture2(@PathVariable int idUtilisateur)throws Exception{
        V_TousAnnonceFavorie appel = new V_TousAnnonceFavorie();
        List<V_TousAnnonceFavorie> liste = appel.HistoriqueAnnonceUtilisateur(null,idUtilisateur);
        return liste;
    }
}
