package br.com.nick;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.com.nick.config.NickConfiguration;
import br.com.nick.cpf.CapturaCpf;
import br.com.nick.repository.NickRepository;
import br.com.nick.service.NickService;

@SpringBootApplication
@Component
public class NickApplication {

	static NickService service;

	public static void main(String[] args) {
		SpringApplication.run(NickApplication.class, args);

		CapturaCpf cpf = new CapturaCpf();
		CapturaNick nick = new CapturaNick();
		GravarArquivo ga = new GravarArquivo();
		ArrayList<String>nicks = nick.getNick();
		for(String nick_str:nicks) {
			Nick n = cpf.capturaCpf(nick_str);
			service.salvar(n);
			ga.gravarArquivo(n.getNick()+";"+n.getCpf()+"/r/n");
		}
	}
	@Autowired
	public void salvar(NickService service) {
		this.service = service;
	}


}
