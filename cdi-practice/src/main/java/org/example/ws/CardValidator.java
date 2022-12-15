package org.example.ws;

import org.example.ejb.BookEJB;
import org.example.model.CreditCard;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.swing.text.DateFormatter;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebService(endpointInterface = "org.example.ws.Validator")
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
public class CardValidator  implements Validator {
    // todo: inject CardEjb
    @Override
    @WebResult(name = "isValid")
    @WebMethod(operationName = "ValidateCreditCard")
    public boolean validate(@WebParam(name = "Credit-Card") CreditCard creditCard) throws ParseException {
        String cardNumber = creditCard.getNumber();
        boolean validMasterCard = false;
        if (cardNumber.charAt(0) == (char)'5' && cardNumber.length() == 16) {
            validMasterCard = true;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy", Locale.ENGLISH);
        Date expiryDate = formatter.parse(creditCard.getExpiryDate());
        boolean validDate = new Date().compareTo(expiryDate) > 1;
        if (validMasterCard && validDate) {
            return true;
        } else {
            throw new CardValidatorException("Card validation failed");
        }
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/cardValidator", new CardValidator());
    }
}
