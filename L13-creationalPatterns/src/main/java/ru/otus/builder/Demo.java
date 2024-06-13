package ru.otus.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sergey created on 17.09.18.
 */
public class Demo {
    private static final Logger logger = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        // Так плохо - не понятно, что за параметры
        BigObject bigObject1 = new BigObject(null, "2", null, "4", "5");
        logger.info("{}", bigObject1);

        // Так лучше
        BigObject bigObject2 = new BigObject.Builder("1")
                .withParam2("value of param2") // задаем нужные параметры
                .withParam5("value of param5") // в любом порядке
                // .withParam4() // для необязательных просто не вызываем метод
                .withParam3("value of param3")
                .build(); // получаем нужный нам объект

        logger.info("{}", bigObject2);

        BigObject2 betterObject = BigObject2.builder().param1("x").param4("y").build();

        var changedCopy = betterObject.toBuilder().param5("z").build();

        logger.info("lombok: {}", betterObject);
        logger.info("copy: {}", changedCopy);
    }
}
