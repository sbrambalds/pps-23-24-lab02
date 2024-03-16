package task4

object Main extends App:

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

end Main
