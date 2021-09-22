package encryptdecrypt;

public class EncoderDecoder {
    private EncryptDecrypt method;

    public void setMethod(EncryptDecrypt method) {
        this.method = method;
    }

    public String processText(String inputText, int key, String process, String algorithm) {
        if ("shift".equals(algorithm)) {
            setMethod(new EncryptDecryptShift());
        } else if ("unicode".equals(algorithm)) {
            setMethod(new EncryptDecryptUnicode());
        }

        switch (process) {
            case "enc":
                return method.encryptText(inputText, key);
            case "dec":
                return method.decryptText(inputText, key);
            default:
                return null;
        }
    }
}
