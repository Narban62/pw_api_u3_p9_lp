package uce.edu.web.api.matricula.infraestructure;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import uce.edu.web.api.matricula.domain.Materia;

import java.util.List;

@ApplicationScoped
public class MateriaRepository implements PanacheRepository<Materia> {

    //buscar por código
    public Materia buscarPorCodigo(String codigo) {
        return find("codigo", codigo).firstResult();
    }

    //listar por número de créditos
    public List<Materia> buscarPorCreditos(Integer creditos) {
        return find("creditos", creditos).list();
    }
}
