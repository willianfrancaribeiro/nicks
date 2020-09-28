package br.com.nick;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import br.com.nick.cpf.CapturaCpf;

@SpringBootTest
class NickApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void capturaNick() {
		CapturaCpf cpf = new CapturaCpf();
		CapturaNick nick = new CapturaNick();
		ArrayList<String>nicks = nick.getNick();
		for(String nick_str:nicks) {
			Nick n = cpf.capturaCpf(nick_str);
			Assert.notNull(n, "Não capturado");
		}
	}
	

}
