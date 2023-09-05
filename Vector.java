import manejador.ArbolBinario;
import modelo.Nodo;


public class Vector {
	private ArbolBinario [] sucursal;
	
	public Vector(int tama�o) {
		int i;
		sucursal=new ArbolBinario[tama�o];
		for(i=0;i<tama�o;i++)
		{
			sucursal[i]=new ArbolBinario();
		}
	}

	public ArbolBinario getSucursal(int posicion) {
		return sucursal[posicion];
	}

	public void setSucursal(ArbolBinario[] sucursal) {
		this.sucursal = sucursal;
	}
	
}
