package edu.core.java.bank.translator;

import edu.core.java.bank.AppContext;
import edu.core.java.bank.domain.Product;
import edu.core.java.bank.domain.Transaction;
import edu.core.java.bank.loader.CardLoader;
import edu.core.java.bank.loader.ProductLoader;
import edu.core.java.bank.vo.TransactionVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class TransactionTranslator implements Translator<TransactionVO, Transaction> {

    private static final Logger logger = LoggerFactory.getLogger(TransactionTranslator.class);

    @Override
    public TransactionVO fromDomainToValue(Transaction transaction) {
        TransactionVO transactionVO = null;
        if (transaction != null) {
            transactionVO = new TransactionVO(transaction.getNumber(), transaction.getDate(), transaction.getCard().getId(),
                    transaction.getProduct().getId(), transaction.getSalaryWithPrivilege());
        } else {
            logger.debug("Domain Object was null, so translation not possible");
        }
        return transactionVO;
    }

    @Override
    public Transaction fromValueToDomain(TransactionVO transactionVO) {
        Transaction transaction = null;
        if (transactionVO != null) {
            transaction = new Transaction(transactionVO.number, transactionVO.date, transactionVO.salaryWithPrivilege);
        } else {
            logger.debug("Value Object was null, so translation not possible");
        }
        return transaction;
    }
}
