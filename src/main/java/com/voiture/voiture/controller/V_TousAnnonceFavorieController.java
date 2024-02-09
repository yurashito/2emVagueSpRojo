package com.voiture.voiture.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.modele.*;
import com.voiture.voiture.repository.AnnonceDetailRepository;
import com.voiture.voiture.repository.AnnonceRepository;
import com.voiture.voiture.service.*;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@RestController
@CrossOrigin
@RequestMapping("/V_favories")
public class V_TousAnnonceFavorieController {
    // private final AnnonceService  annonceService;
    // private final AnnonceDetailRepository annonceDetailRepository;
    // private final AnnonceRepository annonceRepository;
    // private final AnnonceDetailService annonceDetailService;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public V_TousAnnonceFavorieController( JwtTokenUtil jwtTokenUtil ){
        this.jwtTokenUtil= jwtTokenUtil;
    }

    // @PostMapping("/favorieParUtilisateur/{idUtilisateur}")
    // public List<V_TousAnnonceFavorie> listeAnnoncePicture2(@PathVariable int idUtilisateur)throws Exception{
    //     V_TousAnnonceFavorie appel = new V_TousAnnonceFavorie();
    //     List<V_TousAnnonceFavorie> liste = appel.HistoriqueAnnonceUtilisateur(null,idUtilisateur);
    //     return liste;
    // }

    @PostMapping("/favorieParUtilisateur")
    public ResponseEntity<Object>  listeAnnoncePicture2(javax.servlet.http.HttpServletRequest request)throws Exception{
     
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String bearerToken = authorizationHeader.substring(7); // Supprimer "Bearer " du début
                try{
                    if(jwtTokenUtil.isTokenValid(bearerToken)){
                        Jws<Claims> claims = jwtTokenUtil.decomposeLeToken(bearerToken);
                        System.out.println("le idUtilisateur est : "+Integer.parseInt(claims.getBody().getSubject()));
                        String idUtilisateur = claims.getBody().getSubject();
                        V_TousAnnonceFavorie appel = new V_TousAnnonceFavorie();
                        List<V_TousAnnonceFavorie> liste = appel.HistoriqueAnnonceUtilisateur(null,Integer.parseInt(idUtilisateur));
                        return ResponseEntity.ok(liste);
                    }else{
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                            Map.of(
                                "status", HttpStatus.BAD_REQUEST.value(),
                                "message", "Une erreur s'est produite : le token n'est plus valide",
                                "timestamp", System.currentTimeMillis()
                            )
                        );
                    } 
                }catch(Exception e){
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        Map.of(
                            "status", HttpStatus.BAD_REQUEST.value(),
                            "message", e,
                            "timestamp", System.currentTimeMillis()
                        )
                    );
                }
            } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of(
                    "status", HttpStatus.BAD_REQUEST.value(),
                    "message", "Une erreur s'est produite : le token n'est plus valide",
                    "timestamp", System.currentTimeMillis()
                )
            );
        }
    }
}
