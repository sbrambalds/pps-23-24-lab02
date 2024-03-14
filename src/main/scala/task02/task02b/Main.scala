package task02.task02b

object Main extends App:

    val p1: Int => Int => Int => Boolean = x => y => z => (x <= y && y == z)
    val p2: (Int, Int, Int) => Boolean = (x: Int, y: Int, z: Int) => (x <= y && y == z)
    def p3(x: Int)(y: Int)(z: Int): Boolean = (x <= y && y == z)
    def p4(x: Int, y: Int, z: Int): Boolean = (x <= y && y == z)

    // test p1
    println(p1(2)(2)(2)) //true
    println(p1(7)(6)(6)) //false

    // test p2
    println(p2(2,2,2)) // true
    println(p2(7,6,6)) // false

    // test p3
    println(p3(2)(2)(2)) //true
    println(p3(7)(6)(6)) //false

    // test p4
    println(p4(2,2,2)) //true
    println(p4(7,6,6)) //false

    def composeInt(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
    
    def compose[A, B, C](f: B => C, g: A => B): A => C = x => f(g(x))

    println(compose[Int, Boolean, Double]({if _ then 2.2 else 3.4}, _ > 0)(5))
  
end Main
