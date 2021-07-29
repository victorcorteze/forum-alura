package br.com.alura.forum.repository;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.modelo.Usuario;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void EncontraUsuarioPeloEmail() {
		String email = "moderador@email.com";
		Optional<Usuario> findByEmail = usuarioRepository.findByEmail(email);
		Assert.assertNotNull(findByEmail);
		Assert.assertEquals(email, findByEmail.get().getEmail());
	}

}
