package com.example.ejercicio9panatallaresumen
import kotlin.math.roundToInt
import kotlin.random.Random
class Mochila(private var pesoMochila: Int){
    private var contenido=ArrayList<Articulo>()

    fun getPesoMochila():Int{
        return pesoMochila
    }
    fun addArticulo(articulo:Articulo){
        if (articulo.getPeso()<=pesoMochila){
            contenido.add(articulo)
            this.pesoMochila-=articulo.getPeso()
        }else{
            println("La mochila está llena, debes vender artículos")
        }
        println("Peso restante de la Mochila: "+pesoMochila)

    }
    fun getContenido(): ArrayList<Articulo> {
        return contenido
    }
    fun getSice ():Int{
        return contenido.size
    }
    fun findObjeto(id: String):Int{
        for((indice,item) in contenido.withIndex()){
            if (item.getId() == id) {
                return indice
            }
        }
        return -1
    }
    fun valor ():Int{
        var valor = 0
        if (!contenido.isEmpty()){
        repeat( contenido.size){
            valor =+ contenido[it].getValor()
        }}
        return valor
    }
}
class Dado1() {

    private var numMin=1
    private var numMax=6

    fun tirada (): Int {
        return Random.nextInt(numMin, numMax)
    }
}
class Articulo (private var id:String, private var peso:Int, private var valor:Int, private var vida:Int){

    fun getVida():Int{
        return vida
    }
    fun getPeso():Int{
        return peso
    }
    fun getValor():Int{
        return valor
    }
    fun getId():String{
        return id
    }
    override fun toString(): String {
        return "[ID:$id, Peso:$peso, Valor:$valor]"
    }
}
class Personaje(
    private var nombre: String,
    private var pesoMochila: Int,
    private var estadoVital: String,
    private var raza: String,
    private var clase: String,

    ) {
    var fuerza = 0.0
    var defensa= 0.0
    var suerte = 0.0
    var vida = 0.0
    var victorias = 0

    private var mochila=Mochila(pesoMochila)
    var monedero = HashMap<Int, Int>()

    fun getSice ():Int{
        return mochila.getSice()
    }
    init {
        monedero.put(1, 0)
        monedero.put(5, 0)
        monedero.put(10, 0)
        monedero.put(25, 0)
        monedero.put(100, 0)
    }
    fun añadirArticulo(articulo:Articulo){
        mochila.addArticulo(articulo)
    }
    fun getNombre():String{
        return nombre
    }
    fun setNombre(nombre:String){
        this.nombre=nombre
    }
    fun getEstadoVital():String{
        return estadoVital
    }
    fun setEstadoVital(estadoVital:String){
        this.estadoVital=estadoVital
    }
    fun getRaza():String{
        return raza
    }
    fun setRaza(raza:String){
        this.raza=raza
    }
    fun getClase():String{
        return clase
    }
    fun setClase(clase:String){
        this.clase=clase
    }
    fun getMochila(): Mochila {
        return this.mochila
    }
    fun puntos (){
        fuerza += sumar()
        defensa += sumar()
        suerte += sumar()
        vida = ((10 +(defensa-10)/2) - 0.001).roundToInt().toDouble()
    }
    fun sumar ():Double{
        var dado = Dado1()
        var guardar = Array(4) { dado.tirada() }
        guardar.sortDescending()
        var suma = guardar.sum() - guardar[3]
        return suma.toDouble()

    }
    fun total():Int{
        return mochila.valor()
    }
    fun comercio (){
        var total = 0
        total = mochila.valor()
        total =+ 10 * victorias

    }
    fun luchar (personaje: Personaje){
        var dado = Dado1()
        var dado1 =0
        var dado2 = 0
        var vida1 = vida
        var vida2 = personaje.vida
        println("Te has encontrado por el camino con tu nemesisi")
        println("Que deseas hacer luchar o huir?")
        var opcion = readln()
        if (opcion=="luchar"){
            println("Comienza la lucha con ${personaje.nombre}")
            dado1 = dado.tirada() * fuerza.toInt()
            dado2 = dado.tirada() * personaje.fuerza.toInt()
            if (dado1<dado2)
                mochila.addArticulo(Articulo("articulo",1,100,10))
            else
                println("Te han noqueado")
        }
        else
            println("Has huido")
    }
    fun cifrado(mensaje : String, ROT : Int) : String{
        val abecedario : ArrayList<Char> = "abcdefghijklmnñopqrstuvwxyz".toList() as ArrayList<Char>
        var stringInv = ""
        var indice = 0

        for(i in mensaje.lowercase().toList() as ArrayList<Char>){
            if(!i.isLetter() || i.isWhitespace()){
                stringInv += i
            } else{
                indice = abecedario.indexOf(i) + ROT
                if (indice >= abecedario.size) {
                    indice -= abecedario.size
                    stringInv += abecedario[indice]
                } else
                    stringInv += abecedario[indice]
            }
        }
        return stringInv.filter { !it.isWhitespace() && it.isLetter() }
    }
    fun comunicacion(mensaje:String){
        var respuesta=""
        when(estadoVital){
            "Adulto"->{
                if (mensaje.equals("¿Como estas?"))
                    respuesta="En la flor de la vida, pero me empieza a doler la espalda"
                else
                    if ((mensaje.contains('?') || mensaje.contains('¿')) && mensaje == mensaje.uppercase())
                        respuesta="Estoy buscando la mejor solución"
                    else
                        if (mensaje == mensaje.uppercase())
                            respuesta="No me levantes la voz mequetrefe"
                        else
                            if (mensaje == nombre)
                                respuesta="¿Necesitas algo?"
                            else
                                if(mensaje== "Hasta la proxima jugadores")
                                    respuesta == "Un placer servirte"
                                else
                                    respuesta="No sé de qué me estás hablando"
            }
            "Joven"->{
                if (mensaje.equals("¿Como estas?"))
                    respuesta="De lujo"
                else
                    if ((mensaje.contains('?') || mensaje.contains('¿')) && mensaje == mensaje.uppercase())
                        respuesta="Tranqui se lo que hago"
                    else
                        if (mensaje == mensaje.uppercase())
                            respuesta="Eh relájate"
                        else
                            if (mensaje == nombre)
                                respuesta="Qué pasa?"
                            else
                                if(mensaje== "Hasta la proxima jugadores")
                                    respuesta == "Un placer servirte"
                                else
                                    respuesta="Yo que se"

            }
            "Anciano"->{
                if (mensaje.equals("¿Como estas?"))
                    respuesta="No me puedo mover"
                else
                    if ((mensaje.contains('?') || mensaje.contains('¿')) && mensaje == mensaje.uppercase())
                        respuesta="Que no te escucho!"
                    else
                        if (mensaje == mensaje.uppercase())
                            respuesta="Háblame más alto que no te escucho"
                        else
                            if (mensaje == nombre)
                                respuesta="Las 5 de la tarde"
                            else
                                if(mensaje== "Hasta la proxima jugadores")
                                    respuesta == "Un placer servirte"
                                else
                                    respuesta="En mis tiempos esto no pasaba"
            }
        }
        when(raza){
            "Elfo"-> println(cifrado(respuesta, 1))
            "Enano"-> println(respuesta.uppercase())
            "Goblin"-> println(cifrado(respuesta, 1))
            else -> println(respuesta)
        }
    }
    fun vender(mercader:Personaje, articulo: Articulo) {
        var id: String
        var posicion: Int
        if (!mercader.clase.equals("Mercader"))
            print("No soy un Mercader")
        else {
            if(this.mochila.getContenido().size!=0){
                println("Tienes ${this.mochila.getContenido().size} objetos")
                mochila.getContenido().forEach { println(it) }
                posicion=mochila.findObjeto(articulo.getId())
                if(posicion!=-1){
                    println("Movemos el artículo al mercader")
                    mercader.mochila.addArticulo(mochila.getContenido()[posicion])
                    println("Convertimos el artículo en monedas")
                    cashConverter(mochila.getContenido()[posicion])
                    println("Eliminamos el artículo del jugador principal")
                    this.mochila.getContenido().remove(mochila.getContenido()[posicion])
                }else println("No hay ningún objeto con ese ID")

            }else println("No tienes objetos para vender")

            println("Te quedan ${this.mochila.getContenido().size} objetos")
            println("Hasta pronto")
        }
    }
    fun cashConverter(articulo: Articulo){
        var total = 0
        var i = 0
        var coins = arrayListOf(1, 5, 10, 25, 100)
        coins.sortDescending()

        while(total < articulo.getValor() && i < coins.size) {
            if (total + coins[i] <= articulo.getValor()) {
                total += coins[i]
                monedero[coins[i]] = monedero[coins[i]]!! + 1
            } else
                i++
        }
    }

}