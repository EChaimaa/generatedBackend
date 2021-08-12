package  com.cc.projetX.ws.rest.provided.vo;

    import java.math.BigDecimal;

public class CommandeItemVo {

            private String id ;
            private String qte ;

    private ProduitVo produitVo ;
    private CommandeVo commandeVo ;


            private String qteMax ;
            private String qteMin ;

    public CommandeItemVo(){
    super();
    }


        public String getId(){
        return this.id;
        }
        public void setId(String id){
        this.id = id;
        }


        public String getQte(){
        return this.qte;
        }
        public void setQte(String qte){
        this.qte = qte;
        }




            public String getQteMax(){
            return this.qteMax;
            }

            public String getQteMin(){
            return this.qteMin;
            }

            public void setQteMax(String qteMax){
            this.qteMax = qteMax;
            }

            public void setQteMin(String qteMin){
            this.qteMin = qteMin;
            }



        public ProduitVo getProduitVo(){
        return this.produitVo;
        }

        public void setProduitVo(ProduitVo produitVo){
        this.produitVo = produitVo;
        }

        public CommandeVo getCommandeVo(){
        return this.commandeVo;
        }

        public void setCommandeVo(CommandeVo commandeVo){
        this.commandeVo = commandeVo;
        }




            }
