package edu.core.java.bank;

import edu.core.java.bank.loader.*;
import edu.core.java.bank.repository.*;
import edu.core.java.bank.translator.*;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class AppContext {

    private CardRepository cardRepository;
    private CustomerRepository customerRepository;
    private CustomerPersonalRepository customerPersonalRepository;
    private PrivilegeRepository privilegeRepository;
    private ProductRepository productRepository;
    private TransactionRepository transactionRepository;

    private CardTranslator cardTranslator;
    private CustomerTranslator customerTranslator;
    private CustomerPersonalTranslator customerPersonalTranslator;
    private PrivilegeTranslator privilegeTranslator;
    private ProductTranslator productTranslator;
    private TransactionTranslator transactionTranslator;

    private CardLoader cardLoader;
    private CustomerLoader customerLoader;
    private CustomerPersonalLoader customerPersonalLoader;
    private PrivilegeLoader privilegeLoader;
    private ProductLoader productLoader;
    private TransactionLoader transactionLoader;

    public void init() {
        customerPersonalRepository = new CustomerPersonalRepository();
        customerRepository = new CustomerRepository();
        cardRepository = new CardRepository();
        privilegeRepository = new PrivilegeRepository();
        productRepository = new ProductRepository();
        transactionRepository = new TransactionRepository();

        customerPersonalTranslator = new CustomerPersonalTranslator();
        customerTranslator = new CustomerTranslator();
        cardTranslator = new CardTranslator();
        privilegeTranslator = new PrivilegeTranslator();
        productTranslator = new ProductTranslator();
        transactionTranslator = new TransactionTranslator();

        customerPersonalLoader = new CustomerPersonalLoader(customerPersonalRepository, customerPersonalTranslator);
        customerLoader = new CustomerLoader(customerRepository, customerTranslator, customerPersonalLoader);
        cardLoader = new CardLoader(cardRepository, cardTranslator, customerLoader);
        privilegeLoader = new PrivilegeLoader(privilegeRepository, privilegeTranslator, cardLoader);
        productLoader = new ProductLoader(productRepository, productTranslator);
        transactionLoader = new TransactionLoader(transactionRepository, transactionTranslator, cardLoader, productLoader);

    }


    public CustomerPersonalRepository getCustomerPersonalRepository() {
        return customerPersonalRepository;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public CardRepository getCardRepository() {
        return cardRepository;
    }

    public PrivilegeRepository getPrivilegeRepository() {
        return privilegeRepository;
    }

    public ProductRepository getProductRepository(){
        return productRepository;
    }

    public TransactionRepository getTransactionRepository(){
        return transactionRepository;
    }

    public CardTranslator getCardTranslator(){
        return cardTranslator;
    }

    public CustomerTranslator getCustomerTranslator(){
        return customerTranslator;
    }

    public CustomerPersonalTranslator getCustomerPersonalTranslator(){
        return customerPersonalTranslator;
    }

    public PrivilegeTranslator getPrivilegeTranslator(){
        return privilegeTranslator;
    }

    public ProductTranslator getProductTranslator(){
        return productTranslator;
    }

    public TransactionTranslator getTransactionTranslator(){
        return transactionTranslator;
    }

    public CustomerPersonalLoader getCustomerPersonalLoader() {
        return customerPersonalLoader;
    }

    public CustomerLoader getCustomerLoader() {
        return customerLoader;
    }

    public CardLoader getCardLoader() {
        return cardLoader;
    }

    public PrivilegeLoader getPrivilegeLoader() {
        return privilegeLoader;
    }

    public ProductLoader getProductLoader() {
        return productLoader;
    }

    public TransactionLoader getTransactionLoader(){
        return transactionLoader;
    }
}
