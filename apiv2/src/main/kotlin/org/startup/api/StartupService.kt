package org.startup.api

import org.slf4j.LoggerFactory
import org.startup.api.model.Card
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.LockModeType

interface CardCollection : CrudRepository<Card, String> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select c from CardCopy c where c.id = :id")
    fun lockedFind(@Param("id") cardId: String) : Card?
}

@Service
@Transactional
open class StartupService(
    private var drawPile : MutableList<Card> = mutableListOf(),
    private var discardPile : MutableList<Card> = mutableListOf()
) {

    companion object {
        private val log = LoggerFactory.getLogger(StartupService::class.java)
    }



    fun retrieveDrawPile() : MutableList<Card> {
        return drawPile
    }

    fun addACard(card : Card) {
        discardPile.add(card)
    }

    fun shuffleIn(){
        discardPile.shuffle()
        drawPile.addAll(discardPile)
        discardPile.removeAll(discardPile)
    }

    fun drawCard() : Card? {
        if (drawPile.isEmpty()) {
            if(discardPile.isEmpty()) return null
            else shuffleIn()
        }

        return drawPile.removeFirst()
    }

    protected open fun fetchData(){
        // TODO
    }


}