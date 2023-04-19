package com.example.kotlin.mykotlin

import kotlin.properties.Delegates

interface SoundPlayer {
    fun playSound()
}

class AudioPlayer : SoundPlayer {
    override fun playSound() {
        println("Audio is playing...")
    }
}

class VideoPlayer(soundPlayer: SoundPlayer) : SoundPlayer by soundPlayer {
    fun playVideo() {
        println("Video is Playing..")
    }
}

fun main() {
    val audioPlayer = AudioPlayer()
    val videoPlayer = VideoPlayer(audioPlayer)
    videoPlayer.playSound()
    videoPlayer.playVideo()

    // lazy
    val myLazyProperty: String by lazy {
        println("Computing the value")
        "Hello, World!"
    }
    println(myLazyProperty)
    println(myLazyProperty)

    // observable
    var myObservableProperty: String by Delegates.observable("Initial Value") { property, oldValue, newValue ->
        println("$property has changed from $oldValue to $newValue")
    }
    myObservableProperty = "Name"
    println(myObservableProperty)
    myObservableProperty = "Name new"
    println(myObservableProperty)

    // vetoable
    var myVetoableProperty: String by Delegates.vetoable("Initial Value") { property, oldValue, newValue ->
        if (newValue.length > 10) {
            println("Value $newValue is too long, not setting the property")
            false
        } else {
            println("Setting property value to $newValue")
            true
        }
    }

    myVetoableProperty = "Sagar"
    println(myVetoableProperty)
    myVetoableProperty = "Ajudiya"
    println(myVetoableProperty)
    myVetoableProperty = "Sagar Ajudiya"
    println(myVetoableProperty)

}