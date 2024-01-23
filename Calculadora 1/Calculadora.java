import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Implementación de una calculadora básica usando una pila personalizada.
 * 
 * @param <T> el tipo de elementos en la calculadora.
 */
public class Calculadora<T> implements ICalculadora {

    private CustomStack stack = new CustomStack<>();
    private boolean error = false;

    public Calculadora(CustomStack stack) {
        this.stack = stack;
    }

    public Calculadora() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String readTXT() {
        try (FileReader fr = new FileReader("./datos.txt")) {
            BufferedReader br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null)
                return linea;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void calculate() {
        String expresion = readTXT();

        // Elimina los espacios en blanco
        expresion = expresion.replaceAll("\\s", "");

        // Se recorre la expresión
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            String valornode = String.valueOf(caracter);
            if (isNumeric(valornode)) {
                stack.push(valornode);

            } else if (valornode.equals("+")) {
                sumar();

            } else if (valornode.equals("-")) {
                resta();

            } else if (valornode.equals("*")) {
                multiplicacion();

            } else if (valornode.equals("/")) {
                if (division() == false) {
                    error = true;
                    break;
                }

            } else {
                System.out.println("Este caracter no puede ser interpretado.");
                break;
            }

        }
        if (!error) {
            System.out.println();
            System.out.println("Resultado operación postfix: " + stack.lastNode.getValue());
            System.out.println();
        } else {
            System.out.println("Error, No es posible dentro de CERO");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int sumar() {
        if (stack.size() >= 2) {
            T operandoA = (T) stack.pop();
            T operandoB = (T) stack.pop();
            int resultado = Integer.parseInt(String.valueOf(operandoA)) + Integer.parseInt(String.valueOf(operandoB));
            stack.push(resultado);
            return resultado;
        } else {
            System.out.println("Error: Insuficientes operandos para la suma.");
            error = true;
        }
        return 0;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int resta() {
        if (stack.size() >= 2) {
            T operandoA = (T) stack.pop();
            T operandoB = (T) stack.pop();
            int resultado = Integer.parseInt(String.valueOf(operandoA)) - Integer.parseInt(String.valueOf(operandoB));
            stack.push(resultado);
            return resultado;
        } else {
            System.out.println("Error: Insuficientes operandos para la resta.");
            error = true;
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public int multiplicacion() {
        if (stack.size() >= 2) {
            T operandoA = (T) stack.pop();
            T operandoB = (T) stack.pop();
            int resultado = Integer.parseInt(String.valueOf(operandoA)) * Integer.parseInt(String.valueOf(operandoB));
            stack.push(resultado);
            return resultado;
        } else {
            System.out.println("Error: Insuficientes operandos para la multiplicación.");
            error = true;
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean division() {
        if (stack.size() >= 2) {
            try {
                T operandoA = (T) stack.pop();
                T operandoB = (T) stack.pop();

                int resultado = Integer.parseInt(String.valueOf(operandoB))
                        / Integer.parseInt(String.valueOf(operandoA));
                stack.push(resultado);
                return true;

            } catch (Exception e) {
                System.out.println("Error: No es posible dividir dentro de cero.");
                error = true;
                return false;
            }
        } else {
            System.out.println("Error: Insuficientes operandos para la división.");
            error = true;
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isNumeric(String value) {
        try {
            // Intenta convertir el string a un número
            Integer.parseInt(value);
            return true; // Si no hay excepción, el string es un valor numérico
        } catch (NumberFormatException e) {
            return false; // Si hay excepción, el string no es un valor numérico
        }
    }

    /**
     * Obtiene la pila utilizada por la calculadora.
     * 
     * @return La pila utilizada por la calculadora.
     */
    public CustomStack<T> getStack() {
        return stack;
    }
}