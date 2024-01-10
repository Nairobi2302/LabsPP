package lab4;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtil {

    public static String encryptData(String data) {
        try {
            // Создаем экземпляр MessageDigest, используя алгоритм SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Получаем байтовое представление входных данных
            byte[] encodedhash = digest.digest(data.getBytes());

            // Преобразуем байтовое представление входных данных в шестнадцатеричное представление
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedhash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
                      return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Пример использования:
        String data = "Kamaz\nGas_tanker\n22884\nMaz\nWood_truck\n19500";

        // Шифруем входные данные с помощью метода encryptData
        String encryptedData = encryptData(data);

        // Выводим зашифрованные данные
        System.out.println("Shifr info: " + encryptedData);
    }
}
