package com.atguigu.scala.chapter05

/**
 * 注意：
 *  1. 当Lambda表示用_表示参数时，外面不能再有包装，否则会报错。
 *  2. 当Lambda表示用_表示参数时, Lambda表达式的参数列表必须省略
 *  3. Lambda表达式使用 _ 的前提时，参数类型明确的，且参数只出现一次，每个参数只能一次_，且必须按照顺序。
 *  4. 当使用函数嵌套时，内存函数名依次为foo，bar显得专业。且函数返回值尽量使用类型推导，避免出错。
 *  5. 如果函数嵌套，且返回值是函数时，当指明函数的返回值为函数类型，不能再使用_表示函数是一个整体。
 *
 * @author chenhuiup
 * @create 2020-09-14 14:36
 */
object Test08_Practise {
  def main(args: Array[String]): Unit = {
    //1.实现一个三参数（Int，String，Char）函数，返回一个Boolean
    //要求：f(0,"",'')得到false，其他情况得到true

    val f1 = (a: Int, b: String, c: Char) => {
      if (a == 0 && b == "" && c == '0') false else true
    }

    val f2: (Int, String, Char) => Boolean = (a, b, c) => {
      if (a == 0 && b == "" && c == '0') false else true
    }

    val f3: (Int, String, Char) => Boolean = (a, b, c) => a != 0 || b != "" || c != '0'

    //当lambda表达式在参数类型明确的前提下，参数只出现一次，可以省略参数列表和 =>,并用_表示参数，按照顺序一一匹配
    val f4: (Int, String, Char) => Boolean = _ != 0 || _ != "" || _ != '0'

    println(f2(0, "", '0'))
    println(f2(0, "", '1'))
    println(f2(10, "", '0'))
    println(f2(0, "hello", '0'))

    //2.实现一个高阶函数，多次调用时返回一个Boolean
    //要求：f(0)("")('0')得到false
    def f5(a: Int) = {
      def foo(b: String) = {
        def bar(c: Char) = {
          if (a == 0 && b == "" && c == '0') false else true
        }

        bar _
      }

      foo _
    }

    def f6(a: Int): String => Char => Boolean = {
      def foo(b: String): Char => Boolean = {
        def bar(c: Char): Boolean = {
          if (a == 0 && b == "" && c == '0') false else true
        }

        bar
      }

      foo
    }

    println(f5(0)("")('0'))
    println(f5(1)("")('0'))
    println(f5(0)("")('1'))
    println(f5(0)("hello")('0'))

    val f7: Int => String => Char => Boolean =
      i => s => c => !(i == 0 && s == "" && c == '0')

    def f8(a: Int)(b: String)(c: Char): Boolean = {
      !(a == 0 && b == "" && c == '0')
    }

    println(f8(0)("")('0'))
    println(f8(1)("")('0'))
    println(f8(0)("")('1'))
    println(f8(0)("hello")('0'))

  }

}
