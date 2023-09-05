import manejador.ArbolBinario;
import modelo.Nodo;


public class Vector {
	private ArbolBinario [] sucursal;
	
	public Vector(int tamaño) {
		int i;
		sucursal=new ArbolBinario[tamaño];
		for(i=0;i<tamaño;i++)
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
