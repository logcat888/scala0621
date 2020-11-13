package com.atguigu.scala.chapter08

/**
 * @author chenhuiup
 * @create 2020-09-20 10:01
 */
/*
模式匹配:
1. 基本语法： val result = x match {
              case 情况1 => {处理逻辑}
              case 情况2 => {处理逻辑}
                ....
              case _ => {处理逻辑}
              }
   总结：1）x代表 需要执行匹配的变量；2）情况可以常量（任意多种类型）、变量（任意类型，可类型推断）、数组、元组、列表、对象及精准匹配；
        3） 处理逻辑是一段代码块，最后一行为返回值，当 只有一行或一行都没有（返回Unit），花括号可以省略；
        4）最后一个case为默认情况，_代表占位符，相当于起别名，写任意值都行（比如，a,b,c）,建议写成_
        5) case天生自带break，不会出现java中“贯穿”现象
        6）如果没有默认case，当case中没有匹配时，会抛异常
        7） result为模式匹配的返回值
2. 当函数体中只有match体时，可以将函数的{}省略，其实就是一行代码
3. case _ => 什么都没有写，   返回Unit。 Nothing是根本不返回，是throw new Exception  这个表达式的类型。
 */
object Test01_PatternMatchBase {
  def main(args: Array[String]): Unit = {
    // 1.基本定义语法
    val x:Int = 12
    val y = x match{
      case 1 => "One"
      case 2 => "Two"
      case 10 =>"Ten"
      case _ => x
    }
    println(y) //12

    // 2.复杂示例
    val a :Int = 12
    val b :Int = 17
    def matchOpAandB(op:Char):Any={
      op match{
        case '+' => a + b
        case '-' => a - b
        case '*' => a * b
        case '/' => a / b
        case _ => "输入参数不合法"
      }
    }
    println(matchOpAandB('+')) //29
    println(matchOpAandB('*')) //204
    println(matchOpAandB('D')) //输入参数不合法

    // 3.模式守卫
    def abs(num:Int):Int = num match {
        //i 相当于接收num的变量，当不做类型匹配，可以类型推断出i的类型时，可以省略类型
      case i if i > 0 => i
      case i if i < 0 => -i
      case _ => 0
    }

    println(abs(8)) // 8
    println(abs(-15)) // 15
    println(abs(0)) // 0
  }
}
