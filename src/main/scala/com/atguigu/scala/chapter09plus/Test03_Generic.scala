package com.atguigu.scala.chapter09plus

/**
 * @author chenhuiup
 * @create 2020-09-20 17:07
 */
/*
1. 泛型上下限是针对泛型而言，规定了泛型的上下边界，但是对于类型来说，只有上限有约束作用，下限没有约束作用（可能是类型多态的原因，子类依旧可以传入）。
2. 上限文限定就是一个语法糖，def f[A : B](a: A) = println(a) //等同于def f[A](a:A)(implicit arg:B[A])=println(a)
  是将泛型和隐式参数结合在一起。
 */
object Test03_Generic {
  def main(args: Array[String]): Unit = {
    val father = new MyList01[Father]()
    val child = new MyList01[Child]()
    //MyList01[Child] 是 MyList01[Father]的子类
    println(child.isInstanceOf[MyList01[Father]]) //true


    val father02 = new MyList02[Father]()
    val child02 = new MyList02[Child]()
    val subChild02 = new MyList02[SubChild]()
    println(child02.isInstanceOf[MyList02[Father]]) //true
    println(subChild02.isInstanceOf[MyList02[Father]]) //true
    println(father02.isInstanceOf[MyList02[Child]]) //true
    println(father02.isInstanceOf[MyList02[SubChild]]) //true

//    val subChild021:MyList02[Father] = new MyList02[SubChild]() //error
    val subChild021:MyList02[SubChild] = new MyList02[Father]() //ok

    //他们之间没有关系
//    val test:MyList03[SubChild] = new MyList03[Father]() //error

    println("===============================")
    //泛型通配符之下限 形式扩展 ,没用
    def testLow[A>:Child](num:A)={
      println(num.getClass.getName)
    }

    // 泛型通配符之上限 形式扩展 ,有用
    def testHigh[A<:Child](num:A)={
      println(num.getClass.getName)
    }

    testLow(new SubChild) //ok
    testLow(new Father) //ok
    testLow(new Child) //ok

    testHigh(new SubChild) //ok
//    testHigh(new Father) //error
    testHigh(new Child) //ok

    //泛型通配符之下限
    def testGenericLow[A >: Child](a:Class[A]): Unit ={
      println(a)
    }

//    testGenericLow(classOf[SubChild]) //error
    testGenericLow(classOf[Child]) //ok

    //泛型通配符之上限
    def testGenericHigh[A <: Child](a:Class[A]): Unit ={
      println(a)
    }
//    testGenericHigh(classOf[Father])  //error
    testGenericHigh(classOf[Child]) //ok

//    implicit val x = 3
//    implicit val p = 1.0
//    val y = implicitly[Int]
//    val z = implicitly[Double]

    //A代表泛型，implicitly[Ordering[A]]代表获取Ordering[A]类型的隐式变量
    def f[A:Ordering](a:A,b:A) = implicitly[Ordering[A]].compare(a,b)

    println(f(1, 2)) // -1

    def f12[A](a: A, b: A)(implicit ord: Ordering[A]) = ord.compare(a, b)

    println(f12(5, 10)) // -1
    println(f12(15, 10)) // 1


  }
}

class Father

class Child extends Father

class SubChild extends Child

class MyList01[+T]

class MyList02[-T]

class MyList03[T]




