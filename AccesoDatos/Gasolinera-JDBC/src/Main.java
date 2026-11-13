public class Main {
    public static void main(String[] args) {
        MigrarCSVToJson migracion = new MigrarCSVToJson();
        migracion.migrar();
        Menu.elegirOpcion();
    }
}