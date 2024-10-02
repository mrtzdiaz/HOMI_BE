package mx.homi.homi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.homi.homi.model.Usuario;
import mx.homi.homi.service.UsuarioService;

@RestController
@RequestMapping(path = "/api/usuarios/")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {
	private UsuarioService uS;
	
	@Autowired
	UsuarioController(UsuarioService usuarioService){
		this.uS = usuarioService;
	}
	
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return uS.addUsuario(usuario);
	}
	
}
