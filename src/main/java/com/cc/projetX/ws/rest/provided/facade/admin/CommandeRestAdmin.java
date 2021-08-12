
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
import com.cc.projetX.bean.Commande;
import com.cc.projetX.service.facade.CommandeService;
import com.cc.projetX.ws.rest.provided.converter.CommandeConverter;
import com.cc.projetX.ws.rest.provided.vo.CommandeVo;

@Api("Manages commande services")
@RestController
@RequestMapping("api/admin/commande")
public class  CommandeRestAdmin {

@Autowired
private  CommandeService  commandeService;

@Autowired
private  CommandeConverter  commandeConverter;
        @ApiOperation("Updates the specified  commande")
        @PutMapping("/")
        public  CommandeVo update(@RequestBody  CommandeVo  commandeVo){
        Commande  commande =  commandeConverter.toItem( commandeVo);
        commande =  commandeService.update( commande);
        return  commandeConverter.toVo( commande);
        }


        @ApiOperation("Finds a list of all  commandes")
        @GetMapping("/")
        public List< CommandeVo> findAll(){
        return  commandeConverter.toVo( commandeService.findAll());
        }




        @ApiOperation("Saves the specified  commande")
        @PostMapping("/")
        public CommandeVo save(@RequestBody CommandeVo  commandeVo){
        Commande  commande=  commandeConverter.toItem( commandeVo);
        commande=     commandeService.save( commande);
        return  commandeConverter.toVo( commande);
        }


        @ApiOperation("Delete the specified  commande")
        @DeleteMapping("/")
        public int delete(@RequestBody  CommandeVo  commandeVo){
        Commande commande =  commandeConverter.toItem( commandeVo);
        return  commandeService.delete( commande);
        }



}
