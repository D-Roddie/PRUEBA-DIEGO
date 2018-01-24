package ui;

import capalogica.CL;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Esta clase contiene todos los metodos que se comunican con el usuario.
 *
 * @author Daniel Rodríguez Retana
 */
public class UI {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static CL nuevoMercadito = new CL();

    /**
     * Este método es como el usuario habla con la computadora y le pide que acción hacer, y le muestra el menú, con
     * varias opciones. Cada opción tiene un grupo de metodos que hacen que funcione.
     *
     * @throws java.io.IOException
     */
    public static void mostrarMenu() throws java.io.IOException {
        boolean seguir;
        int opcion;
        seguir = true;
        opcion = -1;
        do {
            out.println("---MENU PRINCIPAL---");
            out.println("1. Registrar proveedor");
            out.println("2. Mostrar proveedores");
            out.println("3. Registrar productos");
            out.println("4. Mostrar productos");
            out.println("5. Registrar clientes");
            out.println("6. Mostrar clientes");
            out.println("Digite la opcion");
            opcion = Integer.parseInt(in.readLine());
            procesarOpcion(opcion);
            out.println("La opcion ingresada fue: " + opcion);
        } while (opcion != 9);
    }

    /**
     * Este método es el que tiene menos lineas de código, ya que sin esto el programa no funcionaria. Este el main, en
     * este llama al método que llama a mostrar menu que es el metodo que permitira que el usuario llene la información,
     * que el sistema le solicita.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        mostrarMenu();
    }

    /**
     * Este método muestra un menú, que va a permitir al usuario seleccionar acciones, que le van a mostrar otros menus
     * con diferentes acciones.
     *
     * @param pOpcion
     * @throws IOException
     */
    public static void procesarOpcion(int pOpcion) throws IOException {

        switch (pOpcion) {
            case 1:
                mostrarProveedor();
                break;

            case 2:
                mostrarProveedores();
                break;
            case 3:
                ingresarProducto();
                break;
            case 4:
                mostrarProductos();
                break;
            case 5:
                ingresarCliente();
                break;
            case 6:
                mostrarClientes();
                break;

            default:
                out.println("Opción inválida");
        }
    }

    /**
     * Este método es como el usuario habla con la computadora y le pide que acción hacer, y le muestra el menú, con
     * varias opciones. Cada opción tiene un grupo de metodos que hacen que funcione
     *
     * @throws java.io.IOException
     */
    public static void mostrarProveedor() throws java.io.IOException {
        boolean seguir;
        int opcion;
        seguir = true;
        opcion = -1;
        do {
            out.println("---MENU PRINCIPAL---");
            out.println("1. Organización");
            out.println("2. Persona física");
            out.println("3. Volver al menú");
            out.println("Digite la opcion");
            opcion = Integer.parseInt(in.readLine());
            procesarProveedor(opcion);
            out.println("La opcion ingresada fue: " + opcion);
        } while (opcion != 9);
    }

    /**
     * Este método muestra un menú, que va a permitir al usuario seleccionar acciones, que le van a mostrar otros menus
     * con diferentes acciones.
     *
     * @param pOpcion
     * @throws IOException
     */
    public static void procesarProveedor(int pOpcion) throws IOException {

        switch (pOpcion) {
            case 1:
                ingresarOrganizacion();
                break;

            case 2:
                ingresarPersonaFisica();
                break;
            case 3:
                mostrarMenu();
                break;

            default:
                out.println("Opción inválida");
        }
    }

    /**
     * Este metodo le pide al usuario que ingrese la información solicitada, y luego guarda la información en diferentes
     * variables que luego se mandan a otra clase como parametros para que los guarde en el ArrayList listaProveedor.
     *
     * @throws IOException
     */
    public static void ingresarPersonaFisica() throws IOException {
        String pfNombre;
        String pfApellido;
        String pfDireccion;
        String pfTelefono;
        String pfIdentificacion;

        if (buscarProveedorUI() == false) {
            out.println("Ingrese el nombre del proveedor: ");
            pfNombre = in.readLine();

            out.println("Ingrese el apellido del proveedor: ");
            pfApellido = in.readLine();

            out.println("Ingrese la dirección del proveedor ");
            pfDireccion = in.readLine();

            out.println("Ingrese el teléfono del proveedor ");
            pfTelefono = in.readLine();

            out.println("Ingrese la identificación del proveedor: ");
            pfIdentificacion = in.readLine();

            nuevoMercadito.registrarPersonaFisica(pfNombre, pfApellido, pfDireccion, pfTelefono, pfIdentificacion);
        }
    }

    /**
     * Este metodo le pide al usuario que ingrese la información solicitada, y luego guarda la información en diferentes
     * variables que luego se mandan a otra clase como parametros para que los guarde en el ArrayList listaProveedor.
     *
     * @throws IOException
     */
    public static void ingresarOrganizacion() throws IOException {
        String oNombre;
        String oDireccion;
        String oTelefono;
        String oIdentificacion;
        String oRepresentante;

        if (buscarProveedorUI() == false) {
            out.println("Ingrese el nombre de la organización (proveedor)");
            oNombre = in.readLine();

            out.println("Ingrese la dirección de la organización (proveedor) ");
            oDireccion = in.readLine();

            out.println("Ingrese el telefono de la organización (proveedor) ");
            oTelefono = in.readLine();

            out.println("Ingrese la identificación de la organización (proveedor) ");
            oIdentificacion = in.readLine();

            out.println("Ingrese el nombre del representante: ");
            oRepresentante = in.readLine();

            nuevoMercadito.registrarOrganizacion(oNombre, oDireccion, oTelefono, oIdentificacion, oRepresentante);
        }
    }

    /**
     * Este método toma toda la información que se guardo en el ArrayList "listaProveedor", y la imprime.
     */
    public static void mostrarProveedores() {
        String[] posicionProveedor = nuevoMercadito.mostrarProveedorCL();
        for (int i = 0; i < posicionProveedor.length; i++) {
            out.println("--PROVEDORES--");
            out.println(posicionProveedor[i].toString());
        }
    }

    /**
     * Este metodo le pide al usuario que ingrese la información solicitada, y luego guarda la información en diferentes
     * variables que luego se mandan a otra clase como parametros para que los guarde en el ArrayList listaProducto.
     *
     * @throws IOException
     */
    public static void ingresarProducto() throws IOException {
        String nombreProducto;
        String idProducto;
        String descProducto;
        String tipo;
        double precioPOrg;
        double precioPNoOrg;

        if (buscarProductoUI() == false) {
            out.println("Ingrese el nombre del producto ");
            nombreProducto = in.readLine();

            out.println("Ingrese el ID del producto)");
            idProducto = in.readLine();

            out.println("Ingrese una descripcion del producto ");
            descProducto = in.readLine();

            out.println("Ingrese el tipo de el producto: Fruta or Verdura");
            tipo = in.readLine();

            out.println("Ingrese el precio del producto organico");
            precioPOrg = Integer.parseInt(in.readLine());

            out.println("Ingrese el precio del pruducto NO organico ");
            precioPNoOrg = Integer.parseInt(in.readLine());

            nuevoMercadito.registrarProducto(nombreProducto, idProducto, descProducto, tipo, precioPOrg, precioPNoOrg);
        }
    }

    /**
     * Este metodo le pide al usuario que ingrese la información solicitada, y luego guarda la información en diferentes
     * variables que luego se mandan a otra clase como parametros para que los guarde en el ArrayList listaCliente.
     *
     * @throws IOException
     */
    public static void ingresarCliente() throws IOException {
        String nombre;
        String apellidos;
        String identificacion;
        String provincia;
        String canton;
        String distrito;
        String correo;

        if (buscarClienteUI() == false) {
            out.println("Ingrese el nombre del cliente) ");
            nombre = in.readLine();


            out.println("Ingrese el apellido del cliente)");
            apellidos = in.readLine();

            out.println("Ingrese la identificación del cliente ");
            identificacion = in.readLine();

            out.println("Ingrese la provincia  donde vive el cliente");
            provincia = in.readLine();

            out.println("Ingrese el canton  donde vive el cliente");
            canton = in.readLine();

            out.println("Ingrese el distrito donde vive el cliente");
            distrito = in.readLine();

            out.println("Ingrese el precio del pruducto NO organico ");
            correo = in.readLine();

            nuevoMercadito.registrarCliente(nombre, apellidos, identificacion, provincia, canton, distrito, correo);
        }
    }

    /**
     * Este método toma toda la información que se guardo en el ArrayList "listaProducto", y la imprime.
     */

    public static void mostrarProductos() {
        String[] posicionProducto = nuevoMercadito.mostrarProductosCL();
        for (int i = 0; i < posicionProducto.length; i++) {
            out.println("--PRODUCTOS--");
            out.println(posicionProducto[i].toString());
        }
    }

    /**
     * Este método toma toda la información que se guardo en el ArrayList "listaProducto", y la imprime.
     */
    public static void mostrarClientes() {
        String[] posicionCliente = nuevoMercadito.mostrarClienteCL();
        for (int i = 0; i < posicionCliente.length; i++) {
            out.println("--CLIENTE--");
            out.println(posicionCliente[i].toString());
        }
    }

    /**
     * Este método le pide al usuario que ingrese información, luego lo que este hace es que verifica si la
     * información que ingreso ya existe. En este caso se busca por la identificación del proveedor, entonces si esta identificación
     * ya existe o fue previamente registrar el sistema no lo deja registrar.
     *
     * @return
     * @throws IOException
     */
    public static boolean buscarProveedorUI() throws IOException {
        String pIdentificacion;
        boolean verificacionProveedor;

        out.println("Busque la identificación del proveedor: ");
        pIdentificacion = in.readLine();

        verificacionProveedor = nuevoMercadito.buscarProveedorCL(pIdentificacion) != false;

        if (verificacionProveedor == true) {
            out.println("Proveedor existente, por faovr ingrese otra identificación");
        } else {
            out.println("Proveedor no existente, por favor llene el formulario");
        }
        return verificacionProveedor;
    }

    /**
     * Este método le pide al usuario que ingrese información, luego lo que este hace es que verifica si la
     * información que ingreso ya existe. En este caso se busca por la identificación del producto, entonces si esta identificación
     * ya existe o fue previamente registrar el sistema no lo deja registrar.
     * @return
     * @throws IOException
     */
    public static boolean buscarProductoUI() throws IOException {
        String pIDProducto;
        boolean verificacionProducto;

        out.println("Busque la identificación del producto: ");
        pIDProducto = in.readLine();

        verificacionProducto = nuevoMercadito.buscarProductoCL(pIDProducto) != false;

        if (verificacionProducto == true) {
            out.println("Producto existente, por faovr ingrese otra identificación");
        } else {
            out.println("Producto no existente, por favor llene el formulario");
        }
        return verificacionProducto;
    }

    /**
     * Este método le pide al usuario que ingrese información, luego lo que este hace es que verifica si la
     * información que ingreso ya existe. En este caso se busca por la identificación del cliente, entonces si esta identificación
     * ya existe o fue previamente registrar el sistema no lo deja registrar.
     * @return
     * @throws IOException
     */
    public static boolean buscarClienteUI() throws IOException {
        String pIdentificacion;
        boolean verificacionCliente;

        out.println("Busque la identificacion del cliente");
        pIdentificacion = in.readLine();

        verificacionCliente = nuevoMercadito.buscarClienteCL(pIdentificacion) != false;

        if (verificacionCliente == true) {
            out.println("Cliente existente, por favor ingrese otra identificación");
        } else {
            out.println("Cliente no existente, por favor llene el formulario");
        }
        return verificacionCliente;
    }
}






