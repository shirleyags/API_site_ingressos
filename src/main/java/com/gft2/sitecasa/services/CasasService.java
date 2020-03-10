package com.gft2.sitecasa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.gft2.sitecasa.domain.CasaShow;
import com.gft2.sitecasa.domain.Eventos;
import com.gft2.sitecasa.exceptions.CasaDeShowExistenteException;
import com.gft2.sitecasa.exceptions.CasaDeShowNaoExistenteException;
import com.gft2.sitecasa.exceptions.EventoNaoEncontradoException;
import com.gft2.sitecasa.repository.CasasRepository;


@Service
public class CasasService {
	
	@Autowired
	private CasasRepository casasRepository;
	
	
	
	public List<CasaShow> listar(){
		return casasRepository.findAll();
		
	}
	
	public CasaShow salvar(CasaShow casa) {
		if(casa.getId() != null){
			
			CasaShow a = casasRepository.findById(casa.getId()).get();
			
			if(a !=null) {
				throw new CasaDeShowExistenteException("A casa de show já existe.");
			}
			
		}
		return casasRepository.save(casa) ;
	}
	
	public Optional<CasaShow> buscar(Long id) {
		Optional<CasaShow> casa = casasRepository.findById(id);
			if(casa.isEmpty()) {
				throw new CasaDeShowNaoExistenteException("A casa de show não pôde ser encontrado");
			}
			
			return casa;
			
		}
	
	
	public void deletar(Long id) {
		try {
			casasRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e){
			throw new CasaDeShowNaoExistenteException("A casa de show não pôde ser encontrado!"); //Por que não é ao contrário??
		}
		
	} 
	
	public void atualizar(CasaShow cadaShow) { //Por que aqui não recebe o Long Id???
		verificarExistenciaCasa(cadaShow); //Verifica a existência do livro
		casasRepository.save(cadaShow);
		
	}
	
	private void verificarExistenciaCasa(CasaShow cadaShow) {
		buscar(cadaShow.getId());
	}
	
	public List<CasaShow>listarOrdemAlfabeticaCrescente(){
		return casasRepository.findAll(Sort.by(Sort.Direction.ASC, "casa"));
	}
	
	public List<CasaShow>listarOrdemAlfabeticaDecrescente(){
		return casasRepository.findAll(Sort.by(Sort.Direction.DESC, "casa"));
	}
	
	
	public List<CasaShow> pesquisar(String casa){
		return casasRepository.findByCasaContaining(casa);
	}
	
	
	
	
	
	
	
	
}
