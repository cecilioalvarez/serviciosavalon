package es.avalon.servicios.impl;

import java.util.List;

import es.avalon.negocio.Cliente;
import es.avalon.negocio.Factura;
import es.avalon.negocio.Linea;
import es.avalon.negocio.LineaFacturaPK;

public interface ServicioFacturacion {

	Linea buscarUnaLinea(LineaFacturaPK clave);

	void borrarLinea(Linea LineaFactura);

	void insertar(Linea LineaFactura);

	void actualizarLinea(Linea LineaFactura);

	List<Cliente> buscarTodosClientes();

	List<Cliente> buscarTodosClientesPorNombre(String nombre);

	List<Cliente> buscarTodosClientesPorNombreApellidos(String nombre, String apellidos);

	Cliente buscarCliente(String dni);

	void borrarCliente(Cliente cliente);

	void insertarCliente(Cliente cliente);

	void actualizarCliente(Cliente cliente);

	List<Factura> buscarTodosFacturasConLineas();
	
	List<Factura> buscarTodasFacturas();

	List<Factura> buscarTodosFacturasConLineasOrdenadas();

	List<Factura> buscarTodosFacturasPor(String campo);

	List<Factura> filtrarFacturaPor(String tipo, String valor);

	Factura buscarUnaFactura(int numero);

	void borrarFactura(Factura factura);

	void insertar(Factura factura);

	void actualizarFactura(Factura factura);

}