package com.cc.projetX.bean;

import javax.persistence.ManyToOne;
    import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;

@Entity
public class Produit {

@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

            private String ref ;
            private String nom ;
            private BigDecimal prix ;


public Produit(){
super();
}

            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
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
            public BigDecimal getPrix(){
            return this.prix;
            }
            public void setPrix(BigDecimal prix){
            this.prix = prix;
            }


}

