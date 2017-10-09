package edu.core.java.bank.loader;

import edu.core.java.bank.domain.Privilege;
import edu.core.java.bank.repository.Repository;
import edu.core.java.bank.translator.Translator;
import edu.core.java.bank.vo.ValueObject;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class PrivilegeLoader extends Loader<Privilege> {

    private CardLoader cardLoader = null;

    public PrivilegeLoader(Repository repository, Translator translator, CardLoader cardLoader) {
        super(repository, translator);
        this.cardLoader = cardLoader;
    }

    public Privilege getEntityById(Long id){
        ValueObject vo = repository.getValueObject(id);
        Privilege privilege = null;
        if (vo != null) {
            privilege = (Privilege) translator.fromValueToDomain(vo);
            logger.info("Domain object successfully loaded");
            privilege.setCard(cardLoader.getEntityById(vo.getId()));
            logger.info("Card has been set");
        } else {
            logger.info("Domain object wasn't loaded");
        }
        return privilege;
    }
}
