package com.revature.inventory.exceptions;

public class NoProductListFoundException extends RuntimeException {

		
		private static final long serialVersionUID = -4997079804524621764L;

				public NoProductListFoundException() {
				}

				public NoProductListFoundException(String message) {
					super(message);
				}

				public NoProductListFoundException(Throwable cause) {
					super(cause);
				}

				public NoProductListFoundException(String message, Throwable cause) {
					super(message, cause);
				}

				public NoProductListFoundException(String message, Throwable cause, boolean enableSuppression,
						boolean writableStackTrace) {
					super(message, cause, enableSuppression, writableStackTrace);
				}
	}

