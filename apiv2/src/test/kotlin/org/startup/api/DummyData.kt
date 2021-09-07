package org.startup.api

import org.startup.api.model.Card
import org.startup.api.model.Suite

object DummyData {
        fun getCardDealer() : StartupService {
            val deal = StartupService()

            deal.run {
                addACard(Card(1, 1, Suite.CLUBS))
                addACard(Card(2, 1, Suite.CLUBS))
                addACard(Card(3, 1, Suite.CLUBS))

                addACard(Card(5, 1, Suite.SPADES))
                addACard(Card(6, 1, Suite.SPADES))
                addACard(Card(7, 1, Suite.SPADES))

                shuffleIn()
            }

            return deal
        }

}