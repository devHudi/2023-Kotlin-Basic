package domain.lotto

import domain.money.Money

class Lottos(
    inputMoney: Money,
    manualLottos: List<Lotto>
) {
    val lottos: List<Lotto>
    val lottoCount: Int
        get() = lottos.size

    init {
        val lottoCount = inputMoney.value / Lotto.LOTTO_PRICE
        val autoCount = lottoCount - manualLottos.size
        val autoLottos = (1..autoCount).toList()
            .map { Lotto.auto() }

        lottos = manualLottos + autoLottos
    }
}