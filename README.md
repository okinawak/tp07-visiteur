# tp07-visiteur

    Le pattern Visiteur est-il réellement pertinent dans ce contexte ?
    Oui, car il sépare les opérations (affichage, calcul) de la structure des expressions. On peut ajouter de nouvelles opérations sans modifier les classes d'expressions.

    Quelles sont les limites de cette implémentation ?
    Chaque nouveau type d'expression nécessite de modifier l'interface ExpressionVisitor et tous les visiteurs existants
    Code verbeux avec beaucoup de méthodes visit...() similaires
    Gestion d'erreurs complexe (variables non définies, division par zéro)

    Certaines opérations ne seraient-elles pas plus naturellement implémentées directement dans Expression ?
    Oui, le calcul pourrait être une méthode evaluer(Map<String, Double>) dans Expression. Le pattern Visiteur est surtout utile quand on a beaucoup d'opérations différentes à implémenter.

    Peut-on simplifier la hiérarchie (par exemple pour la fonction cos) ?
    Oui, on pourrait fusionner Fonction et FonctionExpression en une seule classe Fonction qui extends Expression directement, mais on perdrait la flexibilité de réutiliser les objets Fonction.

    Que se passerait-il si l’on ajoutait un nouveau type d’expression ?
    Il faudrait créer la nouvelle classe, ajouter une méthode dans ExpressionVisitor, implémenter cette méthode dans tous les visiteurs existants.
