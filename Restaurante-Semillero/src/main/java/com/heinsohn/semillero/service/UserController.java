package com.heinsohn.semillero.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.heinsohn.semillero.dto.*;
import com.heinsohn.semillero.repository.UsuariosRepository;

@RestController
@RequestMapping("usuarios")
public class UserController {
	
	//private List<UsuarioDTO> usuarios = new ArrayList<>();
	@Autowired
	private UsuariosRepository uRepository;
	
	  
	/**
	 * Metodo que retorna los datos de un usuario buscado por id, 
	 * por medio del metodo HTTP.GET
	 * @return String
	 */
		@ApiOperation(value = "Metodo que retorna los datos de un usuario buscado por id, por medio del metodo HTTP.GET",
			response = Integer.class, tags ="consultarUsuario por Id")
		@ApiResponses(value= {
		@ApiResponse(code=200, message="Exitoso,función!"),
		@ApiResponse(code=401, message="No autorizado,pila!"),
		@ApiResponse(code=403, message="No tienes permiso!"),
		@ApiResponse(code=404, message="No se encontro lo que buscabas!")


	})
		@GetMapping("usuarios1")
	public Optional<UsuarioDTO> obtenerUsuarioPorId(int idUsuario) {		
			Optional<UsuarioDTO> usuario = uRepository.findById(idUsuario);			
			return usuario;		
			}
	
	/**
	 * metodo que permite registrar los datos de un usuario
	 * utilizando el metodo HTTP.POST
	 * @return String
	 */
		
		@ApiOperation(value = "metodo que permite registrar los datos de un usuario por medio del metodo HTTP.POST",
				response = Integer.class, tags ="Agregar Usuario")
		@ApiResponses(value= {
				@ApiResponse(code=200, message="Exitoso,función!"),
				@ApiResponse(code=401, message="No autorizado,pila!"),
				@ApiResponse(code=403, message="No tienes permiso!"),
				@ApiResponse(code=404, message="No se encontro lo que buscabas!")
		})
	@PostMapping
	public @ResponseBody String crearUsuario ( int id,@RequestParam String nombre
		      , @RequestParam String correo, @RequestParam String contraseña, @RequestParam String estado) {

		    UsuarioDTO n = new UsuarioDTO();
		    n.setId(id);
		    n.setNombre(nombre);
		    n.setCorreo(correo);
		    n.setPassword(contraseña);
		    n.setEstado(estado);
		    uRepository.save(n);
		    return "Saved";
		  }
		
		
		
			
			
	/**
	 * Metodo que retorna los datos de los usuarios
	 * por medio del metodo HTTP.GET
	 * @return String
	 */
		@ApiOperation(value = "Metodo que retorna los datos de los usuarios por medio del metodo HTTP.GET",
			response = Integer.class, tags ="consultarUsuarios")
		@ApiResponses(value= {
		@ApiResponse(code=200, message="Exitoso,función!"),
		@ApiResponse(code=401, message="No autorizado,pila!"),
		@ApiResponse(code=403, message="No tienes permiso!"),
		@ApiResponse(code=404, message="No se encontro lo que buscabas!")


	})
	
	@GetMapping
	public List<UsuarioDTO> obtenerUsuario() {
		return (List<UsuarioDTO>) uRepository.findAll();
	}
	
	
	
	/** 
	 * Metodo permite actualizar los datos de un usuario
	 * por medio del metodo HTTP.PUT
	 * Recuerde llenar todos los campos o quedaran vacios
	 * 
	 * @return String
	 */
		@ApiOperation(value = "Metodo permite actualizar los datos de un usuario por medio del metodo HTTP.PUT. \n Recuerde llenar todos los campos o quedaran vacios",
				response = Integer.class, tags ="Actualizar Usuario")
		@ApiResponses(value= {
				@ApiResponse(code=200, message="Exitoso,función!"),
				@ApiResponse(code=401, message="No autorizado,pila!"),
				@ApiResponse(code=403, message="No tienes permiso!"),
				@ApiResponse(code=404, message="No se encontro lo que buscabas!")
		})
	@PutMapping
	public String actualizarUsuario(@RequestParam int id,@RequestParam String nombre
		      , @RequestParam String correo, @RequestParam String contraseña, @RequestParam String estado) {
		
		;
		if(uRepository.findById(id).isPresent()) {
				
			UsuarioDTO uUpdate = new UsuarioDTO();
			uUpdate.setId(id);
			uUpdate.setNombre(nombre);
			uUpdate.setCorreo(correo);
			uUpdate.setPassword(contraseña);
			uUpdate.setEstado(estado);
		    uRepository.save(uUpdate);
		    return "Usuario actualizado";
		}
		
		
		
		return "No se encuentra un usuario con id " +id;
	}
	
	
	/**
	 * Este metodo permite eliminar la información de un usuario
	 * especifico
	 * @return String
	 */
		@ApiOperation(value = "Metodo permite eliminar un usuario especifico por medio del metodo HTTP.DELETE. Se debe ingresar el id del usuario a eliminar",
				response = Integer.class, tags ="Eliminar Usuario")
		@ApiResponses(value= {
				@ApiResponse(code=200, message="Exitoso,función!"),
				@ApiResponse(code=401, message="No autorizado,pila!"),
				@ApiResponse(code=403, message="No tienes permiso!"),
				@ApiResponse(code=404, message="No se encontro lo que buscabas!")
		})
	
	@DeleteMapping
	public String eliminarUsuario(int idUsuario) {
			if (uRepository.findById(idUsuario).isPresent()) {
				uRepository.deleteById(idUsuario);	
				return "Usuario eliminado correctamente.";			
				}			
				return "Error! El usuario:"+idUsuario+ " no existe";
	}
	
	
	
	
	
	
	
	
	
}
