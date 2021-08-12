package com.cc.projetX.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.cc.projetX.bean.CommandeItem;


@Repository
public interface CommandeItemDao extends JpaRepository<CommandeItem,Long> {


        List<CommandeItem> findByProduitRef(String ref);
        int deleteByProduitRef(String ref);
    List<CommandeItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
        List<CommandeItem> findByCommandeRef(String ref);
        int deleteByCommandeRef(String ref);
    List<CommandeItem> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);

}
