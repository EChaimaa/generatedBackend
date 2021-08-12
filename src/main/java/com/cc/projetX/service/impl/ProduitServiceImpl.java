package com.cc.projetX.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.cc.projetX.bean.Produit;
import com.cc.projetX.dao.ProduitDao;
import com.cc.projetX.service.facade.ProduitService;

import com.cc.projetX.ws.rest.provided.vo.ProduitVo;
import com.cc.projetX.service.util.*;
@Service
public class ProduitServiceImpl implements ProduitService {

@Autowired
private ProduitDao produitDao;


@Autowired
private EntityManager entityManager;

@Override
public List<Produit> findAll(){
return produitDao.findAll();
}
    @Override
    public Produit findByRef(String ref){
    if( ref==null)
    return null;
    return produitDao.findByRef(ref);
    }



    @Override
    @Transactional
    public int deleteByRef(String  ref) {
    return produitDao.deleteByRef(ref);
    }

@Override
public Produit findById(Long id){
if(id==null)
return null;
return produitDao.getOne(id);
}

@Transactional
public int deleteById(Long id){
    if(produitDao.findById(id) == null) return 0;
    produitDao.deleteById(id);
    return 1;
}
@Override
public Produit save (Produit produit){
    Produit foundedProduit = findByRef(produit.getRef());
    if(foundedProduit!=null)
    return null;

Produit savedProduit = produitDao.save(produit);
return savedProduit;
}

@Override
public List<Produit> save(List<Produit> produits){
List<Produit> list = new ArrayList<Produit>();
for(Produit produit: produits){
list.add(save(produit));
}
return list;
}


@Override
public Produit update(Produit produit){


Produit foundedProduit = findById(produit.getId());
if(foundedProduit==null)
return null;

return  produitDao.save(produit);

}

@Override
@Transactional
public int delete(Produit produit){

    if(produit.getRef()==null)
    return -1;

    Produit foundedProduit = findByRef(produit.getRef());
    if(foundedProduit==null)
    return -1;
produitDao.delete(foundedProduit);
return 1;
}


public List<Produit> findByCriteria(ProduitVo produitVo){
String query = "SELECT o FROM Produit o where 1=1 ";
            query += SearchUtil.addConstraint( "o", "id","=",produitVo.getId());
            query += SearchUtil.addConstraint( "o", "ref","LIKE",produitVo.getRef());

            query += SearchUtil.addConstraint( "o", "nom","LIKE",produitVo.getNom());

            query += SearchUtil.addConstraint( "o", "prix","=",produitVo.getPrix());
            query += SearchUtil.addConstraintMinMax("o","prix",produitVo.getPrixMin(),produitVo.getPrixMax());
return entityManager.createQuery(query).getResultList();
}


}
