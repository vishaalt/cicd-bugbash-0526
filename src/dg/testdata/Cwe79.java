package dg.testdata;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Cwe79 {

    private static final long serialVersionUID = 1L;

//    @ExpectedFinding(expectedFindings = 1, automatonName = "cwe79ServletResponse")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String param = request.getHeaders("Referer").nextElement();
        Object[] obj = {};
        response.getWriter().format(java.util.Locale.US, param, obj);
    }
}
