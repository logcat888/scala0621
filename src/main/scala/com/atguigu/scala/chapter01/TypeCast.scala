package com.atguigu.scala.chapter01

/**
 * @author chenhuiup
 * @create 2020-09-11 17:50
 */
object TypeCast {
  def main(args: Array[String]): Unit = {
    //（1）自动提升原则：有多种类型的数据混合运算时，系统首先自动将所有数据转换成精度大的那种数值类型，然后再进行计算。
    var n = 1 + 2.0
    println(n)

    //（2）把精度大的数值类型赋值给精度小的数值类型时，就会报错，反之就会进行自动类型转换。
    var n2 = 1.0
//    var n3 :Int = n2

    //（3）（byte，short）和char之间不会相互自动转换。
    var n4 :Byte =1
    var n5 :Short = n4
//    var c1:Char = n4

    //（4）byte，short，char他们三者可以计算，在计算时首先转换为int类型。

    var n6 :Byte = 1
//    var n8 :Byte = 15+127 //报错
//    var n8 : Byte = n6 +1
//    print(n8)
    var c2 :Char = 1
//    var n :Short = n6 + c2
    var n7 :Short = 10 + 20
    print(n7)


    //（1）将数据由高精度转换为低精度，就需要使用到强制转换
    var n1: Int = 2.5.toInt // 这个存在精度损失

    //（2）强转符号只针对于最近的操作数有效，往往会使用小括号提升优先级
    var r1: Int = 10 * 3.5.toInt + 6 * 1.5.toInt  // 10 *3 + 6*1 = 36
    var r2: Int = (10 * 3.5 + 6 * 1.5).toInt  // 44.0.toInt = 44

    println("r1=" + r1 + " r2=" + r2)

    var n9 = 130
    var v :Byte = n9.toByte
    print(v)


  }
}
