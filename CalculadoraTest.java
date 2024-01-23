import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.*;

public class CalculadoraTest {

    private Calculadora<String> calculadora;

    /**
     * Prueba el resultado de la suma.
     */
    @Test
    public void sumTestResult() {
        // Se crea una instancia de CustomStack con dos operandos
        CustomStack<String> stack = new CustomStack<>();
        stack.push("2");
        stack.push("3");

        // Se crea una instancia de Calculadora pasándole el stack preparado
        Calculadora<String> calculadora = new Calculadora<>(stack);

        // Se llama al método sumar y se verifica el resultado
        int resultado = calculadora.sumar();

        // Verificación de que la suma se realiza correctamente
        assertEquals(5, resultado);
    }

    /**
     * Prueba el resultado de la resta.
     */
    @Test
    public void substractionTestResult() {
        // Se crea una instancia de CustomStack con dos operandos
        CustomStack<String> stack = new CustomStack<>();
        stack.push("2");
        stack.push("3");

        // Se crea una instancia de Calculadora pasándole el stack preparado
        Calculadora<String> calculadora = new Calculadora<>(stack);

        // Se llama al método sumar y se verifica el resultado
        int resultado = calculadora.resta();

        // Verificación de que la suma se realiza correctamente
        assertEquals(1, resultado);
    }

    /**
     * Prueba el resultado de la división.
     */
    @Test
    public void divisionTest() {
        CustomStack<String> stack = new CustomStack<>();
        stack.push("6");
        stack.push("2");

        calculadora = new Calculadora<>(stack);

        boolean resultado = calculadora.division();

        assertTrue(resultado);

        assertEquals("3", calculadora.getStack().popAsString());
    }
}