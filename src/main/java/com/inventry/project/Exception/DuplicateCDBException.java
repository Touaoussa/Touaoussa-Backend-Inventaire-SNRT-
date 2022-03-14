package com.inventry.project.Exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class DuplicateCDBException extends SQLIntegrityConstraintViolationException {

	public DuplicateCDBException(String description) {
		super(description);
	}
	public DuplicateCDBException(String code, String description) {
		super(description);
	}
	
}
