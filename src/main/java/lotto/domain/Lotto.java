package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        if (isDuplicated(lottoNumbers)) {
            throw new InvalidLottoException("중복된 수가 있습니다.");
        }
        if (!isValidSize(lottoNumbers)) {
            throw new InvalidLottoException("로또 수는 6개 이어야 합니다.");
        }
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(this.lottoNumbers);
    }

    private boolean isDuplicated(List<LottoNumber> scannedNumbers) {
        return scannedNumbers.size() != new HashSet<>(scannedNumbers).size();
    }

    private boolean isValidSize(List<LottoNumber> scannedNumbers) {
        return scannedNumbers.size() == LOTTO_SIZE;
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public LottoNumber getLottoNumberByIndex(int index) {
        return this.lottoNumbers.get(index);
    }
}
