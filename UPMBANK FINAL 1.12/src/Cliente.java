import java.util.Scanner;
import static java.lang.Math.pow;

public class Cliente {
    //Declaración de todas las variables globales
    //Datos Cliente
    static int dia=0,mes=0,year=0;
    static int DniN=0;
    //Datos Cuenta
    static char tcuenta='X';
    static int a1 = 9, a2 = 0, a3 = 1, a4 = 0,b1 = 0, b2 = 2, b3 = 0, b4 = 1,c1=0 , c2=0, d1=0, d2=0, d3=0, d4=0, d5=0, d6=0, d7=0, d8=0, d9=0, d10=0;
    static int DCTrans;
    static long NCTrans;
    static double SaldoCuenta=0,deposito=0,retirada=0,transferencia=0;
    static String Nombre="",Apellido="",DniL="",correo="";
    static int opciones2=1;
    static double CapitalSolicitado,CapitalPedido, Cuota, InteresM, InteresA, amortizado = 0, interes2 = 0;
    static int yearsP, mesesP, mesesAbonados = 0;
    static boolean clientecreado=false,g1,cuentacreada=false,g2;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Declaración de variables del main
        int opciones=1;

        while (opciones !=0) {
            Funciones.menu();
            opciones= teclado.nextInt();
            teclado.nextLine();
            switch (opciones) {

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                case 1:
                    g1= crearUsuario();
                    break;

                case 2:
                    if (g1){
                        g2=Crearcuenta();
                    }else {
                        System.out.println("Por favor, cree un cliente primero");
                    }

                    break;

                case 3:
                    if (g2){
                        fdeposito();
                    }else {
                        System.out.println("Por favor, cree una cuenta primero para realizar un depósito");
                    }

                    break;

                case 4:
                    if (g2) {
                        Fretirada();
                    }else {
                        System.out.println("Por favor, cree una cuenta primero para realizar una retirada");
                    }
                    break;

                case 5:
                    if (g2) {
                        ftransferencia();
                    }else {
                        System.out.println("Por favor, cree una cuenta primero para realizar una transferencia");
                    }
                    break;

                case 6:
                    if (g2) {
                        Prestamo();
                    }else {
                        System.out.println("Por favor, cree una cuenta primero para solicitar un prestamo");
                    }
                    break;

                case 7:
                    if (g2) {
                        opciones2 = 1;
                        ResumenCuenta();
                    }else {
                        System.out.println("Por favor, cree una cuenta primero para acceder al resumen de la cuenta.");
                    }
                    break;
            }
        }
    }


    //FUNCIONES

    //Función para crear cliente
    public static boolean crearUsuario (){
        Scanner teclado= new Scanner(System.in);

        System.out.print("\nIntroduzca el nombre del cliente:");
        Nombre = teclado.nextLine();
        System.out.print("Introduzca los apellidos del cliente:");
        Apellido = teclado.nextLine();
        do{
            System.out.print("Introduzca la fecha de nacimiento del cliente (dd mm aaaa):");
            dia = teclado.nextInt();
            mes = teclado.nextInt();
            year = teclado.nextInt();
            //Comprobación Fecha
        }while(!Funciones.ComprobarYear(dia,mes,year));
        System.out.print("Introduzca el DNI del cliente (Ej: 12345678 N):");
        DniN = teclado.nextInt();
        DniL = teclado.nextLine();
        System.out.print("Introduzca el correo electrónico del cliente (@upm.es o @alumnos.upm.es):");
        correo = teclado.nextLine();

        //Resumen datos cliente
        System.out.println("\n\nCliente creado correctamente:");
        System.out.println("---------------------------");
        System.out.println("Nombre y Apellidos: " + Nombre + " " + Apellido);
        System.out.println("Fecha de nacimiento: " + dia + "/" + mes + "/" + year);
        System.out.printf("DNI: %08d%s\n",DniN, DniL);
        System.out.println("Correo electrónico: " + correo);
        return clientecreado;
    }


    //Función para crear cuenta bancaria
    public static boolean Crearcuenta(){
        Scanner teclado = new Scanner(System.in);
        do {System.out.print("Introduzca el tipo de cuenta (Corriente (C), Ahorro (A) o Remunerada (R):");
        tcuenta = teclado.next().charAt(0);}
        while (!Funciones.comprobarCuenta(tcuenta));
        d1 = (int) Math.round(Math.random() * 9);
        d2 = (int) Math.round(Math.random() * 9);
        d3 = (int) Math.round(Math.random() * 9);
        d4 = (int) Math.round(Math.random() * 9);
        d5 = (int) Math.round(Math.random() * 9);
        d6 = (int) Math.round(Math.random() * 9);
        d7 = (int) Math.round(Math.random() * 9);
        d8 = (int) Math.round(Math.random() * 9);
        d9 = (int) Math.round(Math.random() * 9);
        d10 = (int) Math.round(Math.random() * 9);

        c1 = Funciones.GenerarC1(b4, b3, b2, b1, a4, a3, a2, a1);
        c2 = Funciones.GenerarC2( d1, d2, d3, d4, d5, d6, d7, d8, d9, d10);

        System.out.print("Introduzca la cantidad de dinero disponible (En euros):");
        SaldoCuenta = teclado.nextDouble();
        //Resumen datos cuenta bancaria
        System.out.println("\n\nCuenta creada correctamente.\nDatos de la cuenta:");
        System.out.println("---------------------------");
        System.out.println("Tipo de cuenta: " + tcuenta);
        System.out.println("Número de cuenta: " + a1 + a2 + a3 + a4 + " " + b1 + b2 + b3 + b4 + " " + c1 + c2 + " " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + d10);
        System.out.println("Saldo en la cuenta: " + SaldoCuenta + "€");
        return cuentacreada;
    }


    //Funcion de deposito de dinero
    public static void fdeposito(){
        Scanner teclado= new Scanner(System.in);
        //Ingreso de Dinero
        do{System.out.print("\n\nIntroduzca la cantidad a depositar (En €):");
        deposito= teclado.nextDouble();}
        while (deposito<=0);
        System.out.println("Importe a depostar: "+deposito+"€");
        SaldoCuenta=SaldoCuenta+deposito;
        System.out.println("Saldo actual en la cuenta: "+ SaldoCuenta+"€");
    }


    //Funcion de retirada de dinero
    public static void Fretirada(){
        Scanner teclado= new Scanner(System.in);
        //Retirada de Dinero
        do {System.out.print("\n\nIntroduzca la cantidad a retirar (En €):");
        retirada= teclado.nextDouble();}
        while (retirada<=0);
        System.out.println("Importe a retirar: "+retirada+"€");
        if (retirada>SaldoCuenta || SaldoCuenta<0){
            System.out.println("No dispone de suficiente saldo, volviendo al menú");
        }else{
            SaldoCuenta =SaldoCuenta-retirada;
            System.out.println("Saldo actual en la cuenta: "+ SaldoCuenta+"€");
        }
    }


    //Función de tranferencia entre cuentas
    public static void ftransferencia(){
        Scanner teclado= new Scanner(System.in);
        //Transferencia
        do {System.out.print("\n\nIntroduzca la cantidad de dinero a transferir (En €):");
        transferencia=teclado.nextDouble();}
        while (transferencia<=0);
        if (SaldoCuenta<0 || transferencia>SaldoCuenta){
            System.out.println("No dispone de suficiente saldo, volviendo al menú");
        }else {
            System.out.println("Introduzca el digito de control y el número de cuenta a la que desea realizar la tranferencia (00 0000000000):");
            DCTrans=teclado.nextInt();
            NCTrans=teclado.nextLong();
            SaldoCuenta=SaldoCuenta-transferencia;
            System.out.println("\nImporte a transferir: "+transferencia+"€");
            System.out.printf("Transferencia realizada correctamente a la cuenta: 9010 0201 %02d %010d \nSaldo actual en la cuenta : %.2f €",DCTrans,NCTrans,SaldoCuenta);
        }
    }

    //Funcion para el prestamo
    public static void Prestamo() {
        Scanner teclado = new Scanner(System.in);

        do {System.out.print("Introduzca la cantidad de dinero del préstamo (En €):");
        CapitalSolicitado = teclado.nextDouble();}
        while (CapitalSolicitado<=0);
        CapitalPedido=CapitalSolicitado;
        SaldoCuenta=SaldoCuenta+CapitalPedido;
        do {System.out.print("Introduzca el interes anual (0-100):");
        InteresA = teclado.nextDouble();}
        while (InteresA<0 || InteresA>100);
        InteresA = InteresA / 100;
        InteresM = InteresA / 12;
        do {System.out.print("Introduzca el número de años en los que se devolverá el prestamo:");
        yearsP = teclado.nextInt();}
        while (yearsP<0);
        mesesP = yearsP * 12;

        Cuota = CapitalSolicitado * InteresM * (pow(1 + InteresM, mesesP) / (pow(1 + InteresM, mesesP) - 1));
        System.out.println("\t\tPAGO MENSUAL\tINTERESES\tAMORTIZADO\tCAPITAL VIVO");
        System.out.printf("\n%3d \t%10.2f \t %10.2f \t%10.2f \t %10.2f", mesesAbonados, Cuota, interes2, amortizado, CapitalSolicitado);
        mesesAbonados++;
        while (mesesAbonados <= mesesP) {
            interes2 = CapitalSolicitado * InteresM;
            amortizado = Cuota - interes2;
            CapitalSolicitado = CapitalSolicitado - amortizado;
            System.out.printf("\n%3d \t%10.2f \t %10.2f \t%10.2f \t %10.2f", mesesAbonados, Cuota, interes2, amortizado, CapitalSolicitado);
            mesesAbonados++;
        }
    }

    //Función para mostrar el resumen de la cuenta
    public static void ResumenCuenta(){
        Scanner teclado= new Scanner(System.in);
        System.out.println("Información sobre la cuenta del cliente: "+Nombre+" "+Apellido);
        while (opciones2 !=0) {
            Funciones.menuCliente();
            opciones2= teclado.nextInt();
            switch (opciones2) {
                case 0:
                    System.out.println("Volviendo al menú principal");
                    break;

                //Datos de la cuenta
                case 1:
                    System.out.println("Nombre y Apellidos: " + Nombre + " " + Apellido);
                    System.out.println("Fecha de nacimiento: " + dia + "/" + mes + "/" + year);
                    System.out.printf("DNI: %08d%s\n",DniN, DniL);
                    System.out.println("Correo electrónico: " + correo);
                    System.out.println("Tipo de cuenta: " + tcuenta);
                    System.out.println("Número de cuenta: " + a1 + a2 + a3 + a4 + " " + b1 + b2 + b3 + b4 + " " + c1 + c2 + " " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + d10);
                    System.out.println("Saldo en la cuenta: " + SaldoCuenta + "€");
                    break;

                //Últimos movimientos
                case 2:
                    if (deposito==0 && retirada==0 && transferencia==0){
                        System.out.println("No se ha realizado ningún movimiento en la cuenta");
                    }else {
                        System.out.println("Último depósito = " + deposito + "€");
                        System.out.println("Última extracción = " + retirada + "€");
                        System.out.println("Última transferencia = " + transferencia + "€");
                    }
                    break;

                //Prestamos activos
                case 3:
                    if (CapitalPedido>0){
                        System.out.println("Prestamo realizado: "+CapitalPedido+"€");
                        System.out.println("Años a devolverlo: "+yearsP);
                        System.out.println("Interes: "+InteresA*100+" anual ");
                        System.out.println("Saldo no prestado: "+(SaldoCuenta-CapitalPedido)+"€");
                    }else {
                        System.out.println("No hay ningún prestamo activo.");
                    }
                    break;
            }
        }
    }



}
