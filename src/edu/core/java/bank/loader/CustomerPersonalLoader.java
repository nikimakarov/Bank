package edu.core.java.bank.loader;

import edu.core.java.bank.AppContext;
import edu.core.java.bank.domain.Customer;
import edu.core.java.bank.domain.CustomerPersonal;
import edu.core.java.bank.domain.Product;
import edu.core.java.bank.repository.Repository;
import edu.core.java.bank.translator.Translator;
import edu.core.java.bank.vo.ValueObject;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class CustomerPersonalLoader extends Loader<CustomerPersonal> {

    public CustomerPersonalLoader(Repository repository, Translator translator) {
            super(repository, translator);
    }

    public CustomerPersonal getEntityById(Long id){
            ValueObject vo = repository.getValueObject(id);
            CustomerPersonal cm = null;
            if (vo != null) {
                cm = (CustomerPersonal) translator.fromValueToDomain(vo);
            }
            return cm;
    }
}
