package com.gft2.sitecasa.exceptions;

public class CasaDeShowExistenteException extends RuntimeException {
	
	//RuntimeException = Excessão não checada

	

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public CasaDeShowExistenteException(String mensagem) {

			super(mensagem); //super = Construtor da classe RuntimeException
		}

		public CasaDeShowExistenteException(String mensagem, Throwable causa) {

			super(mensagem, causa);
		}

}
