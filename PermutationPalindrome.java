import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationPalindrome {

	public static Map<Character, Integer> freg(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : str.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}
		return map;
	}

	public static void printPerms(Map<Character, Integer> map, String prefix, int remaining, List<String> list) {
		if (remaining == 0) {
			list.add(prefix);
			return;
		}
		for (Character c : map.keySet()) {
			int count = map.get(c);
			if (count > 0) {
				map.put(c, map.get(c) - 1);
				printPerms(map, prefix + c, remaining - 1, list);
				map.put(c, count);
			}
		}
	}

	public static List<String> permutation(String str) {
		List<String> list = new ArrayList<>();
		Map<Character, Integer> map = freg(str);
		printPerms(map, "", str.length(), list);
		return list;
	}

	public static boolean isPalindrome(String str) {
		StringBuilder sb1 = new StringBuilder(str);
		StringBuilder sb2 = new StringBuilder(sb1).reverse();
		return sb1.toString().equals(sb2.toString());
	}

	public static void main(String[] args) {
		String word = "madam";
		List<String> list = permutation(word);
		for (String str : list) {
			if (isPalindrome(str)) {
				System.out.println(str);
			}
		}
		System.out.println(list.size());
	}
}
