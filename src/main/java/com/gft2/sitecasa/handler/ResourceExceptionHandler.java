package com.gft2.sitecasa.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import com.gft2.sitecasa.exceptions.CasaDeShowExistenteException;
import com.gft2.sitecasa.exceptions.CasaDeShowNaoExistenteException;
import com.gft2.sitecasa.exceptions.EventoNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	
	@ExceptionHandler(EventoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleEventoNaoEncontradoException (EventoNaoEncontradoException e, HttpServletRequest resquest) {
		
		
		//Instaciar um objeto dessa (DetalheErro) classe e setar.
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O evento não pôde ser encontrado!");
		erro.setTimestamp(System.currentTimeMillis()); //Para trazer a mensagem de erro em milesegundos
		erro.setMensagemDesenvolvedor("http://erros.siteingressos.com/404");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
				}
	
	
	@ExceptionHandler(CasaDeShowExistenteException .class) //
	public ResponseEntity<DetalhesErro> handleCasadeShowExistenteException (CasaDeShowExistenteException  e, HttpServletRequest request) {
		
		
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Casa de Show já existente!");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor("http//:erros.socialbooks.com/409");

		
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
				}
	
	@ExceptionHandler(CasaDeShowNaoExistenteException.class) //
	public ResponseEntity<DetalhesErro> handleAutorNaoExistenteException (CasaDeShowNaoExistenteException e, HttpServletRequest request) {
		
		
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Casa de Show não econtrada!");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
				}
	
	
	@ExceptionHandler(DataIntegrityViolationException.class) //
	public ResponseEntity<DetalhesErro> handlesDataIntegrityViolationException (DataIntegrityViolationException e, HttpServletRequest request) {
		
		
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição inválida!");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/400");

		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
		
				}
				

}
