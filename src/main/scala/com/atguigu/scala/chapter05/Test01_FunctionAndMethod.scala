package com.atguigu.scala.chapter05

/**
 * 1. 函数本身也是一个对象，可以声明一个变量接收函数对象，该变量就成为了一个新函数对象
 * 2. 通过函数名加_ 方式用 变量接收函数对象，相当于创建了一个新对象
 * 3. 当指定变量的类型为函数，可以省略_，相当于创建了一个新对象
 * 4. 方法是可以重载和重写的
 * 5. 可以打印函数对象，看函数的类型，2.11版本打印出来是<FunctionX>,X为参数的个数，2.12版本打印出来是
 *    函数的地址值Lambda$5/2096171631@7e0babb1
 * @author chenhuiup
 * @create 2020-09-14 19:37
 */
object Test01_FunctionAndMethod {
  def main(args: Array[String]): Unit = {
    //定义函数
    def sayHi(name:String) = {
      println(s"hi,$name")
    }

    //函数调用
    sayHi("赵丽颖")

    //通过函数名加_ 方式用 变量接收函数对象，相当于创建了一个新对象
    val n = sayHi _
    println(n)
    val m = sayHi _
    println(n == m) //false

    //指定变量的类型为函数，可以省略_，相当于创建了一个新对象
    val n1:String => Unit = sayHi
    val m1:String => Unit = sayHi
    println(n1 == m1) //false

    //函数调用
    n("陈钰琪")

    // 方法调用
    Test01_FunctionAndMethod.sayHi()

    val student = new Student
    student.sayHi("DongLiang")

  }

  def sayHi(name: String): Unit ={
    println(s"Hi, $name from object")
  }
  def sayHi(): Unit ={
    println(s"Hi, student")
  }

}

// 定义方法
class Student {
  def sayHi(name: String): Unit ={
    println(s"Hi, student $name")
  }
  def sayHi(): Unit ={
    println(s"Hi, student")
  }
}