package edu.core.java.bank.loader;

import edu.core.java.bank.AppContext;
import edu.core.java.bank.domain.Transaction;
import edu.core.java.bank.repository.Repository;
import edu.core.java.bank.translator.Translator;
import edu.core.java.bank.vo.TransactionVO;
import edu.core.java.bank.vo.ValueObject;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class TransactionLoader extends Loader<Transaction> {

    private CardLoader cardLoader = null;
    private ProductLoader productLoader = null;

    public TransactionLoader(Repository repository, Translator translator,  CardLoader cardLoader, ProductLoader productLoader) {
        super(repository, translator);
        this.cardLoader = cardLoader;
        this.productLoader = productLoader;
    }

    public Transaction getEntityById(Long id) {
        ValueObject vo = repository.getValueObject(id);
        Transaction transaction = null;
        if (vo != null) {
            transaction = (Transaction) translator.fromValueToDomain(vo);
            logger.info("Domain object successfully loaded");
            transaction.setCard(cardLoader.getEntityById(vo.getId()));
            logger.info("Card has been set");
            transaction.setProduct(productLoader.getEntityById(vo.getId()));
            logger.info("Product has been set");
        } else {
            logger.info("Domain object wasn't loaded");
        }
        return transaction;
    }

}