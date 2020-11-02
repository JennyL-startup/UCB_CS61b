package Exercise_1;

public class DrawTriangle {
	public static void drawTriangle(int n) {
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < i+1; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		DrawTriangle.drawTriangle(5);
	}

}
