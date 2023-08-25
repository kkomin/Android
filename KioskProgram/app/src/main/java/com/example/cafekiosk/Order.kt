package com.example.cafekiosk

import kotlin.system.exitProcess

// 결제 총괄 진행 클래스
class Order : OrderSystem() {
    // 매장 이용 방법
    fun firstMenu() {
        while (true) {
            println(
                "매장 이용 방법을 선택해주세요\n" +
                        "1. 매장식사\n" +
                        "2. 포장하기\n" +
                        "0. 프로그램종료"
            )
            when (readLine()?.toIntOrNull()) {
                in 1..2 -> {
                    // 메인메뉴로 이동
                    mainMenu()
                    break
                }
                0 -> {
                    println("프로그램 종료")
                    exitProcess(0)
                }
                else -> println("올바르지 않은 번호입니다. 다시 입력해주세요. \n----------------------------------\n")
            }
        }
    }

    // 메인 메뉴 화면
    fun mainMenu() {
        while (true) {
            println("아래 메뉴판 중 메뉴를 골라 번호를 입력하세요.")
            println("1. Coffee")
            println("2. Non-Coffee")
            println("3. Ade")
            println("4. Smoothie")
            println("5. Tea")
            println("6. Dessert")
            println("0. 프로그램 종료")

            var input = readLine()?.toIntOrNull()
            println()
            when(input){
                in 1..6 -> {
                    selectMenu(input!!)
                }
                0 -> {
                    exitProcess(0)
                }
                else -> {
                    println("올바르지 않은 번호입니다. 다시 입력해주세요.\n")
                }
            }
        }
    }

}