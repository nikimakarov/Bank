package edu.core.java.bank.repository;

import edu.core.java.bank.vo.CustomerPersonalVO;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class CustomerPersonalRepository extends Repository<CustomerPersonalVO>{

    public CustomerPersonalRepository() { this(new LinkedHashMap<>()); }

    public CustomerPersonalRepository(Map<Long, CustomerPersonalVO> customerPersonalSet) {
        super.valueObjects = customerPersonalSet;
    }

}
