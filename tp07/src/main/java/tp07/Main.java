package tp07;
import tp07.fonction.Cos;
public class Main {
Constante deux = new Constante(2);
ExpressionVariable x = new ExpressionVariable("x");
Somme expression1 = new Somme(deux, x);
Produit expression2 = new Produit(expression1, x);
Cos cos = new Cos();
FonctionExpression fonctionExpression = new FonctionExpression(cos, expression2);
}
