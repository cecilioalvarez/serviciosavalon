package es.avalon.servicios.impl;

import java.util.List;

import es.avalon.Cliente;
import es.avalon.Factura;
import es.avalon.LineaFactura;
import es.avalon.LineaFacturaPK;

public interface ServicioFacturacion {

	
	//lineasFactura
	LineaFactura buscarUnaLinea(LineaFacturaPK clave);

	void borrarLinea(LineaFactura LineaFactura);

	void insertar(LineaFactura LineaFactura);

	void actualizarLinea(LineaFactura LineaFactura);
	
	
	//clientes
	List<Cliente> buscarTodosClientes();

	List<Cliente> buscarTodosClientesPorNombre(String nombre);

	List<Cliente> buscarTodosClientesPorNombreApellidos(String nombre, String apellidos);

	Cliente buscarCliente(String dni);

	void borrarCliente(Cliente cliente);

	void insertarCliente(Cliente cliente);

	void actualizarCliente(Cliente cliente);
	
	
	//Facturas
	public List<Factura> buscarTodos();

	List<Factura> buscarTodosFacturasConLineas();

	List<Factura> buscarTodosFacturasConLineasOrdenadas();

	List<Factura> buscarTodosFacturasPor(String campo);

	List<Factura> filtrarFacturaPor(String tipo, String valor);

	Factura buscarUnaFactura(int numero);

	void borrarFactura(Factura factura);

	void insertar(Factura factura);

	void actualizarFactura(Factura factura);

}