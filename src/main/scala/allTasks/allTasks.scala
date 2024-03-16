package allTasks

class allTasks:
    // Task 1:
    object Main extends App:

        print("Hello, Scala")

    end Main

    // Task 2a:
    val positive: Int => String = _ match
        case n if n >= 0 => "Positive"
        case _ => "Negative"

    def isPositive(n: Int): String = n match
        case _ => positive(n)
    
    def neg[A](pred: A => Boolean): A => Boolean = !pred(_) 

    // Task 2b:
    val p1: Int => Int => Int => Boolean = x => y => z => (x <= y && y == z)
    val p2: (Int, Int, Int) => Boolean = (x: Int, y: Int, z: Int) => (x <= y && y == z)

    def p3(x: Int)(y: Int)(z: Int): Boolean = (x <= y && y == z)
    def p4(x: Int, y: Int, z: Int): Boolean = (x <= y && y == z)

    def composeInt(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
    
    def compose[A, B, C](f: B => C, g: A => B): A => C = x => f(g(x))

    // Task 3:
    def gcd(a: Int, b: Int): Int = b match // this is the tail-recursive version of the funcion, i didn't know how to do it using normal recursion
        case 0 => a
        case i if b < a => gcd(b, a % b)
        case i if b > a => gcd(a, b % a)

    // Task 4, using TDD:
    enum Shape: 
        case Rectangle(height: Double, width: Double)
        case Circle(radius: Double)
        case Square(side: Double)

    def perimeter(shape: Shape): Double = shape match
        case Shape.Rectangle(h,w) => (h*2) + (w*2)
        case Shape.Circle(r) => 2*Math.PI*r
        case Shape.Square(s) => s*4

    def scale(shape: Shape, alpha: Double): Shape = shape match
        case Shape.Rectangle(h,w) => Shape.Rectangle(h*alpha,w*alpha)
        case Shape.Circle(r) => Shape.Circle(r*alpha)
        case Shape.Square(s) => Shape.Square(s*alpha)

    val alpha = 0.5

    val side = 4.5
    val radius = 3.3
    val width = 7.6
    val height = 5.2

    val rect: Shape = Shape.Rectangle(width, height)
    val square: Shape = Shape.Square(side)
    val circle: Shape = Shape.Circle(radius)

    @Test def testCreateShape() = {
        assertNotNull(rect)
        assertNotNull(circle)
        assertNotNull(square)
    }

    @Test def testPerimeter() = {
        val delta = 1e-15 // necessary for assertion with Double types
        val rectPerimeter: Double = (height*2) + (width*2)
        val circlePerimeter: Double = Math.PI*2*radius
        val squarePerimeter: Double = side*4

        assertEquals(rectPerimeter, perimeter(rect), delta) 
        assertEquals(squarePerimeter, perimeter(square), delta) 
        assertEquals(circlePerimeter, perimeter(circle), delta) 
    }

    @Test def testScale() = {
        val scaledRect: Shape = Shape.Rectangle(alpha*width, alpha*height)
        val scaledSquare: Shape = Shape.Square(side*alpha)
        val scaledCircle: Shape = Shape.Circle(radius*alpha)

        assertEquals(scaledRect, scale(rect, alpha))
        assertEquals(scaledSquare, scale(square, alpha))
        assertEquals(scaledCircle, scale(circle, alpha))
    }

    // Task 5:
    def map[A, B](optional: Optional[A], f: A => B): Optional[B] = optional match 
      case Maybe(value) => Optional.Maybe(f(value))
      case Empty() => Empty()

    def filter[A](optional: Optional[A])( f: A => Boolean): Optional[A] = optional match // i used TDD approach (as following) to do this function
      case Optional.Maybe(value) if f(value) => Optional.Maybe(value)
      case _ => Optional.Empty()
    
    @Test def filterShouldReturnFilteredValue(): Unit = {
        val nonEmpty = Optional.Maybe(5)
        val filteredEmpty = Optional.Empty()
        val filteredNotEmpty = Optional.Maybe(5)

        assertEquals(filteredEmpty, Optional.filter(nonEmpty)(_ > 5))
        assertEquals(filteredNotEmpty, Optional.filter(nonEmpty)(_ < 10))
    }

    @Test def filterShouldReturnEmptyIfOptionalIsEmpty(): Unit = {
        val empty = Optional.Empty()

        assertEquals(Optional.Empty(), Optional.filter(empty)( _ => true))
    }
