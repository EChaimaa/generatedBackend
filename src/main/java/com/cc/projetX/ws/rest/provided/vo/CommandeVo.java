package  com.cc.projetX.ws.rest.provided.vo;

    import java.util.List;
    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import java.math.BigDecimal;

public class CommandeVo {

            private String id ;
            private String ref ;
            private String dateCmd ;
            private String total ;


private List<CommandeItemVo> commandeItemsVo ;

            private String dateCmdMax ;
            private String dateCmdMin ;
            private String totalMax ;
            private String totalMin ;

    public CommandeVo(){
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


        public String getDateCmd(){
        return this.dateCmd;
        }
        public void setDateCmd(String dateCmd){
        this.dateCmd = dateCmd;
        }


        public String getTotal(){
        return this.total;
        }
        public void setTotal(String total){
        this.total = total;
        }




            public String getDateCmdMax(){
            return this.dateCmdMax;
            }

            public String getDateCmdMin(){
            return this.dateCmdMin;
            }

            public void setDateCmdMax(String dateCmdMax){
            this.dateCmdMax = dateCmdMax;
            }

            public void setDateCmdMin(String dateCmdMin){
            this.dateCmdMin = dateCmdMin;
            }



            public String getTotalMax(){
            return this.totalMax;
            }

            public String getTotalMin(){
            return this.totalMin;
            }

            public void setTotalMax(String totalMax){
            this.totalMax = totalMax;
            }

            public void setTotalMin(String totalMin){
            this.totalMin = totalMin;
            }




    public List
    <CommandeItemVo> getCommandeItemsVo(){
        return this.commandeItemsVo;
        }

        public void setCommandeItemsVo(List<CommandeItemVo> commandeItemsVo){
            this.commandeItemsVo = commandeItemsVo;
            }


            }
