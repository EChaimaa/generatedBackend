package  com.cc.projetX.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cc.projetX.service.util.*;


import com.cc.projetX.bean.Commande;
import com.cc.projetX.ws.rest.provided.vo.CommandeVo;

@Component
public class CommandeConverter extends AbstractConverter<Commande,CommandeVo>{

        @Autowired
        private CommandeItemConverter commandeItemConverter ;
    private Boolean commandeItems;

public  CommandeConverter(){
init(true);
}

@Override
public Commande toItem(CommandeVo vo) {
if (vo == null) {
return null;
} else {
Commande item = new Commande();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getRef()))
        item.setRef(vo.getRef());
        if(StringUtil.isNotEmpty(vo.getDateCmd()))
        item.setDateCmd(DateUtil.parse(vo.getDateCmd()));
        if(StringUtil.isNotEmpty(vo.getTotal()))
        item.setTotal(NumberUtil.toBigDecimal(vo.getTotal()));

    if(ListUtil.isNotEmpty(vo.getCommandeItemsVo()) && this.commandeItems)
        item.setCommandeItems(commandeItemConverter.toItem(vo.getCommandeItemsVo()));



return item;
}
}

@Override
public CommandeVo toVo(Commande item) {
if (item == null) {
return null;
} else {
CommandeVo vo = new CommandeVo();

        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getRef()))
        vo.setRef(item.getRef());

        if(item.getDateCmd()!=null)
        vo.setDateCmd(DateUtil.formateDate(item.getDateCmd()));
        if(item.getTotal()!=null)
        vo.setTotal(NumberUtil.toString(item.getTotal()));
    if(ListUtil.isNotEmpty(item.getCommandeItems()) && this.commandeItems){

    commandeItemConverter.init(false);
    vo.setCommandeItemsVo(commandeItemConverter.toVo(item.getCommandeItems()));
    commandeItemConverter.init(true);
    }

return vo;

}
}
public void init(Boolean value) {
    commandeItems = value;
}


        public CommandeItemConverter getCommandeItemConverter(){
        return this.commandeItemConverter;
        }
        public void setCommandeItemConverter(CommandeItemConverter commandeItemConverter ){
        this.commandeItemConverter = commandeItemConverter;
        }

    public Boolean  isCommandeItems(){
    return this.commandeItems ;
    }
    public void  setCommandeItems(Boolean commandeItems ){
    this.commandeItems  = commandeItems ;
    }
}
