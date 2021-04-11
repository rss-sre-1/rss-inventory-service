package com.revature.inventory.exceptions;

	public class UnsuccessfulSaveOperationException extends RuntimeException {

		
		private static final long serialVersionUID = -4997079804524621764L;

				public UnsuccessfulSaveOperationException() {
				}

				public UnsuccessfulSaveOperationException(String message) {
					super(message);
				}

				public UnsuccessfulSaveOperationException(Throwable cause) {
					super(cause);
				}

				public UnsuccessfulSaveOperationException(String message, Throwable cause) {
					super(message, cause);
				}

				public UnsuccessfulSaveOperationException(String message, Throwable cause, boolean enableSuppression,
						boolean writableStackTrace) {
					super(message, cause, enableSuppression, writableStackTrace);
				}
	}

