import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Approach: The idea is that if you're able to simulate the movement of the
 * robots, you'll be able to see who are remaining. This is done in unison with
 * keeping a track of the surviving robots, using survivingRobotSet, and
 * tracking the index of each robot, using indexRobotMap. Once the order of
 * robots is sorted by position, it is simulated using a stack seeing that if
 * the robot you're looking at is going right then it cannot conflict with any
 * previous robots or that if the robot you're looking at is going left and the
 * previous robot is going left, there's no conflict. If both aren't true and it
 * isn't your first robot then you have to simulate the conflict(s).
 * 
 * Time complexity: O(nlogn) --> Seeing that the code is mostly iterating over
 * the input size in separate parts (i.e: doesn't compound on itself), the base
 * time complexity is O(n). However, the sorting of the robots based on position
 * takes O(nlogn) time, which makes the overall code be O(logn) time complexity.
 * 
 * Space complexity: O(n) --> Extra storage is needed based on a linear
 * correlation with the input size as you store each robot in separate occasions
 * and are given n robots. That said, the space complexity is the sum of
 * multiple n's, resulting in a O(n) space complexity.
 * 
 *
 */
public class Solution {
	class Robot {
		int health;
		char direction;
		int position;

		public Robot(int health, int position, char direction) {
			this.health = health;
			this.position = position;
			this.direction = direction;
		}
	}

	public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
		HashMap<Integer, Robot> indexRobotMap = new HashMap<>();
		HashSet<Robot> survivingRobotSet = new HashSet<>();
		int len = positions.length;
		Robot[] robots = new Robot[len];

		Robot create;
		for (int i = 0; i < len; i++) {
			create = new Robot(healths[i], positions[i], directions.charAt(i));
			indexRobotMap.put(i, create);
			survivingRobotSet.add(create);
			robots[i] = create;
		}

		// Sort robots based on order
		Integer[] order = new Integer[len];
		for (int i = 0; i < len; i++) {
			order[i] = i;
		}
		Arrays.sort(order, (a, b) -> positions[a] - positions[b]);

		Stack<Robot> stack = new Stack<Robot>();
		Robot goingRight;
		for (int i = 0; i < len; i++) {

			Robot robot = robots[order[i]];

			// Don't need to consider the current robot if the stack is empty or if the
			// robot is going or if the robot in the stack is going left.
			if (stack.isEmpty() || robot.direction == 'R' || stack.peek().direction == 'L') {
				stack.push(robot);
			}

			else {
				// At this point, the current robot is going left and the previous robot is
				// going right, we must resolve the conflict.
				while (!stack.isEmpty() && stack.peek().direction == 'R') {
					goingRight = stack.pop();

					// Previous robot survives
					if (goingRight.health > robot.health) {
						goingRight.health -= 1;
						stack.push(goingRight);
						survivingRobotSet.remove(robot);
						robot = null;
						break;
					}
					// Current robot survives
					else if (goingRight.health < robot.health) {
						robot.health -= 1;
						survivingRobotSet.remove(goingRight);
					}
					// Both robots are destroyed
					else {
						survivingRobotSet.remove(robot);
						survivingRobotSet.remove(goingRight);
						robot = null;
						break;
					}

				}
				if (robot != null) {
					stack.push(robot);
				}

			}
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			if (survivingRobotSet.contains(indexRobotMap.get(i))) {
				list.add(indexRobotMap.get(i).health);
			}
		}

		return list;

	}

}
