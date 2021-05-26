package dg.testdata;

/**
 See automaton explanation. Tests are modified OWASP Benchmarks.
 **/

// See https://sim.amazon.com/issues/DG-817 for rule current status.

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CmdInjection {

    public void bad1(HttpServletRequest request) {
        String foo = request.getHeader("foo");
        ProcessBuilder pb = new ProcessBuilder();
        ProcessBuilder pb0 = pb.command(foo);
        try {
            pb0.start();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
