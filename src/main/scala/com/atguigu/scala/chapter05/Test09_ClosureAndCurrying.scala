package com.atguigu.scala.chapter05

/**
 * 闭包：外层函数返回内层函数，内层函数依赖外层函数的参数（局部变量）。内层函数可以将依赖的外层函数的参数一起
 *      打包，这样外层函数的变量就可以释放资源，不需要等内层函数计算完毕后再一起释放资源。同时内层函数依旧可以
 *      使用外层函数的变量。外层函数也是一个对象，打包保存的就是函数的属性。
 *      注：在函数式编程语言中，必须实现闭包，闭包可以节省大量资源（比如基于内层计算的Spark，节约资源代表性能提升），
 *         对于纯函数式编程的语言，比如哈斯卡尔，甚至没有变量，也就意味着没有循环，因为没有循环，所以只能通过递归实现。
 *         其实对于数学而言，根本就没有变量。但是对于计算机而言，变量其实是地址指向的存储空间。
 *  函数柯里化：就是一个语法糖，是数理学家们在Lambda演算时，对嵌套函数的进行封装。对于多层级的函数，只关心各层级
 *       传入的参数、最终返回值类型，以及最内层函数的处理逻辑。如果外层函数，在返回内层函数之前，还有其他逻辑，可能实现
 *       就有些麻烦。
 *   函数柯里化与闭包的应用场景：在大数据领域处理数据既要考虑适用性（效率高）又要考虑通用性（效率低）。对于一部分数据已经
 *       确定，可以重复利用这部分数据的结果，没有必要每次都计算这部分已经确定的数据。
 *
 *
 * @author chenhuiup
 * @create 2020-09-15 7:30
 */
object Test09_ClosureAndCurrying {
  def main(args: Array[String]): Unit = {
    //定义一个两个数求和的函数，通用性很好，适用性很差
    def add(a: Int, b: Int): Int = {
      a + b
    }

    //1. 考虑实际应用场景，大部分都是一个加数为4的场景
    def addByFour(b: Int): Int = 4 + b

    //2. 继续考虑扩展，有一部分场景是加数固定为5
    def addByFive(b: Int) = 4 + b

    //以上定义，适用性很好，但是通用性很差

    //3.考虑适用性和通用性的平衡，把第一个参数单独提取出来
    def addByFour1() = {
      val a = 4

      def addB(b: Int) = 4 + b

      addB _
    }

    def addByA(a: Int) = {
      def addB(b: Int) = a + b

      addB _
    }

    println(addByFour1()(35))
    println(addByA(5)(18))

    // 4.传入一个参数，得到具体的函数
    val addByFour2 = addByA(4)
    val addByFive2 = addByA(5)

    // 5 .匿名函数的简写
    def addByA2(a: Int): Int => Int = {
      a + _
    }

    // 6.函数柯里化
    def addCurrying(a: Int)(b: Int): Int = a + b

    println(addCurrying(5)(18))
  }

}
