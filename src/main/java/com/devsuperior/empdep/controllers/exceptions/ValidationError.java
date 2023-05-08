package com.devsuperior.empdep.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError
{
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    /**
     * getErrors
     *
     */
    public List<FieldMessage> getErrors()
    {
        return errors;
    }

    /**
     * addError
     *
     * @param fieldName String
     * @param message String
     */
    public void addError( String fieldName, String message )
    {
        errors.add( new FieldMessage( fieldName, message ) );
    }
}
