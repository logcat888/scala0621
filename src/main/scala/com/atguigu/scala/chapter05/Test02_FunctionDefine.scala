package com.atguigu.scala.chapter05

/**
 * 1. 当用一个变量接收函数，如果没有使用lazy关键字，那么在变量引用指向函数对象时，就执行了函数对象的逻辑。
 * 2. 当函数无参时，调用函数时可以省略()
 * 3. 当函数无参时，声明/定义函数时可省略()
 * @author chenhuiup
 * @create 2020-09-14 19:52
 */
object Test02_FunctionDefine {
  def main(args: Array[String]): Unit = {
    //（1）函数1：无参，无返回值
    def f1(): Unit ={
      println("1. f1")
    }
    f1()
    f1
    val a = f1() //a 为 Unit类型
    println(a) //()

    //（2）函数2：无参，有返回值
    def f2(): Int = {
      println("2. f2")
      return 2
    }
    f2()
    println(f2())

    //（3）函数3：有参，无返回值
    def f3(name: String): Unit ={
      println(s"3. f3  $name")
    }
    f3("DongLiang")
    println(f3("DongLiang"))

    //（4）函数4：有参，有返回值
    def f4(name: String): String ={
      println(s"4. f4  $name")
      return "hello, " + name
    }
    f4("DongLiang")
    println(f4("DongLiang"))

    //（5）函数5：多参，无返回值
    def f5(name1: String, name2: String): Unit ={
      println(s"5. f5  $name1 $name2 都是我的好朋友")
    }
    f5("DongLiang", "ShiLei")
    println(f5("DongLiang", "ShiLei"))

    //（6）函数6：多参，有返回值
    def f6(name1: String, name2: String): String ={
      println(s"6. f6")
      return s"$name1 $name2 都是我的好朋友"
    }
    f6("DongLiang", "ShiLei")
    println(f6("DongLiang", "ShiLei"))

  }
}
