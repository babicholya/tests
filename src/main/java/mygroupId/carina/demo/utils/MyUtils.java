package mygroupId.carina.demo.utils;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static List<ExtendedWebElement> joinLists(List<ExtendedWebElement> a, List<ExtendedWebElement> b) {
        if ((a == null) || (a.isEmpty() && (b != null))) return b;
        if ((b == null) || b.isEmpty()) return a;
        ArrayList<ExtendedWebElement> result = new ArrayList(a.size() + b.size());
        result.addAll(a);
        result.addAll(b);
        return result;
    }

    public static int getRandomNumberInts(int min, int max) {
        Random random = new Random();
        int x = random.ints(min, (max + 1)).findFirst().getAsInt();
        LOGGER.debug("Number is {}", x);
        return x;
    }
}
