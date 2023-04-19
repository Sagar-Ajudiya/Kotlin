package com.example.kotlin.mykotlin

interface DeliveryService {
   fun deliver(order: Order)
}

class ZomatoDeliveryService : DeliveryService {
    override fun deliver(order: Order) {
        println("Service Deliver")
    }

}

class Restaurant(val name: String, val deliveryService: DeliveryService) {
    fun receiveOrder(order: Order) {
        // Receive the order and delegate the delivery to the delivery service
        deliveryService.deliver(order)
    }
}

class Order {

}

fun main() {
    val zomatoDeliveryService = ZomatoDeliveryService()
    val restaurant = Restaurant("ABC Restaurant", zomatoDeliveryService)

    val order = Order(/* Order details */)
    restaurant.receiveOrder(order)
}
