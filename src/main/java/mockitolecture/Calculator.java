package mockitolecture;

/**
 * verwende Mockito um ein Mock objekt der Calculator klasse
 * zu erstellen. Simuliere das Verhalten der add Methode,
 * sodass sie immer 10 zurückgibt, egal welche argumente.
 * Schreibe einen Testfall, der prüft das der mock korrekt ist.
 */
public class Calculator {

    int add(int a, int b){
        return a+b;
    }
}
