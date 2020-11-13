package com.atguigu.scala.chapter07

/**
 * @author chenhuiup
 * @create 2020-09-19 21:31
 */
/*
1. reduce:def reduce[A1 >: A](op: (A1, A1) => A1): A1 = reduceLeft(op)
   1）参数解读：(A1, A1) => A1  第一个A1之归约的结果，第二个A1为新来的数据，第三个A1为处理逻辑，为归约结果，返回值必须是A1类型
   2）reduce底层调用reduceLeft()方法，从左向右对集合元素进行反复归约，递归。
   3）reduce归约是不平等的，集合中的第一个元素为归约初始状态，依次对后面的元素进行归约，比如进行减法，
     1-2-3-4，如果是平等的归约应该是所有元素都应该是-号，-1-2-3-4
   4）使用reduce方法要求归约结果的类型必须大于等于集合元素类型
2. reduceLeft：
   1）源码：def reduceLeft[B >: A](@deprecatedName('f) op: (B, A) => B): B =
    if (isEmpty) throw new UnsupportedOperationException("empty.reduceLeft")
    else tail.foldLeft[B](head)(op)
    -----
      def foldLeft[B](z: B)(@deprecatedName('f) op: (B, A) => B): B = {
    var acc = z
    var these = this
    while (!these.isEmpty) {
      acc = op(acc, these.head)
      these = these.tail
    }
    acc
  }
   2）源码解读，B为归约结果，A为新来的数据，集合的头为初始状态，尾调用foldleft(初始状态)(处理逻辑)，反复循环迭代获取积累状态acc
   3）参数解读，归约结果和集合元素类型可以不一样，从左向右归约集合元素
   4） 第一个元素作为初始状态，对于其他元素不公平

3. reduceRight：
   1）源码：  def reduceRight[B >: A](op: (A, B) => B): B =
    if (isEmpty) throw new UnsupportedOperationException("Nil.reduceRight")
    else if (tail.isEmpty) head
    else op(head, tail.reduceRight(op))
    2） 源码解读：B为归约结果，A为新来的数据，递归到最后，最后一个元素作为初始状态，前一个元素，依赖后面集合的归约集合，进行归约操作。
    3） 参数解读，归约结果和集合元素类型可以不一样，从右向左归约集合元素，反复递归
    4） 最后一个元素作为初始状态，对于其他元素不公平
    5） 没有实现尾递归，应用场景不大，与集合元素reverse之后使用reduce效果不一样

4. fold 可以自定义初始状态，采用了函数柯里化，第一个参数是初始状态，第二个参数是处理逻辑
5. 能用reduce实现的，fold一定也能实现。fold 与 reduce一样要求集合数据类型与归约结果类型一致，而left和right可以不一致


 */
object Test13_HighLevelFuction_Reduce {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4)
    // 1. reduce
    val result0 = list.sum
    val result1 = list.reduce((sum,data)=>sum+data)
    val result2 = list.reduce(_ + _)
    val result3 = list.reduceLeft(_ + _)
    val result4 = list.reduceRight(_+_)
    println(result1)
    println(result2)
    println(result3)
    println(result4)

    println("==========================")

    println(list.reduce(_ - _))    // -8, 1-2-3-4
    println(list.reduceRight(_ - _))    // -2, 1-(2-(3-4))

    val list2 = List(3,4,5,8,10)
    println(list2.reduce(_ - _))    // -24, 3-4-5-8-10
    println(list2.reduceRight(_ - _))    // 6, 3-(4-(5-(8-10)))

    // 2. fold
    val res5 = list.fold(10)(_+_)
    println(res5) //20
    println(list2.foldLeft(10)(_ - _))    // -20, 10-3-4-5-8-10
    println(list2.foldRight(11)(_ - _))     // -5, 3-(4-(5-(8-(10-11))))
  }
}
