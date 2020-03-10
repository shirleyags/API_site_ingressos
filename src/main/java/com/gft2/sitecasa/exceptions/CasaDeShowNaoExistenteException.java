package com.gft2.sitecasa.exceptions;

public class CasaDeShowNaoExistenteException extends RuntimeException {
	
	//RuntimeException = Excessão não checada

	

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public CasaDeShowNaoExistenteException(String mensagem) {

			super(mensagem); //super = Construtor da classe RuntimeException
		}

		public CasaDeShowNaoExistenteException(String mensagem, Throwable causa) {

			super(mensagem, causa);
		}

}
