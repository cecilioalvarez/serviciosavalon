package es.avalon.servicios.impl;

import java.util.List;

import es.avalon.negocio.Cliente;
import es.avalon.negocio.Factura;
import es.avalon.negocio.LineaFactura;
import es.avalon.negocio.LineaFacturaPK;

public interface ServicioFacturacion {

	LineaFactura buscarLineaFactura(LineaFacturaPK clave);

	void borrarLineaFactura(LineaFactura LineaFactura);

	void insertarLineaFactura(LineaFactura LineaFactura);

	void actualizarLineaFactura(LineaFactura LineaFactura);

	List<Cliente> buscarClientesTodos();

	List<Cliente> buscarClientesPorNombre(String nombre);

	List<Cliente> buscarClientesPorNombreApellidos(String nombre, String apellidos);

	Cliente buscarClienteDni(String dni);

	void borrarCliente(Cliente cliente);

	void insertarCliente(Cliente cliente);

	void actualizarCliente(Cliente cliente);

	List<Factura> buscarFacturasConLineasTodas();

	List<Factura> buscarFacturasConLineasOrdenadasTodas();

	List<Factura> ordenarFacturas(String campo);

	List<Factura> filtrarFacturaPor(String tipo, String valor);

	Factura buscarFactura(int numero);

	void borrarFactura(Factura factura);

	void insertarFactura(Factura factura);

	void actualizarFactura(Factura factura);

	List<Factura> buscarFacturasTodas();

}