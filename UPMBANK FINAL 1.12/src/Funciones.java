public class Funciones {

    //Funcion para mostrar el menú principal
    public static void menu() {
        System.out.println("\n\nSeleccione una opción del menú:");
        System.out.println("1. Dar de alta un nuevo cliente");
        System.out.println("2. Crear una cuenta bancaria");
        System.out.println("3. Realizar un depósito en una cuenta");
        System.out.println("4. Realizar una extracción de una cuenta");
        System.out.println("5. Realizar una transferencia bancaria");
        System.out.println("6. Solicitar un préstamo hipotecario");
        System.out.println("7. Ver los datos de un Cliente");
        System.out.println("0. Salir");
    }


    //Funcion que comprueba la fecha introducida, inculuso si el año es bisiesto
    public static boolean ComprobarYear(int dia, int mes, int year) {
        boolean yearbien=false;

        if ((year > 0 && year <= 2021) && (mes > 0 && mes <= 12)) {
            if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && (dia>=1 && dia <= 31)) {
                yearbien=true;
            } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia>=1 && dia <= 30)) {
                yearbien=true;
            } else if (((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) && (dia>=1 && dia <= 29)) {
                yearbien=true;
            } else if (((year % 4 != 0) && ((year % 100 == 0) || (year % 400 != 0))) && (dia>=1 && dia <= 28)) {
                yearbien=true;
            } else {
                System.out.println("La fecha introducida es inválida, vuelva a introducirla.");
            }
        } else {
            System.out.println("La fecha introducida es inválida, vuelva a introducirla");
        }
        return yearbien;
    }


    public static boolean comprobarCuenta(char tcuenta) {
        boolean tipocorreco = false;
        if (tcuenta == 'A' || tcuenta == 'C' || tcuenta == 'R') {
            tipocorreco = true;
        } else {
            System.out.println("El tipo de cuenta introducido no es válido");
        }
        return tipocorreco;
    }

    //Generar digito de control
    public static int GenerarC1( int b4, int b3, int b2, int b1, int a4, int a3, int a2, int a1) {
        int r1;
        int c1 = 0;
        r1 = (11 - ((6 * b4 + 3 * b3 + 7 * b2 + 9 * b1 + 10 * a4 + 5 * a3 + 8 * a2 + 4 * a1) / 11));
        if (r1 <= 10 && r1 > 0) {
            c1 = r1;
        } else if (r1 == 11) {
            c1 = 0;
        } else if (r1 == 0) {
            c1 = 1;
        }
        return c1;
    }

    public static int GenerarC2( int d1, int d2, int d3, int d4, int d5, int d6, int d7, int d8, int d9, int d10) {
        int r2;
        int c2 = 0;
        r2 = (11 - ((d1 + 2 * d2 + 4 * d3 + 8 * d4 + 5 * d5 + 10 * d6 + 9 * d7 + 7 * d8 + 3 * d9 + 6 * d10) / 11));
        if (r2 <= 10 && r2 > 0) {
            c2 = r2;
        } else if (r2 == 11) {
            c2 = 0;
        } else if (r2 == 0) {
            c2 = 1;
        }
        return c2;
    }



    //Submenú cliente (Opción 7)
    public static void menuCliente() {
        System.out.println("\nSeleccione una opción del menú:");
        System.out.println("1. Ver datos completos de la cuenta");
        System.out.println("2. Visualizar últimos movimientos");
        System.out.println("3. Visualizar prestamos activos");
        System.out.println("0. Salir");
    }

}
