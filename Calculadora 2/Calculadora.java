import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implementación de la interfaz ICalc que realiza operaciones aritmeticas
 * utilizando una pila (stack) de enteros.
 */
public class Calculadora implements ICalculadora {

    /**
     * Pila (stack) utilizada para almacenar operandos.
     */
    private ICustomStack<Integer> stack = new CustomStack<>();

    /**
     * Constructor que recibe una pila (stack) como parámetro.
     *
     * @param stack La pila a utilizar para almacenar operandos.
     */
    public Calculadora(ICustomStack<Integer> stack) {
        this.stack = stack;
    }

    public Calculadora (){}

 /**
     * La función calculate procesa una expresión matemática en notación postfix
     * (postfija) utilizando la pila de enteros. La expresión debe estar formateada
     * con operadores y operandos separados por espacios.
     * Los operadores permitidos son: + (suma), - (resta), * (multiplicación), / (división).
     *
     * @throws IllegalArgumentException Si la expresión no contiene suficientes operandos
     * o si se encuentra un operador no válido.
     */
    public void calculate() {
        try {
            // Lee la expresión matemática desde una fuente (en este caso, método readTXT).
            String expresion = readTXT();

            // Divide la expresión en tokens separados por espacios.
            String[] tokens = expresion.split(" ");

            // Verifica que la expresión tenga al menos dos operandos y un operador.
            if (tokens.length < 3) {
                throw new IllegalArgumentException("Se necesitan al menos dos operandos y un operador.");
            }

            // Procesa cada token de la expresión.
            for (String token : tokens) {
                if (isNumeric(token)) {
                    // Si el token es un número, lo apila en la pila de operandos.
                    stack.push(Integer.parseInt(token));
                } else {
                    // Si el token es un operador, realiza la operación correspondiente y apila el resultado.
                    switch (token) {
                        case "+":
                            stack.push(sumar());
                            break;
                        case "-":
                            stack.push(resta());
                            break;
                        case "*":
                            stack.push(multiplicacion());
                            break;
                        case "/":
                            stack.push(division());
                            break;
                        default:
                            throw new IllegalArgumentException("Operador no válido: " + token);
                    }
                }
            }

            // Obtiene el resultado final de la expresión.
            Integer resultado = stack.pop();

            // Verifica si hay un exceso de operadores en la pila.
            if (stack.pop() != null) {
                throw new IllegalArgumentException("La expresión no tiene suficientes operadores.");
            }

            // Imprime la expresión y el resultado.
            System.out.println("Expresion: " + expresion);
            System.out.println("Resultado: " + resultado);

        } catch (ArithmeticException e) {
            // Captura y muestra excepciones aritméticas, como la división por cero.
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Captura y muestra excepciones relacionadas con argumentos no válidos en la expresión.
            System.out.println("Error: " + e.getMessage());
        }
    }





    /**
     * Realiza la operación de suma tomando dos operandos de la pila.
     *
     * @return El resultado de la suma.
     * @throws IllegalArgumentException Si faltan operandos para la suma.
     */
    public int sumar() {
        Integer operandoB = stack.pop();
        Integer operandoA = stack.pop();
        if (operandoA != null && operandoB != null) {
            return operandoA + operandoB;
        } else {
            throw new IllegalArgumentException("Faltan operandos para la suma.");
        }
    }

    /**
     * Realiza la operación de resta tomando dos operandos de la pila.
     *
     * @return El resultado de la resta.
     * @throws IllegalArgumentException Si faltan operandos para la resta.
     */
    public int resta() {
        Integer operandoB = stack.pop();
        Integer operandoA = stack.pop();
        if (operandoA != null && operandoB != null) {
            return operandoA - operandoB;
        } else {
            throw new IllegalArgumentException("Faltan operandos para la resta.");
        }
    }
    /*
     * Realiza la operación de resta tomando dos operandos de la pila.
     */
    public int multiplicacion() {
        Integer operandoB = stack.pop();
        Integer operandoA = stack.pop();
        if (operandoA != null && operandoB != null) {
            return operandoA * operandoB;
        } else {
            throw new IllegalArgumentException("Faltan operandos para la multiplicación.");
        }
    }
    
    /*
     * Realiza la operación de resta tomando dos operandos de la pila.
     */
    public int division() {
        Integer operandoB = stack.pop();
        Integer operandoA = stack.pop();
        if (operandoA != null && operandoB != null && operandoB != 0) {
            return operandoA / operandoB;
        } else {
            throw new IllegalArgumentException("Faltan operandos o división por cero.");
        }
    }

    @Override
    public String readTXT() {
        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
