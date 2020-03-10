package com.gft2.sitecasa.exceptions;

public class EventoNaoEncontradoException extends RuntimeException  {
	
	//RuntimeException = Excessão não checada

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EventoNaoEncontradoException(String mensagem) {

		super(mensagem); //super = Construtor da classe RuntimeException
	}

	public EventoNaoEncontradoException(String mensagem, Throwable causa) {

		super(mensagem, causa);
	}

}
