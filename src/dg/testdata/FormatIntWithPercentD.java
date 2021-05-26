package com.mycompany.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FormatIntWithPercentD {
    public void runProcess(final ProcessBuilder pb, final String successOutput) {
        int exitValue;
        Process p = null;
        final StringBuilder stdoutSB = new StringBuilder();
        final StringBuilder stderrSB = new StringBuilder();
        boolean isConfigured = false;
        try {
            p = pb.start();
            try (BufferedReader stdoutBR = new BufferedReader(new InputStreamReader(p.getInputStream(),
                    StandardCharsets.UTF_8));
                 BufferedReader stderrBR = new BufferedReader(new InputStreamReader(p.getErrorStream(),
                         StandardCharsets.UTF_8))) {
                String line;
                while ((line = stdoutBR.readLine()) != null) {
                    stdoutSB.append(line);
                    stdoutSB.append("\n");                   
                    isConfigured = true;                
                }

                while ((line = stderrBR.readLine()) != null) {
                    stderrSB.append(line);
                    stderrSB.append("\n");
                }

                exitValue = p.waitFor();
            }
        } catch (final Exception e) {
            throw new RuntimeException("Got exception running process to configure VMW appliance.", e);
        } finally {
            try {
                if (p != null) {
                    p.destroy();
                    if (p.getInputStream() != null) {
                        p.getInputStream().close();
                    }
                    if (p.getOutputStream() != null) {
                        p.getOutputStream().close();
                    }
                    if (p.getErrorStream() != null) {
                        p.getErrorStream().close();
                    }
                }
            } catch (final IOException e) {
            }
        }

        if (exitValue != 0 || !isConfigured) {
            final String msg = String.format(
                    "Process did not complete successfully. Exit value [%s]. stdout [%s]. stderr[%s].",
                    exitValue, stdoutSB.toString(), stderrSB.toString());
            throw new RuntimeException(msg);
        } else {
        }
    }
}
