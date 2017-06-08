import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Arquivo {
	
	public void salvar(Serializable objeto, String nome){
		
		try {
			
			FileOutputStream 	fos = new FileOutputStream( nome + ".ser");
			ObjectOutputStream 	oos = new ObjectOutputStream(fos);
			oos.writeObject(objeto);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	
	
	public Object lerObjeto(String nome){
		
		try {
			
			FileInputStream 	fis	= new FileInputStream(nome + ".ser");
			ObjectInputStream	oos	= new ObjectInputStream(fis);
			Object objeto = oos.readObject();
			oos.close();
			fis.close();
			return objeto;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		return null;
	}
}
