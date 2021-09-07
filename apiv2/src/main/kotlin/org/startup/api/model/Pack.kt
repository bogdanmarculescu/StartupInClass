package org.startup.api.model

class Pack (
    var contents : MutableList<Card> = mutableListOf()
){
    fun addCard(card : Card){
        contents.add(card)
    }

    fun drawCard() : Card{
        val result = contents.removeFirst()
        return result
    }

    fun shuffle() {
        contents.shuffle()
    }
}