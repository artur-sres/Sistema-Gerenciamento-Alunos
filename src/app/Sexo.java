package app;

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
