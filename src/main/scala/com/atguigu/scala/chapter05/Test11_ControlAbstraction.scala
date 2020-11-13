package com.atguigu.scala.chapter05

/**
 *  1.值调用：把计算后的值传递过去，函数的参数类型为值，当传入一段代码（代码块，函数，对象），
 *    他们的返回值必须和参数类型一样。传入时就完成了相关的调用执行，获取了返回值。
 *  2.名调用（传名参数-by name parameter）：传递的是一段代码，函数的参数类型为 f3(a: =>Int)
 *     =>Int之前有一个空格，空格代表一段代码（可以是函数，代码块，对象），这段代码的最终返回值为Int类型。
 *  3. 名调用只有在调用代码块时才被真正执行，目的就是控制一段代码什么时候执行，用于实现框架的设计。
 *  4.  函数没有参数时要写(),而对于代码块而言，是什么都没有，代码块没有输入。
 *  5. 10 是最简单的代码块{10}
 *
 *
 * @author chenhuiup
 * @create 2020-09-15 19:05
 */
object Test11_ControlAbstraction {
  def main(args: Array[String]): Unit = {
    //1. 值调用
    def f1(a:Int) = {
      println("f1()")
      println(a)
      println(a)
    }
    f1(10)

    println("=====================")

    def f2():Int={
      println("f2()")
      25
    }
    f1(f2())

    println("=====================")

    //2.名调用（传名参数），传递的是代码块
    def f3(a: =>Int):Unit ={
      println("f3()")
      println(a)
      println(a)
    }
    f3(10)

    println("=====================")
    f3({
      println("hello")
      10
    })

    println("=====================")
    f3(f2())




  }

}
