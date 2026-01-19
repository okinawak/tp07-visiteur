package tp07;

import java.util.Map;
public class CalculVisitor implements ExpressionVisitor<Double> {

    private Map<String, Double> valeursVariables;

    public CalculVisitor(Map<String, Double> valeursVariables) {
        this.valeursVariables = valeursVariables;
    }

    @Override
    public Double visitConstante(Constante constante) {
        return constante.getValeur();
    }

    @Override
    public Double visitVariable(ExpressionVariable expressionVariable) {
        String nomVariable = expressionVariable.getNomVariable();
        
        if (!valeursVariables.containsKey(nomVariable)) {
            throw new IllegalArgumentException(
                "Variable non définie : " + nomVariable + 
                ". Variables disponibles : " + valeursVariables.keySet()
            );
        }
        
        return valeursVariables.get(nomVariable);
    }

    @Override
    public Double visitSomme(Somme somme) {
        Double valeurGauche = somme.getGauche().accept(this);
        Double valeurDroite = somme.getDroite().accept(this);
        return valeurGauche + valeurDroite;
    }

    @Override
    public Double visitProduit(Produit produit) {
        Double valeurGauche = produit.getGauche().accept(this);
        Double valeurDroite = produit.getDroite().accept(this);
        return valeurGauche * valeurDroite;
    }

    @Override
    public Double visitQuotient(Quotient quotient) {
        Double valeurGauche = quotient.getGauche().accept(this);
        Double valeurDroite = quotient.getDroite().accept(this);
        
        if (valeurDroite == 0.0) {
            throw new ArithmeticException(
                "Division par zéro : " + valeurGauche + " / " + valeurDroite
            );
        }
        
        return valeurGauche / valeurDroite;
    }

    @Override
    public Double visitDifference(Difference difference) {
        Double valeurGauche = difference.getGauche().accept(this);
        Double valeurDroite = difference.getDroite().accept(this);
        return valeurGauche - valeurDroite;
    }

    @Override
    public Double visitFonction(FonctionExpression fonctionExpression) {
        Double valeurArgument = fonctionExpression.getArgument().accept(this);
        
        return fonctionExpression.getFonction().evaluer(valeurArgument);
    }
}