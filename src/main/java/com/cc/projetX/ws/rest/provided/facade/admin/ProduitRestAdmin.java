
package  com.cc.projetX.ws.rest.provided.facade.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.cc.projetX.bean.Produit;
import com.cc.projetX.service.facade.ProduitService;
import com.cc.projetX.ws.rest.provided.converter.ProduitConverter;
import com.cc.projetX.ws.rest.provided.vo.ProduitVo;

@Api("Manages produit services")
@RestController
@RequestMapping("api/admin/produit")
public class  ProduitRestAdmin {

@Autowired
private  ProduitService  produitService;

@Autowired
private  ProduitConverter  produitConverter;
        @ApiOperation("Updates the specified  produit")
        @PutMapping("/")
        public  ProduitVo update(@RequestBody  ProduitVo  produitVo){
        Produit  produit =  produitConverter.toItem( produitVo);
        produit =  produitService.update( produit);
        return  produitConverter.toVo( produit);
        }


        @ApiOperation("Finds a list of all  produits")
        @GetMapping("/")
        public List< ProduitVo> findAll(){
        return  produitConverter.toVo( produitService.findAll());
        }




        @ApiOperation("Saves the specified  produit")
        @PostMapping("/")
        public ProduitVo save(@RequestBody ProduitVo  produitVo){
        Produit  produit=  produitConverter.toItem( produitVo);
        produit=     produitService.save( produit);
        return  produitConverter.toVo( produit);
        }


        @ApiOperation("Delete the specified  produit")
        @DeleteMapping("/")
        public int delete(@RequestBody  ProduitVo  produitVo){
        Produit produit =  produitConverter.toItem( produitVo);
        return  produitService.delete( produit);
        }



}
