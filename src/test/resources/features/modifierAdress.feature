# language: fr
Fonctionnalité: Modifier l'adresse d'un abonné

Plan du scénario: Modification de l'adresse d'un abonné résidant en France sans date d'effet
	Etant donné un abonné avec une adresse principale active en France
    Lorsque le conseiller connecté à "<canal>" modifie l'adresse de l'abonné sans date d'effet
    Alors l'adresse de l'abonné modifiée est enregistrée sur l'ensemble des contrats de l'abonné
    Et un mouvement de modification d'adresse est créé

Exemples:
      | canal |
      | FACE |
      | EC |