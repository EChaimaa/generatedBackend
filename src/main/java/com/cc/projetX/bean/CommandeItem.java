package com.cc.projetX.bean;

import javax.persistence.ManyToOne;
    import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import com.cc.projetX.bean.Produit;
    import com.cc.projetX.bean.Commande;

@Entity
public class CommandeItem {

@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

            private BigDecimal qte ;

    @ManyToOne
    private Produit produit ;
    @ManyToOne
    private Commande commande ;

public CommandeItem(){
super();
}

            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public Produit getProduit(){
            return this.produit;
            }
            public void setProduit(Produit produit){
            this.produit = produit;
            }
            public BigDecimal getQte(){
            return this.qte;
            }
            public void setQte(BigDecimal qte){
            this.qte = qte;
            }
            public Commande getCommande(){
            return this.commande;
            }
            public void setCommande(Commande commande){
            this.commande = commande;
            }


}

