package com.gft2.sitecasa.resources;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gft2.sitecasa.domain.CasaShow;
import com.gft2.sitecasa.domain.Eventos;
import com.gft2.sitecasa.services.CasasService;



@RestController
@RequestMapping("/api/casas")
public class CasasResource {	

	@Autowired
	private CasasService casasService;

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CasaShow>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(casasService.listar());

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody CasaShow casa) {
		casa = casasService.salvar(casa);

		URI umaUri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

		return ResponseEntity.created(umaUri).build();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<CasaShow>> buscar(@PathVariable("id") Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(casasService.buscar(id));
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deletar(@PathVariable("id")Long id) {
		casasService.deletar(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.PUT) 
	public  ResponseEntity<Void> atualizar(@RequestBody CasaShow cadaShow, @PathVariable("id")Long id) {
		cadaShow.setId(id);
		casasService.atualizar(cadaShow);
	return ResponseEntity.noContent().build();
	}
	

	@RequestMapping (value ="/asc", method = RequestMethod.GET)
	public ResponseEntity<List<CasaShow>> listarOrdemAlfabeticaCrescente() {
		return ResponseEntity.status(HttpStatus.OK).body(casasService.listarOrdemAlfabeticaCrescente());
	}
	
	@RequestMapping (value ="/desc", method = RequestMethod.GET)
	public ResponseEntity<List<CasaShow>> listarOrdemAlfabeticaDecrescente() {
		return ResponseEntity.status(HttpStatus.OK).body(casasService.listarOrdemAlfabeticaDecrescente());
	}
	
	
	@RequestMapping (value ="/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<List<CasaShow>> todasCasa = 
	
	public List<CasaShow> pesquisar(String casa){
		return casasRepository.findByCasaContaining(casa);
	}
	

	

}
