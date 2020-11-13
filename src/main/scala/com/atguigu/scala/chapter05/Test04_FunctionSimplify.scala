package com.atguigu.scala.chapter05

/**
 * 函数至简原则：
 * 1. scala会默认将函数的最后一行作为返回值，或者说scala会默认将代码块的最后一行作为返回值。
 * 2. : 类型 是一个整体
 * 3. 如果有return，则不能省略返回值类型，必须指定,否则报错
 * 4. 定义函数时省略返回值类型和=，默认就是Unit类型，这时一行代码时花括号{}不能省
 * 5. 如果函数没有参数，也没有返回值，就是一段代码块，我们将这种函数称为过程
 * 6. 匿名函数也叫Lambda表达式，使用 =>,不再使用=
 * 7. 单独写出Lambda表达式没有意义，只有通过变量接收，或者当做函数的参数才有意义
 * 8. 函数 的类型为  输入类型 => 输出类型，当输入参数为空时，要写成()
 * 9. 当Lambda表达式输入为空时，通过变量接收Lambda表达式，调用函数如果没有括号，等于没有调用函数
 * 10. 当接收Lambda表示的变量指定了函数的类型，那么Lambda表达式的参数可以省略类型
 *
 * @author chenhuiup
 * @create 2020-09-14 20:28
 */
object Test04_FunctionSimplify {
  def main(args: Array[String]): Unit = {
    // 正常定义函数
    def f0(name: String): String = {
      return name
    }

    //（1）return可以省略，Scala会使用函数体的最后一行代码作为返回值
    def f1(name: String): String = {
      name
    }

    //（2）如果函数体只有一行代码，可以省略花括号
    def f2(name: String): String = name

    //（3）返回值类型如果能够推断出来，那么可以省略（:和返回值类型一起省略）
    def f3(name: String) = name

    //（4）如果有return，则不能省略返回值类型，必须指定,否则报错
    def f4(name: String): String = {
      return name
    }
  }

  //（5）如果函数明确声明unit，那么即使函数体中使用return关键字也不起作用
  def f5(name: String): Unit = {
    return name
  }

  //（6）Scala如果期望是无返回值类型，可以省略等号，这时花括号{}不能省
  def f6(name: String) {
    println(name)
  }

  //（7）如果函数无参，但是声明了参数列表，那么调用时，小括号，可加可不加
  def f7(): Unit = {
    println("f7")
  }

  f7()
  f7

  //（8）如果函数没有参数列表，那么小括号可以省略，调用时小括号必须省略
  def f8: Unit = {
    println("f7")
  }

  //  f8()  //报错
  f8

  println("--------------------")
  //（9）如果不关心名称，只关心逻辑处理，那么函数名（def）可以省略
  (name: String) => println(name)

  val f9 = (name: String) => println(name)
  println(f9) //com.atguigu.scala.chapter05.Test04_FunctionSimplify$$$Lambda$6/1844169442@5ba23b66

  val f10: String => Unit = name => println(name) //赵丽颖0
  //    val f11: String=>Unit = name => println(_)  //报错
  //    val f12: String=>Unit = _ => println(_) //报错
  val f13: String => Unit = _ => println //  输出空行
  val f14: String => Unit = _ => println() //  输出空行
  val f15: () => Unit = () => {
    println("哈哈哈")
    println("哈哈哈")
  }



  f10("赵丽颖0")
  //  f11("赵丽颖1")
  //  f12("赵丽颖2")
  f13("赵丽颖3")
  f14("赵丽颖4")
  f15()
  f15 //没有输出
  f15()


}
