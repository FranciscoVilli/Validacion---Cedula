import java.util.HashMap;
import java.util.Map;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;
    private String correo;
    private String telefono;
    private String direccion;
    private String fechaNacimiento;


    public Estudiante(String nombre, String apellido, String cedula, int edad,
                      String correo, String telefono, String direccion, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }


    private boolean validarCedulaEcuatoriana(String cedula) {
        if (cedula == null || !cedula.matches("\\d{10}")) {
            return false;
        }
        // Se realiza la comprobación de los dos primeros dígitos de la cédula con respecto a los 30 códigos de provincia existentes
        // según los datos del registro civil.

        int provincia = Integer.parseInt(cedula.substring(0, 2));
        if (provincia < 1 || provincia > 24) {

            if (provincia != 30) {
                return false;
            }
        }
        // En el tercer digito comprobamos que este en el rango de 0 - 5
        int tercerDigito = Character.getNumericValue(cedula.charAt(2));
        if (tercerDigito >= 6) {
            return false;
        }
        // Se multiplican los primeros 9 dígitos por coeficientes alternos (2 y 1).
        // Si el resultado de una multiplicación es ≥ 10, se le resta 9.
        // Luego se suman todos los valores y se calcula el dígito verificador con: 10 - (suma % 10).
        // Si el resultado es 10, se convierte en 0.
        int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int suma = 0;

        for (int i = 0; i < coeficientes.length; i++) {
            int digito = Character.getNumericValue(cedula.charAt(i));
            int resultado = coeficientes[i] * digito;
            if (resultado >= 10) {
                resultado -= 9;
            }
            suma += resultado;
        }

        int digitoVerificador = Character.getNumericValue(cedula.charAt(9));
        int digitoCalculado = 10 - (suma % 10);
        if (digitoCalculado == 10) {
            digitoCalculado = 0;
        }

        return digitoVerificador == digitoCalculado;
    }

    public boolean CedulaValida() {
        return validarCedulaEcuatoriana(this.cedula);
    }

    public boolean esExtranjero() {
        return !CedulaValida();
    }

    public String getNombreProvincia() {
        int provinciaCodigo = Integer.parseInt(cedula.substring(0, 2));
        return obtenerNombreProvincia(provinciaCodigo);
    }

    private String obtenerNombreProvincia(int codigoProvincia) {
        // Mapa que relaciona el código de la provincia con su nombre
        Map<Integer, String> provincias = new HashMap<>();
        provincias.put(1, "Azuay");
        provincias.put(2, "Bolivar");
        provincias.put(3, "Cañar");
        provincias.put(4, "Carchi");
        provincias.put(5, "Cotopaxi");
        provincias.put(6, "Chimborazo");
        provincias.put(7, "El Oro");
        provincias.put(8, "Esmeraldas");
        provincias.put(9, "Guayas");
        provincias.put(10, "Imbabura");
        provincias.put(11, "Loja");
        provincias.put(12, "Los Rios");
        provincias.put(13, "Manabi");
        provincias.put(14, "Morona Santiago");
        provincias.put(15, "Napo");
        provincias.put(16, "Pastaza");
        provincias.put(17, "Pichincha");
        provincias.put(18, "Tungurahua");
        provincias.put(19, "Zamora Chinchipe");
        provincias.put(20, "Galapagos");
        provincias.put(21, "Sucumbios");
        provincias.put(22, "Orellana");
        provincias.put(23, "Santo Domingo de los Tsachilas");
        provincias.put(24, "Santa Elena");
        provincias.put(30, "Ecuatorianos residentes en el exterior");

        return provincias.get(codigoProvincia);
    }
}