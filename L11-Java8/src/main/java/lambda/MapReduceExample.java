package lambda;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"java:S4276", "java:S1612"})
public class MapReduceExample {
    private static final Logger logger = LoggerFactory.getLogger(MapReduceExample.class);

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 16, 25);
        logger.info("map_1:{}", map(list, new SquareRoot()));

        logger.info("map_2:{}", map(list, val -> Math.sqrt(val)));

        logger.info("map_3:{}", map(list, (Function<Integer, Double>) Math::sqrt));

        logger.info("reduce:{}", reduce(list, Integer::sum, 0));

        logger.info("filter:{}", filter(list, a -> a % 2 == 0));

        Function<Integer, Double> func1 = MapReduceExample::mySqrt;
        logger.info("func1:{}", map(list, func1));
    }

    // Integer -> Double
    static class SquareRoot implements Function<Integer, Double> {
        @Override
        public Double apply(Integer val) {
            return Math.sqrt(val);
        }
    }

    static Double mySqrt(Integer val) {
        return Math.sqrt(val);
    }

    // Трансформация каждого элемента
    static <T, R> Collection<R> map(List<T> src, Function<T, R> op) {
        List<R> r = new ArrayList<>();
        for (T t : src) {
            r.add(op.apply(t));
        }
        return r;
    }

    static <T, R> R reduce(List<T> src, BiFunction<T, R, R> op, R zero) {
        R result = zero;
        for (T t : src) {
            result = op.apply(t, result);
        }
        return result;
    }

    static <R> Collection<R> filter(List<R> src, Predicate<R> pred) {
        List<R> r = new ArrayList<>();
        for (R t : src) {
            if (pred.test(t)) r.add(t);
        }
        return r;
    }
}
