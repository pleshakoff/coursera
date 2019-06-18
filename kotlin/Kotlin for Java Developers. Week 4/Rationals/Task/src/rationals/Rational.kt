package rationals

import java.lang.Math.abs
import java.math.BigInteger
import kotlin.math.abs

class Rational(num:BigInteger,den:BigInteger):Comparable<Rational>{


    override fun compareTo(other: Rational): Int {
        return (numerator * other.denominator - other.numerator * denominator).signum()
    }

    val numerator:BigInteger
    val denominator:BigInteger

    init {
        require(den!=BigInteger.ZERO)
        val gcd = num.gcd(den);
        val sign = den.signum().toBigInteger()
        numerator = num/gcd*sign
        denominator = den/gcd*sign
    }

    override fun toString(): String {
        return numerator.toString() + if(denominator!= BigInteger.ONE) "/$denominator" else ""
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rational

        if (numerator != other.numerator) return false
        if (denominator != other.denominator) return false

        return true
    }

    override fun hashCode(): Int {
        var result = numerator.hashCode()
        result = 31 * result + denominator.hashCode()
        return result
    }


}

infix fun Int.divBy(x: Int): Rational {
   return Rational(this.toBigInteger(),x.toBigInteger())
}

infix fun Long.divBy(x: Long): Rational {
    return Rational(this.toBigInteger(),x.toBigInteger())
}

infix fun BigInteger.divBy(x: BigInteger): Rational {
    return Rational(this,x)
}

fun String.toRational():Rational{
    val split = this.split("/")
    return Rational(split[0].toBigInteger(),if(split.size == 2)split[1].toBigInteger() else BigInteger.ONE)
    }

operator fun Rational.plus(other: Rational):Rational{
    return Rational(this.denominator*other.numerator+other.denominator*this.numerator,this.denominator*other.denominator)
}

operator fun Rational.minus(other: Rational):Rational{
    return Rational(other.denominator*this.numerator-this.denominator*other.numerator,this.denominator*other.denominator)
}

operator fun Rational.times(other: Rational):Rational{
    return Rational(this.numerator*other.numerator,this.denominator*other.denominator)
}

operator fun Rational.div(other: Rational):Rational{
    return Rational(this.numerator*other.denominator,this.denominator*other.numerator)
}

operator fun Rational.unaryMinus():Rational{
    return Rational(this.numerator*(-1).toBigInteger(),this.denominator)
}







fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)
}