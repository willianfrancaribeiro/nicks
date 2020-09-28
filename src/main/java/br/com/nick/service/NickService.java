package br.com.nick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nick.Nick;
import br.com.nick.repository.NickRepository;

@Service
public class NickService {
	@Autowired	NickRepository repositorio;
	public void salvar(Nick n) {
		repositorio.save(n);
	}
}
