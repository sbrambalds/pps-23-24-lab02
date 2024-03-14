package task3

object Main extends App:

    @annotation.tailrec
    def gcd(a: Int, b: Int): Int = b match
        case 0 => a
        case i if b < a => gcd(b, a % b)
        case i if b > a => gcd(a, b % a)

    println(gcd(12,8))
    println(gcd(14,7))

end Main
