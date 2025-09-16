public class tablas {
    public static void main(String[] args) {
        System.out.println(ejercicio1(10));
}
public static int ejercicio1(int n){
    for (int i = 1; i < 10; i--) {
        int resultado = n * i;
        System.out.println(resultado);
    }
    return n;

}

}
