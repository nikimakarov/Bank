package edu.core.java.bank;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import edu.core.java.bank.domain.DomainObject;
import edu.core.java.bank.loader.Loader;
import edu.core.java.bank.repository.Repository;
import edu.core.java.bank.vo.*;
import edu.core.java.bank.vo.ValueObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by nikitamakarov on 14.05.17.
 */

public class UI {

    private static Scanner scanner;
    private static Gson gson;
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    private static Increment cardId = new Increment();
    private static Increment customerId = new Increment();
    private static Increment customerPersonalId = new Increment();
    private static Increment privilegeId = new Increment();
    private static Increment productId = new Increment();
    private static Increment transactionId = new Increment();

    private static AppContext appContext = new AppContext();

    public static void start() {
        appContext.init();
        scanner = new Scanner(System.in);
        gson = new GsonBuilder().setDateFormat("dd-mm-yyyy").create();
        logger.info("Entering application.");
        while (true) {
            System.out.println("");
            System.out.println("Choose action:\n1)Add or updateValueObject entity\n" +
                    "2)Get full list of entities\n3)Remove entity\n4)End program");
            switch (readChoice().intValue()) {
                case 1:
                    addEntity();
                    break;
                case 2:
                    printListOfEntities();
                    break;
                case 3:
                    deleteEntity();
                    break;
                case 4:
                    logger.info("Exiting application.");
                    return;
                default:
                    logger.error("Wrong input!");
                    break;

            }
        }
    }

    private static void addEntity() {
        System.out.println("");
        System.out.println("Choose entity type to addValueObject/updateValueObject:\n1)Card\n2)Customer\n" +
                "3)Customer Personal\n4)Privilege\n5)Product\n6)Transaction");
        CardVO cardVO;
        CustomerVO customerVO;
        CustomerPersonalVO customerPersonalVO;
        PrivilegeVO privilegeVO;
        ProductVO productVO;
        TransactionVO transactionVO;
        int choice = readChoice().intValue();
        switch (choice) {
            case 1:
                cardVO = (CardVO) readValueObject(Types.card);
                if (cardVO != null) {
                    if (appContext.getCustomerRepository().contain(cardVO.customerId)) {
                        writeVO(getRepository(choice), cardVO, cardId);
                        printDomainObject(choice, cardId);
                    } else {
                        logger.info("There is no customer with id = " + cardVO.customerId);
                    }
                }
                break;
            case 2:
                customerVO = (CustomerVO) readValueObject(Types.customer);
                if (customerVO != null) {
                    if (appContext.getCustomerPersonalRepository().contain(customerVO.personalInfo)) {
                        writeVO(getRepository(choice), customerVO, customerId);
                        printDomainObject(choice, customerId);
                    } else {
                        logger.info("There is no personal information with id = " + customerVO.personalInfo);
                    }
                }
                break;
            case 3:
                customerPersonalVO = (CustomerPersonalVO) readValueObject(Types.customerPersonal);
                if (customerPersonalVO != null) {
                    writeVO(getRepository(choice), customerPersonalVO, customerPersonalId);
                    printDomainObject(choice, customerPersonalId);
                }
                break;
            case 4:
                privilegeVO = (PrivilegeVO) readValueObject(Types.privilege);
                    if (appContext.getCardRepository().contain(privilegeVO.cardId)) {
                        writeVO(getRepository(choice), privilegeVO, privilegeId);
                        printDomainObject(choice, privilegeId);
                    } else {
                        logger.info("There is no card with id = " + privilegeVO.cardId);
                    }
                break;
            case 5:
                productVO = (ProductVO) readValueObject(Types.product);
                if (productVO != null) {
                    writeVO(getRepository(choice), productVO, productId);
                    printDomainObject(choice, productId);
                }
                break;
            case 6:
                transactionVO = (TransactionVO) readValueObject(Types.transaction);
                if (transactionVO!= null) {
                    if (appContext.getCardRepository().contain(transactionVO.cardId) &&
                            appContext.getProductRepository().contain(transactionVO.productId)) {
                        writeVO(getRepository(choice), transactionVO, transactionId);
                        printDomainObject(choice, transactionId);
                    } else {
                        logger.info("There is no card with id = " + transactionVO.cardId +
                                " or no product with id = " + transactionVO.productId);
                    }
                }
                break;
            default:
                logger.error("Wrong input");
        }
    }

    private static void writeVO(Repository repository, ValueObject valueObject, Increment id) {
        if (valueObject != null) {
            if (valueObject.getId() == null) {
                valueObject.setId(id.getValue());
                repository.addValueObject(valueObject);
            } else {
                repository.updateValueObject(valueObject);
            }
        }
    }

    private static void printListOfEntities() {
        System.out.println("Choose type of entity to print list:\n1)Card\n2)Customer\n" +
                "3)Customer Personal\n4)Privilege\n5)Product\n6)Transaction");
        int choice = readChoice().intValue();
        Repository repository = getRepository(choice);
        Loader loader = getLoader(choice);
        System.out.println("Print entities on the screen or save to json file?\n" +
                "1)Print on the screen\n2)Save to file");
        if (repository != null && loader != null) {
            switch (readChoice().intValue()) {
                case 1:
                    printDO(loader.getAllEntities());
                    break;
                case 2:
                    writeDO(loader.getAllEntities());
                    break;
                default:
                    logger.error("Wrong input");
            }

        }
    }

    private static void printObject(ValueObject v){
        System.out.println(gson.toJson(v));
    }

    private static void printDomainObject(int choice, Increment increment) {
        Loader loader = getLoader(choice);
        Long id = increment.getValue();
        DomainObject domainObject = loader.getEntityById(id);
        System.out.println(gson.toJson(domainObject));
    }

    private static void printVO(Map<Long, ValueObject> map) {
        if (map != null) {
            for (ValueObject v : map.values()) {
                System.out.println(gson.toJson(v));
            }
        }
    }

    private static void printDO(List<DomainObject> list) {
        if (list != null) {
            for (DomainObject d : list) {
                System.out.println(gson.toJson(d));
            }
        }
    }

    private static void deleteEntity() {
        System.out.println("");
        System.out.println("Choose type of entity to deleteValueObject:\n1)Card\n2)Customer\n" +
                "3)Customer Personal\n4)Privilege\n5)Product\n6)Transaction");
        Repository repository = getRepository(readChoice().intValue());
        if (repository != null) {
            printVO(repository.getAllValueObjects());
            System.out.println("Enter id of record to deleteValueObject");
            Long id = readChoice();
            if (id > -1) {
                repository.deleteValueObject(id);
            }
        }
    }

    private static Repository getRepository(int choice) {
        Repository repository = null;
        switch (choice) {
            case 1:
                repository = appContext.getCardRepository();
                break;
            case 2:
                repository = appContext.getCustomerRepository();
                break;
            case 3:
                repository = appContext.getCustomerPersonalRepository();
                break;
            case 4:
                repository = appContext.getPrivilegeRepository();
                break;
            case 5:
                repository = appContext.getProductRepository();
                break;
            case 6:
                repository = appContext.getTransactionRepository();
                break;
            default:
                logger.error("Wrong input");
                break;
        }
        return repository;
    }

    private static Loader getLoader(int choice) {
        Loader loader = null;
        switch (choice) {
            case 1:
                loader = appContext.getCardLoader();
                break;
            case 2:
                loader = appContext.getCustomerLoader();
                break;
            case 3:
                loader = appContext.getCustomerPersonalLoader();
                break;
            case 4:
                loader = appContext.getPrivilegeLoader();
                break;
            case 5:
                loader = appContext.getProductLoader();
                break;
            case 6:
                loader = appContext.getTransactionLoader();
                break;
            default:
                logger.error("Wrong input");
                break;
        }
        return loader;
    }

    private static Long readChoice() {
        String input;
        Long choice = -1L;
        try {
            input = scanner.next();
            choice = Long.parseLong(input);
        } catch (NumberFormatException e) {
            logger.error("Error while trying to read choice from the console", e);
        }
        return choice;

    }

    private static ValueObject readValueObject(Types type) {
        JsonReader reader;
        System.out.println("Enter path to file:");
        String path = scanner.next();
        try {
            reader = new JsonReader(new FileReader(path));
            try {
                switch (type) {
                    case card:
                        return gson.fromJson(reader, CardVO.class);
                    case customer:
                        return gson.fromJson(reader, CustomerVO.class);
                    case customerPersonal:
                        return gson.fromJson(reader, CustomerPersonalVO.class);
                    case privilege:
                        return gson.fromJson(reader, PrivilegeVO.class);
                    case product:
                        return gson.fromJson(reader, ProductVO.class);
                    case transaction:
                        return gson.fromJson(reader, TransactionVO.class);
                }
            } catch (JsonIOException | JsonSyntaxException e) {
                logger.error("File not properly formatted", e);
            }
        } catch (FileNotFoundException e) {
            logger.error("File wasn't found", e);
        }

        return null;
    }

    private static void writeDO(List<DomainObject> domainObjects) {
        FileWriter writer;
        System.out.println("Enter path to file in json format where entities will be stored:");
        String path = scanner.next();
        if (path.contains(".json")) {
            try {
                writer = new FileWriter(path);
                String jsonArray = gson.toJson(domainObjects);
                writer.write(jsonArray);
                writer.close();
                logger.info("Entities successfully saved");
            } catch (IOException e) {
                logger.error("Wrong path", e);
            }
        } else {
            logger.error("File should be in json format");
        }
    }
}
