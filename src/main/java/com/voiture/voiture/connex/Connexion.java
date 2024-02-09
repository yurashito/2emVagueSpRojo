package com.voiture.voiture.connex;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    public static Connection getConnex()throws Exception{
      Class.forName("org.postgresql.Driver");
      // Connection co= DriverManager.getConnection("jdbc:postgresql://localhost:5432/ventevoiture","postgres","diary");
       Connection co= DriverManager.getConnection("jdbc:postgresql://dpg-cmeqd16n7f5s73806qi0-a.oregon-postgres.render.com:5432/ventevoiture","ventevoiture_user","5mEBJe2FVsZoFoY8xooDAdR4OtfBRlT9");
        return co;
}

}
