package com.example.calculator


// 2개의 값 연산 계산기 입니다.
fun main() {
    println("============== 계산기 ===============")
    val cal = Calculator()

    outer@ while (true) {
        println("계산기를 실행합니다.\n(exit 입력 시 프로그램 종료)\n")
        print("수식을 입력하세요 : ")
        val input = readLine()
        if(input.equals("exit", ignoreCase = true)) {
            println("\n프로그램 종료")
            println("====================================\n")
            break@outer
        }

        print("계산할 첫 번째 값 입력 : ")
        val num1 = readLine()
        if((num1.equals("exit", ignoreCase = true))) {
            println("\n프로그램 종료")
            println("====================================\n")
            break@outer
        }
        // 두 번째 값 입력
        print("계산할 두 번째 값 입력 : ")
        val num2 = readLine()
        if(num2.equals("exit", ignoreCase = true)) {
            println("\n프로그램 종료")
            println("====================================\n")
            break@outer
        }
        //  연산자 입력
        print("연산자(+, -, *, /) 중 하나 입력 : ")
        val operator = readLine()
        if(operator.equals("exit", ignoreCase = true)) {
            println("\n프로그램 종료")
            println("====================================\n")
            break@outer
        }
        if(num1.isNullOrBlank() || num2.isNullOrBlank() || operator.isNullOrBlank()){
            println("\n잘못 입력하셨습니다. 다시 입력해 주세요.")
            println("====================================\n")
        }
        else {
            val num1 = num1.toDouble()
            val num2 = num2.toDouble()

            val operation = cal.operations[operator]
            if (operation == null) {
                println("지원되지 않는 연산자입니다.\n")
            } else {
                val result = operation.perform(num1, num2)
                if(result != null)
                    println("결과 : $result")
                println("====================================\n")
            }
        }
    }
}

class Calculator {

    var operations: Map<String, AbstractOperation> = mapOf(
        "+" to AddOperation(),
        "-" to SubstractOperation(),
        "*" to MultiplyOperation(),
        "/" to DivideOperation()
    )
    // 추상클래스 Operation 생성
    abstract class AbstractOperation {
        abstract fun perform(num1:Double, num2:Double):Double
    }

    // 더하기
    class AddOperation : AbstractOperation() {
        override fun perform(num1: Double, num2: Double): Double {
            return num1 + num2
        }
    }

    // 빼기
    class SubstractOperation : AbstractOperation() {
        override fun perform(num1: Double, num2: Double): Double {
            return num1 - num2
        }
    }
    // 곱하기
    class MultiplyOperation : AbstractOperation() {
        override fun perform(num1: Double, num2: Double): Double {
            return num1 * num2
        }
    }

    // 나누기
    class DivideOperation : AbstractOperation() {
        override fun perform(num1: Double, num2: Double): Double {
            return num1 / num2
        }
    }
}