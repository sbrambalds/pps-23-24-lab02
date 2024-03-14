package task2.task2a

object Main extends App: 

    val positive: Int => String = _ match
        case n if n >= 0 => "Positive"
        case _ => "Negative"

    def isPositive(n: Int): String = n match
        case _ => positive(n)
    
    def neg[A](pred: A => Boolean): A => Boolean = !pred(_) // i => !f(g(i))
    
    val empty: String => Boolean = _ == ""
    val notEmpty = neg(empty) // which type of notEmpty?
    println(notEmpty("foo")) // true
    println(notEmpty("")) // false
    println(notEmpty("foo") && !notEmpty("")) // true.. a comprehensive test

    val pos: Int => Boolean = _ >= 0
    val notPositive = neg(pos)
    println(notPositive(-2)) // true
    println(notPositive(5)) // false
    println(notPositive(-3) && !notPositive(5)) // true.. a comprehensive test

end Main
