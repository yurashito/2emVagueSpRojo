package com.voiture.voiture.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.voiture.voiture.connex.Connexion;
import com.voiture.voiture.modele.AnnonceAvecPhoto;
import com.voiture.voiture.modele.Favorie;
import com.voiture.voiture.service.FavorieService;
import com.voiture.voiture.service.JwtTokenUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import java.sql.Connection;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/favories")
@AllArgsConstructor
public class FavorieController {
    private final FavorieService favorieService;
    private final JwtTokenUtil jwtTokenUtil;
    
    @GetMapping
    public List<Favorie> selectAll() {
        return this.favorieService.select();
    }

    @PostMapping("/create")
    public Favorie create(@RequestBody Favorie favorie){
        return favorieService.CreerFavorie(favorie) ;
    }
     @PostMapping("/deleteFavorie/{idFavorie}")
    public void deleteFavorie(@PathVariable int idFavorie){
         this.favorieService.deleteFavorie(idFavorie);
    }

    // @PostMapping("/mettreFavorie/{idAnnonce}/{idUtilisateur}")
    // public Favorie mettreFavorie(@PathVariable int idAnnonce, @PathVariable int idUtilisateur){
    //     Favorie favorie = new Favorie(idAnnonce,idUtilisateur);
    //     return favorieService.mettreFavorie(favorie);
    // }

    @PostMapping("/mettreFavorie/{idAnnonce}")
    public  ResponseEntity<Object> mettreFavorie( javax.servlet.http.HttpServletRequest request ,@PathVariable int idAnnonce){
        
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String bearerToken = authorizationHeader.substring(7); // Supprimer "Bearer " du début
                try{
                    if(jwtTokenUtil.isTokenValid(bearerToken)){
                      
                        
                        Jws<Claims> claims = jwtTokenUtil.decomposeLeToken(bearerToken);
                        String idUtilisateur = claims.getBody().getSubject();
                        Favorie favorie = new Favorie(idAnnonce,Integer.parseInt(idUtilisateur));
                        Favorie resultat = new Favorie();
                        try{
                            resultat = (favorieService.mettreFavorie(favorie));
                        }catch(Exception e){
                            
                            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                                Map.of(
                                    "status", HttpStatus.BAD_REQUEST.value(),
                                    "message", "Une erreur s'est produite : il y a erreur sur l'appel du fonction Favorie/mettreFavorie(favorie)",
                                    "timestamp", System.currentTimeMillis()
                                )
                            );
                        }
                        return ResponseEntity.ok(resultat);
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
