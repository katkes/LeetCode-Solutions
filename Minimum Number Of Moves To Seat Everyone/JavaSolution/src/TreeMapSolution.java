import java.util.TreeMap;

public class TreeMapSolution {
    public int minMovesToSeat(int[] seats, int[] students) {
		int minMoves = 0;
		int seatMin, studentMin;

		TreeMap<Integer, Integer> seatMap = new TreeMap<>();
		TreeMap<Integer, Integer> studentMap = new TreeMap<>();

		for (int seat : seats) {
			seatMap.put(seat, seatMap.getOrDefault(seat, 0) + 1);
		}

        System.out.println(seatMap);

		for (int student : students) {
			studentMap.put(student, studentMap.getOrDefault(student, 0) + 1);
		}

		while (seatMap.size() != 0) {
			seatMin = seatMap.firstKey();
			studentMin = studentMap.firstKey();

			minMoves += Math.abs(studentMin - seatMin);
			if (seatMap.get(seatMin) == 1) {
				seatMap.remove(seatMin);
			}
			else {
				seatMap.put(seatMin, seatMap.get(seatMin) - 1);
			}
			
			if (studentMap.get(studentMin) == 1) {
				studentMap.remove(studentMin);
			}
			else {
				studentMap.put(studentMin, studentMap.get(studentMin) - 1);
			}
		}

		return minMoves;
	}
}