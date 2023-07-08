package kr.or.sw.jython;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

@Slf4j
public class JythonTest {

    @Test
    public void testJython() {
        log.info("testJython()");

        try (PythonInterpreter py = new PythonInterpreter()) {
            py.exec("from functools import reduce");
            py.exec("print('Hello, Python World!')");
            py.exec("sum = reduce(lambda x, y: x + y, [1, 2, 3, 4])");
            PyObject sum = py.get("sum");
            boolean result = (int) sum.__tojava__(Integer.class) == 10;
            Assert.assertTrue("FAIL", result);
        }
    }
}
