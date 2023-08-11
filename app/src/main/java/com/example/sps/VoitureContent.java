package com.example.sps;

import java.util.ArrayList;

public class VoitureContent
{
    public static ArrayList<Voiture> getVoitures()
    {
        ArrayList<Voiture> voitures = new ArrayList<Voiture>();

        voitures.add(new Voiture("123","KIA","Sami"));
        voitures.add(new Voiture("456","MERCEDES VIENNA","Sofiene"));
        voitures.add(new Voiture("455","MERCEDES CLASS A","Sofiene"));
        voitures.add(new Voiture("457","MERCEDES BRABUS","Sofiene"));
        voitures.add(new Voiture("458","MERCEDES MAYBACH","Sofiene"));
        voitures.add(new Voiture("459","MERCEDES AMG","Sofiene"));
        voitures.add(new Voiture("789","AUDI","Yassine"));
        voitures.add(new Voiture("147","FERARRI","Mohamed"));
        voitures.add(new Voiture("258","RENAULT","Ali"));
        voitures.add(new Voiture("369","OPEL","Ahmed"));
        voitures.add(new Voiture("741","MAZDA","Rachid"));
        voitures.add(new Voiture("852","FIAT","Khaled"));
        voitures.add(new Voiture("963","PEUGEOT","Samir"));

        return voitures;
    }
}
