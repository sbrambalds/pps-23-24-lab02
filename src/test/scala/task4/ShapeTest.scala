package task4

import task4.Main.*
import org.junit.*
import org.junit.Assert.*

class ShapeTest :

    val delta = 1e-15 // necessary for assertion with Double types
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

end ShapeTest
