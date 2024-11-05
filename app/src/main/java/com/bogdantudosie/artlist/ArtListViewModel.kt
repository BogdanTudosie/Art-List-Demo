package com.bogdantudosie.artlist

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ArtListViewModel {
    private val artworkList = listOf(
        Artwork(
            imageRes = R.drawable.angron,
            title = "Primarch Angron",
            artist = "Someone on the Internet"
        ),
        Artwork(
            imageRes = R.drawable.triarii,
            title = "World Eater Triarius",
            artist = "Someone on the internet"
        ),
        Artwork(
            imageRes = R.drawable.leviathan,
            title = "Leviathan Dreadnought",
            artist = "Someone"
        ),
        Artwork(
            imageRes = R.drawable.world_eater_attack,
            title = "World Eater Attacking",
            artist = "World Eater fanboy"
        ),
        Artwork(
            imageRes = R.drawable.legionnaire,
            title = "World Eaters Legionnaire",
            artist = "unknown"
        ),
        Artwork(
            imageRes = R.drawable.redbutcher,
            title = "Red Butcher Terminator",
            artist = "Unknown"
        )
    )

    private var currentIndex = 0
    private val _currentImage = MutableStateFlow(artworkList[currentIndex])
    val currentImage: StateFlow<Artwork> = _currentImage


    // Navigation functions
    fun nextArtwork() {
        currentIndex = (currentIndex + 1) % artworkList.size
        _currentImage.value = artworkList[currentIndex]
    }

    fun previousArtwork() {
        currentIndex = if (currentIndex > 0) {
            currentIndex - 1
        } else {
            artworkList.lastIndex
        }
        _currentImage.value = artworkList[currentIndex]
    }
}