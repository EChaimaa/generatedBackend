package  com.cc.projetX.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cc.projetX.service.util.*;


import com.cc.projetX.bean.Produit;
import com.cc.projetX.ws.rest.provided.vo.ProduitVo;

@Component
public class ProduitConverter extends AbstractConverter<Produit,ProduitVo>{


public  ProduitConverter(){
init(true);
}

@Override
public Produit toItem(ProduitVo vo) {
if (vo == null) {
return null;
} else {
Produit item = new Produit();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getRef()))
        item.setRef(vo.getRef());
        if(StringUtil.isNotEmpty(vo.getNom()))
        item.setNom(vo.getNom());
        if(StringUtil.isNotEmpty(vo.getPrix()))
        item.setPrix(NumberUtil.toBigDecimal(vo.getPrix()));


return item;
}
}

@Override
public ProduitVo toVo(Produit item) {
if (item == null) {
return null;
} else {
ProduitVo vo = new ProduitVo();

        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));
        if(StringUtil.isNotEmpty(item.getRef()))
        vo.setRef(item.getRef());

        if(StringUtil.isNotEmpty(item.getNom()))
        vo.setNom(item.getNom());

        if(item.getPrix()!=null)
        vo.setPrix(NumberUtil.toString(item.getPrix()));

return vo;

}
}
public void init(Boolean value) {
}



}
