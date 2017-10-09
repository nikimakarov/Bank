package edu.core.java.bank.repository;

import edu.core.java.bank.vo.CustomerVO;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class CustomerRepository extends Repository<CustomerVO>{

    public CustomerRepository() { this(new LinkedHashMap<>()); }

    public CustomerRepository(Map<Long, CustomerVO> customerSet) {
        super.valueObjects = customerSet;
    }

}
