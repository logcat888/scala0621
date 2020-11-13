package com.atguigu.scala.chapter08

/**
 * @author chenhuiup
 * @create 2020-09-20 10:34
 */
/*
1. 模式匹配时，对于类型匹配，只有Array[T] 的泛型不会被擦除，其余集合(比如List[Int])、类(Person[T])等的泛型都会被擦除，只会保留List,Person类型。
2. 泛型擦除的原因：scala是基于JVM，JVM不会保存泛型，对于List[T]，只会保留List类型，而不保留其中的T。
   但是对于Array[T]来说,其底层就是有类型的数组（比如Int[],String[]），则不会擦除泛型。
3. case Array(a,_) => a   ,a是可以使用的，_不能使用，只能表示占位符
4. List创建对象的方式：1）伴生对象；2）Nil对象 使用 :: 方法 。:: 是从右向左调用
5. Nil是List[Nothing],Nothing是任何类型的子类和任意类型都能匹配
6. List(1,2)使用模式匹配 case one :: two :: rest 。 one/two 是Int类型，rest是List[Int]
7. case i ,i为定义变量，不使用外面的变量，接受match前的变量的引用
8. arr <- arrList为最简单的模式匹配
9. case Array(x,y) => {}  x,y没有限制类型，为任意类型
 */
object Test02_MatchTypes {
  def main(args: Array[String]): Unit = {
    // 1. 匹配一个常量值
    def describeConst(x: Any): Any = x match {
      case 10 => "Int ten"
      case "hello" => "String hello"
      case true => "Boolean true"
      case "+" => "Char +"
      case _ =>
    }

    println(describeConst(10)) //Int ten
    println(describeConst("hello")) //String hello
    println(describeConst(true)) //Boolean true
    println(describeConst("abc")) //()

    println("=======================================")

    // 2. 匹配类型
    def describeType(x: Any): String = x match {
      case i: Int => "Int " + i
      case s: String => "String " + s
      case b: Boolean => "Boolean " + b
      case l: List[String] => "List " + l //泛型擦除
      case arr: Array[Int] => "Array[Int] " + arr.mkString(",")
      case _ => "something else"
    }

    println(describeType(10)) //Int 10
    println(describeType("hello")) //String hello
    println(describeType(true)) // Boolean true
    println(describeType("abc")) // String abc
    println(describeType(List())) // List List()
    println(describeType(List("abc", "def"))) // List List(abc, def)
    println(describeType(List(2, 3, 4, 6))) // List List(2, 3, 4, 6) //泛型擦除
    println(describeType(Array(2, 5, 2, 65))) // Array[Int] 2,5,2,65
    println(describeType(Array("hello", "world"))) //something else，Array的泛型不会被擦除

    // 3. 匹配数组
    val arrList: List[Any] = List(
      Array(0),
      Array(0, 1),
      Array(1, 0),
      Array(0, 1, 0),
      Array(1, 1, 0),
      Array(35, 47, 96, 45),
      Array("hello", "world")
    )

    def describeArray(arr: Any): String = arr match {
      case Array(0) => "Array(0)"
      case Array(x, y) => "Array 2: " + x + " " + y //表示任意类型的2个元素的数组
      case Array(0, _*) => "Array with 0 start" // 表示第一个元素是0的数组
      case Array(_, 1, _) => "Array 3 with 1 in middle" //数组中有3个元素，且第二个是1
      case _ => "something else"
    }
    //arr <- arrList为最简单的模式匹配
    for (arr <- arrList) println(describeArray(arr))
    /*
    Array(0)
    Array 2: 0 1
    Array 2: 1 0
    Array with 0 start
    Array 3 with 1 in middle
    something else
    Array 2: hello world
     */

    println(describeArray(Array('c', 'a'))) //Array 2: c a

    println("==============================")

    // 4. 匹配列表
    for (list <- List(
      List(0),
      List(0, 1),
      List(1, 0),
      List(0, 1, 0),
      List(1, 1, 0),
      List(35, 47, 96, 45),
      List("hello"),
      List('a', 'b'),
      Map(('a', 1))
    )) {
      val description = list match {
        case List(0) => "List(0) " + list
        case List(_, _) => "List 2 elements"
        case List(0, _*) => "List with 0 start"
        case List(_) => "List " + list
        case _ => "something else"
      }
      println(description)

    }
    /*
    List(0)List(0)
   List 2 elements
   List 2 elements
   List with 0 start
   something else
   something else
   ListList(hello)
   List 2 elements
   something else
     */
    println("======================================")
    for (i <- List(
      List(2, 45, 62, 17, 56, 91),
      List(1, 2, 3),
      List(1, 2),
      List(1)
    )) {
      i match {
        case one :: two :: rest => println(s"first: $one \t second: $two \t rest: $rest")
        case _ => println("something else")
      }
    }
    println("==================================")
    /*
    first: 2 	 second: 45 	 rest: List(62, 17, 56, 91)
    first: 1 	 second: 2 	 rest: List(3)
    first: 1 	 second: 2 	 rest: List()
    something else
     */

    println("=========================")
    // 5. 匹配元组
    for (tuple <- List(
      (0, 0),
      (0, 1),
      (1, 0),
      (1, 1),
      (1, 0, 2),
      ("hello", 1, 0.5)
    )) {
      val result = tuple match {
        case (0, _) => "0,_"
        case (y, 0) => y + " ,0"
        case (a, b) => "二元组"
        case (_, 1, b) => "_, 1, " + b
        case _ => "其他"
      }
      println(result)
    }
  }
}
