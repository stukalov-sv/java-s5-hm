import java.util.Map;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
 * что 1 человек может иметь несколько телефонов.
 */

public class Task2HM {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        Map<Long, String> workMap = phoneDictionary(Arrays.asList(89991234567L, 89981234567L, 89971234567L));
        logger.info(workMap.toString());        
    }

    public static Map<Long, String> phoneDictionary(List<Long> listPhones) {
        Scanner iScanner = new Scanner(System.in);
        Map<Long, String> workMap = new HashMap<>();
        
        for (long item : listPhones) {
            System.out.printf("Whose phone %d?\n", item);
            String contactName = iScanner.nextLine();
            workMap.put(item, contactName);
        }
        
        iScanner.close();
        return workMap;
    }    
    
}
