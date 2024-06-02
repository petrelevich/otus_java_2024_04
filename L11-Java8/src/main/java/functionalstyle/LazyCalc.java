package functionalstyle;

import static java.lang.Thread.sleep;

import java.util.function.IntUnaryOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LazyCalc {
    private static final Logger logger = LoggerFactory.getLogger(LazyCalc.class);

    public static void main(String[] args) {
        var calc = new LazyCalc();

        var startTime1 = System.currentTimeMillis();
        calc.calculation(calc.veryHeavyFunc(61));
        logger.info("== eager 1, time : {}", (System.currentTimeMillis() - startTime1));

        var startTime2 = System.currentTimeMillis();
        calc.calculation(calc.veryHeavyFunc(62));
        logger.info("== eager 2, time : {}", (System.currentTimeMillis() - startTime2));

        var startTime3 = System.currentTimeMillis();
        calc.calculationLazy(true, 63, calc::veryHeavyFunc);
        logger.info("== lazy 1, time : {}", (System.currentTimeMillis() - startTime3));

        var startTime4 = System.currentTimeMillis();
        calc.calculationLazy(false, 64, calc::veryHeavyFunc);
        logger.info("== lazy 2, true time : {}", (System.currentTimeMillis() - startTime4));
    }

    private void calculation(int veryHeavyFunc) {
        logger.info("{}:", veryHeavyFunc);
    }

    private void calculationLazy(boolean calc, int value, IntUnaryOperator veryHeavyFunc) {
        if (calc) {
            logger.info("{}:", veryHeavyFunc.applyAsInt(value));
        }
    }

    private Integer veryHeavyFunc(int input) {
        try {
            sleep(1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return input * 2;
    }
}
