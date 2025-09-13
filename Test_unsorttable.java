public class Test_unsorttable {
    public static void main(String[] args) {
        UnsortedTableMap<String, Integer> map = new UnsortedTableMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println("Size: " + map.size()); // Size: 3
        System.out.println("Get 'Two': " + map.get("Two")); // Get 'Two': 2
        map.remove("Two");
        System.out.println("Size after removing 'Two': " + map.size()); // Size after removing 'Two': 2
        System.out.println("Get 'Two' after removal: " + map.get("Two"));
    }
    
}
