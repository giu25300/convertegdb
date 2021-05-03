/**
 * 
 */
package br.com.convertegdb;

/**
 * @author mex9856
 *
 */
public class Convertegdb {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Util util = new Util();
		util.setHost("localhost");
		util.setUser("giu");
		util.setPassword("giu");
		
//		util.setUser("SYSDBA");
//		util.setPassword("masterkey");

		String[] lista = util.retornaLista(args[0]);

		for (int i = 0; i < lista.length; i++) {
			util.setDatabase(String.format("%s/%s", args[0], lista[i]));

			try {
				if (util.Inicia()) {
					if (util.listaTabelas()) {
						util.salvaArquivos();
						System.out.println("Processo Concluído");
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

	}
}
