package task4

object Main extends App:

    enum Shape: 
        case Rectangle(height: Double, width: Double)
        case Circle(radius: Double)
        case Square(side: Double)

    def perimeter(shape: Shape): Double = shape match
        case Shape.Rectangle(h,w) => h*w
        case Shape.Circle(r) => 2*Math.PI*r
        case Shape.Square(s) => s*s

    def scale(shape: Shape, alpha: Double): Shape = shape match
        case Shape.Rectangle(h,w) => Shape.Rectangle(h*alpha,w*alpha)
        case Shape.Circle(r) => Shape.Circle(r*alpha)
        case Shape.Square(s) => Shape.Square(s*alpha)

    val rect: Shape = Shape.Rectangle(5,2)
    val circle: Shape = Shape.Circle(4)
    val square: Shape = Shape.Square(6)
    
    println(perimeter(rect))
    println(perimeter(scale(rect, 0.6)))

    println(perimeter(circle))
    println(perimeter(scale(circle, 0.6)))

    println(perimeter(square))
    println(perimeter(scale(square, 0.6)))

end Main
