import java.util.function.Function;

public class EnumTest {

	public enum CalculatorType{
		
		A(value->value),
		B(value->value*10);
		private CalculatorType(Function<Long,Long> expression) {
			
		}
		
	}
	
	public static void main(String[] args) {
		
		
		
	}//main() end
}//EnumTest end