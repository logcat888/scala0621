package com.atguigu.scala.chapter05

/**
 * 1. 函数就是接收多个对象，对对象进行处理，返回一个对象。对象可以是任何类型，包含函数
 * 2. 定义了函数的形参为函数之后，使用Lambda表达式当做参数传入，可以根据类型推断，省略Lambda表达式的参数类型
 * 3. 当Lambda表达式当做函数的参数传递时，Lambda表达式当没有参数和参数超过1的永远不能省略参数列表的圆括号
 * 4. 当Lambda表达式当做函数的参数传递时，如果参数只出现一次，则参数省略且后面参数可以用_代替
 * 5. 当Lambda表达式当做函数的参数传递时，逻辑处理相同时，可以方法引用
 * 6. 当Lambda表达式当做函数的参数传递时，由于可以通过类型推断出参数类型，println(dualFunctionOneAndTwo(_ + _))
 * 7. fun(name => println(name)) 可以简化为 fun(println(_)) ，尽管效果和fun(println)相同，但是fun(println)属于方法引用
 * 8. val f12:String=>Unit = f _ //报错，因为变量已经指定了函数类型
 * 9. Lambda表达式参数列表的类型必须带上，因为函数体不能类型推断，当接收变量指定类型后，可以省略Lambda表达式的参数类型，可以类型推断。
 *
 * @author chenhuiup
 * @create 2020-09-14 21:06
 */
object Test05_Lambda {
  def main(args: Array[String]): Unit = {
    //定义一个匿名函数
    val f = (name: String) => println(name)
    f("赵丽颖")

    //定义一个以函数作为参数的函数
    def fun(f: (String) => Unit): Unit = {
      f("Dong")
    }

    val f11:String=>Unit = f
//    val f12:String=>Unit = f _
//    val f13:String=>Unit = f _
//    println("******************************")
//    println(f12 == f13)
//    println(f11 == f13)
//    println("******************************")

    fun(f) //Dong

    //匿名函数作为函数参数传入
    fun((name: String) => println(name))

    //匿名函数的简化
    //(1) 参数的类型可以省略，会根据形参进行自动的推导
    fun((name) => {
      println(name)
    })

    //2.类型省略之后，发现只有一个参数，则圆括号可以省略，其他情况：没有参数和参数超过1的永远不能省略圆括号。
    fun(name => {
      println(name)
    })

    //3.匿名函数如果只有一行，则大括号也能省略
    fun(name => println(name))

    //4.如果参数只出现一次，则参数省略且后面参数可以用_代替
    fun(println(_))

    //方法引用
    fun(println)
    println("----------------------------")

    //扩展：两个参数的函数
    def dualFunctionOneAndTwo(fun: (Int, Int) => Int): Int = {
      fun(1, 2)
    }

    val add = (a: Int, b: Int) => a + b
    //    val add1 = (a:Int,b:Int) => _ + _ //报错
    val minus = (a: Int, b: Int) => a - b

    println(dualFunctionOneAndTwo(add)) //3
    println(dualFunctionOneAndTwo(minus)) // -1

    dualFunctionOneAndTwo((a: Int, b: Int) => a + b)
    println(dualFunctionOneAndTwo((a, b) => a + b)) // 3
    //    println(dualFunctionOneAndTwo((a, b) => _ + _)) //报错
    println(dualFunctionOneAndTwo(_ + _)) // 3


  }
}
