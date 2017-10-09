package edu.core.java.bank.loader;

import edu.core.java.bank.AppContext;
import edu.core.java.bank.domain.Customer;
import edu.core.java.bank.domain.Privilege;
import edu.core.java.bank.repository.Repository;
import edu.core.java.bank.translator.Translator;
import edu.core.java.bank.vo.ValueObject;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class CustomerLoader extends Loader<Customer> {

    private CustomerPersonalLoader customerPersonalLoader = null;

    public CustomerLoader(Repository repository, Translator translator, CustomerPersonalLoader customerPersonalLoader) {
        super(repository, translator);
        this.customerPersonalLoader = customerPersonalLoader;
    }

    public Customer getEntityById(Long id){
        ValueObject vo = repository.getValueObject(id);
        Customer customer = null;
        if (vo != null) {
            customer = (Customer) translator.fromValueToDomain(vo);
            logger.info("Domain object successfully loaded");
            customer.setCustomerPersonal(customerPersonalLoader.getEntityById(vo.getId()));
            logger.info("Customer Personal has been set");
        } else {
            logger.info("Domain object wasn't loaded");
        }
        return customer;
    }

}