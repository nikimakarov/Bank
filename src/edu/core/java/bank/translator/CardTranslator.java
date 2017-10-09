package edu.core.java.bank.translator;

import edu.core.java.bank.domain.Card;
import edu.core.java.bank.vo.CardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class CardTranslator implements Translator<CardVO, Card>{

    private static final Logger logger = LoggerFactory.getLogger(CardTranslator.class);

    @Override
    public CardVO fromDomainToValue(Card card) {
        CardVO cardVO = null;
        if (card != null) {
            cardVO = new CardVO(card.getNumber(), card.getBalance(), card.getType(), card.getCustomer().getId());
        } else {
            logger.debug("Domain Object was null, so translation not possible");
        }
        return cardVO;
    }

    @Override
    public Card fromValueToDomain(CardVO cardVO) {
        Card card = null;
        if (cardVO != null) {
            card = new Card(cardVO.number, cardVO.balance, cardVO.type);
        } else {
            logger.debug("Value Object was null, so translation not possible");
        }
        return card;
    }

}
