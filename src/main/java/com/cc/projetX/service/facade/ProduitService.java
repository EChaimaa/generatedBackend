package com.cc.projetX.service.facade;

import java.util.List;
import com.cc.projetX.bean.Produit;
import com.cc.projetX.ws.rest.provided.vo.ProduitVo;

public interface ProduitService {

/**

* find all Produit in database
* @return List<Produit> , If database is empty return  null.
*/
List<Produit> findAll();

    /**

    * find Produit from database by ref (reference)
    * @param ref - reference of Produit
    * @return the founded Produit , If no Produit were
    *         found in database return  null.
    */
    Produit findByRef(String ref);

/**
* find Produit from database by id (id)
* @param id - id of Produit
* @return the founded  Produit , If no Produit were
*         found in database return  null.
*/
Produit findById(Long id);

/**
* delete Produit from database
* @param id - id of Produit to be deleted
*
*/
int deleteById(Long id);

/**
* save Produit in database
* @param produit - Produit to be saved
* @return the saved Produit, If the Produit can't be saved return null.
*/
Produit save(Produit produit);

/**
* save list Produit in database
* @param produits - list of Produit to be saved
* @return the saved Produit list
*/
List<Produit> save(List<Produit> produits);

/**
* update Produit in database
* @param produit - Produit to be updated
* @return the updated Produit, If the Produit can't be updated return null.
*/
Produit update(Produit produit);

/**
* delete Produit from database
* @param produit - Produit to be deleted
* @return 1 if Produit deleted successfully, If the Produit can't be deleted return negative int
*/
int delete(Produit produit);


    /**
    * delete Produit from database by ref (reference)
    *
    * @param ref - reference of Produit to be deleted
    * @return 1 if Produit deleted successfully
    */
    int deleteByRef(String ref);


/**
* search for Produit in by some criteria
* @return the searhed list Produit
*/
List<Produit> findByCriteria( ProduitVo produitVo);
}
