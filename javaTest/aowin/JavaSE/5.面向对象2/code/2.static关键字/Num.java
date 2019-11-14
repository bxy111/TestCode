public class Num{
	static int a=19;
	int b=20;
	public Num(){
		a++;
		b++;
		Num(b);
	}
	public void Num(int num){
		a+=num;
	}
}