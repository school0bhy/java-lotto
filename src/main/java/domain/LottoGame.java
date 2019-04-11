package domain;

import domain.util.UserInput;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int PRICE_OF_LOTTO = 1000;

    private List<Lotto> lottos;
    private WinningLotto winningLotto;
    private LottoManager lottoManager = new LottoManager();

    public void start() {
        setLottoList(getNumOfLottos());
    }

    private int getNumOfLottos() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = getPurchaseAmount();
        int change = purchaseAmount % PRICE_OF_LOTTO;
        if (change != 0) {
            System.out.println(String.format("거스름돈은 %d원 입니다.", change));
        }
        return (purchaseAmount / PRICE_OF_LOTTO);
    }

    private int getPurchaseAmount() {
        int purchaseAmount = UserInput.getInteger();
        if (purchaseAmount < PRICE_OF_LOTTO) {
            System.out.println(String.format("로또 한장의 금액(%d원) 이상을 입력하세요", PRICE_OF_LOTTO));
            return getPurchaseAmount();
        }
        return purchaseAmount;
    }

    private void setLottoList(int numOfLottos) {
        lottos = new ArrayList<>();
        LottoManager lottoManager = new LottoManager();
        for (int i = 0; i < numOfLottos; i++) {
            lottos.add(lottoManager.generateLotto());
        }
        System.out.println(String.format("\n%d개를 구매했습니다.", numOfLottos));
        printLottos();
    }

    private void printLottos() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
