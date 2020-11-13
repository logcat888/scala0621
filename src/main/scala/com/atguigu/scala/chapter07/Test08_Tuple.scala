package com.atguigu.scala.chapter07

/**
 * @author chenhuiup
 * @create 2020-09-18 23:17
 */
/*
元组说明：
1. 元组的类型为 (Int, String, Boolean)，必须加上(),元组的参数类别为(_1: T1, _2: T2, _3: T3),所以可以通过参数名_1 访问元素
final case class Tuple3[+T1, +T2, +T3](_1: T1, _2: T2, _3: T3)
  extends Product3[T1, T2, T3]
{
  override def toString() = "(" + _1 + "," + _2 + "," + _3 + ")"
}
2. case class其主构造器参数列表即使不加var/val，也是属性
3. 因为Tuple3继承了Product,所以他可以通过tuple.productIterator，获取元组中元素的迭代器
4. tuple.productElement(1),使用角标获取元组中的元素，1代表第二个元素
5. 元组中的元素可以是任意类型
6. 推荐使用参数名 _x的方式访问元组中的元素
 */
object Test08_Tuple {
  def main(args: Array[String]): Unit = {
    // 1. 创建元组
    val tuple: (Int, String, Boolean) = Tuple3[Int, String, Boolean](12, "hello", true)

    // 2. 元组和map
    val map = Map(("a", 1), ("b", 2), "c" -> 3, "d" -> 4)

    // 3. 访问元组中元素
    println(tuple._1) // 12
    println(tuple.productElement(1)) //hello
    println(tuple._3) //true

    // 4. 遍历访问元素
    for (elem <- tuple.productIterator) print(elem + "\t")

    // 5. 嵌套元组
    val tuple2:(Int,(String,Char),Double) = Tuple3(12,("abc",'A'),3.3)
    //访问元组中第二个元素，该元素为二元组，继续访问其第一个元素
    print(tuple2._2._1) //abc
  }

}
