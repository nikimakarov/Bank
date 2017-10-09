package edu.core.java.bank.translator;

import edu.core.java.bank.domain.CustomerPersonal;
import edu.core.java.bank.vo.CustomerPersonalVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class CustomerPersonalTranslator implements Translator<CustomerPersonalVO, CustomerPersonal>{

    private static final Logger logger = LoggerFactory.getLogger(CustomerPersonalTranslator.class);

    @Override
    public CustomerPersonalVO fromDomainToValue(CustomerPersonal customerPersonal) {
        CustomerPersonalVO customerPersonalVO = null;
        if (customerPersonal != null) {
            customerPersonalVO = new CustomerPersonalVO(customerPersonal.getPhoneNumber(),customerPersonal.getEmail());
        } else {
            logger.debug("Domain Object was null, so translation not possible");
        }
        return customerPersonalVO;
    }

    @Override
    public  CustomerPersonal fromValueToDomain(CustomerPersonalVO customerPersonalVO) {
        CustomerPersonal customerPersonal = null;
        if (customerPersonalVO != null) {
            customerPersonal = new CustomerPersonal(customerPersonalVO.phoneNumber, customerPersonalVO.email);
        } else {
            logger.debug("Value Object was null, so translation not possible");
        }
        return customerPersonal;
    }

}

