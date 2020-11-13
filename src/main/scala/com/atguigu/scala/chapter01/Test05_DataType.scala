package com.atguigu.scala.chapter01

/**
 * @author chenhuiup
 * @create 2020-09-12 13:36
 */
object Test05_DataType {
  def main(args: Array[String]): Unit = {
    // 1. 整型
    // （1）Scala各整数类型有固定的表示范围和字段长度，不受具体操作的影响，以保证Scala程序的可移植性。
    val a1: Byte = 127
    //    val a2: Byte = 128
    var a3: Byte = -128
    //    var a4: Byte = -129

    // (2) Scala的整型，默认为Int型，声明Long型，须后加‘l’或‘L’
    val b1 = 10
    //    val b2: Byte = b1 + 13
    //    val b3: Byte = 127 + 13
    val b2: Byte = 10 + 13
    println(b2)
    val b3: Long = 25353246543652353L

    // 2. 浮点类型
    val d1 = 2.34f

    // 3. 字符类型
    val c1 = 'a'
    //idea报错，但是编译运行通过
    val c2: Char = 'a' + 1
    println(c2)

    // 4. 布尔类型（略）

    // 5. 空类型：Unit、Null和Nothing
    //（1） Unit类型用来标识过程，也就是没有明确返回值的函数
    def m1(): Unit = {
      println("m1被调用")
    }

    val m: Unit = m1()
    println(m) //  ()   Unit的对象就是（），是scala对void的封装，调用toString方法使，返回()

    //(2)Null类只有一个实例对象，Null类似于Java中的null引用
    //Null可以赋值给任意引用类型(AnyRef)，但是不能赋值给值类型(AnyVal)
    var student = new Student
    student = null

    var std = 123
    //    std = null  //报错

    //（3）Nothing，可以作为没有正常返回值的方法的返回类型，非常直观的告诉你这个方法不会正常返回，因为不会正常返回所以不知道返回值的类型，四大皆空
    //而且由于Nothing是其他任意类型的子类，他还能跟要求返回值的方法兼容
    def m2(n: Int): Nothing = {
      if (n == 0)
        throw new NullPointerException
      else
        throw new RuntimeException
    }

    println(m2(2))

    def m3(n: Int): Double = {
      if (n == 0)
        throw new NullPointerException
      else
        return n + 3
    }

    println(m3(2))


  }

}
