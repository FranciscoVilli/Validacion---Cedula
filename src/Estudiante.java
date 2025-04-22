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
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean CedulaValida() {
        return validarCedulaEcuatoriana(this.cedula);
    }

    private boolean validarCedulaEcuatoriana(String cedula) {
        if (cedula == null || cedula.length() != 10) {
            return false;
        }

        int provincia = Integer.parseInt(cedula.substring(0, 2));
        if (provincia < 1 || provincia > 24) {
            return false;
        }

        int tercerDigito = Character.getNumericValue(cedula.charAt(2));
        if (tercerDigito >= 6) {
            return false;
        }

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

    public boolean esExtranjero() {
        return !CedulaValida();
    }
}