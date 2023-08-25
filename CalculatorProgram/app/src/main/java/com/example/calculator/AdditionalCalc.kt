package com.example.calculator

import java.util.Stack

// 3개 이상의 수식 연산 계산기 입니다.
fun main() {
    println("============== 계산기 ===============")
    val cal = AddCalculator()

    outer@ while (true) {
        println("계산기를 실행합니다.\n(exit 입력 시 프로그램 종료)\n")
        print("공백없이 수식을 입력하세요 : ")
        val input = readLine()
        if(input.equals("exit", ignoreCase = true)) {
            println("\n프로그램 종료")
            println("====================================\n")
            break@outer
        }
        if(input.isNullOrBlank()){
            println("\n잘못 입력하셨습니다. 다시 입력해 주세요.")
            println("====================================\n")
        }
        else {
            val postfix = convert(input)
            val result = cal.calculate(postfix)
            if(result != null)
                println("결과 : $result")
            println("====================================\n")
        }
    }
}

class AddCalculator {

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

    fun calculate(postfix:String):Double?{
        val stack = Stack<Double>()

        for(token in postfix.split(" ")){
            if(token.isNumeric()){
                stack.push(token.toDouble())
            }
            else if(token in operations.keys){
                if(stack.size < 2)
                    return null

                val num2 = stack.pop()
                val num1 = stack.pop()
                val operation = operations[token] ?: return null
                val result = operation.perform(num1, num2)

                stack.push(result)
            } else {
                return null
            }
        }

        return if (stack.size == 1) stack.pop() else null
    }
}

fun String.isNumeric() : Boolean {
    return matches("^-?\\d+(\\.\\d+)?\$".toRegex())
}

fun convert(infix:String):String {
    val stack = Stack<String>()
    val postfix = mutableListOf<String>()
    val precedence = mapOf("+" to 1, "-" to 1, "*" to 2, "/" to 2)

    var currentNum = ""
    for(token in infix) {
        // 숫자나 소수점이면
        if(token.isDigit() || token == '.') {
            currentNum += token
        }
        // 연산자라면
        else {
            if(currentNum.isNotEmpty()) {
                postfix.add(currentNum)
                currentNum = ""
            }

            if(token.toString() in precedence.keys) {
                while(stack.isNotEmpty() &&
                    stack.peek() in precedence.keys &&
                    precedence[token.toString()]!! <= precedence[stack.peek()]!!)
                    postfix.add(stack.pop())
            }
            stack.push(token.toString())
        }
    }
    if(currentNum.isNotEmpty()) {
        postfix.add(currentNum)
    }
    while(stack.isNotEmpty()) {
        postfix.add(stack.pop())
    }

    return postfix.joinToString (" ")
}