package decorator.customizable_printer;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class EncryptedPrinter extends PrinterDecorator {

    private SecretKey key;
    private Cipher cipher;

    public EncryptedPrinter(Printer printer) {
        super(printer);
        this.generateKey();
    }

    private void generateKey() {
        try {
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            this.key = keygenerator.generateKey();
            this.cipher = Cipher.getInstance("DES");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String encryptString(String string) {
        try {
            byte[] bytes = string.getBytes();

            this.cipher.init(Cipher.ENCRYPT_MODE, this.key);
            byte[] bytesEncrypted = this.cipher.doFinal(bytes);

            return Base64.getEncoder().encodeToString(bytesEncrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return string;
    }

    private String decryptString(String string) {
        try {
            byte[] bytes = Base64.getDecoder().decode(string);

            this.cipher.init(Cipher.DECRYPT_MODE, this.key);
            byte[] bytesDecrypted = this.cipher.doFinal(bytes);

            return new String(bytesDecrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return string;
    }

    @Override
    public void print(String message) {
        String encryptedMessage = encryptString(message);
        super.print(encryptedMessage);

        String decryptedMessage = decryptString(encryptedMessage);
        super.print(decryptedMessage);
    }
}
