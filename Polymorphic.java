package Text;

	interface Fly{
		void fly();
	}
	interface Run{
		void run();
	}
	
	abstract class Stand{
	public abstract	void stand();
	}


class Bird extends Stand implements Fly,Run{
		
		public	void fly(){
			System.out.println("∑…");
		}
		public	void run(){
			System.out.println("≈‹");
		}
		public void stand(){
			System.out.println("’æ¡¢");
		}
		public void fly(int x)
		{
			for(int i=0;i<x;i++)
				System.out.println("∑…");
		}
}
		class Cyckoo extends Bird
	{
		public int age;
			char sex;
			
		public Cyckoo(int age){
				this.age=age;
			}	
		public Cyckoo(int age,char sex) {
			this.age=age;
			this.sex=sex;
		}
		public Cyckoo(char sex) {
			this.sex=sex;
		}

	}
public class Polymorphic {
	
public static void main(String[] args) {
		
		Cyckoo cy = new Cyckoo(5);
		
		cy.sex='M';
		cy.fly(5);
		System.out.println(cy.age);
		cy.stand();
	
	}
}
