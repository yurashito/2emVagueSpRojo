package com.voiture.voiture.connex;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    public static Connection getConnex()throws Exception{
      Class.forName("org.postgresql.Driver");
      Connection co= DriverManager.getConnection("jdbc:postgresql://localhost:5432/ventevoiture","postgres","fehizoro");
      return co;
}

}