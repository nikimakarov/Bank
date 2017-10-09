package edu.core.java.bank.loader;

import edu.core.java.bank.AppContext;
import edu.core.java.bank.domain.Card;
import edu.core.java.bank.domain.Customer;
import edu.core.java.bank.repository.Repository;
import edu.core.java.bank.translator.Translator;
import edu.core.java.bank.vo.ValueObject;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class CardLoader extends Loader<Card> {

    private CustomerLoader customerLoader = null;

    public CardLoader(Repository repository, Translator translator, CustomerLoader customerLoader) {
        super(repository, translator);
        this.customerLoader = customerLoader;
    }

    public Card getEntityById(Long id){
        ValueObject vo = repository.getValueObject(id);
        Card card = null;
        if (vo != null) {
            card = (Card) translator.fromValueToDomain(vo);
            logger.info("Domain object successfully loaded");
            card.setCustomer(customerLoader.getEntityById(vo.getId()));
            logger.info("Customer has been set");
        } else {
            logger.info("Domain object wasn't loaded");
        }
        return card;
    }

}