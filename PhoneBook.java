import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();

        phoneBook.put("Alice", new HashSet<>(Arrays.asList("123456", "987654")));
        phoneBook.put("Bob", new HashSet<>(Arrays.asList("234567", "876543")));
        phoneBook.put("Alice", new HashSet<>(Arrays.asList("345678")));

        Map<String, Integer> contactFrequency = new HashMap<>();

        for (Set<String> numbers : phoneBook.values()) {
            for (String number : numbers) {
                contactFrequency.put(number, contactFrequency.getOrDefault(number, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> sortedContacts = new ArrayList<>(contactFrequency.entrySet());
        sortedContacts.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<String, Integer> entry : sortedContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}