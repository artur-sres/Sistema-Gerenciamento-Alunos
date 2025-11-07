package app;

/**
 * Enumeração que representa os sexos possíveis (M/F) e utilidades de conversão.
 * @author Artur Saraiva Rabelo (asr.engsoft@gmail.com)
 * @version 1.0
 * @since 2025-11-03
 */
public enum Sexo {
    M,
    F;

    public static Sexo converterParaSexo(int valor) {
        switch (valor) {
            case 0:
                return Sexo.M; 
            case 1:
                return Sexo.F; 
            default:
                throw new IllegalArgumentException("Valor de sexo inválido: " + valor);
        }
    }
}
