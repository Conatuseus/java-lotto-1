package lotto.domain;

import java.util.*;

public class User {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int MUL_NUM_FOR_PERCENT = 100;
    private final Money money;
    private final int countOfLotto;
    private final int countOfManualLotto;
    private List<Lotto> userLottos = new ArrayList<>();

    public User(Money money, int countOfManualLotto) {
        this.money = money;
        this.countOfLotto = money.calculateCountOfLotto();
        this.countOfManualLotto = countOfManualLotto;
        if (countOfManualLotto > countOfLotto) {
            throw new InvalidCountOfManualLottoException("구입금액보다 수동으로 구매할 로또비용이 더 큽니다.");
        }
        generateAutoLottos();
    }

    private void generateAutoLottos() {
        int countOfAutoLotto = countOfLotto - countOfManualLotto;
        for (int i = 0; i < countOfAutoLotto; i++) {
            userLottos.add(new UserLotto(LottoAutoGenerator.generateAutoLotto()));
        }
    }

    public void addManualLottos(List<Lotto> manualLottos) {
        userLottos.addAll(manualLottos);
    }

    public List<Lotto> getUserLottos() {
        return this.userLottos;
    }

    public Map<Rank, Integer> calculateCountOfRank(WinningLotto winningLotto) {
        Map<Rank, Integer> countOfRank = new TreeMap<>(Collections.reverseOrder());
        Arrays.stream(Rank.values()).forEach(rank -> countOfRank.put(rank, ZERO));
        for (Lotto userLotto : userLottos) {
            int countOfMatch = userLotto.calculateCountOfMatch(winningLotto);
            boolean matchBonus = winningLotto.isBonusContain(userLotto);
            Rank thisRank = Rank.valueOf(countOfMatch, matchBonus);
            int countOfThisRank = countOfRank.get(thisRank);

            countOfRank.put(thisRank, countOfThisRank + ONE);
        }
        return countOfRank;
    }

    public double calculateRateOfReturn(Prize calculatePrize) {
        return calculatePrize.divideByMoney(money) * MUL_NUM_FOR_PERCENT;
    }
}
