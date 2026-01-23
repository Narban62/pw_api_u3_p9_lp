package uce.edu.web.api.matricula.interfaces;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.matricula.aplication.MateriaService;
import uce.edu.web.api.matricula.domain.Materia;

@Path("/materias")
public class MateriaResource {

    @Inject
    private MateriaService materiaService;

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Materia> listarTodas() {
        return materiaService.listarTodas();
    }

    @GET
    @Path("consultarPorId/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Materia consultarPorId(@PathParam("id") Integer id) {
        return materiaService.consultarPorId(id);
    }

    @POST
    @Path("")
    public Response guardarMateria(Materia materia) {
        this.materiaService.crear(materia);
        return 
        Response.status(Response.Status.CREATED).entity(materia).build();
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") Integer id, Materia materia) {
        this.materiaService.actualizar(id, materia);
        return Response.status(210).entity(null).build();
    }

    @PATCH
    @Path("/{id}")
    public Response actualizarParcial(@PathParam("id") Integer id, Materia materia) {
        this.materiaService.actualizarParcial(id, materia);
        return Response.status(211).entity(null).build();
    }

    @DELETE
    @Path("/{id}")
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
