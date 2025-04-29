package com.senai.cadastroendereco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.cadastroendereco.entitites.Endereco;
import com.senai.cadastroendereco.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	//Salvar um novo endereco
	public Endereco salvar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	//Buscar todos os enderecos
	public List<Endereco> listarTodos(){
		return enderecoRepository.findAll();
	}
	
	//Buscar um endereco por ID
	public Optional<Endereco> buscarPorId(Long id){
		return enderecoRepository.findById(id);
	}
	
	//Deletar um endereco por ID
	public void deletarPorId(Long id) {
		enderecoRepository.deleteById(id);
	}

}
