package dg.testdata;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

public class JavaCryptoExamples2 {

    public char[] unknownCharArray;

    public void incorrectUsage1() throws KeyStoreException, NoSuchProviderException, NoSuchAlgorithmException,
                                         CertificateException, IOException, UnrecoverableEntryException {
        KeyStore keystore = KeyStore.getInstance("PKCS12", "BC");
        keystore.load(null, unknownCharArray);
        keystore.getEntry(null, null);
    }
}
