package com.cc.projetX.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.cc.projetX.bean.Commande;
    import com.cc.projetX.bean.CommandeItem;
import com.cc.projetX.dao.CommandeDao;
import com.cc.projetX.service.facade.CommandeService;
        import com.cc.projetX.service.facade.CommandeItemService;

import com.cc.projetX.ws.rest.provided.vo.CommandeVo;
import com.cc.projetX.service.util.*;
@Service
public class CommandeServiceImpl implements CommandeService {

@Autowired
private CommandeDao commandeDao;

        @Autowired
        private CommandeItemService commandeItemService ;

@Autowired
private EntityManager entityManager;

@Override
public List<Commande> findAll(){
return commandeDao.findAll();
}
    @Override
    public Commande findByRef(String ref){
    if( ref==null)
    return null;
    return commandeDao.findByRef(ref);
    }



    @Override
    @Transactional
    public int deleteByRef(String  ref) {
    return commandeDao.deleteByRef(ref);
    }

@Override
public Commande findById(Long id){
if(id==null)
return null;
return commandeDao.getOne(id);
}

@Transactional
public int deleteById(Long id){
    if(commandeDao.findById(id) == null) return 0;
    commandeDao.deleteById(id);
    return 1;
}
@Override
public Commande save (Commande commande){
    Commande foundedCommande = findByRef(commande.getRef());
    if(foundedCommande!=null)
    return null;

Commande savedCommande = commandeDao.save(commande);
        if(ListUtil.isNotEmpty(commande.getCommandeItems())){
            savedCommande.setCommandeItems(commandeItemService.save(prepareCommandeItems(savedCommande,commande.getCommandeItems())));
        }
return savedCommande;
}

@Override
public List<Commande> save(List<Commande> commandes){
List<Commande> list = new ArrayList<Commande>();
for(Commande commande: commandes){
list.add(save(commande));
}
return list;
}

        private List<CommandeItem> prepareCommandeItems(Commande commande,List<CommandeItem> commandeItems){
        for(CommandeItem commandeItem:commandeItems ){
        commandeItem.setCommande(commande);
        }
        return commandeItems;
        }

@Override
public Commande update(Commande commande){


Commande foundedCommande = findById(commande.getId());
if(foundedCommande==null)
return null;

return  commandeDao.save(commande);

}

@Override
@Transactional
public int delete(Commande commande){

    if(commande.getRef()==null)
    return -1;

    Commande foundedCommande = findByRef(commande.getRef());
    if(foundedCommande==null)
    return -1;
commandeDao.delete(foundedCommande);
return 1;
}


public List<Commande> findByCriteria(CommandeVo commandeVo){
String query = "SELECT o FROM Commande o where 1=1 ";
            query += SearchUtil.addConstraint( "o", "id","=",commandeVo.getId());
            query += SearchUtil.addConstraint( "o", "ref","LIKE",commandeVo.getRef());

        query += SearchUtil.addConstraintDate( "o", "dateCmd","=",commandeVo.getDateCmd());
            query += SearchUtil.addConstraint( "o", "total","=",commandeVo.getTotal());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCmd",commandeVo.getDateCmdMin(),commandeVo.getDateCmdMax());
            query += SearchUtil.addConstraintMinMax("o","total",commandeVo.getTotalMin(),commandeVo.getTotalMax());
return entityManager.createQuery(query).getResultList();
}


}
