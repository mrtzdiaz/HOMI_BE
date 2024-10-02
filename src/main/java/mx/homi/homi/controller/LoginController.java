package mx.homi.homi.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.homi.homi.model.Usuario;
import mx.homi.homi.repository.UsuarioRepository;
import mx.homi.homi.security.JwtFilter;
import mx.homi.homi.security.Token;
import mx.homi.homi.service.UsuarioService;

@RestController
@RequestMapping("/login/")
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {
	
	private final UsuarioService usuarioService;
	private final UsuarioRepository usuarioRepository;
	@Autowired
	public LoginController(UsuarioService usuarioService, UsuarioRepository usuarioRepository) {
		this.usuarioService = usuarioService;
		this.usuarioRepository = usuarioRepository;
	}

	@PostMapping
	public Token loginUser(@RequestBody Usuario usuario) 
										throws ServletException {
		if (usuarioService.validateUser(usuario)) {
			Usuario user = usuarioRepository.findByEmail(usuario.getEmail()).get();
			System.out.println("Usuario válido " + user.getEmail());
			return new Token(generateToken(user.getUsername()));
		}
		throw new ServletException("Nombre de usuario o contraseña incorrectos [" + usuario.getEmail()+ "]");
	}//login
	
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();//Fecha hora actual
		calendar.add(Calendar.HOUR, 12); // Pruebas
		return Jwts.builder().setSubject(username).claim("role", "user")
		.setIssuedAt(new Date())
		.setExpiration(calendar.getTime())
		.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
		.compact();
	}//generateToken
}
