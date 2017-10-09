package edu.core.java.bank.translator;

import edu.core.java.bank.AppContext;
import edu.core.java.bank.domain.Customer;
import edu.core.java.bank.domain.Privilege;
import edu.core.java.bank.loader.CardLoader;
import edu.core.java.bank.loader.CustomerLoader;
import edu.core.java.bank.vo.PrivilegeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class PrivilegeTranslator implements Translator<PrivilegeVO, Privilege> {

    private static final Logger logger = LoggerFactory.getLogger(PrivilegeTranslator.class);

    @Override
    public PrivilegeVO fromDomainToValue(Privilege privilege) {
        PrivilegeVO privilegeVO = null;
        if (privilege != null) {
            privilegeVO = new PrivilegeVO(privilege.getCard().getId(), privilege.getSalePercent());
        } else {
            logger.debug("Domain Object was null, so translation not possible");
        }
        return privilegeVO;
    }

    @Override
    public Privilege fromValueToDomain(PrivilegeVO privilegeVO) {
        Privilege privilege = null;
        if (privilegeVO != null) {
            privilege = new Privilege(privilegeVO.salePercent);
        } else {
            logger.debug("Value Object was null, so translation not possible");
        }
        return privilege;
    }
}