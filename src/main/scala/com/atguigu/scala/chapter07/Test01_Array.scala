package com.atguigu.scala.chapter07

/**
 *  不可变数组
 *  1. Array[Int](5) 为定义一个长度为5的Int类型数组，Array为长度不可变的集合，继承于java.io.Serializable接口，可隐式转换为
 *     indexseq
 *  2. Array(1,2,3,4,5),用伴生对象的apply方法(支持可变参数)，scala对apply做了语法糖，可以省略apply
 *  3. 使用伴生类中的apply方法 arr1(0)，伴生类中的apply方法，取索引位置的元素，不能对其赋值，比如 arr1.apply(0) = 13 报错
 *  4. 使用伴生类中的update方法，修改Array中的元素，arr1(0) = 48 是 arr1.update(0,48)的简写
 *  5. Array对象的toString方法返回的是地址值
 *  6. arr2.indices 返回索引的Range集合
 *  7. for循环可以遍历集合
 *  8. 所有的集合都继承iterable，所以都可以返回迭代器
 *  9. foreach函数的参数列表为函数类型
 *  10. foreach函数本质还是遍历集合，用while循环 取出每个元素（apply方法），再执行foreach传入的函数操作
 *  11. 向不可变数组添加新元素，由于数组长度不可变，所以原数组不变，返回一个新数组对象
 *  12. arr2.:+(20)  隐式转换为ArrayOps，调用 :+ 方法，在数组最后索引为添加元素，返回一个新数组
 *  13. 为什么Array能调用各种indexseq的方法，是 因为发生隐式转换了
 *  14. 遍历索引的只有indexseq下的集合才可以
 *  15. 隐式转换是 如果当前对象没有这个方法，编译器就会把当前类型转换成另一个类型，看有没有这个方法。
 *  16. 为什么scala编译器慢，就是因为scala编译器帮我们做了大量工作。在scala.Predef包中定义了大量的隐式转换
 *  17. 在idea中隐式转换下面会显示横线，可惜我的没有显示
 *  18. mkString方法在底层还是调用foreach方法。
 *  19. 在scala中编译器对:进行了特殊处理，如果省略.使用 代替，scala认为 :边为对象调用者。 如果arr.+:(13)就不会产生歧义
 *  20. +：是在数组前面加，：+是在数组后面加
 *  21. 打印Array必须使用mkString，否则输出的是地址值，ArrayBuffer可以直接打印
 *
 *
 * @author chenhuiup
 * @create 2020-09-17 8:58
 */
object Test01_Array {
  def main(args: Array[String]): Unit = {
    // 1. 创建一个不可变数组
    // 1）new的方式，为定义一个长度为5的Int类型数组
    val arr1:Array[Int] = new Array[Int](5)
    // 2） 用伴生对象的apply方法，scala对apply做了语法糖，可以省略apply
    val arr2 = Array(1,2,3,4,5)

    println("===========================")

    // 2.访问数组中元素，做读写操作
    // 1）使用伴生类中的apply方法，取Array中的索引位置的元素
    println(s"${arr1(0)} ${arr1(1)} ${arr1(2)} ${arr1(3)} ${arr1(4)}") //0 0 0 0 0
    //    println(s"${arr1(5)}") //数组角标越界
    arr1(3) = 13
    // 2) 使用伴生类中的update方法，修改Array中的元素，arr1(0) = 48 是 arr1.update(0,48)的简写
    arr1.update(0,48) // arr1(0) = 48
//    arr1.apply(0) = 13 //报错，伴生类的apply返回一个数值对象，对其赋值错误
    arr2(2) = 27
    println(arr1.mkString(" ")) // 48 0 0 13 0
    println(arr2.toString) // [I@6bdf28bb

    //3. 遍历所有元素
    // 1） for循环，遍历索引
    for (i <- 0 until arr2.length)
      print(arr2(i) + "\t")
    println()

    // arr2.indices 返回索引的Range集合
    for (i <- arr2.indices)
      print(arr2(i) + "\t")
    println()

    // 2）for 循环直接遍历元素
    for (elem <- arr2)
      print(elem + "\t")
    println()

    // 3) 迭代器遍历
    val iterator:Iterator[Int] = arr2.iterator
    while (iterator.hasNext){
      val elem = iterator.next()
      print(elem + "\t")
    }
    println()

    // 4) foreach方法遍历集合
    def op(elem:Int) = {
      print(elem + "\t")
    }
    // 向foreach用传入自定义函数
    arr2.foreach(op)
    print("\n")
    // 向foreach中传入匿名函数
    arr2.foreach(elem => print(elem + "\t"))
    println()
    // 匿名函数简写
    arr2.foreach(println(_))
    println()
    // 向foreach中传入函数
    arr2.foreach(println)
    //  def println(x: Any) = Console.println(x)

    // 4. 向数组中添加元素
    // 生成一个新的数组，原数组不变
    // 隐式转换为ArrayOps，调用 :+ 方法，在数组最后索引为添加元素，返回一个新数组
    val newArr1 = arr2.:+(20)
    println(newArr1.mkString("\t")) // 1	2	27	4	5	20

//    val newArr2 = newArr1 +: 63 // 报错,因为 63 这个对象Int类型的没有 +：这个方法
//    val newArr2 = newArr1.+:63
    val newArr2 = newArr1.+:(63)
    println(newArr2.mkString("\t")) //63	1	2	27	4	5	20

    //
    val newArr3 = 26 +: 25 +: newArr2 :+ 1 :+ 2 :+ 3
    println(newArr3.mkString("\t")) // 26 25 63	1	2	27	4	5	20 1 2 3
  }

}

/*

// Array 伴生对象的apply方法，支持可变参数
  Creates an array of `Int` objects
// Subject to a compiler optimization in Cleanup, see above.
def apply(x: Int, xs: Int*): Array[Int] = {
  val array = new Array[Int](xs.length + 1)
  array(0) = x
  var i = 1
  for (x <- xs.iterator) { array(i) = x; i += 1 }
  array
}

// foreach函数本质还是遍历集合，用while循环 取出每个元素（apply方法），再执行foreach传入的函数操作
  def foreach[U](f: A => U): Unit = {
    var i = 0
    val len = length
    while (i < len) { f(this(i)); i += 1 }
  }

  // 隐式转换为ArrayOps，调用 :+ 方法，在数组最后索引为添加元素，返回一个新数组
    def :+[B >: T: ClassTag](elem: B): Array[B] = {
    val currentLength = repr.length
    val result = new Array[B](currentLength + 1)
    Array.copy(repr, 0, result, 0, currentLength)
    result(currentLength) = elem
    result
  }


//伴生类中的apply方法，取索引位置的元素
final class Array[T](_length: Int) extends java.io.Serializable with java.lang.Cloneable {
  def apply(i: Int): T = throw new Error()  //throw new Errow 并不是抛出异常，而是底层做了封装
  }

//  使用伴生类中的update方法，修改Array中的元素，arr1(0) = 48 是 arr1.update(0,48)的简写
 `xs(i) = x` is a shorthand for `xs.update(i, x)`.
  def update(i: Int, x: T) { throw new Error() }

 */