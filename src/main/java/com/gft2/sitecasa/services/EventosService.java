package com.gft2.sitecasa.services;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gft2.sitecasa.domain.CasaShow;
import com.gft2.sitecasa.domain.Eventos;
import com.gft2.sitecasa.exceptions.EventoNaoEncontradoException;
import com.gft2.sitecasa.repository.EventosRepository;




@Service
public class EventosService {
	
	@Autowired
	private EventosRepository eventosRepository; 
	
	
	public List<Eventos> listar(){
		return eventosRepository.findAll();
		
	}
	
	
	public Optional<Eventos> buscar(Long id){
		Optional<Eventos> evento = eventosRepository.findById(id); 
		if(evento.isEmpty()) {
			throw new EventoNaoEncontradoException("O evento não pôde ser encontrado!"); 
		}
		return evento;
}
	
	public Eventos salvar(Eventos cadaEvento){ 
		cadaEvento.setId(null); //Setar igual a nulo para garantir que será criada uma instância nova, não alterar um objeto já criado. 
		return  eventosRepository.save(cadaEvento);
	
	}
	
	public void deletar(Long id) {
		try {
			eventosRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e){
			throw new EventoNaoEncontradoException("O evento não pôde ser encontrado!"); //Por que não é ao contrário??
		}
		
	} //Por que não precisa do return???
	
	public void atualizar(Eventos cadaEvento) { //Por que aqui não recebe o Long Id???
		verificarExistenciaLivro(cadaEvento); //Verifica a existência do livro
		eventosRepository.save(cadaEvento);
		
	}
	
	private void verificarExistenciaLivro(Eventos cadaEvento) {
		buscar(cadaEvento.getId());
	}
	
	
	public List<Eventos>listarCapacidadeAsc(){
		return eventosRepository.findAll(Sort.by(Sort.Direction.ASC, "capacidade"));
	}
	
	public List<Eventos>listarCapacidadeDesc(){
		return eventosRepository.findAll(Sort.by(Sort.Direction.DESC, "capacidade"));
	}
	
	public List<Eventos>listarDataAsc(){
		return eventosRepository.findAll(Sort.by(Sort.Direction.ASC, "data"));
	}
	
	public List<Eventos>listarDataDesc(){
		return eventosRepository.findAll(Sort.by(Sort.Direction.DESC, "data"));
	}
	
	
	public List<Eventos>listarNomeAsc(){
		return eventosRepository.findAll(Sort.by(Sort.Direction.ASC, "evento"));
	}
	
	public List<Eventos>listarNomeDesc(){
		return eventosRepository.findAll(Sort.by(Sort.Direction.DESC, "evento"));
	}
	
	public List<Eventos>listarPrecoAsc(){
		return eventosRepository.findAll(Sort.by(Sort.Direction.ASC, "valor"));
	}
	
	public List<Eventos>listarPrecoDesc(){
		return eventosRepository.findAll(Sort.by(Sort.Direction.DESC, "valor"));
	}
	
	
//	public Comentario salvarComentario(Long livroId, Comentario cadaComentario ) {
//		Livro cadaLivro = buscar(livroId).get();
//		cadaComentario.setEsseLivro(cadaLivro);
//		cadaComentario.setData(new Date());
//		
//		return comentariosRepository.save(cadaComentario);
//		
//	}
//	
//	public List<Comentario> listarComentario(Long livroId) {
//		Livro cadaLivro = buscar(livroId).get();
//		return 	cadaLivro.getComentarios();
//		
//	}
	
	
	
	
	
	
	
	

}
