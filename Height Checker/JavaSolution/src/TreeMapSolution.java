import java.util.TreeMap;

public class TreeMapSolution {
	public int heightChecker(int[] heights) {
        int discrepancies = 0;
		int min;
		int putBack;

		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (int x : heights) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
        
		for (int height : heights) {
			min = map.firstKey();
			if (min != height)
				discrepancies++;
			putBack = map.get(min) - 1;
			if (putBack == 0)
				map.remove(min);
			else
				map.put(min, map.get(min) - 1);
		}

		return discrepancies;
    }
}
