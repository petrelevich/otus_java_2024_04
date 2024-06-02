package var;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"java:S125"})
public class VarIntro {
    // var field; ошибка компиляции
    private static final Logger log = LoggerFactory.getLogger(VarIntro.class);

    public static void main(String[] args) throws IOException {
        new VarIntro().test(5);
    }

    // private var test(var val) throws IOException { Ошибка компиляции
    public void test(int val) throws IOException {
        log.info("val:{}", val);
        var example = "ValueStr"; // String
        example = "newString";
        // example = 5; нельзя изменить тип
        // var error = null; ошибка, тип неопределен
        log.info("example:{}", example);

        try (InputStream is = new FileInputStream("lines.txt")) {
            log.info("{}", is);
        }

        // FileInputStream
        try (var is = new FileInputStream("lines.txt")) {
            log.info("{}", is);
        }

        // List<String> list = Arrays.asList("1", "2", "3");
        var list = Arrays.asList("1", "2", "3");
        for (var str : list) {
            log.info("{}", str);
        }

        // var nameList = new ArrayList<>(); не понятен тип
        var stringList = new ArrayList<String>(); // а тут уже все ясно

        // Посмотрите на var в debug
        var testString = "StringVal";

        log.info("{}, {}", stringList, testString);
    }
}
