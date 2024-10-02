package mx.homi.homi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mx.homi.homi.model.Usuario;
import mx.homi.homi.repository.UsuarioRepository;

@Service
public class UsuarioService {
	private UsuarioRepository uR;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository){
		this.uR = usuarioRepository;
	}
	
	public Optional<Usuario> getUserByEmail(String email){
		return uR.findByEmail(email);
	}
	
	public Usuario addUsuario(Usuario usuario) {
		Optional<Usuario> tmpUsuario = uR.findByEmail(usuario.getEmail());
		if(tmpUsuario.isEmpty()) {
			usuario.setPassword(encoder.encode(usuario.getPassword()));
			uR.save(usuario);
			return usuario;
		}
		System.out.println("Ya hay un usuario con ese correo");
		return null;
	}
	
	public Boolean validateUser(Usuario usuario) {
		Optional<Usuario> userByEmail = uR.findByEmail(usuario.getEmail());
		if(userByEmail.isPresent()) {
			Usuario tmpUser = userByEmail.get();
			if(encoder.matches(usuario.getPassword(), tmpUser.getPassword())) {
				return true;
			}
		}
		return false;
	}
}

