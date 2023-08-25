package com.example.cafekiosk

data class MenuItem(
    var id: Int,            // 메뉴 입력 번호
    var name: String,       // 메뉴 이름들
    var price: Int         // 가격
) {
}