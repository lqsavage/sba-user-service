package com.iihtibm.sba.exception;

/**
 * @author savagelee
 */
public class PaginationSortingException extends RuntimeException {

	private static final long serialVersionUID = -123L;
	private Exception ex;

	public PaginationSortingException(String message) {
		super(message);
	}

	public PaginationSortingException(Exception e, String message) {
		super(message);
		ex = e;
	}

	public Exception getEx() {
		return ex;
	}

}
