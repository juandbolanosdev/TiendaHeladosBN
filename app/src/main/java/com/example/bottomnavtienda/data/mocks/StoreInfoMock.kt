package com.example.bottomnavtienda.data.mocks

import com.example.bottomnavtienda.data.models.StoreInfo

class StoreInfoMock {
    fun loadStoreInfo(): StoreInfo {
        return StoreInfo(
            1,
            "Mi tienda mictic",
            "https://w7.pngwing.com/pngs/80/585/png-transparent-post-board-gaming-logo-brand-hobby-shop-organization-post-card-text-logo-video-game.png",
            "Calle falsa 123",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        )
    }
}