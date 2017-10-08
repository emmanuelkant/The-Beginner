package excript;

public class arraymaiormenor {
public static void main(String[] args) {

int array[] = new int [5];
array[0] = 1;
array[1] = 6;
array[2] = 2;
array[3] = 3;
array[4] = 4;
	



int menor=0;
int maior=0;
//imprime o menor
for (int item:array) {
	if ((item<menor) || (menor==0))
	menor=item;
}
//imprimeo maior
for (int item:array) {
	if (item>maior)
	maior=item;
}
System.out.println(menor);
System.out.println(maior);
}
}
