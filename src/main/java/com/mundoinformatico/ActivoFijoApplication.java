package com.mundoinformatico;

import java.sql.Blob;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PathVariable;

import com.mundoinformatico.modelo.ActivoDat;
import com.mundoinformatico.modelo.AdicionDat;
import com.mundoinformatico.modelo.Contacto;
import com.mundoinformatico.modelo.Empleado;
import com.mundoinformatico.modelo.GrupoDat;
import com.mundoinformatico.modelo.UbicacionDat;
import com.mundoinformatico.repositorio.ActivoRepositorio;
import com.mundoinformatico.repositorio.AdicionRepositorio;
import com.mundoinformatico.repositorio.ContactoRepositorio;
import com.mundoinformatico.repositorio.EmpleadoRepositorio;
import com.mundoinformatico.repositorio.GrupoRepositorio;
import com.mundoinformatico.repositorio.UbicacionRepositorio;

@SpringBootApplication
public class ActivoFijoApplication implements CommandLineRunner {

	@Autowired
	private EmpleadoRepositorio empleadoRepo;

	@Autowired
	private ContactoRepositorio contactoRepo;

	@Autowired
	private UbicacionRepositorio ubicacionRepo;

	@Autowired
	private ActivoRepositorio activoRepo;

	@Autowired
	private AdicionRepositorio adicionRepo;  
	
	@Autowired
	private GrupoRepositorio grupoRepo;   
	
	public static void main(String[] args) {
		SpringApplication.run(ActivoFijoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/* ☝️👆👍👇
		 * System.out.println("Hello Henry Jose!!!"); probarEmpleado(); //👈exito!!
		 * probarContacto(); //👈exito!! 👍
		 * probarUbicacion(); //👈exito!!👍
		 * probarArticulo(); //👈exito!!👍
		 *
		 * probarActivo(); // 👈exito!!👍 
		 * guardarActivo() // 👈exito!!👍   
		 * System.out.println("Reg Activo #7="+buscarActivoPorId(7) );   // 👍 
		 * System.out.println("Reg Ubicacion x cod="+buscarUbicacionCod("OFIC-MNT-PROD") );  // 👍
		 * */   
		 // probarAdiciones();  // 👍  
		 // probarGrupoActivos();  // 👈exito!!👍   
		 // pruebaBuscarUbicPorExample(); // Sujeto a revision 😞
		 // pruebaBuscarPorCodigoUbic();  // 👈exito!!👍
		 // pruebaGoRegistro();   // 👈exito!!👍	 
	}

	private void probarEmpleado() {
		// TODO Auto-generated method stub
		List<Empleado> lista = empleadoRepo.findAll();
		System.out.println("*RESULTADO (query Empleado_dat)*:");
		System.out.println("*Total registro de la tabla=" + lista.size());
		System.out.println("=================================");
		lista.forEach(System.out::println); // https://www.delftstack.com/es/howto/java/print-list-java/
		System.out.println("*================================");
	}

	private void probarContacto() {
		List<Contacto> lista = (List<Contacto>) contactoRepo.findAll();
		System.out.println("*RESULTADO (query Contacto_dat)*:");
		System.out.println("*Total registro de la tabla=" + lista.size());
		System.out.println("=================================");
		lista.forEach(System.out::println); // https://www.delftstack.com/es/howto/java/print-list-java/
		System.out.println("*================================");
	}

	private void probarUbicacion() {
		// TODO Auto-generated method stub
		List<UbicacionDat> lista = ubicacionRepo.findAll();
		System.out.println("*RESULTADO (query UbicacionDat)*:");
		System.out.println("*Total registro de la tabla=" + lista.size());
		System.out.println("=================================");
		lista.forEach(System.out::println); // https://www.delftstack.com/es/howto/java/print-list-java/
		System.out.println("*================================");
	}

	private void probarActivo() {
		// TODO Auto-generated method stub
		// List<ActivoDat> lista = activoRepo.findAll();  // 👍
		// List<ActivoDat> lista = activoRepo.findByCodigoActivoLike("%SERVER%");   // 👍
		// List<ActivoDat> lista = activoRepo.getActivosLike("%VEN%");         // 👍 
		List<ActivoDat> lista = activoRepo.findAllByOrderByDescripcionAsc();   // 👍 
		System.out.println("*RESULTADO (query ActivoDat)*:");
		System.out.println("*Total registro de la tabla=" + lista.size());
		System.out.println("=================================");
		lista.forEach(System.out::println); // https://www.delftstack.com/es/howto/java/print-list-java/
		System.out.println("*================================");
	}

	private void guardarActivo() {
		Integer id = 0;  // dumy valor becouse is 'Generated.AutoIncrement' 
		String codigo_activo = "ELIMINAME";
	    String descripcion = "PC ELIMINAME";   
	    UbicacionDat ubicacion = new UbicacionDat("OFIC-CONTADOR","OFICINA DEL CONTADOR");  
	    // 
	    // const imagen  = this.imgPrevisualizacion;   //   Error: Blob
	    // var blob1 = new Blob([new Uint8Array(data[0].image_blob.data)]);    // Ejemplo
	    // const blob1 = new Blob([new Uint8Array(this.imagenes.pop())]);
	    // const blob2 = new Blob();  
	    // const imagen = new Blob([new Uint8Array(this.imagenes.pop())]);
	    byte[] imagen = null; 
	    // 
	    String nro_compra = "PRUEBA"; 
	    String marca = "GENERICO";  
	    String modelo = "GENERICO";  
	    String serial = "S/S";  
	    Byte vida_util  = 5;  
	    Float valor_inicial = (float) 999.0;  
	    Float valor_rescate = (float) 9.0;  
	    Float valor_libro = (float) 99.0;  
	    Float depre_anual = (float) 5.0; 
	    Float depre_acum = (float) 777.0;  
	    String observacion = "PC de PRUEBA, COLOR: negro, c/DVD.";  
	    Byte desincorporado = 0;  
	    /* OLD
		ActivoDat a = new ActivoDat(id,codigo_activo, descripcion ,ubicacion, imagen, nro_compra, 
			      marca, modelo, serial, vida_util, valor_inicial, valor_rescate, valor_libro, depre_anual, 
			      depre_acum, observacion, desincorporado );
		*/   
		/*
		ActivoDat(String codigoActivo, String descripcion, UbicacionDat ubicacionDat, byte[] imagen,
				String nroCompra, String marca, String modelo, String serial, Byte vidaUtil, Float valorInicial,
				Float valorRescate, Float valorLibro, Float depreAnual, Float depreAcum, String observacion,
				Byte desincorporado) {
		*/ 
	    ActivoDat a = new ActivoDat();  
		activoRepo.save(a);  
		System.out.println("registro 👇");
		System.out.println( a );
		System.out.println("Saved exitosamente 👍 -check it out!!!");
		System.out.println("*********************************************************************");  
		System.out.println("OJO: no te olvides de limpiar este registro de la tabla en produccion");
		System.out.println("*********************************************************************");
	} // guardarActivo()
	
	private ActivoDat buscarActivoPorId( Integer id ) {
		Optional<ActivoDat> o = activoRepo.findById(id);   
		if ( o.isPresent() ) {
			return o.get();
		}
		return null;	
	}  // buscarActivoPorId(). 
	
	private UbicacionDat buscarUbicacionCod( @PathVariable String codigo_ubic ) {
		Optional<UbicacionDat> o = ubicacionRepo.findById(codigo_ubic);
		if ( o.isPresent() ) {
			//System.out.println("Buscar activo id="+id+"**Encontrado***"); 
			return o.get();
		}
		return null;
	} // buscarUbicacionCod(). 
	
	private void probarAdiciones() {
		// TODO Auto-generated method stub
		// List<ActivoDat> lista = activoRepo.findAll();  // 👍
		// List<ActivoDat> lista = activoRepo.findByCodigoActivoLike("%SERVER%");   // 👍
		// List<ActivoDat> lista = activoRepo.getActivosLike("%VEN%");         // 👍 
		//List<AdicionDat> lista = adicionRepo.findAllBycodigo_activo("HP9000"); 
		List<AdicionDat> lista = adicionRepo.getTodosByCodActivoEquals( "HP9000" ); 
		System.out.println("*RESULTADO I:(query AdicionDat)*:");
		System.out.println("*Total registro de la tabla=" + lista.size());
		System.out.println("=================================");
		lista.forEach(System.out::println); // https://www.delftstack.com/es/howto/java/print-list-java/
		System.out.println("*================================");
		
		AdicionDat a = adicionRepo.getAdicionByCodigoActivoAndIdEquals("HP9000",5);    
		System.out.println("*RESULTADO II:(query AdicionDat)*:");
		System.out.println("=================================");
		//lista.forEach(System.out::println); // https://www.delftstack.com/es/howto/java/print-list-java/
		
		System.out.println("*================================");
	}
	
	private void probarGrupoActivos() {
		List<GrupoDat> lista = grupoRepo.findAll();   
		System.out.println("*RESULTADO I:(query GrupoDat)*:");
		System.out.println("*Total registro de la tabla=" + lista.size());
		System.out.println("=================================");
		lista.forEach(System.out::println); // https://www.delftstack.com/es/howto/java/print-list-java/
		System.out.println("*================================");
	}
	
	// Sujeto a revision!!!!
	private List<ActivoDat> buscarUbicPorExample( String ubicacion ) {
		ActivoDat e = new ActivoDat();
		e.setUbicacionDat(new UbicacionDat(ubicacion,"") );
		Example<ActivoDat> example = Example.of(e); 
		List<ActivoDat> lista = activoRepo.findAll(example);  
		lista.forEach(System.out::println); 
		System.out.println("*Total registro de la tabla=" + lista.size());    
		return lista;   
	}  // buscarUbicPorExample().   
	
	private void pruebaBuscarUbicPorExample() {
		String e = "INFORMATICA";  
		if ( buscarUbicPorExample( e ).size() <= 0  ) {
			System.out.println("OJO!! No hay activos con Ubic='"+e+"'");  
		} else {
			System.out.println("OJO!! HAY activos con Ubic='"+e+"'");
		}
	} // pruebaBuscarUbicPorExample() 
	
	private void pruebaBuscarPorCodigoUbic() {
		String u = "VENTAS"; 
		if ( activoRepo.getActivoPorCodigoUbic(u).size() <= 0 ) {
			System.out.println("OJO!! No hay activos con Ubic='"+u+"'");
		} else {
			System.out.println("OJO!! *HAY* activos con Ubic='"+u+"'");
		}
	}  // pruebaBuscarPorCodigoUbic() 
	
	private void pruebaGoRegistro() {
		final Integer REG = 1;  
		
		System.out.println("1er reg de 'activo_dat'="+activoRepo.getPrimero());
		
		System.out.println( "Previo reg a "+REG+" de 'activo_dat'="+activoRepo.getPrevio(REG) );  
		System.out.println( "Next reg de "+REG+" de 'activo_dat'="+activoRepo.getProximo(REG));
		
		System.out.println("Ultimo reg de 'activo_dat'="+activoRepo.getFinal());
	} // pruebGoRegistro() 

}
