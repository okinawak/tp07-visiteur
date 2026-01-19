package tp07;

public class StringVisitor implements ExpressionVisitor<String> {

    @Override
    public String visitConstante(Constante constante){
        return String.valueOf(constante.getValeur());
    };
    @Override
    public String visitVariable(ExpressionVariable expressionVariable){
        return expressionVariable.getNomVariable();
    };
    @Override
    public String visitSomme(Somme somme){
        return "(" + somme.getGauche().accept(this) + " + " + somme.getDroite().accept(this) + ")";
    };
    @Override
    public String visitProduit(Produit produit){
        return "(" + produit.getGauche().accept(this) + " * " + produit.getDroite().accept(this) + ")";
    };
    @Override
    public String visitQuotient(Quotient quotient){
        return "(" + quotient.getGauche().accept(this) + " / " + quotient.getDroite().accept(this) + ")";
    };
    @Override
    public String visitDifference(Difference difference){
        return "(" + difference.getGauche().accept(this) + " - " + difference.getDroite().accept(this) + ")";
    };
    @Override
    public String visitFonction(FonctionExpression fonctionExpression){
        return fonctionExpression.getFonction().getNom() + "(" + fonctionExpression.getArgument().accept(this) + ")";
    };

}
