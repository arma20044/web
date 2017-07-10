package py.edu.ucsa.voto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

 
 

import py.edu.ucsa.voto.entity.UcsawsVotosBlanco;



@Repository("votoBlancoDAO")
@Transactional(readOnly = true)
public class VotoBlancoDAO extends AbstractSpringDAO implements VotoBlancoDAOInterface {
  
 
  
  
  

  public VotoBlancoDAO() {
    claseEntidad = "UcsawsVotosBlanco";
    nombreCampoID = "idVotoBlanco";
    campoOrden = "idVotoBlanco";
  }

  @Transactional
  public void saveOrUpdate(UcsawsVotosBlanco o) {
    if (o.getIdVotoBlanco() == null)
      super.save(o);
    else
      super.update(o);
  }

  @Transactional
  public void delete(UcsawsVotosBlanco o) {
    super.delete(o);
  }

  @Transactional
  public List<UcsawsVotosBlanco> getList() {
    return super.getList();
  }

 


 
   


}
