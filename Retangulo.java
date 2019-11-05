import java.util.InputMismatchException;
import java.util.Scanner;

public class Retangulo implements IShape,IShow{

	private float base;
	private float altura;
	
	public Retangulo(float base, float altura)
	{
		setBase(base);
		setAlt(altura);
	}
	
	@Override
	public float getArea() 
	{
		
		return (this.base* this.altura);
	}

	@Override
	public float getPerimetro() 
	{
		
		return (this.base*2)+(this.altura*2);
	}
	
	public float getBase() 
	{
		return base;
	}

	public void setBase(float base) 
	{
		this.base = base;
	}

	public float getAlt() 
	{
		return altura;
	}

	public void setAlt(float alt) 
	{
		this.altura = alt;
	}

	@Override
	public void Imprimir() 
	{
		System.out.println("Perimetro "+getPerimetro());
		System.out.println("Base "+getArea());	
	}
	public void calcular()
	{
			float perimetro,area;
			try{
				System.out.println("Entre com o valor para a base: ");
				Scanner a = new Scanner(System.in);
				base = a.nextInt();
				System.out.println("Entre com o valor a Altura: ");
				altura = a.nextInt();
				area = base * altura;
				perimetro = base*2 + altura*2;
				System.out.println("Area: " +area);	
				System.out.println("Perimetro: " +perimetro);
	}
			catch (InputMismatchException e)
	{
				System.out.println("Digite um numero por favor");
				System.out.println("___________________________");
				calcular();
	}
	}
}