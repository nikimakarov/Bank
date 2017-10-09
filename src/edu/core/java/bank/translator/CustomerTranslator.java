package edu.core.java.bank.translator;

import edu.core.java.bank.domain.Customer;
import edu.core.java.bank.loader.CustomerPersonalLoader;
import edu.core.java.bank.vo.CustomerVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class CustomerTranslator implements Translator<CustomerVO, Customer> {

    private static final Logger logger = LoggerFactory.getLogger(CustomerTranslator.class);

    @Override
    public CustomerVO fromDomainToValue(Customer customer) {
        CustomerVO customerVO = null;
        if (customer != null) {
            customerVO = new CustomerVO(customer.getName(), customer.getDateOfBirth(),
                    customer.getGender(), customer.getPersonalInfo().getId());
        } else {
            logger.debug("Domain Object was null, so translation not possible");
        }
        return customerVO;
    }

    @Override
    public Customer fromValueToDomain(CustomerVO customerVO) {
        Customer customer = null;
        if (customerVO != null) {
            customer = new Customer(customerVO.name, customerVO.dateOfBirth, customerVO.gender);
        } else {
            logger.debug("Value Object was null, so translation not possible");
        }
        return customer;
    }
}