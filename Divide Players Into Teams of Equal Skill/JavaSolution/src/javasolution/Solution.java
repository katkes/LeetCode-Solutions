package javasolution;

import java.util.Arrays;

public class Solution {
	public long dividePlayers(int[] skill) {
		Arrays.sort(skill);
		int n = skill.length;
		long chem = 0;
		int teamSkill = skill[0] + skill[n - 1];
		chem += skill[0] * skill[n - 1];
		for (int i = 1; i < n / 2; i++) {
			if (skill[i] + skill[n - 1 - i] != teamSkill)
				return -1;
			chem += skill[i] * skill[n - 1 - i];
		}
		return chem;
	}
}