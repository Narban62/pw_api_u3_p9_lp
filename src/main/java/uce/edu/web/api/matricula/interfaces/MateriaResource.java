package uce.edu.web.api.matricula.interfaces;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import uce.edu.web.api.matricula.aplication.MateriaService;
import uce.edu.web.api.matricula.domain.Materia;

@Path("/materias")
public class MateriaResource {

    @Inject
    private MateriaService materiaService;

    @GET
    @Path("/todas")
    public List<Materia> listarTodas() {
        return materiaService.listarTodas();
    }

    @GET
    @Path("/{id}")
    public Materia consultarPorId(@PathParam("id") Integer id) {
        return materiaService.consultarPorId(id);
    }

    @POST
    @Path("/crear")
    public void crear(Materia materia) {
        materiaService.crear(materia);
    }

    @PUT
    @Path("/actualizar/{id}")
    public void actualizar(@PathParam("id") Integer id, Materia materia) {
        materiaService.actualizar(id, materia);
    }

    @PATCH
    @Path("/actualizarParcial/{id}")
    public void actualizarParcial(@PathParam("id") Integer id, Materia materia) {
        materiaService.actualizarParcial(id, materia);
    }

    @DELETE
    @Path("/eliminar/{id}")
    public void eliminar(@PathParam("id") Integer id) {
        materiaService.eliminar(id);
    }

    @GET
    @Path("/buscarPorCodigo/{codigo}")
    public Materia buscarPorCodigo(@PathParam("codigo") String codigo) {
        return materiaService.buscarPorCodigo(codigo);
    }

    @GET
    @Path("/buscarPorCreditos/{creditos}")
    public List<Materia> buscarPorCreditos(@PathParam("creditos") Integer creditos) {
        return materiaService.buscarPorCreditos(creditos);
    }
}
