package com.revature.inventory.exceptions;

public class UnsuccessfulDeleteOperationException extends RuntimeException {

		
		private static final long serialVersionUID = -4997079804524621764L;

				public UnsuccessfulDeleteOperationException() {
				}

				public UnsuccessfulDeleteOperationException(String message) {
					super(message);
				}

				public UnsuccessfulDeleteOperationException(Throwable cause) {
					super(cause);
				}

				public UnsuccessfulDeleteOperationException(String message, Throwable cause) {
					super(message, cause);
				}

				public UnsuccessfulDeleteOperationException(String message, Throwable cause, boolean enableSuppression,
						boolean writableStackTrace) {
					super(message, cause, enableSuppression, writableStackTrace);
				}
	}

