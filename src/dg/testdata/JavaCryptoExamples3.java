package dg.testdata;

import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class JavaCryptoExamples3 {

    public void PBEKeySpecTest3() throws NoSuchAlgorithmException {
        final byte[] salt = new byte[32];
        SecureRandom.getInstanceStrong().nextBytes(salt);
        // Assertions.hasEnsuredPredicate(salt);
        final PBEKeySpec pbe = new PBEKeySpec(new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'}, salt, 65000, 128);
        // Assertions.assertState(pbe, 0);
        pbe.clearPassword();
        // Assertions.assertState(pbe, 1);
    }
}
