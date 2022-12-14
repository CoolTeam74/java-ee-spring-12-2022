package org.example.ws;

import org.example.model.CreditCard;

import javax.jws.WebService;
import java.text.ParseException;

@WebService
public interface Validator {
    boolean validate(CreditCard creditCard) throws ParseException;
}
