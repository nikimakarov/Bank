package edu.core.java.bank.repository;

import edu.core.java.bank.vo.CardVO;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class CardRepository extends Repository<CardVO> {

    public CardRepository() { this(new LinkedHashMap<>()); }

    public CardRepository(Map<Long, CardVO> cardSet) {
        super.valueObjects = cardSet;
    }

}
