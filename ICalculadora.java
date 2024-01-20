/**
 * Interfaz para una calculadora básica.
 */
public interface ICalculadora {
    /**
     * Realiza el cálculo basado en la expresión leída desde un archivo de texto.
     */
    public void calculate();

    /**
     * Suma dos operandos de la pila.
     */
    public void sumar();

    /**
    * Resta dos operandos de la pila.
    */
    public void resta();

    /**
     * Multiplica dos operandos de la pila.
     */
    public void multiplicacion();

    /**
     * Divide dos operandos de la pila.
     * 
     * @return true si la división es exitosa, false en caso contrario.
     */
    public boolean division();

    /**
     * Lee una expresión desde un archivo de texto.
     * 
     * @return la expresión leída desde el archivo.
     */
    public String readTXT();

    /**
     * Verifica si una cadena dada es numérica.
     * 
     * @param value la cadena a verificar.
     * @return true si la cadena es numérica, false en caso contrario.
     */
    public boolean isNumeric(String value);
} 