package com.heinsohn.semillero.repository;

import org.springframework.stereotype.Repository;
import com.heinsohn.semillero.dto.*;


import org.springframework.data.repository.*;

@Repository
public interface UsuariosRepository extends CrudRepository<UsuarioDTO, Integer>{

	//public List<UsuarioDTO> buscarPorCorreo(String correo);
	
}
