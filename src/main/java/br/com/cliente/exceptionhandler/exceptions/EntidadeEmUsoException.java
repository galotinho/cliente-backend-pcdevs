package br.com.cliente.exceptionhandler.exceptions;

public class EntidadeEmUsoException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public EntidadeEmUsoException(String mensagem) {
		super(mensagem);
	}
	
}
