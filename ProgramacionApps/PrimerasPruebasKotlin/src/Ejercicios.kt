fun main() {
    ejercicio01()
    ejercicio02()
    ejercicio03()
    ejercicio04()
    ejercicio05()
    ejercicio06()
//    ejercicio07()
}
fun ejercicio01() {
    var n1=10
    var n2=5
    println("Suma : ${n1+n2}")
    println("Resta : ${n1-n2}")
    println("Multiplicacion : ${n1*n2}")
    println("divisio : ${n1/n2}")
}
fun ejercicio02() {
    var nombre = "Lucia"
    println("Bienvenido, $nombre")
}
fun ejercicio03() {
    println("indicame tu nombre")
    var nombre =readln()
    println("Bienvenido $nombre")
}
fun ejercicio04() {
    println("Indicame un numero")
    var num1=readln().toInt()
    println("Indicame otro numero")
    var num2=readln().toInt()
    if (num1 > num2){
        println("el numero $num1 es mayor")
    }else if (num1 < num2){
        println("el numero $num1 es menor")
    }else{
        println("el numero $num2 y $num1 son iguales")
    }
}
fun ejercicio05() {
    println("Ingrese un numero")
    var num= readln().toInt()
    if (num %2== 0){
        println("El numero $num es divisible entre 2")
    }else
        println("El numero $num no es divisible entre 2")
}
fun ejercicio06() {
    val op="""
        ¿Cual es la capital de colombia?
        a.La paz
        b.Buenos Aires
        c.La Habana
        d.Bogota
        
    """.trimIndent()
    print(op)
    var respuesta=readln()
    while (respuesta!="d"){
        println(op)
        respuesta=readln()
    }
    println("Felicitaciones!")
}