package dg.testdata;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class JavaCryptoExamples1 {

    public void testCipher4() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher c = Cipher.getInstance("AES");
        c.init(1, new SecretKeySpec(null, "AES"));
        c.doFinal(null);
        c.doFinal(null);
        // Assertions.assertState(c, -1);

        c.doFinal(null);
        // The object is will have an empty state because it was in an error state earlier.
    }

}
