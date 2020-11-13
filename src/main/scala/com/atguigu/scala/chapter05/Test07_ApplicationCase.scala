package com.atguigu.scala.chapter05

/**
 * @author chenhuiup
 * @create 2020-09-14 22:40
 */
object Test07_ApplicationCase {
  def main(args: Array[String]): Unit = {
    // 需求：提供一个函数，对一个数组中的元素进行处理，完成之后返回一个新的数组
    def arrayOps(arr: Array[Int], op: Int => Int): Array[Int] = {
      for (elem <- arr) yield op(elem)
    }

    //每个元素都加一
    def addOne(a: Int): Int = a + 1

    // 调用map函数进行数组转换
    val arr = Array(1, 2, 3, 4)
    val newArr = arrayOps(arr, addOne)
    println(newArr.mkString(" ")) //2 3 4 5

    val newArr1 = arrayOps(arr, _ * 3)
    // 下面报错
//    val newArr2 = arrayOps(arr, _ * _)
    val newArr2 = arrayOps(arr, elem => elem * elem)
    val newArr3 = arrayOps(arr, addOne)

  }

}
