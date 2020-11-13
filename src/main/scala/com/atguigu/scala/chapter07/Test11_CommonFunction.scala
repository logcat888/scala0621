package com.atguigu.scala.chapter07

/**
 * @author chenhuiup
 * @create 2020-09-19 8:27
 */
/*
1. 排序函数：
 1）sorted：  def sorted[B >: A](implicit ord: Ordering[B]): Repr
    Ordering[B]代表隐式参数类型，可写可不写，当写成Ordering[Int].reverse时，代表降序
    底层实现原理：1）创建一个数组，将集合中的元素全部取出放入数组中；2）采用快排对数组进行排序，ord为java中Comparator；
      3）将数组中的元素类型转换为集合元素类型，循环添加到新创建的集合中
 2）sortBy：def sortBy[B](f: A => B)(implicit ord: Ordering[B]): Repr = sorted(ord on f)。
    sortBy依旧底层调用sorted，使用函数柯里化传入两个参数，第二个参数是隐式参数，
    为比较方式，默认是从小到大，当传入Ordering[Int].reverse后为降序排序
 3）sortwith：def sortWith(lt: (A, A) => Boolean): Repr = sorted(Ordering fromLessThan lt)
 sortwith的参数为一个比较函数，判断大小,底层调用sorted函数

 */
object Test11_CommonFunction {
  def main(args: Array[String]): Unit = {
    val list = List(23, 54, 68, 91, 15)

    //    （1）求和
    println(list.sum)

    //    （2）求乘积
    println(list.product)
    println(List(1, 2, 3, 4, 5).product)
    println((1 to 10).product)

    //    （3）最大值
    println(list.max)

    //    （4）最小值
    println(list.min)

    //    （5）排序
    println(list)
    //升序
    println(list.sorted) //List(15, 23, 54, 68, 91)
    //降序
    println(list.sorted(Ordering[Int].reverse)) //List(91, 68, 54, 23, 15)

    println("========================")
    //def sortBy[B](f: A => B)(implicit ord: Ordering[B]): Repr = sorted(ord on f)
    //sortBy依旧底层调用sorted，使用函数柯里化传入两个参数，第二个参数是隐式参数，为比较方式，默认是从小到大，当传入Ordering[Int].reverse后为降序排序
    println(list.sortBy(data => data)) //List(15, 23, 54, 68, 91)
    println(list.sortBy(data => -data)) //List(91, 68, 54, 23, 15)
    println(list.sortBy(data => data)(Ordering[Int].reverse)) //List(91, 68, 54, 23, 15)
//    println(list.sortBy(_)(Ordering[Int].reverse)) 不能简写

    //def sortWith(lt: (A, A) => Boolean): Repr = sorted(Ordering fromLessThan lt)
    //sortwith的参数为一个比较函数，判断大小,底层调用sorted函数
    println(list.sortWith(_ > _)) //List(91, 68, 54, 23, 15)

  }

}
