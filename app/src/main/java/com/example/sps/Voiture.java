package com.example.sps;

public class Voiture implements Comparable<Voiture>
{
        private String Matricule;
        private String Modele;
        private String Prop;


        public Voiture(String matricule, String modele, String prop)
        {
                this.Matricule = matricule;
                this.Modele = modele;
                this.Prop = prop;
        }

        public String getMatricule()
        {
                return Matricule;
        }

        public void setMatricule(String matricule)
        {
                Matricule = matricule;
        }

        public String getModele()
        {
                return Modele;
        }

        public void setModele(String modele)
        {
                Modele = modele;
        }

        public String getProp()
        {
                return Prop;
        }

        public void setProp(String prop)
        {
                Prop = prop;
        }

        @Override
        public String toString()
        {
                return "Voiture{" +
                        "Matricule='" + Matricule + '\'' +
                        ", Modele='" + Modele + '\'' +
                        ", Prop='" + Prop + '\'' +
                        '}';
        }

        @Override
        public int compareTo(Voiture voiture)
        {
                return this.Matricule.compareTo(voiture.Matricule);
        }
}
