package com.revature.inventory.exceptions;


public class ProductNotFoundException extends RuntimeException {

		
		private static final long serialVersionUID = -4997079804524621764L;

				public ProductNotFoundException() {
				}

				public ProductNotFoundException(String message) {
					super(message);
				}

				public ProductNotFoundException(Throwable cause) {
					super(cause);
				}

				public ProductNotFoundException(String message, Throwable cause) {
					super(message, cause);
				}

				public ProductNotFoundException(String message, Throwable cause, boolean enableSuppression,
						boolean writableStackTrace) {
					super(message, cause, enableSuppression, writableStackTrace);
				}
	
}
