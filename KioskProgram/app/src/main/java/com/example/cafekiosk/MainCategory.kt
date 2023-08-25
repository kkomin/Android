package com.example.cafekiosk

// 메뉴 카테고리 리스트
class MenuCategory {
    val Coffee = listOf(
        MenuItem(1, "에스프레소", 3000),
        MenuItem(2, "아메리카노(HOT)", 3000),
        MenuItem(3, "아메리카노(ICE)", 3500),
        MenuItem(4, "카페라떼(HOT)", 4000),
        MenuItem(5, "카페라뗴(ICE)", 4500),
        MenuItem(6, "카푸치노(HOT)", 4000),
        MenuItem(7, "카푸치노(ICE)", 4500),
    )
    val NonCoffee = listOf(
        MenuItem(1, "초코라떼(HOT)", 4000),
        MenuItem(2, "초코라떼(ICE)", 4500),
        MenuItem(3, "그린티라떼(HOT)", 4000),
        MenuItem(4, "그린티라떼(ICE)", 4500),
        MenuItem(5, "고구마라떼(HOT)", 4500),
        MenuItem(6, "고구마라떼(ICE)", 5000),
    )
    val Ade = listOf(
        MenuItem(1, "레몬에이드", 5000),
        MenuItem(2, "청포도에이드", 5000),
        MenuItem(3, "딸기에이드", 5000),
        MenuItem(4, "블루베리에이드", 5000)
    )
    val Smoothie = listOf(
        MenuItem(1, "요거트스무디", 5500),
        MenuItem(2, "딸기스무디", 5500),
        MenuItem(3, "망고스무디", 5500),
        MenuItem(4, "블루베리스무디", 6000)
    )
    val tea = listOf(
        MenuItem(1, "페퍼민트(HOT)", 5500),
        MenuItem(2, "페퍼민트(ICE)", 6000),
        MenuItem(3, "캐모마일(HOT)", 5500),
        MenuItem(4, "캐모마일(ICE)", 6000),
        MenuItem(5, "녹차(HOT)", 5500),
        MenuItem(6, "녹차(ICE)", 6000),
    )
    val dessert = listOf(
        MenuItem(1, "허니브레드", 8000),
        MenuItem(2, "치즈케이크", 8500),
        MenuItem(3, "딸기케이크", 8500),
        MenuItem(4, "당근케이크", 8000)
    )

    // 메뉴 선택 시 서브 메뉴로
    fun subMenuCategory(categoryNumber : Int):List<MenuItem>? {
        return when(categoryNumber) {
            1 -> Coffee
            2 -> NonCoffee
            3 -> Ade
            4 -> Smoothie
            5 -> tea
            6 -> dessert
            else -> null
        }
    }
}