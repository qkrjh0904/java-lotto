/*
 * Class : WinningLotto	(당첨 번호를 담당하는 클래스)
 * 
 * Version : 1.0.0
 * 
 * 2019-4-10
 * 
 * Jeongho Park
 */
package domain;

import java.util.List;

public class WinningLotto {
	private final Lotto lotto;
	private final int bonusNo;

	public WinningLotto(Lotto lotto, int bonusNo) {
		this.lotto = lotto;
		this.bonusNo = bonusNo;
	}

	public List<Integer> getWinningNums() {
		return this.lotto.getNumbers();
	}

	public int getBonusNum() {
		return this.bonusNo;
	}

	private int isContain(int num, int numOfMatch) {
		if (this.lotto.getNumbers().contains(num))
			numOfMatch++;
		return numOfMatch;
	}

	public Rank match(Lotto userLotto) {
		int numOfMatch = 0;
		for (int num : userLotto.getNumbers()) {
			numOfMatch = isContain(num, numOfMatch);
		}
		return Rank.valueOf(numOfMatch, userLotto.getNumbers().contains(this.bonusNo));
	}
}
