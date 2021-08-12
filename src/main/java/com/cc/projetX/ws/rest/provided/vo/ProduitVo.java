package  com.cc.projetX.ws.rest.provided.vo;

    import java.math.BigDecimal;

public class ProduitVo {

            private String id ;
            private String ref ;
            private String nom ;
            private String prix ;



            private String prixMax ;
            private String prixMin ;

    public ProduitVo(){
    super();
    }


        public String getId(){
        return this.id;
        }
        public void setId(String id){
        this.id = id;
        }


        public String getRef(){
        return this.ref;
        }
        public void setRef(String ref){
        this.ref = ref;
        }


        public String getNom(){
        return this.nom;
        }
        public void setNom(String nom){
        this.nom = nom;
        }


        public String getPrix(){
        return this.prix;
        }
        public void setPrix(String prix){
        this.prix = prix;
        }




            public String getPrixMax(){
            return this.prixMax;
            }

            public String getPrixMin(){
            return this.prixMin;
            }

            public void setPrixMax(String prixMax){
            this.prixMax = prixMax;
            }

            public void setPrixMin(String prixMin){
            this.prixMin = prixMin;
            }






            }
