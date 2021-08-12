package com.cc.projetX.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.cc.projetX.bean.CommandeItem;
    import com.cc.projetX.bean.Produit;
    import com.cc.projetX.bean.Commande;
import com.cc.projetX.dao.CommandeItemDao;
import com.cc.projetX.service.facade.CommandeItemService;
        import com.cc.projetX.service.facade.CommandeService;
        import com.cc.projetX.service.facade.ProduitService;

import com.cc.projetX.ws.rest.provided.vo.CommandeItemVo;
import com.cc.projetX.service.util.*;
@Service
public class CommandeItemServiceImpl implements CommandeItemService {

@Autowired
private CommandeItemDao commandeItemDao;

        @Autowired
        private CommandeService commandeService ;
        @Autowired
        private ProduitService produitService ;

@Autowired
private EntityManager entityManager;

@Override
public List<CommandeItem> findAll(){
return commandeItemDao.findAll();
}
        @Override
        public List<CommandeItem> findByProduitRef(String ref){
        return commandeItemDao.findByProduitRef(ref);
        }
        @Override
        @Transactional
        public int deleteByProduitRef(String ref){
        return commandeItemDao.deleteByProduitRef(ref);
        }

    @Override
    public List<CommandeItem> findByProduitId(Long id){
    return commandeItemDao.findByProduitId(id);

    }
    @Override
    @Transactional
    public int deleteByProduitId(Long id){
    return commandeItemDao.deleteByProduitId(id);

    }

        @Override
        public List<CommandeItem> findByCommandeRef(String ref){
        return commandeItemDao.findByCommandeRef(ref);
        }
        @Override
        @Transactional
        public int deleteByCommandeRef(String ref){
        return commandeItemDao.deleteByCommandeRef(ref);
        }

    @Override
    public List<CommandeItem> findByCommandeId(Long id){
    return commandeItemDao.findByCommandeId(id);

    }
    @Override
    @Transactional
    public int deleteByCommandeId(Long id){
    return commandeItemDao.deleteByCommandeId(id);

    }


@Override
public CommandeItem findById(Long id){
if(id==null)
return null;
return commandeItemDao.getOne(id);
}

@Transactional
public int deleteById(Long id){
    if(commandeItemDao.findById(id) == null) return 0;
    commandeItemDao.deleteById(id);
    return 1;
}
@Override
public CommandeItem save (CommandeItem commandeItem){

    if(commandeItem.getProduit()!=null){
            Produit produit = produitService.findByRef(commandeItem.getProduit().getRef());
    if(produit == null)
        commandeItem.setProduit(produitService.save(commandeItem.getProduit()));
    else
    commandeItem.setProduit(produit);
    }

    if(commandeItem.getCommande()!=null){
            Commande commande = commandeService.findByRef(commandeItem.getCommande().getRef());
    if(commande == null)
        commandeItem.setCommande(commandeService.save(commandeItem.getCommande()));
    else
    commandeItem.setCommande(commande);
    }

CommandeItem savedCommandeItem = commandeItemDao.save(commandeItem);
return savedCommandeItem;
}

@Override
public List<CommandeItem> save(List<CommandeItem> commandeItems){
List<CommandeItem> list = new ArrayList<CommandeItem>();
for(CommandeItem commandeItem: commandeItems){
list.add(save(commandeItem));
}
return list;
}


@Override
public CommandeItem update(CommandeItem commandeItem){


CommandeItem foundedCommandeItem = findById(commandeItem.getId());
if(foundedCommandeItem==null)
return null;

return  commandeItemDao.save(commandeItem);

}

@Override
@Transactional
public int delete(CommandeItem commandeItem){

    if(commandeItem.getId()==null)
    return -1;
    CommandeItem foundedCommandeItem = findById(commandeItem.getId());
    if(foundedCommandeItem==null)
    return -1;
commandeItemDao.delete(foundedCommandeItem);
return 1;
}


public List<CommandeItem> findByCriteria(CommandeItemVo commandeItemVo){
String query = "SELECT o FROM CommandeItem o where 1=1 ";
            query += SearchUtil.addConstraint( "o", "id","=",commandeItemVo.getId());
            query += SearchUtil.addConstraint( "o", "qte","=",commandeItemVo.getQte());
            query += SearchUtil.addConstraintMinMax("o","qte",commandeItemVo.getQteMin(),commandeItemVo.getQteMax());
    if(commandeItemVo.getProduitVo()!=null){
        query += SearchUtil.addConstraint( "o", "produit.id","=",commandeItemVo.getProduitVo().getId());
            query += SearchUtil.addConstraint( "o", "produit.ref","LIKE",commandeItemVo.getProduitVo().getRef());
    }

    if(commandeItemVo.getCommandeVo()!=null){
        query += SearchUtil.addConstraint( "o", "commande.id","=",commandeItemVo.getCommandeVo().getId());
            query += SearchUtil.addConstraint( "o", "commande.ref","LIKE",commandeItemVo.getCommandeVo().getRef());
    }

return entityManager.createQuery(query).getResultList();
}


}
