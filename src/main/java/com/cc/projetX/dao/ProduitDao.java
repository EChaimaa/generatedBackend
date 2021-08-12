package com.cc.projetX.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.cc.projetX.bean.Produit;


@Repository
public interface ProduitDao extends JpaRepository<Produit,Long> {

    Produit findByRef(String ref);
    int deleteByRef(String ref);


}
