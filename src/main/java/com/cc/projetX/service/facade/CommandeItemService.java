package com.cc.projetX.service.facade;

import java.util.List;
import com.cc.projetX.bean.CommandeItem;
import com.cc.projetX.ws.rest.provided.vo.CommandeItemVo;

public interface CommandeItemService {

/**

* find all CommandeItem in database
* @return List<CommandeItem> , If database is empty return  null.
*/
List<CommandeItem> findAll();


/**
* find CommandeItem from database by id (id)
* @param id - id of CommandeItem
* @return the founded  CommandeItem , If no CommandeItem were
*         found in database return  null.
*/
CommandeItem findById(Long id);

/**
* delete CommandeItem from database
* @param id - id of CommandeItem to be deleted
*
*/
int deleteById(Long id);

    List<CommandeItem> findByProduitRef(String ref);
    int deleteByProduitRef(String ref);
    List<CommandeItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<CommandeItem> findByCommandeRef(String ref);
    int deleteByCommandeRef(String ref);
    List<CommandeItem> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);
/**
* save CommandeItem in database
* @param commandeItem - CommandeItem to be saved
* @return the saved CommandeItem, If the CommandeItem can't be saved return null.
*/
CommandeItem save(CommandeItem commandeItem);

/**
* save list CommandeItem in database
* @param commandeItems - list of CommandeItem to be saved
* @return the saved CommandeItem list
*/
List<CommandeItem> save(List<CommandeItem> commandeItems);

/**
* update CommandeItem in database
* @param commandeItem - CommandeItem to be updated
* @return the updated CommandeItem, If the CommandeItem can't be updated return null.
*/
CommandeItem update(CommandeItem commandeItem);

/**
* delete CommandeItem from database
* @param commandeItem - CommandeItem to be deleted
* @return 1 if CommandeItem deleted successfully, If the CommandeItem can't be deleted return negative int
*/
int delete(CommandeItem commandeItem);




/**
* search for CommandeItem in by some criteria
* @return the searhed list CommandeItem
*/
List<CommandeItem> findByCriteria( CommandeItemVo commandeItemVo);
}
