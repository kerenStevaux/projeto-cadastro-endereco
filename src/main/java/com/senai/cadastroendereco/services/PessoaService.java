package com.senai.cadastroendereco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.cadastroendereco.entitites.Pessoa;
import com.senai.cadastroendereco.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	//Criar uma nova pessoa
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	//Buscar uma pessoa pelo ID
	public Pessoa buscarPorId(long id) {
		return pessoaRepository.findById(id).orElse(null);
	}
	
	//Listar todas as pessoas
	public List<Pessoa> listarTodas(){
		return pessoaRepository.findAll();
	}

	//Excluir uma pessoa
	public void deletarPorId(Long id) {
		pessoaRepository.deleteById(id);
	}
	
	//Buscar pessoa por email 
	public Pessoa buscarPorEmail(String email) {
		return pessoaRepository.findByEmail(email);
	}
	
	//Verficar email e senha 
	public Pessoa autenticarPessoa(String email, String senha) {
		
		//verificar o email
		Pessoa pessoa = pessoaRepository.findByEmail(email);
		
		//
		if (pessoa != null && pessoa.getSenha().equals(senha)) {
			return pessoa;
		} else {
			return null;
		}
			
	}
}
