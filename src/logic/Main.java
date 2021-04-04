package logic;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) 
	{
		
		SwingUtilities.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{
			 new GUI();
			
			}
			
		});
	
		
	
		
		
		// implementation of serializing the data
	/*	try {
			
			File f = new File("C:\\Users\\Liam\\eclipse-workspace\\Banking System\\src\\logic\\Demo2.txt");
			
			if(f.createNewFile()) {
				System.out.println("File Created: " + f.getName());
			}else {
				System.out.println("File : " + f.getName() + " Already Exists "  );
				System.out.println("At " + f.getAbsolutePath());
			}
			
		} catch (IOException e) {

			System.out.println("Error Occured");
			e.printStackTrace();
		}*/
	}

}
