package first_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anargram {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if (strs == null) return res;
		
		Map<String, ArrayList<String>> map = new HashMap<>();
		for (String string :strs){
			char[] strChar = string.toCharArray();
			Arrays.sort(strChar);
			String strSorted = String.valueOf(strChar);
			if (map.containsKey(strSorted)){
				ArrayList<String> aList = map.get(strSorted);
				aList.add(string);
				map.put(strSorted, aList);
			}
			else{
				ArrayList<String> aList = new ArrayList<>();
				aList.add(string);
				map.put(strSorted, aList);				
			}
		}
		for (String key : map.keySet()){
			res.add(map.get(key));
		}
		return res;
	}
}