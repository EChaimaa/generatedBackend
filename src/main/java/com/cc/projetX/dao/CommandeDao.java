package com.cc.projetX.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.cc.projetX.bean.Commande;


@Repository
public interface CommandeDao extends JpaRepository<Commande,Long> {

    Commande findByRef(String ref);
    int deleteByRef(String ref);


}
