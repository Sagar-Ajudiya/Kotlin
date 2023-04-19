package com.example.kotlin.mykotlin

import kotlin.properties.Delegates

interface LoyaltyProgram {
    fun earnPoints(points: Int)
    fun redeemPoints(points: Int)
}

class CoffeeShopLoyaltyProgram : LoyaltyProgram {
    override fun earnPoints(points: Int) {
        // add points to customer's loyalty program balance
    }

    override fun redeemPoints(points: Int) {
        // deduct points from customer's loyalty program balance
    }
}

class Customer(name: String, private val loyaltyProgram: LoyaltyProgram = CoffeeShopLoyaltyProgram()) {
    var points: Int by Delegates.observable(0) { _, _, new ->
        if (new > 100) {
            // send notification to customer about reward
        }
    }

    fun makePurchase(amount: Double) {
        val pointsEarned = (amount / 10).toInt()
        loyaltyProgram.earnPoints(pointsEarned)
        points += pointsEarned
    }

    fun redeemPoints(pointsToRedeem: Int) {
        loyaltyProgram.redeemPoints(pointsToRedeem)
        points -= pointsToRedeem
    }
}
