package com.atguigu.scala.chapter04

/**
 *  1. 1 to 10 是 调用了RichInt中的 to() 方法 def to(end: Int): Range.Inclusive = Range.inclusive(self, end)
 *     返回一个Range集合 ，步长默认是 1 ，def apply(start: Int, end: Int): Range = new Range(start, end, 1)
 *  2. <- 表示遍历集合，1 to 3 的to 方法的返回值是Range集合。
 *  3. for 循环可以遍历集合类型
 *  4. 循环守卫就是模拟continue跳过当前循环
 *  5. 循环步长可以通过循环守卫模拟
 *  6. 循环步长 by 其实调用了Range中的 def by(step: Int): Range = copy(start, end, step)
 *     1）当循环步长by 为浮点型是可以造成精度丢失 ，如for( i <- 2.0 to 10.0 by 0.3 ){println(i)}
 *     2）to 代表 左闭右闭，当左右相等时，会有一次输出 。 until代表左边右开，当左右相等时，不会输出。
 *     3) 当左小于右，且by为负数时，不进去循环，Range会判断为 empty类型
 *   7. for循环默认是没有返回值的，是Unit类型，当使用变量接收时，打印输出为 ()
 *   8. yield 是将一个集合（Range），通过一定规则转变成另一个集合(vector),在大数据分析中，本质就是一种集合转变成另一种集合
 *
 *
 * @author chenhuiup
 * @create 2020-09-14 18:35
 */

object Test02_ForLoop {
  def main(args: Array[String]): Unit = {
    // 1. 对范围数据进行遍历
    for (i <- 1 to 10){
      print(i + ",")
    }

    println()
    for (i <- 1 until 10){
      print(i + ",")
    }

    //2.遍历集合类型
    for (elem <- Array(2,45,75,99)){
      println(elem)
    }

    //3. 循环守卫（可以模拟continue跳过当前循环）
    for (i <- 1 to 10){
      if (i != 5 )
        println(i)
    }

    for (i <- 1 to 10;if i != 5 ){
      println(i)
    }

    println("========================")

    //4.循环步长
    for (i <- 1 to 10;if i % 2 == 1){
      println(i)
    }

    for (i <- 1 to 10 by 2){
      print(i + " ")
    }
    print("\n")

    for( i <- 2.0 to 10.0 by 0.3 ){
      println(i)
    }

    for (i <- 10 to 10 by -2){
      println(i)
    }

    for( i <- 10 until 10 by -2 ){
      println(i + "-------")
    }

    for( i <- -10 to 10 by -2 ){
      println(i + "-------")
    }

    println(-10 to 10 by -2) //empty Range -10 to 10 by -2

    // 6. 引入变量
    for( i <- 1 to 10 ){
      val j = 10 - i
      println(s"i = $i \t j = $j")
    }
    for( i <- 1 to 10; j = 10 - i )
      println(s"i = $i \t j = $j")
    for{
      i <- 1 to 10
      j = 10 - i
    }{
      println(s"i = $i \t j = $j")
    }

    // 7. 返回值
    val a = for(i <- 1 to 10){
      println(i)
      "hello"
    }
    println(a) //()

    val b = for (i <- 1 to 10 ) yield i * i
    println(b) //Vector(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)
  }
}
