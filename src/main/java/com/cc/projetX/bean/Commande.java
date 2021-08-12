package com.cc.projetX.bean;

import javax.persistence.ManyToOne;
    import java.util.List;
    import javax.persistence.OneToMany;
    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;

@Entity
public class Commande {

@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

            private String ref ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateCmd ;
            private BigDecimal total ;

        @OneToMany(mappedBy = "commande")
    private List<CommandeItem> commandeItems ;

public Commande(){
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
            public Date getDateCmd(){
            return this.dateCmd;
            }
            public void setDateCmd(Date dateCmd){
            this.dateCmd = dateCmd;
            }
            public BigDecimal getTotal(){
            return this.total;
            }
            public void setTotal(BigDecimal total){
            this.total = total;
            }
            public List<CommandeItem> getCommandeItems(){
            return this.commandeItems;
            }
            public void setCommandeItems(List<CommandeItem> commandeItems){
            this.commandeItems = commandeItems;
            }


}

