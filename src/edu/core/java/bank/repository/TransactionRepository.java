package edu.core.java.bank.repository;

import edu.core.java.bank.vo.TransactionVO;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class TransactionRepository extends Repository<TransactionVO>{

    public TransactionRepository() { this(new LinkedHashMap<>()); }

    public TransactionRepository(Map<Long, TransactionVO> transactionSet) {
        super.valueObjects = transactionSet;
    }

}
