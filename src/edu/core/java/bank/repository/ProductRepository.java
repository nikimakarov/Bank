package edu.core.java.bank.repository;

import edu.core.java.bank.vo.PrivilegeVO;
import edu.core.java.bank.vo.ProductVO;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class ProductRepository extends Repository<ProductVO>{

    public ProductRepository() { this(new LinkedHashMap<>()); }

    public ProductRepository(Map<Long, ProductVO> productSet) {
        super.valueObjects = productSet;
    }

}
