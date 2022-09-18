import java.util.logging.Logger;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.TreeMap;

/*
 * Дана строка. Необходимо написать метод, который отсортирует слова в строке по 
 * длине с помощью TreeMap. Строки с одинаковой длиной не должны “потеряться”.
 * Пример:
 * “Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись”
 * Результат:
 * [и], [ты], [Еще], [день, друг, Пора], [Мороз], [солнце], 
 * [чудесный, дремлешь, проснись], [красавица], [прелестный]
 */

public class Task1HM {
    public static void main(String[] args) {
        String workString = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись";
        Logger logger = Logger.getAnonymousLogger();
        logger.info(wordSizeSorting(workString).values().toString());
    }
    
    public static TreeMap<Integer, ArrayList<String>> wordSizeSorting(String str) {
        TreeMap<Integer, ArrayList<String>> resMap = new TreeMap<>();
        
        for (String item : Arrays.asList(str.split(" "))) {
            if (resMap.containsKey(item.length())) {
                ArrayList<String> temp = resMap.get(item.length());
                temp.add(item);
                resMap.put(item.length(), temp);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(item);
                resMap.put(item.length(), temp);
            }
        }
        return resMap;
    }
}
