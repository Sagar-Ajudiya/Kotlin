package com.example.kotlin.mykotlin

interface PaymentGateway {
    fun processPayment(amount: Double): Boolean
}

class CreditCardPaymentGateway : PaymentGateway {
    override fun processPayment(amount: Double): Boolean {
        return true
    }
}

interface PaymentLogger {
    fun logPayment(amount: Double)
}

class LoggerPaymentGateway(private val paymentGateway: PaymentGateway, private val paymentLogger: PaymentLogger) : PaymentGateway by paymentGateway {
    override fun processPayment(amount: Double): Boolean {
        val paymentSuccessful = paymentGateway.processPayment(amount)
        if (paymentSuccessful) {
            paymentLogger.logPayment(amount)
        }
        return paymentSuccessful

    }
}

fun main() {
    val creditCardPaymentGateway = CreditCardPaymentGateway()
    val paymentLogger = object : PaymentLogger {
        override fun logPayment(amount: Double) {
            println("Payment of $amount processed successfully")
        }
    }
    val loggerPaymentGateway = LoggerPaymentGateway(creditCardPaymentGateway, paymentLogger)

    val amount = 100.0
    val paymentSuccessful = loggerPaymentGateway.processPayment(amount)
    if (paymentSuccessful) {
        println("Payment of $amount processed successfully")
    } else {
        println("Payment of $amount failed")
    }
}
