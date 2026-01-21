package uce.edu.web.api.matricula.aplication;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.web.api.matricula.domain.Materia;
import uce.edu.web.api.matricula.infraestructure.MateriaRepository;

@ApplicationScoped
public class MateriaService {

    @Inject
    private MateriaRepository materiaRepository;

    public List<Materia> listarTodas() {
        return materiaRepository.listAll();
    }

    public Materia consultarPorId(Integer id) {
        return materiaRepository.findById(id.longValue());
    }

    @Transactional
    public void crear(Materia materia) {
        materiaRepository.persist(materia);
    }

    @Transactional
    public void actualizar(Integer id, Materia materia) {
        Materia mat = consultarPorId(id);
        mat.nombre = materia.nombre;
        mat.codigo = materia.codigo;
        mat.creditos = materia.creditos;
    }

    @Transactional
    public void actualizarParcial(Integer id, Materia materia) {
        Materia mat = consultarPorId(id);
        if (materia.nombre != null) mat.nombre = materia.nombre;
        if (materia.codigo != null) mat.codigo = materia.codigo;
        if (materia.creditos != null) mat.creditos = materia.creditos;
    }

    @Transactional
    public void eliminar(Integer id) {
        materiaRepository.deleteById(id.longValue());
    }

    //endpoint nuevo 1
    public Materia buscarPorCodigo(String codigo) {
        return materiaRepository.buscarPorCodigo(codigo);
    }

    //endpoint nuevo 2
    public List<Materia> buscarPorCreditos(Integer creditos) {
        return materiaRepository.buscarPorCreditos(creditos);
    }
}
