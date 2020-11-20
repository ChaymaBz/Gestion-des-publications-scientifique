package Pub;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
	import java.util.Scanner;
	import java.util.StringTokenizer;

	public class Auteur {
		public static void main(String ags[]) 
		{
			
			try 
			{
					Class.forName("org.postgresql.Driver");//test du driver
					System.out.println("Driver ok!!!");
					String url="jdbc:postgresql://localhost:5432/publication_scientifique";
					String user="postgres";
					String pw="postgre";
					Connection con=DriverManager.getConnection(url,user,pw);
					System.out.println("Connecté !!! ");
					Statement str=con.createStatement();
					String x;
					Scanner sc=new Scanner (System.in);
					x=sc.nextLine();
					StringTokenizer st =new StringTokenizer(x);
					int id=Integer.parseInt(st.nextToken());
					String nom=(st.nextToken());
					String prenom=st.nextToken();
					int num=Integer.parseInt(st.nextToken());
					str.executeUpdate("INSERT INTO auteur values('"+id+"','"+nom+"','"+prenom+"'"
							+ ",'"+num+"')");
					con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	}

