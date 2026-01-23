package uce.edu.web.api.matricula.interfaces;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.matricula.aplication.EstudianteService;
import uce.edu.web.api.matricula.domain.Estudiante;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Produces;


@Path("/estudiantes")
public class EstudianteResource {
    @Inject
    private EstudianteService estudianteService;
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estudiante> listarTodos(){ 
        return this.estudianteService.listarTodos();
    }
    
    @GET
    @Path("/consultarPorId/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Estudiante consultarPotId (@PathParam("id") Integer id){
        return this.estudianteService.consultarPorID(id);
    }

    @POST
    @Path("")
    public Response crearEstudiante(Estudiante estu){
        this.estudianteService.crearEstudiante(estu);
        return 
        Response.status(Response.Status.CREATED).entity(estu).build();
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") Integer id, Estudiante estu){
        this.estudianteService.actualizarEstudiante(id, estu);
        return Response.status(209).entity(null).build();
    }

    @PATCH
    @Path("/{id}")
    public void actualizarParcial(@PathParam("id") Integer id, Estudiante estu){
        this.estudianteService.parcialActuEstudiante(id, estu);
    }

    @DELETE
    @Path("/{id}")
    public void borrarestudiante(@PathParam("id") Integer id){
        this.estudianteService.eliminarEstudiante(id);
    }
    
    
}

