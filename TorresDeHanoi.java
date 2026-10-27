public class TorresDeHanoi {

    private static long movimentos = 0;

    public static void hanoi(int n, char origem, char destino, char auxiliar, boolean imprimirPassos) {
        if (n == 1) {
            movimentos++;
            if (imprimirPassos) {
                System.out.println("Mover disco 1 da estaca " + origem + " para " + destino);
            }
            return;
        }

        hanoi(n - 1, origem, auxiliar, destino, imprimirPassos);

        movimentos++;
        if (imprimirPassos) {
            System.out.println("Mover disco " + n + " da estaca " + origem + " para " + destino);
        }

        hanoi(n - 1, auxiliar, destino, origem, imprimirPassos);
    }

    
    public static void executarInstancia(int qtdDiscos, boolean imprimirPassos) {
        movimentos = 0;
        System.out.println("==========================================");
        System.out.println("Executando para " + qtdDiscos + " disco(s)...");

        long inicio = System.currentTimeMillis();
        hanoi(qtdDiscos, 'A', 'C', 'B', imprimirPassos);
        long fim = System.currentTimeMillis();

        long duracaoMilis = fim - inicio;

        long horas = duracaoMilis / 3600000;
        long minutos = (duracaoMilis % 3600000) / 60000;
        long segundos = (duracaoMilis % 60000) / 1000;
        long milissegundos = duracaoMilis % 1000;

        String tempoFormatado = String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, milissegundos);

        System.out.println("Quantidade de movimentos: " + movimentos);
        System.out.println("Tempo de execução (HH:MM:SS:mm): " + tempoFormatado);
    }
}