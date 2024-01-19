import java.io.BufferedReader;
import java.io.FileReader;

public class Calculadora<T> implements ICalculadora {

    private CustomStack stack = new CustomStack<>();
    private boolean error = false;

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
            System.out.println(stack.lastNode.getValue());
        } else {
            //System.out.println("Error, No es posible dentro de CERO");
        }
    }

    @Override
    public void sumar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sumar'");
    }

    @Override
    public void resta() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resta'");
    }

    public void multiplicacion() {
        T operandoA = (T) stack.pop();
        T operandoB = (T) stack.pop();
        int resultado = Integer.parseInt(String.valueOf(operandoA)) * Integer.parseInt(String.valueOf(operandoB));
        stack.push(resultado);
    }

    @Override
    public boolean division() {
        try {
            T operandoA = (T) stack.pop();
            T operandoB = (T) stack.pop();

            int resultado = Integer.parseInt(String.valueOf(operandoA)) / Integer.parseInt(String.valueOf(operandoB));
            stack.push(resultado);
            return true;
        } catch (Exception e) {
            System.out.println("Error, No es posible dividir dentro de cero");
            return false;
        }
    }

    @Override
    public boolean isNumeric(String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isNumeric'");
    }

}
