package edu.core.java.bank.repository;

import edu.core.java.bank.vo.PrivilegeVO;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class PrivilegeRepository extends Repository<PrivilegeVO> {

    public PrivilegeRepository() { this(new LinkedHashMap<>()); }

    public PrivilegeRepository(Map<Long, PrivilegeVO> privelegeSet) {
        super.valueObjects = privelegeSet;
    }

}
